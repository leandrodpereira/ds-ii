package br.fepi.si.jdbc.app;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.fepi.si.jdbc.dao.ContatoDao;
import br.fepi.si.jdbc.model.Contato;

public class Insert {
	
	public static void main(String[] args) {
		
		Contato contato = new Contato();
		//recebe dados
		contato.setNome("Leandro");
		contato.setEmail("leandro.pereira@fepi.br");
		contato.setEndereco("Itajubá");
		try {
			Date dataEmTexto = new SimpleDateFormat("dd/MM/yyyy").parse("10/03/1984");
			Calendar data = Calendar.getInstance();
			data.setTime(dataEmTexto);
			contato.setDataNascimento(data);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}	
		
		//gravando com o DAO		
		ContatoDao dao = new ContatoDao();
		
		//metedo que adiciona
		dao.insert(contato);
		
		System.out.println("Dados Gravados");
		
	}

}
