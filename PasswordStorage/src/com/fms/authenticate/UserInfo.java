package com.fms.authenticate;

public class UserInfo {
	private String username;
	private String userEncryptedPassword;
	private String userSalt;
	
	@Override
	public String toString() {
		return "UserInfo [username=" + username + ", userENcryptedPassword=" + userEncryptedPassword + ", userSalt="
				+ userSalt + "]";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserEncryptedPassword() {
		return userEncryptedPassword;
	}
	public void setUserEncryptedPassword(String userENcryptedPassword) {
		this.userEncryptedPassword = userENcryptedPassword;
	}
	public String getUserSalt() {
		return userSalt;
	}
	public void setUserSalt(String userSalt) {
		this.userSalt = userSalt;
	}
	
	
}
