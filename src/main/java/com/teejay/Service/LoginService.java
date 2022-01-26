package com.teejay.Service;

import java.util.List;

import com.teejay.Exceptions.IncorrectPasswordException;
import com.teejay.Exceptions.UserNotFoundException;
import com.teejay.Model.TradeEntries;
import com.teejay.Model.User;

public interface LoginService {
	
	public List<User> dbTest();
	
	/*
	 * Method to login to the system
	 * 
	 * @param String loginId
	 * 
	 * @param String password
	 * 
	 * @return List<User>
	 */
	public User doLogin(String loginId, String password) throws UserNotFoundException, IncorrectPasswordException;

	/*
	 * Method to signup the user to the system
	 * 
	 * @param User user
	 * 
	 * @return List<User>
	 */
	public User doSignup(User user) throws UserNotFoundException;
}
