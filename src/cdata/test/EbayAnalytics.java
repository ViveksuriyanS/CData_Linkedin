package cdata.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EbayAnalytics {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("cdata.jdbc.ebayanalytics.EbayAnalyticsDriver");

		
		Connection conn = DriverManager.getConnection("jdbc:ebayanalytics:InitiateOAuth=GETANDREFRESH;CallbackURL='https://localhost:3000';OAuthClientId='Viveksur-CDATATes-PRD-52eb6be68-f0bbc863';OAuthClientSecret='PRD-2eb6be68472a-d09b-4d32-ba3d-854c';OauthAccessToken='v^1.1#i^1#f^0#r^0#I^3#p^3#t^H4sIAAAAAAAAAOVXa2wUVRTutttqgYJRg9ooWQaqBp3dOzM7uztDd8vSbemWPrbd3YLlUedxZ3fs7swwc7ftRgi1GH7UGOUR0PpDElBDwPBQ8PEPNZIQggZDfESJhMSIYGJIFPkhOjN9sC0RlMWkifNnMueee+73fefcufeAwYrKRZubNl+pctxVumsQDJY6HMRMUFlR/sTsstLq8hJQ4ODYNbhw0DlU9mOtwWUzGtsJDU1VDOgayGYUg7WNQSynK6zKGbLBKlwWGiwS2Hi4tYUl3YDVdBWpgprBXNFIEKMgAyhfQBJ5QJOcjzKtynjMhBrERAqIAgAkAxkYAIzfHDeMHIwqBuIUFMRIQAIc+HDgTQCaJQjW63UzAbIbc3VB3ZBVxXRxAyxkw2XtuXoB1ptD5QwD6sgMgoWi4cZ4ezgaaWhL1HoKYoXGdIgjDuWMyV/1qghdXVwmB2++jGF7s/GcIEDDwDyh0RUmB2XD42BuA74tNePlIUlRAegP+BkhQN8RKRtVPcuhm+OwLLKIS7YrCxUko/ytFDXV4J+BAhr7ajNDRCMu69WR4zKyJEM9iDUsDT+VjDd0Yq54LKarfbIIRYspSdCA8JMUEcBCfXIf7DUD83qPF4wtNBptTOYpK9WriihbohmuNhUthSZqOFUbUKCN6dSutOthCVmICv384xr6qW4rqaNZzKG0YuUVZk0hXPbnrTMwXhLXi+BOFQXFSDTpo/2Mj6G9foa8oSisvX4bhRGychOOxTwWFshzeTzL6b0QaRlOgLhgypvLQl0WWYqWSCogQVz0MRLuZSQJ52nRhxMShABCnheYwP+pPhDSZT6H4ESNTB2wSQYxS1NW5iQWqb1QSeQ1iE31tH89Y4UxYASxNEIa6/H09/e7+ym3qqc8JACEZ2VrS1xIwyyHTfjKt3bGZbtEBGjOMmQWmQCC2IBZgebiSgoLdTY0djbEm3oS7csb2sardxKy0FTr3zCNQ0GHaHqxkyHftU7tEpvUzgToaEzlM7HejhSTbgk0K92NKxR1RbIjzK9cTrT0B4sjL6gajKkZWcj/9wrYe/1fqEDpYozTUT4OMxnTUBRRwyI6vZJszTfMAJwmu63t5hbUrEflzF+2ZeqxEXsMk7ubU7hMHsmC4dYhJ6pKJl+UFmFNi2azOcTxGRgVp5coXoLyB6ii6U0zVl32KZDT8fpIOBFOQAOPdUZwmoS8j4e+AC4B8yAK+Irj3ZqSpw9t51BpxKZuzQjQNGG+QXH8IrBvuuWVMy83Ii/xuM/vFXGvIBI455cYnOKgwAgCQUlicZzrM7J5Rk+/47dJNRAU/ym1KYaCu8cN107P5L4vVGI/xJDjCBhyHDJbR+ABNcQCML+iLOksm1VtyAi6zXuK25BTitnO6NDdC/MaJ+ulFQ4tyf1UU9Bp7loDHpzoNSvLiJkFjSd4+PpIOTHngSpTEB/wApogvN5usOD6qJOY67y/S0s+XpWoX3m8eXF1al9621vHVl8EVRNODkd5iXPIUSJvb337o9ibw3u05JbohvuuzHl15/t4y3vkz6m6Rem6lw4P7b9W7qz9ffuerc4nR34p6T8248COptl7e/ZvXnuG3pE+FdMqStwzhs6vOnDx241nLj9CLZuzsfn54b2vzFucrBpxHNijnF5/7t6z3Vs+PHxp37ZzJ7d9Oov7s+Oe3V+F3hjZGl52vPTz6Nrho4e2Ht1Uqaw5+N35a/SShRUX2jrv5mcMnDgZh/pzu9ul6o9/UHcPosSvf3ygrqKuNo+s++K3o7Xr511Z/dC1nTW5g0/3nBY/u/zaziMvj/S8W/P1i99/suCFLYcufZlMbV84f0VQWJJYd6FudeLZud/UzXv9xNXqDfMrzz72zppHy05tGk3fX8VLR9UDEAAA'");

		Statement stat = conn.createStatement();
		boolean ret = stat.execute("SELECT * FROM StandardsProfiles");
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

// https://www.linkedin.com/oauth/v2/authorization?response_type=code&client_id=86fc0f098jn0ol&redirect_uri=http://localhost:33332&scope=r_liteprofile%20r_emailaddress%20w_member_social
