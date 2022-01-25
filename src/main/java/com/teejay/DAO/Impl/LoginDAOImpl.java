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

import com.teejay.Exceptions.UserNotFoundException;
import com.teejay.Model.User;
import com.teejay.Utils.TeejayUtils;

@Repository
public class LoginDAOImpl {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	TeejayUtils teejayUtils;
	
	Transaction transaction = null;
	
	private static final Logger LOGGER = LogManager.getLogger(LoginDAOImpl.class);
	public List<User> dbTest() {
		Session session = this.sessionFactory.openSession();
		try {
			transaction = session.beginTransaction();
			// String sql = "SELECT * FROM userTable";
			// SQLQuery query = session.createSQLQuery(sql);
			// query.addEntity(User.class);
//			//query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			// List<User> result = query.list();
			String hql = "FROM User where username='Sandy' and password = 'Admin123'";
			List<User> result = session.createQuery(hql).list();
			transaction.commit();
			return result;
		} finally {
			session.close();
		}
	}

	public User doLogin(String loginId, String password) throws UserNotFoundException {
		User result = null;
		Date current = new Date();
		String lastLogin = current.toString();
		Session session = this.sessionFactory.openSession();
		try {
			transaction = session.beginTransaction();
			String hql = "FROM User where loginId='"+loginId+"' and password = '"+password+"'";
			result = (User) session.createQuery(hql).uniqueResult();
			if(result == null) {
				throw new UserNotFoundException(loginId);
			}else {
				String hqlUpdate = "Update User set lastlogin= '"+lastLogin+";' where userId = "+result.getUserId();
				session.createQuery(hqlUpdate).executeUpdate();
			}
			transaction.commit();
		} finally {
			session.close();
		}
		return result;

	}
	
	public User doSignup(User user) throws UserNotFoundException {
		Session session = this.sessionFactory.openSession();
		int userId;
		String loginId;
		try {
			transaction = session.beginTransaction();
			userId = (int) session.save(user);
			user.setUserId(userId);
			user.setLoginId(teejayUtils.loginIdGenerator(user));
			String hqlUpdate = "Update User set loginId= '"+user.getLoginId()+"' where userId = "+userId;
			session.createQuery(hqlUpdate).executeUpdate();
			LOGGER.info(userId);
			
			transaction.commit();
		} finally {
			session.close();
		}
		return user;

	}
	
	

}
