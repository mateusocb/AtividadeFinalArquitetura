package br.ifrn.meutcc.visao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ifrn.meutcc.modelo.Candidato;
import br.ifrn.meutcc.modelo.Tema;

@WebServlet("/ViewTemaSolicitacoes")
public class ViewTemaSolicitacoes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewTemaSolicitacoes() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tema = request.getParameter("id");
		int idTema = 1;
		try {
			idTema = Integer.parseInt(tema);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		Tema modelo = new Tema();
		Tema temaVisto = modelo.getTema(idTema);
		modelo.setlistaCandidato(idTema);
		List<Candidato> candidatos = modelo.getListaCandidato();
		request.setAttribute("tema", temaVisto);
		request.setAttribute("candidatos", candidatos);
		request.getRequestDispatcher("viewTemaSolicitacoes.jsp").forward(request, response);
	}
}
