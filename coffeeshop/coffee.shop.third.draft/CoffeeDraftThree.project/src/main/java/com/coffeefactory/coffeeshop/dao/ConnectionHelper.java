package com.coffeefactory.coffeeshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Establishes database connection
 *
 */
public class ConnectionHelper {
	private String url;
	private static ConnectionHelper instance;

	/**
	 * Private constructor
	 */
	private ConnectionHelper() {
		url = "jdbc:mysql://localhost/coffeedb?user=coffeeman&password=lovecoffeepassword";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Cannot establish DB connection", e);
		}
	}

	/**
	 * Returns database connection
	 */
	public static Connection getConnection() throws SQLException {
		if (instance == null) {
			instance = new ConnectionHelper();
		}
		
		return DriverManager.getConnection(instance.url);
	}
}
