package br.fepi.si.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class ConnectionFactory {
	
	public static Connection getConnetion() throws SQLException {
			try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/test")) {
				return connection;
			}
		
	}		
}
