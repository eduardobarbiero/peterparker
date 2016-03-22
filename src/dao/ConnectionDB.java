package org.catolicasc.peterparker.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

	public static Connection con = null;
	public static ConnectionDB instance = null;
	private static final String DATABASE = "peter_parker";
	private static final String PASSWORD = "root";
	private static final String USER = "root";

	public ConnectionDB() {
		System.out.println("Conectando ao banco...");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE, USER, PASSWORD);
			System.out.println("Conectado.");
		} catch (ClassNotFoundException ex) {
			System.out.println("Classe não encontrada, adicione o driver nas bibliotecas.");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public static ConnectionDB getInstance() {

		if (instance == null) {
			instance = new ConnectionDB();
		}

		return instance;
	}

}
