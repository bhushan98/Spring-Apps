package com.cg.ax1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("greet")
public class Greeting {
	private String message;
	
	public Greeting() {
	}
	
	public Greeting(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	@Value("Hello Spring")
	public void setMessage(String message) {
		this.message = message;
	}
	
}
