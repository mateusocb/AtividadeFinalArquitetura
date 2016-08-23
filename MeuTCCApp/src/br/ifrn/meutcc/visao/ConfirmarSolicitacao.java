package br.ifrn.meutcc.visao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ifrn.meutcc.modelo.Orientador;
import br.ifrn.meutcc.modelo.Tema;

@WebServlet("/ConfirmarSolicitacao")
public class ConfirmarSolicitacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = request.getParameter("result");
		request.setAttribute("result", result);
		request.getRequestDispatcher("confirmarSolicitacao.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idCandidatoText = request.getParameter("candidato");
		String idTemaText = request.getParameter("tema");
		int idCandidato = -1;
		int idTema = -1;
		try {
			idCandidato = Integer.parseInt(idCandidatoText);
			idTema = Integer.parseInt(idTemaText);
		} catch (NumberFormatException nfex) {
			nfex.printStackTrace();
		}
		HttpSession session = request.getSession();
		Orientador orientador =(Orientador) session.getAttribute("orientador");
		System.out.println(orientador.getQtdLimite());
		System.out.println(orientador.getQtdAtual());
		Tema modelTema = new Tema();
		Tema tema = modelTema.getTema(idTema);
		if (orientador.getQtdLimite() > orientador.getQtdAtual()) {
			tema.setDisponibilidade(idCandidato);
			orientador.setQtdAtual(orientador.getId());
			System.out.println(orientador.getQtdAtual());
			request.setAttribute("result", true);
		} else {
			tema.setAVerificar(idCandidato);
			request.setAttribute("result", false);
		}
		request.getRequestDispatcher("confirmarSolicitacao.jsp").forward(request, response);
	}

}
