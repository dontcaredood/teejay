package com.teejay.Service;

import java.util.List;

import com.teejay.Exceptions.UserNotFoundException;
import com.teejay.Model.User;

public interface LoginService {
	
	public List<User> dbTest();

	public User doLogin(String loginId, String password) throws UserNotFoundException;

	public User doSignup(User user) throws UserNotFoundException;
}
