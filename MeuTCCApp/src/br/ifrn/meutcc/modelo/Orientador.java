package br.ifrn.meutcc.modelo;

import br.ifrn.meutcc.persistencia.FabricaDAO;
import br.ifrn.meutcc.persistencia.OrientadorDAO;

public class Orientador {
	private int id;
	private String nome;
	private int qtdLimite=2;
	private int qtdAtual=0;
	private OrientadorDAO dao;
	
	public Orientador(){
		super();
		dao = FabricaDAO.getInstancia("mysql").createOrientadorDAO();
	}
	
	public Orientador getOrientador(int idOrientador) {
		return dao.getOrientador(idOrientador);
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

	public int getQtdLimite() {
		return qtdLimite;
	}

	public void setQtdLimite(int qtdLimite) {
		this.qtdLimite = qtdLimite;
	}
	
	public int getQtdAtual() {
		return qtdAtual;
	}
	
	public int setQtdAtual(int idOrientador) {
		this.qtdAtual=dao.setQtdAtual(idOrientador);
		return this.qtdAtual;
	}
	
}
