package com.journaldev.jsf.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpSession;
import com.journaldev.jsf.beans.UserBean;
import com.journaldev.jsf.util.DataConnect;
import com.journaldev.jsf.util.SessionUtils;

public class LoginDAO {

	public static UserBean validate(String user, String password) throws Exception {
		Connection con = null;
		
		UserBean bb = new UserBean();
		try {
			con = DataConnect.getConnection();

			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			String queryy = "Select user_name, pwd, role, userid from table_users where user_name = '"+ user +"' and pwd = '" +password+"'";
			ResultSet rs = stmt.executeQuery(queryy);
			
			while (rs.next())
			{

				System.out.println(rs.getString(1) + "  " + rs.getString(2) + " " + rs.getString(3));
				HttpSession session = SessionUtils.getSession();
				session.setAttribute("userrole", rs.getString(3));
				session.setAttribute("userid", rs.getString(4));

				
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