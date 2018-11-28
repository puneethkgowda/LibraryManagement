package com.journaldev.jsf.dao;

import java.util.List;

import com.journaldev.jsf.beans.BookBeans;
import com.journaldev.jsf.beans.ConnectionStatusBean;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import oracle.jdbc.internal.OracleTypes;
 
public class BookDao {
	private Connection connection;
	private CallableStatement statment;
	private ResultSet rs;
	private ConnectionStatusBean connectionStatusBean;

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

	public void addBook(BookBeans bookbeans) {
		Connect_To_DB();
		try {
			statment = connection.prepareCall("{call add_books(?,?,?,?,?)}");
			statment.setInt(1, bookbeans.getBookisbn());
			statment.setString(2, bookbeans.getBooktitle());
			statment.setString(3, bookbeans.getBookauthor());
			statment.setInt(4, bookbeans.getBookprice());
			statment.setInt(5, bookbeans.getBookquantity());
			statment.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error in addBook method");
		}
		Disconnect_To_DB();
	}

	public void deleteBook(int isbn) {
		Connect_To_DB();
		try {
			statment = connection.prepareCall("{call del_book(?)}");
			statment.setInt(1, isbn);
			statment.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error in deleteBook method");
		}
		Disconnect_To_DB();
	}

	public void updateBook(BookBeans bookbeans) {
		Connect_To_DB();
		try {
			statment = connection.prepareCall("{call update_book(?,?,?,?,?)}");

			statment.setInt(1, bookbeans.getBookisbn());
			statment.setString(2, bookbeans.getBooktitle());
			statment.setString(3, bookbeans.getBookauthor());
			statment.setInt(4, bookbeans.getBookprice());
			statment.setInt(5, bookbeans.getBookquantity());

			statment.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in updateBook method");
			e.printStackTrace();
		}
		Disconnect_To_DB();
	}

	public List<BookBeans> showBooks() throws SQLException {
		List<BookBeans> booklist = new ArrayList<BookBeans>();
		Connect_To_DB();
		statment = connection.prepareCall("{ ? = call show_allbooks }");
		statment.registerOutParameter(1, OracleTypes.CURSOR);
		statment.execute();
		rs = (ResultSet) statment.getObject(1);
		while (rs.next()) {
			BookBeans bb = new BookBeans();
			bb.setBookisbn(rs.getInt("BKISBN"));
			bb.setBooktitle(rs.getString("BKNAME"));
			bb.setBookauthor(rs.getString("BKAUTHOR"));
			bb.setBookprice(rs.getInt("BKPRICE"));
			bb.setBookquantity(rs.getInt("BKQUANTITY"));
			booklist.add(bb);
		}
		Disconnect_To_DB();
		return booklist;
	}

	public BookBeans showBookByISBN() throws SQLException {
		BookBeans bb = new BookBeans();
		Connect_To_DB();
		statment = connection.prepareCall("{call show_isbnbook(?)}");
		statment.registerOutParameter(1, OracleTypes.CURSOR);
		statment.execute();
		rs = (ResultSet) statment.getObject(1);
		while (rs.next()) {
			bb.setBookisbn(rs.getInt("BKISBN"));
			bb.setBooktitle(rs.getString("BKNAME"));
			bb.setBookauthor(rs.getString("BKAUTHOR"));
			bb.setBookprice(rs.getInt("BKPRICE"));
			bb.setBookquantity(rs.getInt("BKQUANTITY"));
		}
		Disconnect_To_DB();
		return bb;
	}

	public String insertnow(int bkisbn, String bkname, String bkauthor, int bkprice, int bkquantity) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@haar0548:1523:hadb", "acelitydev",
					"passcode");
			Statement stmt = con.createStatement();

			int count = stmt.executeUpdate("insert into books values(" + bkisbn + ",'" + bkname + "','" + bkauthor
					+ "'," + bkprice + ",'" + bkquantity + "')");

			con.commit();

			if (count > 0) {
				return "Success";
			}

		} catch (ClassNotFoundException e) { // TODO Auto-generated catch block
			e.printStackTrace();

			return "fail";

		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();

			return "fail";

		}
		return "";
	}

}
