package connpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectToODB {

	public Connection getConnResult() {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:HA", "hr", "hr");

			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("select * from KEM");

			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2));

			con.close();
			return con;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
