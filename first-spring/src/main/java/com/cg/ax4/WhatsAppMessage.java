package com.cg.ax4;

import org.springframework.stereotype.Component;

@Component("wap")
public class WhatsAppMessage implements Message {
	
	public WhatsAppMessage() {
		System.out.println("Whatsapp Message Ready...");
	}
	
	public void send(String to, String msg) {
		System.out.println("Whatsapp send to: " + to + " with " + msg);
	}

}
