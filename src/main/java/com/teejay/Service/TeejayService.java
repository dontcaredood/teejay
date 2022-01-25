package com.teejay.Service;

import java.io.IOException;

public interface TeejayService {

	/**
	 * Method to fetch the last traded price of the stock
	 * 
	 * @param String tickername
	 * 
	 * @return Double LTP
	 */
	public Double getStockLTP(String tickerName) throws IOException ;
	
}
