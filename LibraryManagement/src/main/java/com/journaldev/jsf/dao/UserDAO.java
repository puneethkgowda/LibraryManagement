package com.journaldev.jsf.dao;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import com.journaldev.jsf.beans.ConnectionStatusBean;
import com.journaldev.jsf.beans.UserBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.journaldev.jsf.util.DataConnect;

import oracle.jdbc.OracleTypes;


public class UserDAO {

	private Connection connection;
	private CallableStatement statment;
	private ResultSet rs;
	private ConnectionStatusBean connectionStatusBean;
	
	public boolean SaveUser(String username, String password, String role) throws Exception {
		Connection con = null;
		

		try {
			con = DataConnect.getConnection();

			Statement stmt = con.createStatement();
			int userid = (int)(Math.random() * 100000); 
			int count = stmt.executeUpdate("insert into table_users values('" + userid + "', '" + username + "','" + password + "','" + role +"')");

			con.commit();
			
			if (count > 0) {
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
	
	public void Connect_To_DB() {
		connectionStatusBean = new ConnectionStatusBean();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@haar0548:1523:hadb", "acelitydev", "passcode");
			connectionStatusBean.setStatus("yes");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in Connect_To_DB method");
			e.printStackTrace();
			connectionStatusBean.setStatus("No");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in Connect_To_DB method");
			e.printStackTrace();
			connectionStatusBean.setStatus("No");
		}
	}

	public void Disconnect_To_DB() {
		try {
			statment.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Error in Disconnect_To_DB method");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void adduser(UserBean UserBean) {
		Connect_To_DB();
		try {
			statment = connection.prepareCall("{call add_users(?,?,?,?,?)}");
			statment.setString(1, UserBean.getUsername());
			statment.setString(2, UserBean.getPassword());
			statment.setString(3, UserBean.getRole());
			
			statment.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error in adduser method");
		}
		Disconnect_To_DB();
	}

	public void deleteuser(int userid) {
		Connect_To_DB();
		try {
			statment = connection.prepareCall("{call del_user(?)}");
			statment.setInt(1, userid);
			statment.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error in deleteuser method");
		}
		Disconnect_To_DB();
	}

	public void updateuser(UserBean UserBean) {
		Connect_To_DB();
		try {
			statment = connection.prepareCall("{call update_user(?,?)}");
			statment.setInt(1, UserBean.getUserId());
			statment.setString(2, UserBean.getRole());
			
			statment.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in updateuser method");
			e.printStackTrace();
		}
		Disconnect_To_DB();
	}

	public List<UserBean> showusers() throws SQLException {
		List<UserBean> userlist = new ArrayList<UserBean>();
		Connect_To_DB();
		statment = connection.prepareCall("{ ? = call show_allusers }");
		statment.registerOutParameter(1, OracleTypes.CURSOR);
		statment.execute();
		rs = (ResultSet) statment.getObject(1);
		while (rs.next()) {
			UserBean bb = new UserBean();
			bb.setUserId(rs.getInt("userid"));
			bb.setUsername(rs.getString("user_name"));
			bb.setPassword(rs.getString("pwd"));
			bb.setRole(rs.getString("role"));
			userlist.add(bb);
		}
		Disconnect_To_DB();
		return userlist;
	}

	
}