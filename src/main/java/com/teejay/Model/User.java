package com.teejay.Model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "users_table")
public class User {
	@Id
	@Column(name = "userid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "userpass")
	private String password;

	@Column(name = "useremail")
	private String userEmail;
	
	@Column(name = "usermobile")
	private int userMobile;
	
	@Column(name = "userlevel")
	private int userLevel;

	@Column(name = "lastlogin")
	private String lastLogin;
	
	@Column(name = "isactive")
	private String isActive;
	
	@Column(name = "loginid")
	private String loginId;
	
//	@OneToMany(fetch = FetchType.EAGER,mappedBy="users",cascade = CascadeType.ALL)
//    private Set<TradeEntries> tradeEntries;
//
//	public Set<TradeEntries> getTradeEntries() {
//		return tradeEntries;
//	}
//
//	public void setTradeEntries(Set<TradeEntries> tradeEntries) {
//		this.tradeEntries = tradeEntries;
//	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(int userMobile) {
		this.userMobile = userMobile;
	}

	public int getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	
}
