package io.github.samirsales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import io.github.samirsales.domain.Fabricante;
import io.github.samirsales.factory.ConexaoFactory;

public class FabricanteDAO {
	public void salvar(Fabricante fabricante) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO drogaria.fabricante ");
		sql.append("(descricao) ");
		sql.append("VALUES (?)");

		Connection connection = ConexaoFactory.conectar();
		PreparedStatement comando = connection.prepareStatement(sql.toString());
		comando.setString(1, fabricante.getDescricao());
		comando.executeUpdate();
	}
	
	public void excluir(Fabricante fabricante) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM drogaria.fabricante ");
		sql.append("WHERE codigo = ? ");
		
		Connection connection = ConexaoFactory.conectar();
		PreparedStatement comando = connection.prepareStatement(sql.toString());
		comando.setLong(1, fabricante.getCodigo());
		comando.executeUpdate();
	}
	
	public void editar(Fabricante fabricante) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE drogaria.fabricante ");
		sql.append("SET descricao = ? ");
		sql.append("WHERE codigo = ? ");
		
		Connection connection = ConexaoFactory.conectar();
		PreparedStatement comando = connection.prepareStatement(sql.toString());
		comando.setString(1, fabricante.getDescricao());
		comando.setLong(2, fabricante.getCodigo());
		comando.executeUpdate();
	}
	
	public Fabricante pesquisar(Fabricante fabricante) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM drogaria.fabricante ");
		sql.append("WHERE codigo = ? ");
		
		Connection connection = ConexaoFactory.conectar();
		PreparedStatement comando = connection.prepareStatement(sql.toString());
		comando.setLong(1, fabricante.getCodigo());
		
		ResultSet resultSet = comando.executeQuery();
		Fabricante retorno = null;
		if(resultSet.next()){
			retorno = new Fabricante();
			retorno.setCodigo(resultSet.getLong("codigo"));
			retorno.setDescricao(resultSet.getString("descricao"));
		}		
		return retorno;
	}
	
	public static ArrayList<Fabricante> listar() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM drogaria.fabricante ");
		// it orders the list by ascendent descriptions
		sql.append("ORDER BY descricao ASC ");
		
		Connection connection = ConexaoFactory.conectar();
		PreparedStatement comando = connection.prepareStatement(sql.toString());
		
		ResultSet resultSet = comando.executeQuery();
		ArrayList<Fabricante> retorno = new ArrayList<Fabricante>();
		while(resultSet.next()){
			Fabricante f = new Fabricante();
			f.setCodigo(resultSet.getLong("codigo"));
			f.setDescricao(resultSet.getString("descricao"));
			retorno.add(f);
		}		
		return retorno;
	}
	
	public static ArrayList<Fabricante> buscarPorDescricao(Fabricante fabricante) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM drogaria.fabricante ");
		// it helps with consults by word inserted in the description
		sql.append("WHERE descricao LIKE ? ");
		sql.append("ORDER BY descricao ASC ");
		
		Connection connection = ConexaoFactory.conectar();
		PreparedStatement comando = connection.prepareStatement(sql.toString());
		// the percent makes the description position in the string to become irrelevant
		comando.setString(1, "%"+fabricante.getDescricao()+"%");
		
		ResultSet resultSet = comando.executeQuery();
		ArrayList<Fabricante> retorno = new ArrayList<Fabricante>();
		while(resultSet.next()){
			Fabricante f = new Fabricante();
			f.setCodigo(resultSet.getLong("codigo"));
			f.setDescricao(resultSet.getString("descricao"));
			retorno.add(f);
		}		
		return retorno;
	}
	
	public static void main(String[] args) {
		Fabricante f1 = new Fabricante();
		Fabricante f2 = new Fabricante();
		f1.setCodigo(1L);
		f1.setDescricao("holy");
		f2.setCodigo(6L);
		f2.setDescricao("holy toledoooo!!");
		
		FabricanteDAO fdao = new FabricanteDAO();
		
		try {
			ArrayList<Fabricante> fabricantes = buscarPorDescricao(f1);
			for(Fabricante f : fabricantes){
				System.out.println(f.toString());
			}
			
			System.out.println("Operação realizada com sucesso!");
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao tentar executar os métodos.");
			e.printStackTrace();
		}
		
	}
}
