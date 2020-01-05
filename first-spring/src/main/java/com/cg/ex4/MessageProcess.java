package com.cg.ex4;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MessageProcess implements ApplicationContextAware{
	private ApplicationContext appCtx;
	
	public void process(String type, String to, String msg) {
		Message message = (Message) appCtx.getBean(type);
		message.send(to, msg);
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.appCtx = applicationContext;
	}
	
}
