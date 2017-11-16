package br.fepi.si.mvc.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fepi.si.mvc.model.Contato;
import br.fepi.si.mvc.model.dao.ContatoDao;

public class AlteraContatoBean implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		Calendar data = Calendar.getInstance();
		try {
			Date dataEmTexto = new SimpleDateFormat("dd/MM/yyyy").
					parse(request.getParameter("dataNascimento"));		
			
			data.setTime(dataEmTexto);				
			
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		Contato c = new Contato();
		
		long id = Long.parseLong(request.getParameter("id"));
		c.setNome(nome);
		c.setEmail(email);
		c.setEndereco(endereco);
		c.setDataNascimento(data);
		
		ContatoDao dao = new ContatoDao();
		dao.update(c, id);
		return "/mvc?bean=BuscaContatoIdBean&buscaId="+id;		
	}

}
