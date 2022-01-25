package com.teejay.DAO.Impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.teejay.DAO.AdminDAO;
import com.teejay.Model.User;

import java.util.List;

@Repository
public class AdminDAOImpl implements AdminDAO{

	private static final Logger LOGGER = LogManager.getLogger(AdminDAOImpl.class);
	@Autowired
	SessionFactory sessionFactory;

	Transaction transaction = null;
	
	/**
	 * Method to fetch all active users from the table
	 * 
	 * @param no params
	 * 
	 * @return List<User>
	 */
	public List<User> listAllActiveUser() {
		Session session = this.sessionFactory.openSession();
		try {
			transaction = session.beginTransaction();
			String hql = "FROM User where isActive='Y'";
			List<User> result = session.createQuery(hql).list();
			transaction.commit();
			return result;
		} finally {
			session.close();
		}
	}
	
	/**
	 * Method to fetch all users from the table
	 * 
	 * @param no params
	 * 
	 * @return List<User>
	 */
	public List<User> listAllUser() {
		Session session = this.sessionFactory.openSession();
		try {
			transaction = session.beginTransaction();
			String hql = "FROM User ";
			List<User> result = session.createQuery(hql).list();
			transaction.commit();
			return result;
		} finally {
			session.close();
		}
	}

}
