package com.journaldev.jsf.beans;

import java.math.BigDecimal;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.journaldev.jsf.dao.CrudBookBasee;

@ManagedBean
@RequestScoped
public class BeansForCrud {
	private int bookisbn;
	private String booktitle;
	private String bookauthor;
	private int bookprice;
	private BigDecimal bookquantity;

	public BeansForCrud() {
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

	public BigDecimal getBookquantity() {
		return bookquantity;
	}

	public void setBookquantity(BigDecimal bookquantity) {
		this.bookquantity = bookquantity;
	}

	public void callinsert() {
		System.out.println("called");
	}

	public String insertNow() {
		CrudBookBasee crudbookbasee = new CrudBookBasee();
		crudbookbasee.insertnow(getBookisbn(), getBooktitle(), getBookauthor(), getBookprice(), getBookquantity());
		return "";
	}
}
