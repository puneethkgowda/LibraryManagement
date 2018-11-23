package Hibernate.HibernateMavenTest;

public class UserBook {
	private int Id;
	private int userId;
	private int bookId;
	
	public int getId() {
		return Id;
	}
	
	public void setId(int id) {
		Id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
}
