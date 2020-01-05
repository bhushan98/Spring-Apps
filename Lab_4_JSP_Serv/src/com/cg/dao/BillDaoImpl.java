package com.cg.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cg.bean.BillDetailsBean;
import com.cg.bean.ConsumerBean;

import oracle.jdbc.OracleDriver;

public class BillDaoImpl implements BIllDao {
	
	public BillDaoImpl() {
	}
	
	private Connection getConnection() throws SQLException{
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		DriverManager.registerDriver(new OracleDriver());
		Connection conn = DriverManager.getConnection(url,"bhushan","oracle");
		return conn;
	}
	
	@Override
	public List<ConsumerBean> listConsumers() {
		Connection conn = null;
		List<ConsumerBean> consumers = new ArrayList<ConsumerBean>() ;
		ConsumerBean consumer;
		
		try {
			conn = getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from consumers");
			
			while(rs.next()) {
				consumer = new ConsumerBean();
				consumer.setConsumer_num(rs.getInt(1));
				consumer.setConsumer_name(rs.getString(2));
				consumer.setAddress(rs.getString(3));
				consumers.add(consumer);
			}
				return consumers;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public ConsumerBean findConsumer(int cons_no) {
		
		Connection conn = null;
		List<ConsumerBean> consumers = new ArrayList<ConsumerBean>() ;
		ConsumerBean consumer = new ConsumerBean();
		
		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement("select * from consumers where CONSUMER_NUM = ?");
			stmt.setInt(1, cons_no);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				consumer.setConsumer_num(rs.getInt(1));
				consumer.setConsumer_name(rs.getString(2));
				consumer.setAddress(rs.getString(3));
			}
			 return consumer;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		 
	}

	@Override
	public List<BillDetailsBean> listBillDetails(int cons_no) {
		Connection conn = null;
		List<BillDetailsBean> bills = new ArrayList<BillDetailsBean>() ;
		BillDetailsBean bill;
		
		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement("select * from billdetails where CONSUMER_NUM = ?");
			stmt.setInt(1, cons_no);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				bill = new BillDetailsBean();
				bill.setBill_num(rs.getInt(1));
				bill.setConsumer_num(rs.getInt(2));
				bill.setCurr_reading(rs.getDouble(3));
				bill.setUnitConsumed(rs.getDouble(4));
				bill.setNetAmount(rs.getDouble(5));
				bill.setBill_date(rs.getDate(6));
				bills.add(bill);
			}
				return bills;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean addBill(BillDetailsBean bill) {
		Connection conn = null;
		
		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement("insert into billdetails (bill_num, consumer_num, cur_reading, unitconsumed, netamount, bill_date) values (seq_bill_num.nextval, ?, ?, ?, ?, sysdate)");
			stmt.setInt(1, bill.getConsumer_num());
			stmt.setDouble(2, bill.getCurr_reading());
			stmt.setDouble(3, bill.getUnitConsumed());
			stmt.setDouble(4, bill.getNetAmount());
			return stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
