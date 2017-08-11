package br.fepi.si.jdbc.app;

import java.text.SimpleDateFormat;
import java.util.List;

import br.fepi.si.jdbc.dao.ContatoDao;
import br.fepi.si.jdbc.model.Contato;

public class Select {

	public static void main(String[] args) {
		
		ContatoDao dao = new ContatoDao();
		
		List<Contato> listaContatos = dao.select();
		
		for (Contato recebecontato: listaContatos){
			System.out.println(recebecontato.getId());
			System.out.println(recebecontato.getNome());
			System.out.println(recebecontato.getEmail());
			System.out.println(recebecontato.getEndereco());
			
			System.out.println(new SimpleDateFormat("dd/MM/yyyy").
					format(recebecontato.getDataNascimento().getTimeInMillis()));
		}
	}

}
