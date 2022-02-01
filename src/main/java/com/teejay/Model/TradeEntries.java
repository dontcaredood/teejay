package com.teejay.Model;

import javax.persistence.*;

@Entity
@Table(name = "trade_entries")
public class TradeEntries {

//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "userid",insertable = false, updatable = false)
//	private User users;
	// @ManyToOne(cascade = CascadeType.ALL)
	// @JoinColumn(name = "loginid", insertable = false, updatable = false)
	// private User users;

	@Id
	@Column(name = "tradeid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tradeId;
	
	@Column(name = "userid")
	private int userId;

	@Column(name = "securityname")
	private String securityName;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "avgprice")
	private Double avgPrice;

	@Column(name = "tradecaptial")
	private Double tradeCaptial;

	@Column(name = "remarks")
	private String remarks;

	@Column(name = "entrydate")
	private String entryDate;
	
	@Column(name = "isactive")
	private String isActive;

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

//	public User getUsers() {
//		return users;
//	}
//
//	public void setUsers(User users) {
//		this.users = users;
//	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTradeId() {
		return tradeId;
	}

	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}

	public String getSecurityName() {
		return securityName;
	}

	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(Double avgPrice) {
		this.avgPrice = avgPrice;
	}

	public Double getTradeCaptial() {
		return tradeCaptial;
	}

	public void setTradeCaptial(Double tradeCaptial) {
		this.tradeCaptial = tradeCaptial;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

}
