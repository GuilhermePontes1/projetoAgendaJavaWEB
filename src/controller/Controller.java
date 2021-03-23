package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans agenda = new JavaBeans();

	public Controller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			agenda(request, response);
		} else if (action.equals("/insert")) {
			novoContatoAgenda(request, response);
		} else {
			response.sendRedirect("index.html");
		}

		// Teste de conexão
		// dao.testeConexao();
	}

	// Lista os contatos
	protected void agenda(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Aqui eu crio um objeto que irá receber os dados do JavaBeans
		ArrayList<JavaBeans> lista = dao.listarAgenda();
		//encaminha a lista para documento agenda.jsp
		request.setAttribute("agenda",lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		
		rd.forward(request, response); //encaminha o objeto lista para agenda.jsp
		

		// teste de recebimento da lista

		
		/*
		 * for (int i = 0; i < lista.size(); i++) {
		 * System.out.println(lista.get(i).getIdcon());
		 * System.out.println(lista.get(i).getNome());
		 * System.out.println(lista.get(i).getFone());
		 * System.out.println(lista.get(i).getEmail());
		 * 
		 * }
		 */

	}

	//}

	// Novo Contato
	protected void novoContatoAgenda(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// TESTE PARA VER O ARMAZENAMENTO
		/*
		 * System.out.println(request.getParameter("nome"));
		 * System.out.println(request.getParameter("fone"));
		 * System.out.println(request.getParameter("email"));
		 */
		// Setar variaveis do javaBeans
		agenda.setNome(request.getParameter("nome"));
		agenda.setFone(request.getParameter("fone"));
		agenda.setEmail(request.getParameter("email"));
		// invocar o metodo inserir contato passando o objeto contato
		dao.inserirContatoAgenda(agenda);
		response.sendRedirect("main");
	}

}