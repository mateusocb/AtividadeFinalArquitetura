package br.ifrn.meutcc.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.ifrn.meutcc.modelo.Candidato;
import br.ifrn.meutcc.modelo.Orientador;
import br.ifrn.meutcc.modelo.Tema;

public class CandidatoDAOMySQL implements CandidatoDAO {
	private static CandidatoDAOMySQL instancia = null;
	private ConexaoMySQL conexao;
	
	private CandidatoDAOMySQL() {
		super();
		conexao = new ConexaoMySQL();
	}
	public static CandidatoDAOMySQL getInstancia() {
		if (instancia == null) {
			instancia = new CandidatoDAOMySQL();
		}
		return instancia;
	}
	
	@Override
	public Candidato getCandidato(int idCandidato) {
		Connection conn = conexao.getConexaoBD();
		if (conn != null) {
			try {
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM Candidato as c WHERE c.idCandidato= " + idCandidato);
				Candidato candidato = null;
				if (rs.next()) {
					candidato = new Candidato();
					candidato.setId(rs.getInt("idCandidato"));
					candidato.setNome(rs.getString("name"));
				}
				return candidato;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
