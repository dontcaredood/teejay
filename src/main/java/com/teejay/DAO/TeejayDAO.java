package com.teejay.DAO;

import java.util.List;
import java.util.Set;


import com.teejay.Model.TradeEntries;

public interface TeejayDAO {
	/*
	 * Method to fetch the trade entries from the database
	 * 
	 * @param String loginId
	 * 
	 * @return List<tradeEntries>
	 */
	public List<TradeEntries> fetchTradeEntries(String loginId) ;
}
