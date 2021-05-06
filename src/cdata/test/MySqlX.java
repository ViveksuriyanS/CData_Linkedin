package cdata.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class MySqlX {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("cdata.jdbc.mysql.MySQLDriver");
		Properties prop = new Properties();
		prop.setProperty("User", "root");
		prop.setProperty("Password", "");
		prop.setProperty("Database", "marvel");
		prop.setProperty("Server", "localhost");
		prop.setProperty("Port", "3306");

		Connection conn = DriverManager.getConnection("jdbc:mysql:", prop);

		Statement stat = conn.createStatement();
		boolean ret = stat.execute("select * FROM cast");
		if (ret) {
			ResultSet rs = stat.getResultSet();
			while (rs.next()) {
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					System.out.println(rs.getMetaData().getColumnName(i) + "=" + rs.getString(i));
				}
			}
		}
	}
}
