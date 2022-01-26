package com.teejay.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.apache.logging.log4j.*;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IncorrectPasswordException extends Exception {
	private String loginId;
	private static final Logger LOGGER = LogManager.getLogger(IncorrectPasswordException.class);

	public IncorrectPasswordException(String loginId) {
		this.loginId = loginId;
		LOGGER.error("Password Incorrect for : " + loginId);
	}

	/**
	 * Getter function for course code
	 * 
	 * @return
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return "Password Incorrect for : " + loginId;
	}

}
