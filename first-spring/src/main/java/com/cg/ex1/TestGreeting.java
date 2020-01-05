package com.cg.ex1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestGreeting {
	
	@Test
	public void testMessage() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cg/ex1/appctx.xml");
		Greeting g = (Greeting) ctx.getBean("greet");
		System.out.println(g.getMessage());
	}
}
