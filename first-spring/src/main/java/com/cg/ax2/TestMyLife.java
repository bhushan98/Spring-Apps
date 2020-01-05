package com.cg.ax2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMyLife {
	@Test
	public void testLifeCycle() {
		// adding configurable application context will allow to close the container
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("appctx.xml");
		MyLife me = (MyLife) ctx.getBean("life");
		ctx.close();
	}
}