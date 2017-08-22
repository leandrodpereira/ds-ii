package br.fepi.si.jdbc.app;

import br.fepi.si.jdbc.dao.ContatoDao;

public class Delete {

	public static void main(String[] args) {
		

		ContatoDao dao = new ContatoDao();
		dao.delete(13L);
		
		System.out.println("Dados Excluídos");
	}

}
