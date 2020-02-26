package com.cts.swr.model;

import java.io.Serializable;

public class AppUserModel implements Serializable{
	private static final long serialVersionUID=5926468583005150707L;
	private String userName;
	private String password;
	
	public AppUserModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AppUserModel(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
