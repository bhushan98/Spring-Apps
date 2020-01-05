package com.fms.bean;

public class UserInfo {
	
	private String username;
	private String encpassword;
	private String role;
	private String usersalt;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEncpassword() {
		return encpassword;
	}
	public void setEncpassword(String encpassword) {
		this.encpassword = encpassword;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUsersalt() {
		return usersalt;
	}
	public void setUsersalt(String usersalt) {
		this.usersalt = usersalt;
	}
	
}
