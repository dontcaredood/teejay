package com.teejay.Service.Impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teejay.DAO.TeejayDAO;
import com.teejay.Model.TradeEntries;
import com.teejay.Service.TeejayService;
import com.teejay.Utils.GetLTPDataUtil;

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
	public Double getStockLTP(String tickerName) throws IOException {
		return GetLTPDataUtil.getStockLTP(tickerName);
	}

	/*
	 * Method to fetch the trade entries from the database
	 * 
	 * @param String loginId
	 * 
	 * @return List<tradeEntries>
	 */
	@Override
	public List<TradeEntries> fetchTradeEntries(String loginId) {
		try {
			return teejayDAO.fetchTradeEntries(loginId);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
}
