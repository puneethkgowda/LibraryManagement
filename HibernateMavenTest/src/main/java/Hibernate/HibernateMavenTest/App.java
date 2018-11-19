package Hibernate.HibernateMavenTest;

import java.util.Date;
import org.hibernate.Session;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		User user = new User();

		user.setUserId(1);
		user.setUsername("Mukesh");
		user.setCreatedBy("Google");
		user.setCreatedDate(new Date());

		session.save(user);
		session.getTransaction().commit();

	}

}
