package br.fepi.si.jdbc.app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import br.fepi.si.jdbc.dao.ContatoDao;
import br.fepi.si.jdbc.model.Contato;

public class Select {

	public static void main(String[] args)  {
		
		ContatoDao dao = new ContatoDao();
		
		try(Scanner s = new Scanner(System.in)){
			System.out.print("Entre com a id: ");
			Contato c = dao.selectId(s.nextLong());
			System.out.println(c.toString());
		}catch (SQLException e) {
			System.err.println("Id inválida");			
		}
		
		
		//Lista
		ContatoDao dao2 = new ContatoDao();
		
		List<Contato> listaContatos = dao2.selectAll();
		
		for (Contato recebecontato: listaContatos){
			System.out.println(recebecontato.toString());	
		}
	}

}
