package br.fepi.si.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Leandro
 *
 */
public class DataSource {
	
	public Connection getConnetion() {
			try {
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				return DriverManager.getConnection("jdbc:mysql://localhost/contato","contato","contato");
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		
	}		
}
