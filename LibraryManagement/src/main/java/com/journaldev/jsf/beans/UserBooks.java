package com.journaldev.jsf.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import com.journaldev.jsf.dao.CrudBookBasee;
import com.journaldev.jsf.util.SessionUtils;

@ManagedBean
public class UserBooks {
	private int bookisbn;
	private String booktitle;
	private String bookauthor;
	private ArrayList<UserBooks> userBooks = new ArrayList<UserBooks>();

	public UserBooks() {
	}

	public UserBooks(int bookisbn, String booktitle, String bookauthor) {
		this.bookisbn = bookisbn;
		this.booktitle = booktitle;
		this.bookauthor = bookauthor;
	}

	public ArrayList<UserBooks> getUserBooks() {
		userBooks.clear();
		ArrayList<UserBooks> al = new ArrayList<UserBooks>();
		CrudBookBasee crudbookbasee = new CrudBookBasee();
		try {
			ResultSet userBooks = crudbookbasee.GetUserBooks(SessionUtils.getUserId());
			while (userBooks.next()) {
				al.add(new UserBooks(userBooks.getInt(1), userBooks.getString(2), userBooks.getString(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

		return al;
	}

	public void setUserBooks(ArrayList<UserBooks> userBooks) {
		this.userBooks = userBooks;
	}

	public int getBookisbn() {
		return bookisbn;
	}

	public void setBookisbn(int bookisbn) {
		this.bookisbn = bookisbn;
	}

	public String getBooktitle() {
		return booktitle;
	}

	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}

	public String getBookauthor() {
		return bookauthor;
	}

	public void setBookauthor(String bookauthor) {
		this.bookauthor = bookauthor;
	}
}
