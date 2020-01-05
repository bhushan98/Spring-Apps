package com.fms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fms.bean.UserInfo;

public class AuthenticatorDaoImpl implements AuthenticatorDao {

	@Override
	public boolean addUser(UserInfo user) {
		Connection conn = null;
		
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(save);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getEncpassword());
			stmt.setString(3, user.getRole());
			stmt.setString(4, user.getUsersalt());
			
			int update = stmt.executeUpdate();
			
			if(update > 0)
				return true;
			else 
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public UserInfo getInfo(String username) {
		Connection conn = null;
		UserInfo user = null;
		
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(get);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				user = new UserInfo();
				user.setUsername(rs.getString(1));
				user.setEncpassword(rs.getString(2));
				user.setRole(rs.getString(3));
				user.setUsersalt(rs.getString(4));	
			}
			else {
				return null;
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) 
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
