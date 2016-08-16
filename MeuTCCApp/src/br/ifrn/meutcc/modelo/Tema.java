package br.ifrn.meutcc.modelo;

import java.util.List;

import br.ifrn.meutcc.persistencia.FabricaDAO;
import br.ifrn.meutcc.persistencia.TemaDAO;

public class Tema {
	private int id;
	private String titulo;
	private String descricao;
	private TemaDAO dao;
	private List<Candidato> listaCandidato;
	
	public Tema() {
		super();
		dao = FabricaDAO.getInstancia("mysql").createTemaDAO();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Tema> listTemas(int idCurso) {
		return dao.listTemas(idCurso);
	}
	public Tema getTema(int idTema) {
		return dao.getTema(idTema);
	}
	public List<Tema> listTemasDoOrientador(int idCurso, int idOrientador) {
		return dao.listTemasDoOrientador(idCurso, idOrientador);
	}
	public List<Candidato> getListaCandidato() {
		return listaCandidato;
	}
	public List<Candidato> setlistaCandidato(int idTema) {
		return dao.atualizaListCandidatoTema(idTema);
	}
}
