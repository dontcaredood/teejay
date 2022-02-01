package com.teejay.DAO.Impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

import com.teejay.Constants.LogConstants;
import com.teejay.DAO.TeejayDAO;
import com.teejay.Exceptions.ExitEntryAlreadyExistsException;
import com.teejay.Exceptions.NoHistoryFoundException;
import com.teejay.Model.TradeEntries;
import com.teejay.Model.TradeExits;
import com.teejay.Model.TradeHistories;
import com.teejay.Model.User;
import com.teejay.Utils.TeejayUtils;

/**
 * @author 10689239
 *
 */
@Repository
public class TeejayDAOImpl implements TeejayDAO {
	@Autowired
	SessionFactory sessionFactory;

	Transaction transaction = null;

	private static final Logger LOGGER = LogManager.getLogger(TeejayDAOImpl.class);

	/*
	 * Method to fetch the trade entries from the database
	 * 
	 * @param String loginId
	 * 
	 * @return List<tradeEntries>
	 */
	@Override
	public List<TradeEntries> fetchTradeEntries(String loginId) {
		List<TradeEntries> tradeEntries = new ArrayList<TradeEntries>();
		int userId = 0;
		Session session = this.sessionFactory.openSession();
		try {
			userId = getUserId(loginId);
			LOGGER.info("Searching trade entries for userId : " + userId);
			String hql = "FROM TradeEntries where userid='" + userId + "' and isActive = 'Y'";
			tradeEntries = session.createQuery(hql).list();
			LOGGER.info(tradeEntries.size() + " active trades found for loginID");
			//
			return tradeEntries;
		} catch (Exception e) {
			throw e;
		} finally {
			
			session.close();
		}
	}

	/*
	 * Method to fetch the userid of the user
	 * 
	 * @param String loginId
	 * 
	 * @return int userId
	 */
	public int getUserId(String loginId) {
		int userId = 0;
		Session session = this.sessionFactory.openSession();
		try {
			LOGGER.info("Getting User Id for Login ID: " + loginId);
			
			String sql = "SELECT userid FROM users_table where loginId = '" + loginId + "'	";
			SQLQuery<String> query = session.createSQLQuery(sql);
			List results = query.getResultList();
			if (results.size() > 0) {
				userId = (int) results.get(0);
				LOGGER.info("User Id for Login ID: " + loginId + " -> " + userId);
				return userId;
			} else {
				System.out.println("Exception happened need to add new exception");
				throw new NullPointerException();
			}
			
		} catch (Exception e) {
			throw e;
		}finally {
			
			session.close();
		}

	}

	/*
	 * Method to add the trade entries to the database
	 * 
	 * @param TradeEntries tradeEntries
	 * 
	 * @return int trade Id
	 */
	public int addTradeEntry(TradeEntries tradeEntries) {
		Session session = this.sessionFactory.openSession();
		int tradeId;
		try {
			transaction = session.beginTransaction();
			tradeId = (int) session.save(tradeEntries);
			LOGGER.info(LogConstants.logHeader + tradeId + " trade id created successfully for user Id : "
					+ tradeEntries.getUserId());
			transaction.commit();
		} finally {
			session.close();
		}
		return tradeId;
	}

	/*
	 * Method to add the trade exits to the database
	 * 
	 * @param TradeExits tradeExits
	 * 
	 * @return int exit Id
	 */
	public int addTradeExit(TradeExits tradeExits) throws ExitEntryAlreadyExistsException {
		Session session = this.sessionFactory.openSession();
		int tradeId = 0;
		TradeEntries entry = null;
		TradeHistories history = null;
		try {
			transaction = session.beginTransaction();
			String hql = "FROM TradeExits where tradeId='" + tradeExits.getTradeId() + "'";
			TradeExits existingExit = (TradeExits) session.createQuery(hql).uniqueResult();
			if (existingExit == null) {
				tradeId = (int) session.save(tradeExits);
				String hqlUpdate = "Update TradeEntries set isActive= 'N' where tradeId = " + tradeExits.getTradeId();
				if (session.createQuery(hqlUpdate).executeUpdate() == 1) {
					addTradeHistory(session, tradeExits);
				}
				LOGGER.info(LogConstants.logHeader + tradeId + " exit id created successfully for trade Id : "
						+ tradeExits.getTradeId());

			} else {
				throw new ExitEntryAlreadyExistsException(tradeExits.getTradeId());
			}
			transaction.commit();
		} catch (ExitEntryAlreadyExistsException e) {
			throw e;
		} finally {
			session.close();
		}
		return tradeId;
	}

	/**
	 * Method to add the history to the database
	 * 
	 * @param session
	 * 
	 * @param tradeExits
	 */
	public void addTradeHistory(Session session, TradeExits tradeExits) {
		TradeEntries entry = null;
		TradeHistories history = null;
		try {
			String hqlTradeEntries = "FROM TradeEntries where tradeId='" + tradeExits.getTradeId() + "'";
			entry = (TradeEntries) session.createQuery(hqlTradeEntries).uniqueResult();
			String hqlTradeHistroy = "FROM TradeHistories where tradeId='" + tradeExits.getTradeId() + "'";
			TradeHistories existingHistory = (TradeHistories) session.createQuery(hqlTradeHistroy).uniqueResult();
			if (existingHistory == null) {
				history = TeejayUtils.tradeHistoriesMapper(entry, tradeExits);
				int historyId = (int) session.save(history);
				LOGGER.info(LogConstants.logHeader + historyId + " history id created successfully for trade Id : "
						+ tradeExits.getTradeId());
			}
		} catch (Exception e) {
			throw e;
		}finally {
			transaction.commit();
			session.clear();
		}
	}

	/*
	 * Method to view all the trade history
	 * 
	 * @param String loginId
	 * 
	 * @return List<TradeHistories>
	 */
	public List<TradeHistories> fetchTradeHistories(String loginId) throws NoHistoryFoundException {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		int userId = 0;
		try {
			userId = getUserId(loginId);
			String hql = "FROM TradeHistories where userId = "+userId;
			List<TradeHistories> result = session.createQuery(hql).list();
			if(result.size()>0) {
				return result;
			}else {
				throw new NoHistoryFoundException(loginId);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally {
			session.close();
		}
	}
	
	
}
