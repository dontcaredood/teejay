package com.teejay.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.teejay.DAO.Impl.AdminDAOImpl;
import com.teejay.VO.LtpData;

public class GetLTPDataUtil {
	
	private static final String baseUrl = "https://www.google.com/finance/quote/";
	private static final Logger LOGGER = LogManager.getLogger(AdminDAOImpl.class);
	/**
	 * Method to fetch the last traded price of the stock
	 * 
	 * @param String tickername
	 * 
	 * @return Double LTP
	 */
	public static List<LtpData> getLTP(List<String> tickerList) throws IOException {
		List<LtpData> ltpList = new ArrayList<LtpData>();
		try {
			for(String ticker : tickerList) {
				ltpList.add(new LtpData(ticker,getStockLTP(ticker))) ;
			}
			LOGGER.info("LTP successfully fetched, count: "+ltpList.size());
			return ltpList;
			
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		
		}
	
	private static Double getStockLTP(String tickerName) throws IOException{

		String ltpString = "";
		String inputLine, result;
		int counter = 0;
		double ltp = 0;
		try {

			URL obj = new URL(baseUrl + tickerName + ":NSE");
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { 
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

				StringBuffer response = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					if (inputLine.equals("// Google Inc.")) {
						counter++;
					}
					if (counter == 2 && inputLine.equals("// Google Inc.")) {
						inputLine = in.readLine();
						response.append(inputLine);
					}
				}
				in.close();
				result = response.toString();
				String dataString = (String) result.subSequence(15900, 16100);
				dataString = dataString.replace("=", "\":");
				dataString = dataString.replace("\" ", "\",\"");
				if (dataString.contains("data-last-price")) {
					ltpString = dataString.substring(dataString.indexOf("data-last-price") - 1,
							dataString.indexOf("data-last-normal-market-timestamp") - 2);

					String ltp_temp = ltpString.substring(ltpString.indexOf(":\"") + 2, ltpString.length() - 1);
					ltp = Double.parseDouble(ltp_temp);

				} else {
					LOGGER.error("Error Occured");
				}

			} else {
				LOGGER.error("GET request not worked");
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		return ltp;

	
	}
}
