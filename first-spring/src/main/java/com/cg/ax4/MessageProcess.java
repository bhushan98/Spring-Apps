package com.cg.ax4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service("mp")
public class MessageProcess {
	@Autowired
	private ApplicationContext appCtx;
	
	public void process(String type, String to, String msg) {
		Message message = (Message) appCtx.getBean(type);
		message.send(to, msg);
	}

}
