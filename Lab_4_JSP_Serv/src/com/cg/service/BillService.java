package com.cg.service;

import java.util.List;

import com.cg.bean.BillDetailsBean;
import com.cg.bean.ConsumerBean;

public interface BillService {
	
	double fixedAmount = 100;
	
	List<ConsumerBean> listConsumers();
	
	ConsumerBean findConsumer(int cons_no);	
	
	List<BillDetailsBean> listBills(int cons_no);
	
	double addBill(int cons_no, double currUnit, double lastMonthUnit);
	
}
