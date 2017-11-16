package br.fepi.si.mvc.bean.filtros;

import java.io.IOException;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.fepi.si.mvc.model.dao.DataSource;

/**
 * @version 1.0
 * @author leandro
 * Classe que filtra e acopla um objeto connection para ser utilizado em qualquer Bean
 */

@WebFilter("/mvc")
public class FiltroConcexao implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc)
			throws IOException, ServletException {
		
		try {
			Connection c = new DataSource().getConnetion();
			// "pendura um objeto no Request"
			req.setAttribute("connection", c);

			fc.doFilter(req, res);

			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
