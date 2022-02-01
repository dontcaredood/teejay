package com.teejay.Service.Impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teejay.DAO.TeejayDAO;
import com.teejay.Exceptions.ExitEntryAlreadyExistsException;
import com.teejay.Exceptions.NoHistoryFoundException;
import com.teejay.Model.TradeEntries;
import com.teejay.Model.TradeExits;
import com.teejay.Model.TradeHistories;
import com.teejay.Service.TeejayService;
import com.teejay.Utils.CommonUtils;
import com.teejay.Utils.GetLTPDataUtil;
import com.teejay.VO.LtpData;

@Service
public class TeejayServiceImpl implements TeejayService {
	@Autowired
	TeejayDAO teejayDAO;

	/**
	 * Method to fetch the last traded price of the stock
	 * 
	 * @param String tickername
	 * 
	 * @return Double LTP
	 */
	public List<LtpData> getLTP(List<String> tickerName) throws IOException {
		
		return GetLTPDataUtil.getLTP(tickerName);
	}

	/*
	 * Method to fetch the trade entries from the database
	 * 
	 * @param String loginId
	 * 
	 * @return List<tradeEntries>
	 */
	public List<TradeEntries> fetchTradeEntries(String loginId) {
		try {
			return teejayDAO.fetchTradeEntries(loginId);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}

	/*
	 * Method to add the trade entries to the database
	 * 
	 * @param TradeEntries tradeEntries
	 * 
	 * @return int trade Id
	 */
	public int addTradeEntry(TradeEntries tradeEntries) {
		double tradeCap = tradeEntries.getAvgPrice() * tradeEntries.getQuantity();
		try {
			tradeEntries.setSecurityName(tradeEntries.getSecurityName().toUpperCase());
			tradeEntries.setEntryDate(CommonUtils.getCurrentDate());
			tradeEntries.setTradeCaptial(tradeCap);
			tradeEntries.setIsActive("Y");
			return teejayDAO.addTradeEntry(tradeEntries);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}


	/*
	 * Method to add the trade exits to the database
	 * 
	 * @param TradeExits tradeExits
	 * 
	 * @return int exit Id
	 */
	public int addTradeExit(TradeExits tradeExits) throws ExitEntryAlreadyExistsException {
		try {
			tradeExits.setExitDate(CommonUtils.getCurrentDate());
			return teejayDAO.addTradeExit(tradeExits);
		} catch (ExitEntryAlreadyExistsException e) {
			// TODO: handle exception
			throw e;
		}
	}

	
	/*
	 * Method to view all the trade history
	 * 
	 * @param String loginId
	 * 
	 * @return List<TradeHistories>
	 */
	public List<TradeHistories> fetchTradeHistories(String loginId) throws NoHistoryFoundException {
		try {
			return teejayDAO.fetchTradeHistories(loginId);
		} catch (NoHistoryFoundException e) {
			// TODO: handle exception
			throw e;
		}
	}

	
}
