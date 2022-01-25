package com.teejay.DAO;

import java.util.List;

import com.teejay.Exceptions.UserNotFoundException;
import com.teejay.Model.User;

public interface LoginDAO {
	
	public List<User> dbTest();

	public User doLogin(String loginId, String password) throws UserNotFoundException;

	public User doSignup(User user) throws UserNotFoundException;

}
