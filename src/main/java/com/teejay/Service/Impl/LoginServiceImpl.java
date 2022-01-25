package com.teejay.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teejay.DAO.LoginDAO;
import com.teejay.DAO.Impl.LoginDAOImpl;
import com.teejay.Exceptions.IncorrectPasswordException;
import com.teejay.Exceptions.UserNotFoundException;
import com.teejay.Model.User;
import com.teejay.Service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDAO loginDao;
	
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
		User result = new User();
		try {
			result = loginDao.doLogin(loginId, password);
			return result;
		} catch (UserNotFoundException | IncorrectPasswordException e) {
			throw e;
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

		return loginDao.doSignup(user);

	}

	public List<User> dbTest() {
		return loginDao.dbTest();
	}
}
