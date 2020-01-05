package com.fms.authenticate;

import java.util.Scanner;

public class Cli {
	public static void main(String[] args) {
		PasswordUtils passManager = new PasswordUtils();
		String username = "admin";
		String password = "password";
		
		passManager.signUp(username, password);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Username");
		String inputUser = sc.next();
		
		
		
		System.out.println("Enter Password");
		String inputPassword = sc.next();
		
		boolean status = passManager.authenticateUser(inputUser, inputPassword);
		if(status)
			System.out.println("Logged in successfully");
		else
			System.out.println("Sorry Wrong username/password");
		
		sc.close();
	}
}
