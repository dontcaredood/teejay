package com.teejay.Service;

import java.io.IOException;
import com.teejay.Model.TradeEntries;
import java.util.*;

public interface TeejayService {

	/**
	 * Method to fetch the last traded price of the stock
	 * 
	 * @param String tickername
	 * 
	 * @return Double LTP
	 */
	public Double getStockLTP(String tickerName) throws IOException ;
	
	/*
	 * Method to fetch the trade entries from the database
	 * 
	 * @param String loginId
	 * 
	 * @return List<tradeEntries>
	 */
	public List<TradeEntries> fetchTradeEntries(String loginId) ;
	
}
