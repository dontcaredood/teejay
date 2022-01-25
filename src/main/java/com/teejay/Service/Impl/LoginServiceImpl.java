package com.teejay.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teejay.DAO.LoginDAO;
import com.teejay.Exceptions.UserNotFoundException;
import com.teejay.Model.User;
import com.teejay.Service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDAO loginDao;

	public User doLogin(String loginId, String password) throws UserNotFoundException {
		User result = new User();
		try {
			result = loginDao.doLogin(loginId, password);
		} catch (Exception e) {
			throw new UserNotFoundException(loginId);

		}

		return result;

	}

	public User doSignup(User user) throws UserNotFoundException {
		int id = 0;
//		try {
//			id = teejayDao.doSignup(user);
//		} catch (Exception e) {
//			//throw new UserNotFoundException();
//
//		}

		return loginDao.doSignup(user);

	}

	public List<User> dbTest() {
		return loginDao.dbTest();
	}
}
