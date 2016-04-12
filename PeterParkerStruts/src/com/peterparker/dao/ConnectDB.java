package com.peterparker.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

	private static final String URL = "jdbc:mysql://localhost:3306/peter_parker";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	public Connection getConnection() {
		System.out.println("Connecting database...");
		try {
			Class.forName("com.mysql.jdbc.Driver");

			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
