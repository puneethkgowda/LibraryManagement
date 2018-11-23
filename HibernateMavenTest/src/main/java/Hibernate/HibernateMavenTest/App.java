package Hibernate.HibernateMavenTest;

import java.util.Date;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		User user = new User();

		user.setUsername("Mukesh");
		user.setCreatedBy("Google");
		user.setCreatedDate(new Date());
		
		Book comic= new Book();
		comic.setBookname("Book1");
		comic.setAuthor("Author1");
		
		Book suspense= new Book();
		suspense.setBookname("Book2");
		suspense.setAuthor("Author2");
		
		UserBook userbooks = new UserBook();
		userbooks.setBookId(30);
		userbooks.setUserId(2);
		
	/*	Set<Book> books= new HashSet<Book>();
		books.add(comic);
		books.add(suspense);

		user.setBooks(books);*/
		
		session.save(user);
		session.save(comic);
		session.save(suspense);
		session.save(userbooks);
		
		session.getTransaction().commit();
		
		session.beginTransaction();
		StoredProcedureQuery query = session
			    .createStoredProcedureQuery("count_users")
			    .registerStoredProcedureParameter(1, Long.class, 
			        ParameterMode.OUT);
			 
			query.execute();
			 
			Long userCount = (Long) query.getOutputParameterValue(1);
			System.out.println(userCount);
		session.getTransaction().commit();
		
		session.close();

	}

}
