package io.github.samirsales.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	private static final String USUARIO = "root";
	private static final String SENHA = "qwerty456";
	private static final String URL = "jdbc:mysql://localhost/phpmyadmin";
	
	public static Connection conectar() throws SQLException{
		Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
		return connection;
	}
	
	public static void main(String[] args) {
		try {
			Connection connection = ConexaoFactory.conectar();
			System.out.println("Conexão realizada com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não foi possível realizar a conexão.");
		}
	}
}
