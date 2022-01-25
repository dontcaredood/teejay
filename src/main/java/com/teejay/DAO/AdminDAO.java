package com.teejay.DAO;

import java.util.List;

import com.teejay.Model.User;

public interface AdminDAO {
	
	/**
	 * Method to fetch all active users from the table
	 * 
	 * @param no params
	 * 
	 * @return List<User>
	 */
	public List<User> listAllActiveUser() ;
	
	/**
	 * Method to fetch all users from the table
	 * 
	 * @param no params
	 * 
	 * @return List<User>
	 */
	public List<User> listAllUser();
}
