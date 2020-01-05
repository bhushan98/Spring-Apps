package com.cg.ex3;

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
