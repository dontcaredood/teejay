package com.teejay.Service;

import java.io.IOException;

import com.teejay.Exceptions.ExitEntryAlreadyExistsException;
import com.teejay.Exceptions.NoHistoryFoundException;
import com.teejay.Model.TradeEntries;
import com.teejay.Model.TradeExits;
import com.teejay.VO.LtpData;
import com.teejay.Model.*;

import java.util.*;

import org.springframework.web.bind.annotation.RequestBody;

public interface TeejayService {

	/**
	 * Method to fetch the last traded price of the stock
	 * 
	 * @param String tickername
	 * 
	 * @return Double LTP
	 */
	public List<LtpData> getLTP(List<String> tickerName) throws IOException ;
	
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
	public int addTradeExit(TradeExits tradeExits) throws ExitEntryAlreadyExistsException ;
	
	/*
	 * Method to view all the trade history
	 * 
	 * @param String loginId
	 * 
	 * @return List<TradeHistories>
	 */
	public List<TradeHistories> fetchTradeHistories(String loginId) throws NoHistoryFoundException;
}
