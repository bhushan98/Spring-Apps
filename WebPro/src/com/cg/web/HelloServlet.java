package com.cg.web;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int visitCount;
	
	@Override
	public void init() throws ServletException {
		visitCount = 1001;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// setting response MIME type
		response.setContentType("text/html");
		
		// getting output stream for response
		PrintWriter out = response.getWriter();
		
		//printing HTML on response stream
		out.println("<h1>Hello Beautiful World</h1>");
		out.println("<h2>Welcome to my first servlet</h2>");
		out.println("<h3>Hey there !!</h3>");
		
		Date now  = new Date();
		out.println("<h3> Visit Time : "+ now +"</h3>");
		
		// getting servlet's configuration object
		ServletConfig config = getServletConfig();
		
		// reading init-param from config
		String author = config.getInitParameter("Author");
		out.println("<h3> Servlet Author: "+ author + "</h3>" );
		out.println("<h3> Servlet Name: " + config.getServletName() + "</h3>");
		
		out.println("<h3> You are visitor number: "+ visitCount++ +"</h3>"
				+ "");
	}

}
