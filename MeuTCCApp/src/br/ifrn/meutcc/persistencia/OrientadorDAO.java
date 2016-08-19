package br.ifrn.meutcc.persistencia;

import br.ifrn.meutcc.modelo.Orientador;

public interface OrientadorDAO {
	public Orientador getOrientador(int idOrientador);
	public int setQtdAtual(int idOrientador);
}
