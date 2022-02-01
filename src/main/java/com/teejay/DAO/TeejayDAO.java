package com.teejay.DAO;

import java.util.List;
import java.util.Set;

import com.teejay.Exceptions.ExitEntryAlreadyExistsException;
import com.teejay.Exceptions.NoHistoryFoundException;
import com.teejay.Model.TradeEntries;
import com.teejay.Model.TradeExits;
import com.teejay.Model.TradeHistories;

public interface TeejayDAO {
	/*
	 * Method to fetch the trade entries from the database
	 * 
	 * @param String loginId
	 * 
	 * @return List<tradeEntries>
	 */
	public List<TradeEntries> fetchTradeEntries(String loginId) ;
	
	/*
	 * Method to add the trade entries to the database
	 * 
	 * @param TradeEntries tradeEntries
	 * 
	 * @return int trade Id
	 */
	public int addTradeEntry(TradeEntries tradeEntries) ;
	
	/*
	 * Method to add the trade exits to the database
	 * 
	 * @param TradeExits tradeExits
	 * 
	 * @return int exit Id
	 */
	public int addTradeExit(TradeExits tradeExits) throws ExitEntryAlreadyExistsException;
	
	/*
	 * Method to view all the trade history
	 * 
	 * @param String loginId
	 * 
	 * @return List<TradeHistories>
	 */
	public List<TradeHistories> fetchTradeHistories(String loginId) throws NoHistoryFoundException;
	
}
