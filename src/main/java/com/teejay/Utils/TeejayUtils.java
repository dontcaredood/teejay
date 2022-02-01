package com.teejay.Utils;

import org.springframework.stereotype.Service;

import com.teejay.Model.TradeHistories;
import com.teejay.Model.*;
@Service
public class TeejayUtils {
	
	
	public static User userMapper(User user) {
		user.setUserLevel(1);
		user.setLastLogin("Not Yet");
		user.setIsActive("Y");
		return user;
	}
	
	public static String loginIdGenerator(User user) {
		String loginId = "tj"+user.getUsername().substring(1,4)+user.getUserId();
		loginId = loginId.toUpperCase();
		return loginId;
	}
	
	public static TradeHistories tradeHistoriesMapper(TradeEntries entry, TradeExits exit) {
		TradeHistories tradeHistory = new TradeHistories();
		double exitCap = 0;
		double netProfit = 0;
		double pnlPercent = 0;
		int tradeDays = 0;
		String PNL =  null;
		try {
			exitCap = entry.getQuantity()*exit.getExitPrice();
			netProfit = exitCap - entry.getTradeCaptial();
			pnlPercent = (netProfit/entry.getTradeCaptial())*100;
			if(netProfit>0) {
				PNL = "P";
			}else {
				PNL = "L";
			}
			tradeDays = CommonUtils.getDateDiff(entry.getEntryDate(), exit.getExitDate());
			//Mapping the TradeHistory Class
			tradeHistory.setTradeId(exit.getTradeId());
			tradeHistory.setSecurity(entry.getSecurityName());
			tradeHistory.setUserId(entry.getUserId());
			tradeHistory.setEntryPrice(entry.getAvgPrice());
			tradeHistory.setExitPrice(exit.getExitPrice());
			tradeHistory.setQuantity(entry.getQuantity());
			tradeHistory.setInitialCap(entry.getTradeCaptial());
			tradeHistory.setCloseCap(exitCap);
			tradeHistory.setNetProfit(netProfit);
			tradeHistory.setPnlPercent(pnlPercent);
			tradeHistory.setPnl(PNL);
			tradeHistory.setEntryReason(entry.getRemarks());
			tradeHistory.setExitReason(exit.getExitRemarks());
			tradeHistory.setEntryDate(entry.getEntryDate());
			tradeHistory.setExitDate(exit.getExitDate());
			tradeHistory.setTradeDays(tradeDays);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tradeHistory;
	}
}
