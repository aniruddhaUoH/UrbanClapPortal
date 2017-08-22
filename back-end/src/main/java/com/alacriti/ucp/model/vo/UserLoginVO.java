package com.alacriti.ucp.model.vo;

public class UserLoginVO {
	private String username;
	private String password;

	public UserLoginVO() {

	}

	public UserLoginVO(String username, String password) {

		this.username = username;
		this.password = password;
	}

	public String getUserName() {
		return username;
	}

	public void setName(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
