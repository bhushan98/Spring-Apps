package com.cg.web;

import java.util.List;

import com.cg.bean.ConsumerBean;
import com.cg.service.BillService;
import com.cg.service.BillServiceImpl;

public class Cli {
	public static void main(String[] args) {
		BillService service = new BillServiceImpl();
		ConsumerBean c = service.findConsumer(100001);
		System.out.println(c);
	}
}
