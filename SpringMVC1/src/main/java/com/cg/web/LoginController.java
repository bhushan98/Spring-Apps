package com.cg.web;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cg.bean.LoginBean;

@Controller
public class LoginController {
 
// Without using http session i.e. by maps
//	@RequestMapping("/login.do")
//	public String Validate(LoginBean login, Map model) {
//		model.put("message", "Login Successful " + login.getUserid());
//		model.put("login",login);
//		return "output";
//	}
	
	// Access URL: http://localhost:8080/SpringMVC1/login.do
	// Using post method
	@RequestMapping(name = "/login.do", method = RequestMethod.POST)
	public String validate(LoginBean login, HttpSession session) {
		session.setAttribute("login", login);
		return "output";
	}
	
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
	
	
}
