package com.cg.ex3;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClient {
	
	@Test
	public void testScope() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cg/ex3/appctx.xml");
		Client c1 = ctx.getBean(Client.class);
		Client c2 = ctx.getBean(Client.class);
		
		System.out.println(c1 == c2);
	}
}
