package com.teejay.DAO.Impl;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.teejay.Constants.LogConstants;
import com.teejay.DAO.LoginDAO;
import com.teejay.Exceptions.IncorrectPasswordException;
import com.teejay.Exceptions.UserNotFoundException;
import com.teejay.Model.User;
import com.teejay.Utils.CommonUtils;
import com.teejay.Utils.TeejayUtils;
import com.teejay.Utils.TextModifier;

@Repository
public class LoginDAOImpl implements LoginDAO{
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	TextModifier text;
	
	TeejayUtils teejayUtils;
	Transaction transaction = null;
	
	private static final Logger LOGGER = LogManager.getLogger(LoginDAOImpl.class);
	public List<User> dbTest() {
		Session session = this.sessionFactory.openSession();
		List<User> result = null;
		try {
			transaction = session.beginTransaction();
			// String sql = "SELECT * FROM userTable";
			// SQLQuery query = session.createSQLQuery(sql);
			// query.addEntity(User.class);
//			//query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			// List<User> result = query.list();
			String hql = "FROM User where userid='1' and password = 'We2zS6+CR/Q='";
			result = session.createQuery(hql).list();
			transaction.commit();
			
		} catch(Exception e){
			System.out.println(e.getMessage());
		}finally {
			session.close();
		}
		
		return result;
	}
	
	/*
	 * Method to login to the system
	 * 
	 * @param String loginId
	 * 
	 * @param String password
	 * 
	 * @return List<User>
	 */
	public User doLogin(String loginId, String password) throws UserNotFoundException, IncorrectPasswordException {
		User result = null;
		Session session = this.sessionFactory.openSession();
		try {
			transaction = session.beginTransaction();
			password = text.encrypt(password);
			String hql = "FROM User where loginId='"+loginId+"'";
			result = (User) session.createQuery(hql).uniqueResult();
			if(result == null) {
				throw new UserNotFoundException(loginId);
			}else if(!result.getPassword().equals(password)){
				throw new IncorrectPasswordException(loginId);
			}else {
				String hqlUpdate = "Update User set lastlogin= '"+CommonUtils.getCurrentDateTime()+"' where userId = "+result.getUserId();
				session.createQuery(hqlUpdate).executeUpdate();
			}
			LOGGER.info(LogConstants.logHeader+"Login successful for Login Id :"+loginId);
			transaction.commit();
			return result;
		}catch(UserNotFoundException | IncorrectPasswordException e) {
			throw e;
		} finally {
			
			session.close();
		}
		

	}
	
	/*
	 * Method to signup the user to the system
	 * 
	 * @param User user
	 * 
	 * @return List<User>
	 */
	public User doSignup(User user) throws UserNotFoundException {
		Session session = this.sessionFactory.openSession();
		int userId;
		String loginId = null;
		try {
			transaction = session.beginTransaction();
			userId = (int) session.save(user);
			user.setUserId(userId);
			user.setLoginId(teejayUtils.loginIdGenerator(user));
			String hqlUpdate = "Update User set loginId= '"+user.getLoginId()+"' where userId = "+userId;
			session.createQuery(hqlUpdate).executeUpdate();
			transaction.commit();
			LOGGER.info(LogConstants.logHeader+userId+" user id saved successfully. New Login Id is "+loginId);
		} finally {
			
			session.close();
		}
		return user;

	}
	
	

}
