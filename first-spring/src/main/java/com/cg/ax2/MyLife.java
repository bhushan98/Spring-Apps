package com.cg.ax2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component("life")
public class MyLife {
	
	public MyLife() {
		System.out.println("My life constructor");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("My life initializer");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("My life destroyer");
	}
}
