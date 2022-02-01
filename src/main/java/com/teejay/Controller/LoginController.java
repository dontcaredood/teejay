package com.teejay.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.teejay.Exceptions.IncorrectPasswordException;
import com.teejay.Exceptions.UserNotFoundException;
import com.teejay.Model.User;
import com.teejay.Service.LoginService;
import com.teejay.Utils.TeejayUtils;
import com.teejay.VO.TradeHistory;

@RestController
@CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
@RequestMapping("/teejay")
public class LoginController {

	@Autowired
	LoginService loginService;

	@Autowired
	TeejayUtils teejayUtils;

	/**
	 * Method to test some of the api calls.
	 * 
	 * @param no params
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/test", produces = "application/json", method = RequestMethod.GET)
	public List<String> getLtptest() throws Exception {
		try {
			List<String> list = new ArrayList<String>();
			list.add("IOC");
			list.add("HINDALCO");
			
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception();	
		}

	}

	/*
	 * Method to login to the system
	 * 
	 * @param String loginId
	 * 
	 * @param String password
	 * 
	 * @return List<User>
	 */
	@RequestMapping(value = "/login/{loginId}/{password}", produces = "application/json", method = RequestMethod.POST)
	public User doLogin(@PathVariable String loginId, @PathVariable String password) throws Exception {

		try {
			return loginService.doLogin(loginId, password);
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
	@RequestMapping(value = "/signup", produces = "application/json", method = RequestMethod.POST)
	public ResponseEntity<User> signup(@RequestBody User user) throws Exception {
		try {
			user = teejayUtils.userMapper(user);
			user = loginService.doSignup(user);
			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception();

		}

	}

}