package com.cg.ax3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Client {
	private static Client c;
	
	
	public Client() {
		System.out.println("Client constructor");
	}
	
	public static Client getClient() {
		System.out.println("Client singleton");
		if(c == null)
			c = new Client();
		
		return c;
	}
}
