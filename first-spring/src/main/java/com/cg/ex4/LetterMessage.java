package com.cg.ex4;

public class LetterMessage implements Message {
	
	public LetterMessage() {
		System.out.println("Letter Message Ready...");
	}
	
	public void send(String to, String msg) {
		System.out.println("Letter send to: " + to + " with " +msg);
	}
	
}
