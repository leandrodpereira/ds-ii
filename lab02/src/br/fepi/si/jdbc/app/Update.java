package br.fepi.si.jdbc.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.fepi.si.jdbc.dao.ContatoDao;
import br.fepi.si.jdbc.model.Contato;

public class Update {

	public static void main(String[] args) {
		Contato contato = new Contato();
		//recebe dados
		contato.setNome("João");
		contato.setEmail("joão@fepi.br");
		contato.setEndereco("Itabira");
		try {
			Date dataEmTexto = new SimpleDateFormat("dd/MM/yyyy").parse("09/04/1994");
			Calendar data = Calendar.getInstance();
			data.setTime(dataEmTexto);
			contato.setDataNascimento(data);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}	
		contato.setId((long) 1);
		//gravando com o DAO		
		ContatoDao dao = new ContatoDao();
		
		//metedo que adiciona
		dao.update(contato);
		
		System.out.println("Dados Alterados");
		

	}

}
