package com.bank.dbutil;

import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnection {
	private static Connection connection;
	
	private PostgresConnection() {
		
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		String url="jdbc:postgresql://localhost:5432/postgres";
		String user ="postgres";
		String password ="Afzaal@12";
		connection=DriverManager.getConnection(url, user, password);
		return connection;
	}

}
