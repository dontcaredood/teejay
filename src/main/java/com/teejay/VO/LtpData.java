package com.teejay.VO;

public class LtpData {

	private String ticker;
	
	private double ltp;

	public LtpData(String ticker, double ltp) {
		this.ticker = ticker;
		this.ltp = ltp;
	} 
	
	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public double getLtp() {
		return ltp;
	}

	public void setLtp(double ltp) {
		this.ltp = ltp;
	}

}
