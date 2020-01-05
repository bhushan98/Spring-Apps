package com.cg.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingController {
	
	@RequestMapping("/greet.do")
	public String sayHello(Map<String, String> model) {
		model.put("message", "Welcome to improved MVC");
		return "greeting";
	}
	
	@RequestMapping("/bye.do")
	public String sayGoodbye(Map<String, String> model) {
		model.put("message", "Good Bye !");
		return "greeting";
	}
}
