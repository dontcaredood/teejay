package com.teejay.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetLTPDataUtil {
	
	private static final String baseUrl = "https://www.google.com/finance/quote/";
	
	/**
	 * Method to fetch the last traded price of the stock
	 * 
	 * @param String tickername
	 * 
	 * @return Double LTP
	 */
	public static Double getStockLTP(String tickerName) throws IOException {
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
				String p2 = (String) result.subSequence(15900, 16100);
				p2 = p2.replace("=", "\":");
				p2 = p2.replace("\" ", "\",\"");
				if (p2.contains("data-last-price")) {
					ltpString = p2.substring(p2.indexOf("data-last-price") - 1,
							p2.indexOf("data-last-normal-market-timestamp") - 2);

					String ltp_temp = ltpString.substring(ltpString.indexOf(":\"") + 2, ltpString.length() - 1);
					ltp = Double.parseDouble(ltp_temp);

				} else {
					System.out.println("Error");
				}

			} else {
				System.out.println("GET request not worked");
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ltp;

	}
}
