package com.journaldev.jsf.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;

import com.journaldev.jsf.beans.UserBean;
import com.journaldev.jsf.util.DataConnect;

public class LoginDAO {

	public static UserBean validate(String user, String password) throws Exception {
		Connection con = null;
		
		UserBean bb = new UserBean();
		try {
			con = DataConnect.getConnection();

			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			String queryy = "Select user_name, pwd, role from table_users where user_name = '"+ user +"' and pwd = '" +password+"'";
			ResultSet rs = stmt.executeQuery(queryy);
			
			while (rs.next())
			{
				
				bb.setUsername(rs.getString("user_name"));
				bb.setPassword(rs.getString("pwd"));
				bb.setRole(rs.getString("role"));
				return bb;
			}
		
		} catch (Exception ex) {
			System.out.println("Login error -->" + ex.getMessage());
			//return false;
		} finally {
			DataConnect.close(con);
		}
		//return false;
		return bb;
	}
}