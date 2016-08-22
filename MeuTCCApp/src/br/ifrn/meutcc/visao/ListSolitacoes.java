package br.ifrn.meutcc.visao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import br.ifrn.meutcc.modelo.Orientador;
import br.ifrn.meutcc.modelo.Tema;

@WebServlet("/ListTemasDoOrientador")
public class ListSolitacoes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListSolitacoes() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String curso = request.getParameter("idCurso");
		String orientador = request.getParameter("idOrientador");
		int idCurso = 1;
		int idOrientador = 1;
		try {
			idCurso = Integer.parseInt(curso);
			idOrientador = Integer.parseInt(orientador);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		Tema modelo = new Tema();
		Orientador modeloOrientador = new Orientador();
		modeloOrientador = modeloOrientador.getOrientador(idOrientador);
		List<Tema> temas = modelo.listTemasDoOrientador(idCurso,idOrientador);
		HttpSession sessao = request.getSession();
		sessao.setAttribute("orientador", modeloOrientador);
		request.setAttribute("temas", temas);
		request.setAttribute("solicitacao", true);
		request.getRequestDispatcher("listaTemas.jsp").forward(request, response);
	}
}
