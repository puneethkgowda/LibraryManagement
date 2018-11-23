package com.journaldev.jsf.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;

import com.journaldev.jsf.util.DataConnect;

public class LoginDAO {

	public static boolean validate(String user, String password) throws Exception {
		Connection con = null;
		

		try {
			con = DataConnect.getConnection();

			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			String queryy = "Select user_name, pwd from table_users where user_name = '"+ user +"' and pwd = '" +password+"'";
			ResultSet rs = stmt.executeQuery(queryy);
			
			while (rs.next())
			{
				System.out.println(rs.getString(1) + "  " + rs.getString(2));
				return true;
			}
		
		} catch (Exception ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return false;
		} finally {
			DataConnect.close(con);
		}
		return false;
	}
}