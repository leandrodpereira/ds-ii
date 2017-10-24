package br.fepi.si.mvc.bean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TesteLogicaBean implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		System.out.println("Executando a lógica "+request.getParameter("bean"));
		return "WEB-INF/jsp/primeiraLogica.jsp";
	}

}
