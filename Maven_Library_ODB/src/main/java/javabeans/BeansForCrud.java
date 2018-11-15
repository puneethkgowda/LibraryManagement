package javabeans;


public class BeansForCrud {
	private String bookisbn;
	private String booktitle;
	private String bookauthor;
	private String bookprice;
	private String bookcat;

	public BeansForCrud() {
	}

	public String getBooktitle() {
		return booktitle;
	}

	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}

	public String getBookisbn() {
		return bookisbn;
	}

	public void setBookisbn(String bookisbn) {
		this.bookisbn = bookisbn;
	}

	public String getBookauthor() {
		return bookauthor;
	}

	public void setBookauthor(String bookauthor) {
		this.bookauthor = bookauthor;
	}

	public String getBookprice() {
		return bookprice;
	}

	public void setBookprice(String bookprice) {
		this.bookprice = bookprice;
	}

	public String getBookcat() {
		return bookcat;
	}

	public void setBookcat(String bookcat) {
		this.bookcat = bookcat;
	}

	public void callinsert() {
		System.out.println("called");
	}

}
