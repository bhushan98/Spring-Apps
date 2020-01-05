package com.cg.dao;

import java.util.List;

import com.cg.bean.BillDetailsBean;
import com.cg.bean.ConsumerBean;

public interface BIllDao {
	List<ConsumerBean> listConsumers();
	
	ConsumerBean findConsumer(int cons_no);
	
	List<BillDetailsBean> listBillDetails(int cons_no);
	
	boolean addBill(BillDetailsBean bill);
	
}
