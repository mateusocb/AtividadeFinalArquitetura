package br.ifrn.meutcc.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.ifrn.meutcc.modelo.Tema;
import br.ifrn.meutcc.modelo.Candidato;
import br.ifrn.meutcc.modelo.Orientador;

public class TemaDAOMySQL implements TemaDAO {
	private static TemaDAOMySQL instancia = null;
	private ConexaoMySQL conexao;
	
	private TemaDAOMySQL() {
		super();
		conexao = new ConexaoMySQL();
	}

	public static TemaDAO getInstancia() {
		if (instancia == null) {
			instancia = new TemaDAOMySQL();
		}
		return instancia;
	}
	
	public List<Tema> listTemas(int idCurso) {
		Connection conn = conexao.getConexaoBD();
		if (conn != null) {
			try {
				Statement stListaTema = conn.createStatement();
				ResultSet rsTemas = stListaTema.executeQuery("SELECT * FROM Tema as t WHERE t.idCurso = "+idCurso);
				List<Tema> temas = new ArrayList<Tema>();
				while (rsTemas.next()) {
					Tema tema = new Tema();
					tema.setId(rsTemas.getInt("id"));
					tema.setTitulo(rsTemas.getString("titulo"));
					tema.setDescricao(rsTemas.getString("descricao"));
					temas.add(tema);
				}
				return temas;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return null;
	}
	
	public Tema getTema(int idTema) {
		Connection conn = conexao.getConexaoBD();
		if (conn != null) {
			try {
				Statement stListaTema = conn.createStatement();
				ResultSet rsTemas = stListaTema.executeQuery("SELECT * FROM Tema as t WHERE t.id = "+idTema);
				Tema tema = null;
				if (rsTemas.next()) {
					tema = new Tema();
					tema.setId(rsTemas.getInt("id"));
					tema.setTitulo(rsTemas.getString("titulo"));
					tema.setDescricao(rsTemas.getString("descricao"));
				}
				return tema;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public List<Tema> listTemasDoOrientador(int idCurso, int idOrientador) {
		Connection conn = conexao.getConexaoBD();
		if (conn != null) {
			try {
				Statement stListaTema = conn.createStatement();
				ResultSet rsTemas = stListaTema.executeQuery("SELECT * FROM Tema as t WHERE t.idCurso = "+idCurso+" and t.idOrientador="+idOrientador);
				List<Tema> temas = new ArrayList<Tema>();
				while (rsTemas.next()) {
					Tema tema = new Tema();
					tema.setId(rsTemas.getInt("id"));
					tema.setTitulo(rsTemas.getString("titulo"));
					tema.setDescricao(rsTemas.getString("descricao"));
					temas.add(tema);
				}
				return temas;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return null;
	}
	
	public List<Candidato> atualizaListCandidatoTema(int idTema) {
		Connection conn = conexao.getConexaoBD();
		if (conn != null) {
			try {
				Statement stListaTema = conn.createStatement();
				ResultSet rsTemas = stListaTema.executeQuery("SELECT distinct c.* FROM candidato as c inner join TemaCandidato as tc on c.idCandidato = tc.idCandidato WHERE tc.idTema = "+idTema);
				List<Candidato> candidatos = new ArrayList<Candidato>();
				System.out.println("passou");
				while (rsTemas.next()) {
					Candidato candidato = new Candidato();
					candidato.setId(rsTemas.getInt("idCandidato"));
					candidato.setNome(rsTemas.getString("name"));
					candidatos.add(candidato);
				}
				return candidatos;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return null;
	}

	@Override
	public void setDisponibilidade(int id, int idCandidato) {
		Connection conn = conexao.getConexaoBD();
		if (conn != null) {
			try {
				PreparedStatement updateEXP = (PreparedStatement) conn.prepareStatement("UPDATE TEMA SET disponibilidade = 0, idAluno = "+ idCandidato + " WHERE id=" + id);
				updateEXP.executeUpdate();
				PreparedStatement updateEXP1 = (PreparedStatement) conn.prepareStatement("delete from temacandidato where idTema="+id);
				updateEXP1.executeUpdate();
				PreparedStatement updateEXP2 = (PreparedStatement) conn.prepareStatement("delete from temacandidato where idCandidato="+idCandidato);
				updateEXP2.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void setAVerificar(int id, int idCandidato) {
		Connection conn = conexao.getConexaoBD();
		if (conn != null) {
			try {
				PreparedStatement updateEXP = (PreparedStatement) conn.prepareStatement("UPDATE TEMA SET averificar = 1, idAluno = "+ idCandidato + " WHERE id=" + id);
				updateEXP.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void setVerificado(int id, boolean resultado) {
		Connection conn = conexao.getConexaoBD();
		if (conn != null) {
			try {
				if (resultado) {
					PreparedStatement updateEXP = (PreparedStatement) conn.prepareStatement("UPDATE TEMA SET averificar = 0, disponibilidade = 0 WHERE id=" + id);
					updateEXP.executeUpdate();
					PreparedStatement updateEXP1 = (PreparedStatement) conn.prepareStatement("delete from temacandidato where idTema="+id);
					updateEXP1.executeUpdate();
				} else {
					PreparedStatement updateEXP = (PreparedStatement) conn.prepareStatement("UPDATE TEMA SET averificar = 0, idAluno = null WHERE id=" + id);
					updateEXP.executeUpdate();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Candidato getCandidato(int idTema) {
		Connection conn = conexao.getConexaoBD();
		if (conn != null) {
			try {
				Candidato candidato = new Candidato();
				Statement stListaTema = conn.createStatement();
				ResultSet rsTemas = stListaTema.executeQuery("SELECT idAluno FROM Tema WHERE id = " + idTema);
				while (rsTemas.next()) {
					candidato = candidato.getCandidato(rsTemas.getInt("idAluno"));
				}
				return candidato;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Orientador getOrientador(int idTema) {
		Connection conn = conexao.getConexaoBD();
		if (conn != null) {
			try {
				Orientador orientador = new Orientador();
				Statement stListaTema = conn.createStatement();
				ResultSet rsTemas = stListaTema.executeQuery("SELECT idOrientador FROM Tema WHERE id = " + idTema);
				while (rsTemas.next()) {
					orientador = orientador.getOrientador(rsTemas.getInt("idOrientador"));
				}
				return orientador;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Tema> listTemasAVerificar(int idCurso) {
		Connection conn = conexao.getConexaoBD();
		if (conn != null) {
			try {
				Statement stListaTema = conn.createStatement();
				ResultSet rsTemas = stListaTema.executeQuery("SELECT * FROM Tema WHERE Tema.aVerificar = 1 AND Tema.idCurso = "+idCurso);
				List<Tema> temasAVerificar = new ArrayList<Tema>();
				System.out.println("passou");
				while (rsTemas.next()) {
					Tema tema = new Tema();
					tema = this.getTema(rsTemas.getInt("id"));
					temasAVerificar.add(tema);
				}
				return temasAVerificar;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
