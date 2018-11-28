package com.journaldev.jsf.beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import com.journaldev.jsf.dao.BookDao;

@ManagedBean
@ViewScoped
public class BookCrudController {
	private List<BookBeans> bookbeanlist = null;
	private BookDao bookcrudoperation = null;
	private BookBeans CurrentBook = null;

	@PostConstruct
	private void init() {

		if (bookbeanlist == null) {
			bookbeanlist = new ArrayList<BookBeans>();
		}
		if (bookcrudoperation == null) {
			bookcrudoperation = new BookDao();
			// bookcrudoperation.Connect_To_DB();
		}
		try {
			// bookbeanlist.clear();
			bookbeanlist.addAll(bookcrudoperation.showBooks());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error in getting the list of Books");
		}
	}

	public List<BookBeans> getBookbean() {
		return bookbeanlist;
	}

	public void setBookbean(List<BookBeans> bookbean) {
		this.bookbeanlist = bookbean;
	}

	public void updateRow(BookBeans e) {
		CurrentBook = e;
		e.setUpdate(true);
	}

	public void saveBook() {
		/*
		 * bb.setBookisbn(1004); bb.setBooktitle("Manual"); bb.setBookauthor("Manual");
		 * bb.setBookquantity(2); bb.setBookprice(1);
		 */
		bookcrudoperation.updateBook(CurrentBook);
		try {
			bookbeanlist.clear();
			bookbeanlist.addAll(bookcrudoperation.showBooks());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error in getting the list of Books");
		}
	}

	public void deleteBook(BookBeans bb) {
		CurrentBook = null;
		CurrentBook = bb;
		try {
			bookcrudoperation.deleteBook(bb.getBookisbn());
			bookbeanlist.clear();
			try {
				bookbeanlist.addAll(bookcrudoperation.showBooks());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Error in getting the list of Books");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error deleting Books");
		}
	}

	public void insertRow(BookBeans bb) {
		System.out.println(bb);
		bookcrudoperation.addBook(bb);
		try {
			bookbeanlist.clear();
			bookbeanlist.addAll(bookcrudoperation.showBooks());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error in getting the list of Books");
		}
	}

}
