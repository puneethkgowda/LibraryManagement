package com.journaldev.jsf.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.journaldev.jsf.util.DataConnect;

public class CrudBookBasee {
	
	public String insertnow(int bkisbn, String bkname, String bkauthor, int bkprice, BigDecimal bkquantity) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con =  DataConnect.getConnection();
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

}
