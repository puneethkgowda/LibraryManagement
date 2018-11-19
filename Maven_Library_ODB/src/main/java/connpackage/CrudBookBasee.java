package connpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.catalina.startup.ConnectorCreateRule;

public class CrudBookBasee {
	public String insertnow(int bkisbn, String bkname, String bkauthor, int bkprice, String bkcat) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:HA", "hr", "hr");
			Statement stmt = con.createStatement();

			int count = stmt.executeUpdate("insert into books values(" + bkisbn + ",'" + bkname + "','" + bkauthor
					+ "'," + bkprice + ",'" + bkcat + "')");

			con.commit();

			if (count > 0) {
				return "Success";
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return "fail";

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return "fail";

		}
		return "";
	}

}
