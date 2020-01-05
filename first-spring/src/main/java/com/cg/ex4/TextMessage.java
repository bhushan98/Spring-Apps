package com.cg.ex4;

public class TextMessage implements Message {
	
	public TextMessage() {
		System.out.println("Text Message Ready...");
	}
	
	public void send(String to, String msg) {
		System.out.println("SMS send to: " + to + " with " +msg);
	}
}
