package com.teejay.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.apache.logging.log4j.*;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SignUpException extends Exception{
	private String username;
	private static final Logger LOGGER = LogManager.getLogger(SignUpException.class);
	public SignUpException(String username) {
		this.username = username;
        LOGGER.error("Issue with Signup!");
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



