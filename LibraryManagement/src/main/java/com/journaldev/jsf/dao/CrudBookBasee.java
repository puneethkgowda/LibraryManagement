package com.journaldev.jsf.dao;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.ResultSet;

import com.journaldev.jsf.util.DataConnect;

public class CrudBookBasee {

	public String insertnow(int bkisbn, String bkname, String bkauthor, int bkprice, BigDecimal bkquantity) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DataConnect.getConnection();
			Statement stmt = con.createStatement();

			int count = stmt.executeUpdate("insert into books values(" + bkisbn + ",'" + bkname + "','" + bkauthor
					+ "'," + bkprice + ",'" + bkquantity + "')");

			con.commit();

			if (count > 0) {
				return "Success";
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return "fail";

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return "fail";

		}
		return "";
	}

	public ResultSet GetUserBooks(String userId) {
		ResultSet userBooks = null;
		Connection con = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DataConnect.getConnection();
			Statement stmt = con.createStatement();
			String query = "SELECT b.BKISBN, b.BKNAME, b.BKAUTHOR FROM Books b INNER JOIN UserBooks ub ON b.BKISBN = ub.BKISBN WHERE ub.USERID = "
					+ userId + "";
			userBooks = stmt.executeQuery(query);
			con.commit();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userBooks;
	}

	public ResultSet GetUserBooksForLending(String userId) {
		ResultSet userLendingBooks = null;
		Connection con = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DataConnect.getConnection();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM BOOKS  WHERE BKQUANTITY > 0 AND"
					+ " BKISBN NOT IN (SELECT BKISBN FROM USERBOOKS WHERE USERID =  to_number(" + userId + "))";
			userLendingBooks = stmt.executeQuery(query);
			con.commit();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userLendingBooks;
	}

	/*
	 * public ResultSet GetUserBooksForLending(String userId) { ResultSet
	 * userLendingBooks = null; Connection con = null; CallableStatement stmt;
	 * 
	 * try { Class.forName("oracle.jdbc.driver.OracleDriver"); con =
	 * DataConnect.getConnection(); stmt =
	 * con.prepareCall("{call GET_LENDING_USERBOOKS(?)}"); stmt.setString(1,
	 * userId); userLendingBooks = stmt.getResultSet(); con.commit(); } catch
	 * (ClassNotFoundException e) { e.printStackTrace();
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); }
	 * 
	 * return userLendingBooks; }
	 */

	public void BorrowBooks(String bookisbn, String userId) {
		Connection con = null;
		CallableStatement stmt;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DataConnect.getConnection();
			stmt = con.prepareCall("{call USER_BORROW_BOOKS(?,?)}");
			stmt.setString(1, bookisbn);
			stmt.setString(2, userId);
			stmt.execute();
			con.commit();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
