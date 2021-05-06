package cdata.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class LinkedInX {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("cdata.jdbc.linkedin.LinkedInDriver");
		Properties prop = new Properties();
		prop.setProperty("InitiateOAuth", "GETANDREFRESH");
		prop.setProperty("OAuthClientId", "86fc0f098jn0ol");
		prop.setProperty("OAuthClientSecret", "AuY9cpaFWzR7mtTF");
		prop.setProperty("CallbackURL", "http://localhost:8080");

//		prop.setProperty("CallbackURL", "http://google.com");
		prop.setProperty("CompanyId", "TechLearnX");

		Connection conn = DriverManager.getConnection("jdbc:linkedin:", prop);
		Statement stat = conn.createStatement();
		boolean ret = stat.execute("SELECT VisibilityCode, Comment FROM CompanyStatusUpdates");
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
// https://www.linkedin.com/oauth/v2/authorization?response_type=code&client_id=86fc0f098jn0ol&redirect_uri=http://localhost:8080/springmvc/&scope=r_liteprofile%20r_emailaddress%20w_member_social
// http://localhost:8080/springmvc/?code=AQRN5c-A27JeWaSGnHMOfvZG_fs03m60UAI5BW6bv3uikevCZpQBEySuIBcLKrH8oLuQtIh8rM3Nbc6i3LiWagkv8cvlHljwXruMdYsINqhApuPJL_c19kMsOo9eXX1-UnfcAYQDOwP-7K_glCaKpPwvH--7j7rMxMFrLyvv6lbym7qgorFdwmwtC76CYg
// http://localhost:8080/springmvc/
// https://www.linkedin.com/oauth/v2/authorization?response_type=code&client_id=86fc0f098jn0ol&redirect_uri=http://localhost:33332&scope=r_liteprofile%20r_emailaddress%20w_member_social
//http://localhost:3000/auth/linkedin/callback
// https://www.linkedin.com/uas/oauth2/accessToken
// https://www.linkedin.com/oauth/v2/authorization?scope=r_emailaddress%2Cr_ads%2Cw_organization_social%2Crw_ads%2Cr_basicprofile%2Cr_liteprofile%2Cr_ads_reporting%2Cr_organization_social%2Cr_member_social%2Crw_organization_admin%2Cw_member_social%2Cr_1st_connections_size&client_id=86fc0f098jn0ol&response_type=code&redirect_uri=http%3A%2F%2Flocalhost%3A33333