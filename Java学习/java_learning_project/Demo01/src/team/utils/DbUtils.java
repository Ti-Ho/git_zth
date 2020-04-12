package team.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {
	private static final String URL = "jdbc:mysql://localhost:3306/demo?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123456";
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(AutoCloseable auto) {
		if (auto != null) {
			try {
				auto.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
