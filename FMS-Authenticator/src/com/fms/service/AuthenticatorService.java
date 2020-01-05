package com.fms.service;

public interface AuthenticatorService {
	/*
	 * Reference Links :1. https://dev.to/awwsmm/how-to-encrypt-a-password-in-java-42dh
	 *					2. https://www.quickprogrammingtips.com/java/how-to-securely-store-passwords-in-java.html
	 */
	
	String authenticateUser(String username, String password);
	
	boolean addUser(String username, String password, String role);
	
}
