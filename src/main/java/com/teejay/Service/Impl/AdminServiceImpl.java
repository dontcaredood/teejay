package com.teejay.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teejay.DAO.Impl.AdminDAOImpl;
import com.teejay.Model.User;
import com.teejay.Service.AdminService;
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminDAOImpl adminDao;
	
	/**
	 * Method to fetch all active users from the table
	 * 
	 * @param no params
	 * 
	 * @return List<User>
	 */
	@Override
	public List<User> listAllActiveUsers() {
		// TODO Auto-generated method stub
		return adminDao.listAllActiveUser();
	}

	/**
	 * Method to fetch all active users from the table
	 * 
	 * @param no params
	 * 
	 * @return List<User>
	 */
	@Override
	public List<User> listAllUsers() {
		// TODO Auto-generated method stub
		return adminDao.listAllUser();
	}

}
