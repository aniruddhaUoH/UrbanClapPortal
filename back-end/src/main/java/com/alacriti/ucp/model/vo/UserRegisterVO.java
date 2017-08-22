package com.alacriti.ucp.model.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserRegisterVO {
	private String Username;
	private String Email;
	private String User_password;
	private String UserType;

	public UserRegisterVO() {
		super();
	}

	public UserRegisterVO(String Username, String Email, String User_password,
			String UserType) {
		super();
		this.Username = Username;
		this.Email = Email;
		this.User_password = User_password;
		this.UserType = UserType;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getUser_password() {
		return User_password;
	}

	public void setUser_password(String user_password) {
		User_password = user_password;
	}

	public String getUserType() {
		return UserType;
	}

	public void setUserType(String userType) {
		UserType = userType;
	}

}