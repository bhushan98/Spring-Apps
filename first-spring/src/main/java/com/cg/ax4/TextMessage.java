package com.cg.ax4;

import org.springframework.stereotype.Component;

@Component("sms")
public class TextMessage implements Message {
	
	public TextMessage() {
		System.out.println("Text Message Ready...");
	}
	
	public void send(String to, String msg) {
		System.out.println("SMS send to: " + to + " with " +msg);
	}
}
