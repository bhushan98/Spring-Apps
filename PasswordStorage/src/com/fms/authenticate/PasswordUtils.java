package com.fms.authenticate;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordUtils {
	
	private static final SecureRandom RAND = new SecureRandom();
	private static final int ITERATIONS = 65536;
	private static final int KEY_LENGTH = 512;
	private static final String ALGORITHM = "PBKDF2WithHmacSHA512";
	private static final int SALT_LENGTH = 512;
	
	private Map<String , UserInfo> userDatabase = new HashMap<String, UserInfo>();
	
	// Sign Up method
	public void signUp(String username, String password) {
		String salt = generateSalt(SALT_LENGTH).get();
		String encryptedPassword = hashPassword(password, salt).get();
		UserInfo user = new UserInfo();
		user.setUserEncryptedPassword(encryptedPassword);
		user.setUsername(username);
		user.setUserSalt(salt);
		saveUser(user);
	}
	
	// To save the user into userDatabase
	private void saveUser(UserInfo user) {
		userDatabase.put(user.getUsername(),user);
		System.out.println(userDatabase);
	}
	
	// To authenticate user
	public boolean authenticateUser(String inputUser, String password) {
		UserInfo user = userDatabase.get(inputUser);
		if (user == null)
			return false;
		else {
			String salt = user.getUserSalt();
			String calculatedHash = hashPassword(password, salt).get();
			if(calculatedHash.equals(user.getUserEncryptedPassword())) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	// To generate Salt by SecureRandom class
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
	
}
