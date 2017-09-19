package br.fepi.si.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fepi.si.jdbc.dao.ContatoDao;
import br.fepi.si.jdbc.model.Contato;

@WebServlet("/contatos")
/**
 * Classe que herda de Servlet
 * @author Leandro
 *
 */
public class AdicionaContatoServlet extends HttpServlet {

	
	private static final long serialVersionUID = -6919696316192850082L;
	private Calendar data = Calendar.getInstance();;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		try {
			Date dataEmTexto = new SimpleDateFormat("dd/MM/yyyy").
					parse(request.getParameter("dataNascimento"));
			
			data.setTime(dataEmTexto);				
			
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		Contato c = new Contato();
		
		c.setNome(nome);
		c.setEmail(email);
		c.setEndereco(endereco);
		c.setDataNascimento(data);
		
		ContatoDao dao = new ContatoDao();
		dao.insert(c);
		
				
		System.out.println("Dados gravados com sucesso!");
	}

}
