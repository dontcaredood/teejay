package com.teejay.Service.Impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.teejay.Service.TeejayService;
import com.teejay.Utils.GetLTPDataUtil;

@Service
public class TeejayServiceImpl implements TeejayService {
	
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
}
