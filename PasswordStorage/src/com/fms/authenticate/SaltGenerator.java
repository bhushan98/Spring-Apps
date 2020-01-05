package com.fms.authenticate;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Optional;

public class SaltGenerator {
	private static final SecureRandom RAND = new SecureRandom();
	
	public static Optional<String> generateSalt(final int length){
		if(length < 1) {
			System.out.println("error in generateSalt : length must be > 0 ");
			return Optional.empty();
		}
		
		byte[] salt = new byte[length];
		RAND.nextBytes(salt);
		return Optional.of(Base64.getEncoder().encodeToString(salt));
	}
}
