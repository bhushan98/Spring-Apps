package com.cg.ax4;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("let")
@Lazy
public class LetterMessage implements Message {
	
	public LetterMessage() {
		System.out.println("Letter Message Ready...");
	}
	
	public void send(String to, String msg) {
		System.out.println("Letter send to: " + to + " with " +msg);
	}
	
}
