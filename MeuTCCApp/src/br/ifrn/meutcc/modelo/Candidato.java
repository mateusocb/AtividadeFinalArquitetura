package br.ifrn.meutcc.modelo;

import java.util.List;

import br.ifrn.meutcc.persistencia.CandidatoDAO;
import br.ifrn.meutcc.persistencia.FabricaDAO;

public class Candidato {
	private int id;
	private String nome;
	private CandidatoDAO dao;
	
	public Candidato() {
		super();
		dao = FabricaDAO.getInstancia("mysql").createCandidatoDAO();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Candidato getCandidato(int idCandidato) {
		return dao.getCandidato(idCandidato);
	}
}
