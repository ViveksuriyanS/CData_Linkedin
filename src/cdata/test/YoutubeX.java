package cdata.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class YoutubeX {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("cdata.jdbc.youtube.YouTubeDriver");
		Properties prop = new Properties();
		prop.setProperty("InitiateOAuth", "GETANDREFRESH");

		Connection conn = DriverManager.getConnection("jdbc:youtube:", prop);
		Statement stat = conn.createStatement();
		boolean ret = stat.execute("SELECT Id, ViewCount FROM Videos");
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

// https://www.linkedin.com/oauth/v2/authorization?response_type=code&client_id=86moammarg01l5&redirect_uri=http://localhost:33332&scope=r_liteprofile%20r_emailaddress%20w_member_social
