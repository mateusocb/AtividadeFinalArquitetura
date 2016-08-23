package br.ifrn.meutcc.visao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ifrn.meutcc.modelo.Tema;

@WebServlet("/ListAVerificar")
public class ListAVerificar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListAVerificar() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("listAVerificar.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String situacao = request.getParameter("situacao");
		Tema tema = new Tema();
		tema = tema.getTema(Integer.parseInt(situacao.substring(0, situacao.length() -1)));
		if(situacao.substring(situacao.length()-1).equals("A")) {
			tema.setVerificado(true);
		} else {
			tema.setVerificado(false);
		}
		request.getRequestDispatcher("listAVerificar.jsp").forward(request, response);
	}
}
