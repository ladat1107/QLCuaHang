package hcmute.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {
	private static String DB_URL = "jdbc:mysql://localhost:3306/banhang";
	private static String USER_NAME = "root";
	private static String PASSWORD = "123456";
	private static Connection con;

	public static Connection getConnection() throws IOException {
		con = null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con = (Connection) DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (Exception ex) {
			Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
		}
		return (con);
	}

	public static void main(String[] args) {
		try {

			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select * From category");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "  " + rs.getString(2));
			}
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
