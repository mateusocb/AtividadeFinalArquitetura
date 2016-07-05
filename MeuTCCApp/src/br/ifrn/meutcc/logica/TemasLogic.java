package br.ifrn.meutcc.logica;

import java.util.List;

import br.ifrn.meutcc.modelo.Tema;

public class TemasLogic {
	private Tema tema;
	
	public TemasLogic() {
		tema = new Tema();
	}

	public List<Tema> listTemas(int idCurso) {
		return tema.listTemas(idCurso);
	}
}
