package com.teejay.Service;

import java.util.List;

import com.teejay.Model.User;

public interface AdminService {
	
	/**
	 * Method to fetch all active users from the table
	 * 
	 * @param no params
	 * 
	 * @return List<User>
	 */
	public List<User> listAllActiveUsers() ;
	
	/**
	 * Method to fetch all active users from the table
	 * 
	 * @param no params
	 * 
	 * @return List<User>
	 */
	public List<User> listAllUsers() ;

}
