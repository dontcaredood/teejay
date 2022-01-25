package com.teejay.Controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teejay.Model.User;
import com.teejay.Service.AdminService;

@RestController
@CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
@RequestMapping("/teejay/admin")
public class AdminController {
	private static final Logger logger = LogManager.getLogger(AdminController.class);

	@Autowired
	AdminService adminService;

	/**
	 * Method to fetch all active users from the table
	 * 
	 * @param no params
	 * 
	 * @return List<User>
	 */
	@RequestMapping(value = "/listAllActiveUsers", produces = "application/json", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllActiveUsers() throws Exception {
		try {
			logger.info("List All Active Users function call");
			List<User> usersList = adminService.listAllActiveUsers();
			logger.info(usersList.size() + " Records has been found");
			return new ResponseEntity<>(usersList, HttpStatus.OK);
		} catch (Exception e) {
			throw new Exception();
		}

	}

	/**
	 * Method to fetch all users from the table
	 * 
	 * @param no params
	 * 
	 * @return List<User>
	 */
	@RequestMapping(value = "/listAllUsers", produces = "application/json", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() throws Exception {
		try {
			logger.info("List All Active Users function call");
			List<User> usersList = adminService.listAllUsers();
			logger.info(usersList.size() + " Records has been found");
			return new ResponseEntity<>(usersList, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception();
		}

	}

}