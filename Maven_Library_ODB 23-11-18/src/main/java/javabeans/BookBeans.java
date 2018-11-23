package javabeans;

import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;

import connpackage.BookCrudOpeation;

@ManagedBean
public class BookBeans {
	private int bookisbn;
	private String booktitle;
	private String bookauthor;
	private int bookprice;
	private int bookquantity;
	private boolean update;

	public BookBeans() {
	}

	public boolean isUpdate() {
		return update;
	}

	public void setUpdate(boolean update) {
		this.update = update;
	}

	public String getBooktitle() {
		return booktitle;
	}

	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}

	public int getBookisbn() {
		return bookisbn;
	}

	public void setBookisbn(int bookisbn) {
		this.bookisbn = bookisbn;
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

	public void callinsert() {
		System.out.println("called");
	}

	public void insertNow() {
		BookCrudOpeation crudbookbasee = new BookCrudOpeation();
		crudbookbasee.insertnow(getBookisbn(), getBooktitle(), getBookauthor(), getBookprice(), getBookquantity());
	}

	@Override
	public String toString() {
		return "BookBeans [bookisbn=" + bookisbn + ", booktitle=" + booktitle + ", bookauthor=" + bookauthor
				+ ", bookprice=" + bookprice + ", bookquantity=" + bookquantity + ", update=" + update + "]";
	}

}
