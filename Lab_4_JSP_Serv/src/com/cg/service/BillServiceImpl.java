package com.cg.service;

import java.util.List;

import com.cg.bean.BillDetailsBean;
import com.cg.bean.ConsumerBean;
import com.cg.dao.BIllDao;
import com.cg.dao.BillDaoImpl;

public class BillServiceImpl implements BillService {

	private BIllDao dao;
	
	public BillServiceImpl() {
		dao = new BillDaoImpl();
	}
	
	@Override
	public List<ConsumerBean> listConsumers() {
		return dao.listConsumers();
	}

	@Override
	public ConsumerBean findConsumer(int cons_no) {
		return dao.findConsumer(cons_no);
	}

	@Override
	public List<BillDetailsBean> listBills(int cons_no) {
		return dao.listBillDetails(cons_no);
	}

	@Override
	public double addBill(int cons_no, double currUnit, double lastMonthUnit) {
		double amount = fixedAmount + (currUnit - lastMonthUnit) * 1.15;
		BillDetailsBean bill = new BillDetailsBean();
		bill.setConsumer_num(cons_no);
		bill.setCurr_reading(currUnit);
		bill.setNetAmount(amount);
		bill.setUnitConsumed(currUnit-lastMonthUnit);
		dao.addBill(bill);
		return amount;
	}

}
