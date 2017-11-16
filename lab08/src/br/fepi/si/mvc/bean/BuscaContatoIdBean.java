package br.fepi.si.mvc.bean;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fepi.si.mvc.model.Contato;
import br.fepi.si.mvc.model.dao.ContatoDaoIoC;
import br.fepi.si.mvc.model.dao.DataSource;

public class BuscaContatoIdBean implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			/*Sem Inversão de Controle - Alto Acoplamento
			 * Contato c = new ContatoDao().selectId(Long.parseLong(request.getParameter("buscaId")));
			request.setAttribute("contato", c); */
			
			//Com Inversão de Controle - Médio Acoplamento (depende de getConnetion())
			//Connection c = new DataSource().getConnetion();			
			
			//Com objeto passado via request pelo Filtro		
			Connection c = (Connection) request.getAttribute("connection");
			
			
			Contato contato =
					new ContatoDaoIoC(c).selectId(Long.parseLong(request.getParameter("buscaId")));
			//O DAO espera que a dependência seja Injetada
			request.setAttribute("contato", contato);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "WEB-INF/jsp/buscaContatoId.jsp";
	}

}
