package com.teejay.Model;

import javax.persistence.*;

@Entity
@Table(name = "trade_exits")
public class TradeExits {

	@Id
	@Column(name = "exitid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int exitId;
	
	@Column(name = "tradeid")
	private int tradeId;

	@Column(name = "exitprice")
	private Double exitPrice;

	@Column(name = "exitremarks")
	private String exitRemarks;

	@Column(name = "exitdate")
	private String exitDate;

	public int getExitId() {
		return exitId;
	}

	public void setExitId(int exitId) {
		this.exitId = exitId;
	}

	public int getTradeId() {
		return tradeId;
	}

	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}

	public Double getExitPrice() {
		return exitPrice;
	}

	public void setExitPrice(Double exitPrice) {
		this.exitPrice = exitPrice;
	}


	public String getExitRemarks() {
		return exitRemarks;
	}

	public void setExitRemarks(String exitRemarks) {
		this.exitRemarks = exitRemarks;
	}

	public String getExitDate() {
		return exitDate;
	}

	public void setExitDate(String exitDate) {
		this.exitDate = exitDate;
	}

}
