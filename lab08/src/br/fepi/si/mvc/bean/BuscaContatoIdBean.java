package br.fepi.si.mvc.bean;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fepi.si.mvc.model.Contato;
import br.fepi.si.mvc.model.dao.ContatoDao;

public class BuscaContatoIdBean implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			Contato c = new ContatoDao().selectId(Long.parseLong(request.getParameter("buscaId")));
			request.setAttribute("contato", c);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "WEB-INF/jsp/buscaContatoId.jsp";
	}

}
