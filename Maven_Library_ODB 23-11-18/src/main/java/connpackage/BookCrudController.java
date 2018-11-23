package connpackage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import javabeans.BookBeans;

@ManagedBean
@ViewScoped
public class BookCrudController {
	private List<BookBeans> bookbeanlist = null;
	private BookCrudOpeation bookcrudoperation = null;
	private BookBeans CurrentBook = null;

	@PostConstruct
	private void init() {

		if (bookbeanlist == null) {
			bookbeanlist = new ArrayList<BookBeans>();
		}
		if (bookcrudoperation == null) {
			bookcrudoperation = new BookCrudOpeation();
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
		System.out.println("should print");
		System.out.println(CurrentBook);
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

	public void insertRow() {
		BookBeans dataNewBook = new BookBeans();
		dataNewBook.getBookisbn();
		dataNewBook.getBooktitle();
		dataNewBook.getBookauthor();
		dataNewBook.getBookprice();
		dataNewBook.getBookquantity();
		bookcrudoperation.addBook(dataNewBook);
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
