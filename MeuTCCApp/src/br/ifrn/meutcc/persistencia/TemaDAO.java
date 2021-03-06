package br.ifrn.meutcc.persistencia;

import java.util.List;

import br.ifrn.meutcc.modelo.Candidato;
import br.ifrn.meutcc.modelo.Orientador;
import br.ifrn.meutcc.modelo.Tema;

public interface TemaDAO {
	public List<Tema> listTemas(int idCurso);
	public Tema getTema(int idTema);
	public List<Tema> listTemasDoOrientador(int idCurso, int idOrientador);
	public List<Candidato> atualizaListCandidatoTema(int idTema);
	public void setDisponibilidade(int id, int idCandidato);
	public void setVerificado(int id, boolean resultado);
	public void setAVerificar(int id, int idCandidato);
	public Candidato getCandidato(int idTema);
	public Orientador getOrientador(int idTema);
	public List<Tema> listTemasAVerificar(int idCurso);
}