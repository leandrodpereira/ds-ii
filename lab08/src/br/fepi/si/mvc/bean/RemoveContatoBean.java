package br.fepi.si.mvc.bean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fepi.si.mvc.model.dao.ContatoDao;

public class RemoveContatoBean implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		long id = Long.parseLong(request.getParameter("id"));
		new ContatoDao().delete(id);
		return "mvc?bean=ListaContatosBean";
	}

}
