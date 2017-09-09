package br.fepi.sistemas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ServletApp extends HttpServlet {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		/**
		 * Init e Destroy
		*/
		public void init(ServletConfig config) throws ServletException {
		super.init(config);
			log("Iniciando a servlet");
		}
	
		public void destroy() {
			super.destroy();
			log("Destruindo a servlet");
		}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Primeira Servlet </title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Primeira aplicação Servlet!!!</h1>");
		out.println("<h2>");
		out.println("Você está em: "+request.getRequestURI()+"<br/>");
		out.println("Fez esta requisão em: ");
		out.println(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(System.currentTimeMillis()));
		out.println("</h2>");
		out.println("</body>");
		out.println("</html>");
		
	}
	

}
