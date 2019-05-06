package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigConnection {
	public static Connection getConnection() throws SQLException {
		String url = "localhost";
		String user = "root";
		String password = "";
		return DriverManager.getConnection(url, user, password);
	}
}
