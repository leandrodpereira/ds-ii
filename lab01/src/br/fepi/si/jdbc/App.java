package br.fepi.si.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import br.fepi.si.jdbc.ConnectionFactory;

public class App {

	public static void main(String[] args) {
		
		//Sem a fábrica
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/test")) {			
			System.out.println("Conectado com sucesso.");
		} catch (SQLException e) {
			System.err.println("Um erro ocorreu");
			e.printStackTrace();
		}
		
		//Com a fábrica
		try(Connection connection = ConnectionFactory.getConnetion()) {
			System.out.println("Conectado com sucesso pela fábrica.");
		} catch (SQLException e) {
			System.err.println("Um erro ocorreu");
			e.printStackTrace();
		}		
		
		
	}

}
