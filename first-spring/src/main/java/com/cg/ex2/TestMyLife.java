package com.cg.ex2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMyLife {
	@Test
	public void testLifeCycle() {
		// adding configurable application context will allow to close the container
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("com/cg/ex2/appctx.xml");
		MyLife me = (MyLife) ctx.getBean("life");
		ctx.close();
	}
}