package br.fepi.si.mvc.bean;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fepi.si.mvc.model.Contato;
import br.fepi.si.mvc.model.dao.ContatoDao;

public class ListaContatosBean implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		List<Contato> contatos = new ContatoDao().selectAll();
		request.setAttribute("contatos", contatos);
		return "WEB-INF/jsp/listaContatos.jsp";
	}

}
