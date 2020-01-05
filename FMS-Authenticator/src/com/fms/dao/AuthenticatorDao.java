package com.fms.dao;

import com.fms.bean.UserInfo;

public interface AuthenticatorDao {
	
	/*
	 * Table : CREATE TABLE USERDETAILS (
	 * 			USERNAME VARCHAR2(20) NOT NULL,
	 * 			ENCPASSWORD VARCHAR(512) NOT NULL,
	 * 			ROLE VARCHAR2(20) NOT NULL,
	 * 			USERSALT VARCHAR2(512) NOT NULL);
	 */
	String save = "insert into userdetails values (?,?,?,?)";
	String get = "select * from userdetails where username = ?";
	
	
	boolean addUser(UserInfo user);
	
	UserInfo getInfo(String user);
	
}
