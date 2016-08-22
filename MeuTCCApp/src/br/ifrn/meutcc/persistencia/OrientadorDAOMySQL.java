package br.ifrn.meutcc.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.ifrn.meutcc.modelo.Candidato;
import br.ifrn.meutcc.modelo.Orientador;
import br.ifrn.meutcc.modelo.Tema;

public class OrientadorDAOMySQL implements OrientadorDAO {
	private static OrientadorDAOMySQL instancia = null;
	private ConexaoMySQL conexao;
	
	private OrientadorDAOMySQL() {
		super();
		conexao = new ConexaoMySQL();
	}
	public static OrientadorDAO getInstancia() {
		if (instancia == null) {
			instancia = new OrientadorDAOMySQL();
		}
		return instancia;
	}
	
	@Override
	public Orientador getOrientador(int idOrientador) {
		Connection conn = conexao.getConexaoBD();
		if (conn != null) {
			try {
				Statement stListaTema = conn.createStatement();
				ResultSet rsTemas = stListaTema.executeQuery("SELECT * FROM Orientador as o WHERE o.idOrientador = "+idOrientador);
				Orientador orientador = null;
				if (rsTemas.next()) {
					orientador = new Orientador();
					orientador.setId(rsTemas.getInt("idOrientador"));
					orientador.setNome(rsTemas.getString("nomeOrientador"));
					orientador.setQtdLimite(rsTemas.getInt("qtdLimite"));
				}
				return orientador;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	@Override
	public int setQtdAtual(int idOrientador) {
		Connection conn = conexao.getConexaoBD();
		int qtdAtual = 0;
		if (conn != null) {
			try {
				Statement st= conn.createStatement();
				ResultSet rs = st.executeQuery("SELECT COUNT(*) as qtd FROM tema as t where t.idOrientador ="+idOrientador+" AND t.disponibilidade = 0");
				if (rs.next()) {
					qtdAtual = rs.getInt("qtd");
				}
				return qtdAtual;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return qtdAtual;
	}
}
