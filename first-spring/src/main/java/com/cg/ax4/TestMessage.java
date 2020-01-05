package com.cg.ax4;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMessage {
	
	@Test
	public void testProcess() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("appctx.xml");
		
		MessageProcess mp = (MessageProcess) ctx.getBean("mp");
		mp.process("sms", "9876543210", "Hello SMS");
		mp.process("wap", "Bhushan", "Hello Whatsapp");
		mp.process("let", "Mumbai", "Hello Letter");
	}
}
