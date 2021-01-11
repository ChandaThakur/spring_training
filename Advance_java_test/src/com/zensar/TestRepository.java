package com.zensar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utility.DBUtil;



public class TestRepository {
	
	public boolean checkLogin(String username,String password) {
		System.out.println("in Respsitory");
		//boolean result=true;
		Connection con=DBUtil.getMySqlDbConnection();
		
		String sql="select * from log_in where username=?";
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, username);
			System.out.println(username);
			ResultSet rs=pst.executeQuery();
			
			
			while(rs.next()) {
				String passwordCheck=rs.getString("password");
				if(password.equals(passwordCheck)) {
					return true;
				}else {
					System.out.println("Wrong login");
				}
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
		}

}
