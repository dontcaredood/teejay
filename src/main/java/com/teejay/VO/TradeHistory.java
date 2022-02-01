package com.teejay.VO;
import com.teejay.Model.*;

public class TradeHistory {

	private TradeEntries tradeEntries;
	
	private TradeExits tradeExits;

	public TradeEntries getTradeEntries() {
		return tradeEntries;
	}

	public void setTradeEntries(TradeEntries tradeEntries) {
		this.tradeEntries = tradeEntries;
	}

	public TradeExits getTradeExits() {
		return tradeExits;
	}

	public void setTradeExits(TradeExits tradeExits) {
		this.tradeExits = tradeExits;
	}
	
	
}
