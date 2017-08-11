package br.fepi.si.jdbc.app;

import br.fepi.si.jdbc.dao.ContatoDao;
import br.fepi.si.jdbc.model.Contato;

public class Delete {

	public static void main(String[] args) {
		
		Contato contato = new Contato();
		contato.setId((long) 1);

		ContatoDao dao = new ContatoDao();
		dao.delete(contato);
		
		System.out.println("Dados Excluídos");
	}

}
