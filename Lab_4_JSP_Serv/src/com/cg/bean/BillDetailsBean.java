package com.cg.bean;

import java.sql.Date;

public class BillDetailsBean {
	private int bill_num;
	private int consumer_num;
	private double curr_reading;
	private double unitConsumed;
	private double netAmount;
	private Date bill_date;
	
	
	public int getBill_num() {
		return bill_num;
	}
	public void setBill_num(int bill_num) {
		this.bill_num = bill_num;
	}
	public int getConsumer_num() {
		return consumer_num;
	}
	public void setConsumer_num(int consumer_num) {
		this.consumer_num = consumer_num;
	}
	public double getCurr_reading() {
		return curr_reading;
	}
	public void setCurr_reading(double curr_reading) {
		this.curr_reading = curr_reading;
	}
	public double getUnitConsumed() {
		return unitConsumed;
	}
	public void setUnitConsumed(double unitConsumed) {
		this.unitConsumed = unitConsumed;
	}
	public double getNetAmount() {
		return netAmount;
	}
	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}
	public Date getBill_date() {
		return bill_date;
	}
	public void setBill_date(Date bill_date) {
		this.bill_date = bill_date;
	}
	
	
	
}
