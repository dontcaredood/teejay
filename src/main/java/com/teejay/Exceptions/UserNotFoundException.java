package com.teejay.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.apache.logging.log4j.*;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception{
	private String username;
	private static final Logger LOGGER = LogManager.getLogger(UserNotFoundException.class);
	public UserNotFoundException(String username) {
		this.username = username;
        LOGGER.error("Username/Password Incorrect for : "+username);
	}
	/**
	 * Getter function for course code
	 * @return
	 */
	public String getUsername()
	{
		return username;
	}
	

	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() 
	{
		return "Username/Password Incorrect for : "+ username;
	}

}



