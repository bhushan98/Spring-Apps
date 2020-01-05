package com.fms.service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import com.fms.bean.UserInfo;
import com.fms.dao.AuthenticatorDao;
import com.fms.dao.AuthenticatorDaoImpl;


public class AuthenticatorServiceImpl implements AuthenticatorService{
	
	private static final SecureRandom RAND = new SecureRandom();
	private static final int ITERATIONS = 65536;
	private static final int KEY_LENGTH = 128; //512
	private static final String ALGORITHM = "PBKDF2WithHmacSHA512";
	private static final int SALT_LENGTH = 128; //512
	
	private AuthenticatorDao dao;
	
	public AuthenticatorServiceImpl() {
		dao = new AuthenticatorDaoImpl(); 
	}
	
	private static Optional<String> generateSalt(final int length){
		if(length < 1) {
			System.out.println("error in generateSalt : length must be > 0 ");
			return Optional.empty();
		}
		
		byte[] salt = new byte[length];
		RAND.nextBytes(salt);
		return Optional.of(Base64.getEncoder().encodeToString(salt));
	}
	
private static Optional<String> hashPassword (String password, String salt){
		
		// converting the password from string to char array
		char[] chars = password.toCharArray();
		// converting the salt from get salt to byte array
		byte[] bytes = salt.getBytes();
		// Cannot keep password int string as strings are immutable 
		
		// Method to generate the key where chars is password, bytes is salt
		PBEKeySpec spec = new PBEKeySpec(chars, bytes, ITERATIONS, KEY_LENGTH);
		
		// clearing the array as it contains password in plain text format by setting everything to null
		Arrays.fill(chars, Character.MIN_VALUE);
		
		try {
			
			SecretKeyFactory fac = SecretKeyFactory.getInstance(ALGORITHM);
			byte[] securePassword = fac.generateSecret(spec).getEncoded();
			return Optional.of(Base64.getEncoder().encodeToString(securePassword));
	
		} catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
			
			System.err.println("Exception occured in hashPassword()");
			return Optional.empty();
		
		} finally {
			
			spec.clearPassword();
		
		}
	}

	@Override
	public boolean addUser(String username, String password, String role) {
		String salt = generateSalt(SALT_LENGTH).get();
		String encryptedPassword = hashPassword(password, salt).get();
		UserInfo user = new UserInfo();
		user.setUsername(username);
		user.setEncpassword(encryptedPassword);
		user.setRole(role);
		user.setUsersalt(salt);
		
		return dao.addUser(user);
	}
	
	@Override
	public String authenticateUser(String username, String password) {
		UserInfo user = dao.getInfo(username);
		if (user == null) {
			return "No user Found";
		} else {
			String salt = user.getUsersalt();
			String calculatedHash = hashPassword(password, salt).get();
			if(calculatedHash.equals(user.getEncpassword())) {
				return "Successful Authentication" + user.getRole();
			} else {
				return "Unsuccessful Authentication";
			}
		}
	}

}
