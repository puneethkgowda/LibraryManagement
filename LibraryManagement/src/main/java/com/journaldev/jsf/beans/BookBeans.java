package com.journaldev.jsf.beans;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

<<<<<<< HEAD:LibraryManagement/src/main/java/com/journaldev/jsf/beans/BeansForCrud.java
import com.journaldev.jsf.dao.CrudBookBasee;
import com.journaldev.jsf.util.SessionUtils;
=======
import com.journaldev.jsf.dao.BookDao;

>>>>>>> origin/develop:LibraryManagement/src/main/java/com/journaldev/jsf/beans/BookBeans.java

@ManagedBean(name = "bookrecords", eager = true)
@RequestScoped
public class BookBeans {
	private int bookisbn;
	private String booktitle;
	private String bookauthor;
	private int bookprice;
<<<<<<< HEAD:LibraryManagement/src/main/java/com/journaldev/jsf/beans/BeansForCrud.java
	private BigDecimal bookquantity;
	private String error = "";
	private ArrayList<BeansForCrud> books = new ArrayList<BeansForCrud>();
=======
	private int bookquantity;
	private boolean update;

	public BookBeans() {
	}

	public boolean isUpdate() {
		return update;
	}
>>>>>>> origin/develop:LibraryManagement/src/main/java/com/journaldev/jsf/beans/BookBeans.java

	public void setUpdate(boolean update) {
		this.update = update;
	}

	public BeansForCrud(int bookisbn, String booktitle, String bookauthor, int bookprice, BigDecimal bookquantity) {
		this.bookisbn = bookisbn;
		this.booktitle = booktitle;
		this.bookauthor = bookauthor;
		this.bookprice = bookprice;
		this.bookquantity = bookquantity;
	}

	public ArrayList<BeansForCrud> getBooks() {
		ArrayList<BeansForCrud> al = new ArrayList<BeansForCrud>();
		CrudBookBasee crudbookbasee = new CrudBookBasee();
		try {

			ResultSet userLendingBooks = crudbookbasee.GetUserBooksForLending(SessionUtils.getUserId());
			while (userLendingBooks.next()) {
				al.add(new BeansForCrud(userLendingBooks.getInt(1), userLendingBooks.getString(2),
						userLendingBooks.getString(3), userLendingBooks.getInt(4), userLendingBooks.getBigDecimal(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

		return al;
	}

	public void setBooks(ArrayList<BeansForCrud> books) {
		this.books = books;
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

	public int getBookprice() {
		return bookprice;
	}

	public void setBookprice(int bookprice) {
		this.bookprice = bookprice;
	}

	public int getBookquantity() {
		return bookquantity;
	}

	public void setBookquantity(int bookquantity) {
		this.bookquantity = bookquantity;
	}
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public void insertNow() {
		BookDao crudbookbasee = new BookDao();
		crudbookbasee.insertnow(getBookisbn(), getBooktitle(), getBookauthor(), getBookprice(), getBookquantity());
	}

<<<<<<< HEAD:LibraryManagement/src/main/java/com/journaldev/jsf/beans/BeansForCrud.java
	public void borrowSelectedBooks() {
		try {
			HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
					.getRequest();
			HttpSession ses = request.getSession(false);	
			CrudBookBasee crudbookbasee = new CrudBookBasee();
			if(request.getParameterValues("bookisbn") != null)
			{
				for(String bookisbn: request.getParameterValues("bookisbn"))
				{
					crudbookbasee.BorrowBooks(bookisbn, SessionUtils.getUserId());
				}
			}
			ses = request.getSession(true);	
		} catch (Exception e) {
			this.error = e.getMessage();
		}
	}
=======
	@Override
	public String toString() {
		return "BookBeans [bookisbn=" + bookisbn + ", booktitle=" + booktitle + ", bookauthor=" + bookauthor
				+ ", bookprice=" + bookprice + ", bookquantity=" + bookquantity + ", update=" + update + "]";
	}

>>>>>>> origin/develop:LibraryManagement/src/main/java/com/journaldev/jsf/beans/BookBeans.java
}
