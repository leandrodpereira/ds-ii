package br.fepi.si.mvc.bean;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Logica {
	
	String executa (HttpServletRequest request, 
			HttpServletResponse response) throws ServletException;

}
