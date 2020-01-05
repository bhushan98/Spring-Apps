package com.cg.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.bean.BillDetailsBean;
import com.cg.bean.ConsumerBean;
import com.cg.service.BillService;
import com.cg.service.BillServiceImpl;


@WebServlet("/EBillServlet")
public class EBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BillService service;
    
    @Override
    public void init() throws ServletException {
    	service = new BillServiceImpl();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("consumerNo");
		String referer = request.getHeader("referer");
		String list = request.getParameter("list");
		
		if(referer.contains("searchConsumer")) {
			int consumerNo = Integer.parseInt((request.getParameter("consumerNo")));
			ConsumerBean consumer = service.findConsumer(consumerNo);
			System.out.println(consumer);
			request.setAttribute("USER", consumer);
			getServletContext().getRequestDispatcher("/searchResult.jsp").forward(request, response);
		}
		else if(list != null) {
			List<ConsumerBean> consumers = service.listConsumers();
			request.setAttribute("USERS", consumers);
			getServletContext().getRequestDispatcher("/listConsumers.jsp").forward(request, response);
		}
		else if(action != null) {
			int consumerNo = Integer.parseInt((request.getParameter("consumerNo")));
			List<BillDetailsBean> bills = service.listBills(consumerNo);
			request.setAttribute("bills", bills);
			getServletContext().getRequestDispatcher("/listBills.jsp").forward(request, response);
		}
		else if(referer.contains("generateBill")) {
			double currUnit = Double.parseDouble(request.getParameter("currreading"));
			double lastMonthUnit = Double.parseDouble(request.getParameter("lastreading"));
			int consumerNo = Integer.parseInt(request.getParameter("cons_no"));
			double amount = service.addBill(consumerNo, currUnit, lastMonthUnit);
			request.setAttribute("amount", amount);
			request.setAttribute("consumer", consumerNo);
			request.setAttribute("units", (currUnit - lastMonthUnit));
			getServletContext().getRequestDispatcher("/bill_info.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
