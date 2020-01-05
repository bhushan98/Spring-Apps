package com.cg.ex4;

public class WhatsAppMessage implements Message {
	
	public WhatsAppMessage() {
		System.out.println("Whatsapp Message Ready...");
	}
	
	public void send(String to, String msg) {
		System.out.println("Whatsapp send to: " + to + " with " + msg);
	}

}
