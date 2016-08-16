package br.ifrn.meutcc.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {
	private final String MySQLDriver = "com.mysql.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost/meutcc";
	private final String nome = "root";
	private final String senha = "senha123";
	
	private Connection conn = null;
	
	public ConexaoMySQL() {
		super();
	}
	
	public Connection getConexaoBD() {	
		if (conn != null) {
			return conn;
		}
		try {
			Class.forName(MySQLDriver);
			conn = DriverManager.getConnection(url, nome, senha);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
