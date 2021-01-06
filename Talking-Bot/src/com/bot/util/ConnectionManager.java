package com.bot.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	private static final String url ="jdbc:mysql://localhost:3306/talking_bot";
	private static final String user="root";
	private static final String password="admin";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
}
