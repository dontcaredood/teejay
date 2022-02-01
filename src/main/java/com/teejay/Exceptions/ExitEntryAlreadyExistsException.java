package com.teejay.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.apache.logging.log4j.*;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExitEntryAlreadyExistsException extends Exception {
	private int tradeId;
	private static final Logger LOGGER = LogManager.getLogger(ExitEntryAlreadyExistsException.class);

	public ExitEntryAlreadyExistsException(int tradeId) {
		this.tradeId = tradeId;
		LOGGER.error("Exit entry already exists for this trade id : " + tradeId);
	}

	/**
	 * Getter function for course code
	 * 
	 * @return
	 */
	public int getTradeId() { 
		return tradeId;
	}

	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return "Exit entry already exists for this trade id : " + tradeId;
	}

}
