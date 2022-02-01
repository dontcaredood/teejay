package com.teejay.Model;

import javax.persistence.*;

@Entity
@Table(name = "trade_histories")
public class TradeHistories {
	@Id
	@Column(name = "historyid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int historyId;
	
	@Column(name = "tradeid")
	private int tradeId;
	
	@Column(name = "userid")
	private int userId;
	
	@Column(name = "security")
	private String security;
	
	@Column(name = "entryprice")
	private double entryPrice;
	
	@Column(name = "exitprice")
	private double exitPrice;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "initialcap")
	private double initialCap;
	
	@Column(name = "closecap")
	private double closeCap;
	
	@Column(name = "netprofit")
	private double netProfit;
	
	@Column(name = "pnlpercent")
	private double pnlPercent;
	
	@Column(name = "pnl")
	private String pnl;
	
	@Column(name = "entryreason")
	private String entryReason;
	
	@Column(name = "exitreason")
	private String exitReason;
	
	@Column(name = "entrydate")
	private String entryDate;
	
	@Column(name = "exitdate")
	private String exitDate;
	
	@Column(name = "tradedays")
	private int tradeDays;

	public int getHistoryId() {
		return historyId;
	}

	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}

	public int getTradeId() {
		return tradeId;
	}

	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public double getEntryPrice() {
		return entryPrice;
	}

	public void setEntryPrice(double entryPrice) {
		this.entryPrice = entryPrice;
	}

	public double getExitPrice() {
		return exitPrice;
	}

	public void setExitPrice(double exitPrice) {
		this.exitPrice = exitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getInitialCap() {
		return initialCap;
	}

	public void setInitialCap(double initialCap) {
		this.initialCap = initialCap;
	}

	public double getCloseCap() {
		return closeCap;
	}

	public void setCloseCap(double closeCap) {
		this.closeCap = closeCap;
	}

	public double getNetProfit() {
		return netProfit;
	}

	public void setNetProfit(double netProfit) {
		this.netProfit = netProfit;
	}

	public double getPnlPercent() {
		return pnlPercent;
	}

	public void setPnlPercent(double pnlPercent) {
		this.pnlPercent = pnlPercent;
	}

	public String getPnl() {
		return pnl;
	}

	public void setPnl(String pnl) {
		this.pnl = pnl;
	}

	public String getEntryReason() {
		return entryReason;
	}

	public void setEntryReason(String entryReason) {
		this.entryReason = entryReason;
	}

	public String getExitReason() {
		return exitReason;
	}

	public void setExitReason(String exitReason) {
		this.exitReason = exitReason;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	public String getExitDate() {
		return exitDate;
	}

	public void setExitDate(String exitDate) {
		this.exitDate = exitDate;
	}

	public int getTradeDays() {
		return tradeDays;
	}

	public void setTradeDays(int tradeDays) {
		this.tradeDays = tradeDays;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	
	
}
