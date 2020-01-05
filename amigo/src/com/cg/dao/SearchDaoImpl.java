package com.cg.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleDriver;

import com.cg.bean.LoginBean;
import com.cg.bean.SearchBean;
import com.cg.bean.UserBean;

public class SearchDaoImpl implements SearchDao {

	private Connection getConnection() throws SQLException{
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		DriverManager.registerDriver(new OracleDriver());
		Connection conn = DriverManager.getConnection(url,"bhushan","oracle");
		return conn;
	}
	
	@Override
	public UserBean authenticate(LoginBean login) {
		Connection conn = null;
		UserBean user;
		
		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(authenticate);
			stmt.setString(1, login.getUserid());
//			stmt.setString(1, "1001");
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next())
			{
				user = new UserBean();
				user.setUserid(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setName(rs.getString(3));
				user.setAge(rs.getInt(4));
				user.setGender(rs.getString(5));
				user.setCity(rs.getString(6));
				user.setEmail(rs.getString(7));
			} else {
				System.out.println("Eroro");
				return null;	// User Not Found
			}
			
			if(user.getPassword().equals(login.getPassword())){
				System.out.println("Success");
				return user;}
			else
				return null;	// Invalid Password
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			
		} finally {
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	@Override
	public boolean persist(UserBean user) {
		Connection conn = null;
		
		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(add);
			stmt.setString(1, user.getUserid());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getName());
			stmt.setInt(4, user.getAge());
			stmt.setString(5, user.getGender());
			stmt.setString(6, user.getCity());
			stmt.setString(7, user.getEmail());
			
//			stmt.setString(1, "1001");
//			stmt.setString(2, "Pass");
//			stmt.setString(3, "Name");
//			stmt.setInt(4, 21);
//			stmt.setString(5, "Male");
//			stmt.setString(6, "Mumbai");
//			stmt.setString(7, "Mail");
			
			int rs = stmt.executeUpdate();
			if(rs > 0)
				return true;
			else 
				return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public List<UserBean> search(SearchBean search) {
		Connection conn = null;
		String query = searchMain;
		List<UserBean> users = new ArrayList<UserBean>();
 		
		try {
			conn = getConnection();
			System.out.println(search.getCity());
			
//			if(search.getAgeFrom() != 0 && search.getAgeTo() != 0)
			
			query = query + searchAge;
			
			if(!search.getCity().equals(""))
				query = query + searchCity;
				
			System.out.println(query);
			
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, search.getGender());
			stmt.setInt(2, search.getAgeFrom());
			stmt.setInt(3, search.getAgeTo());
			if(!search.getCity().equals(""))
				stmt.setString(4, search.getCity());
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				UserBean user = new UserBean();
				user.setUserid(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setName(rs.getString(3));
				user.setAge(rs.getInt(4));
				user.setGender(rs.getString(5));
				user.setCity(rs.getString(6));
				user.setEmail(rs.getString(7));
				users.add(user);
			}
				return users;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
	}
}
