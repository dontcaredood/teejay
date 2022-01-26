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

import com.teejay.DAO.TeejayDAO;
import com.teejay.Model.TradeEntries;
import com.teejay.Model.User;

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
			transaction = session.beginTransaction();
			userId = getUserId(session, loginId);
			LOGGER.info("Searching trade entries for userId : " + userId);
			String hql = "FROM TradeEntries where userid='" + userId + "' and isActive = 'Y'";
			tradeEntries = session.createQuery(hql).list();
			LOGGER.info(tradeEntries.size() + " active trades found for loginID");
			transaction.commit();
			return tradeEntries;
		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
	}

	public int getUserId(Session session, String loginId) {
		int userId = 0;
		try {
			LOGGER.info("Getting User Id for Login ID: " + loginId);
			transaction = session.getTransaction();
			String sql = "SELECT userid FROM users_table where loginId = '" + loginId + "'	";
			SQLQuery<String> query = session.createSQLQuery(sql);
			List results = query.getResultList();
			//transaction.commit();
			if (results.size() > 0) {
				userId = (int) results.get(0);
				LOGGER.info("User Id for Login ID: " + loginId+" -> "+ userId);
				return userId;
			} else {
				System.out.println("Exception happened need to add new exception");
				throw new NullPointerException();
			}
		} catch (Exception e) {
			throw e;
		} 

	}

}
