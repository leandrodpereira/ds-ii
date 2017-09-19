package br.fepi.si.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
	
	public Connection getConnetion() {
			try {
				return DriverManager.getConnection("jdbc:mysql://localhost/contato","contato","contato");
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		
	}		
}
