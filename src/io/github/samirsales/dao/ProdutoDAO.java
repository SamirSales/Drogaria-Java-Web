package io.github.samirsales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import io.github.samirsales.domain.Fabricante;
import io.github.samirsales.domain.Produto;
import io.github.samirsales.factory.ConexaoFactory;

public class ProdutoDAO {

	public void salvar(Produto produto) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO drogaria.produto ");
		sql.append("(descricao, preco, quantidade, codigo_fabricante) ");
		sql.append("VALUES (?, ?, ?, ?)");

		Connection connection = ConexaoFactory.conectar();
		PreparedStatement comando = connection.prepareStatement(sql.toString());
		comando.setString(1, produto.getDescricao());
		comando.setDouble(2, produto.getPreco());
		comando.setLong(3, produto.getQuantidade());
		comando.setLong(4, produto.getFabricante().getCodigo());
		comando.executeUpdate();
	}

	public static ArrayList<Produto> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT p.codigo, p.descricao, p.preco, p.quantidade, f.codigo, f.descricao ");
		sql.append("FROM drogaria.produto p ");
		sql.append("INNER JOIN drogaria.fabricante f ON f.codigo = p.codigo_fabricante ");

		Connection connection = ConexaoFactory.conectar();
		PreparedStatement comando = connection.prepareStatement(sql.toString());

		ResultSet resultSet = comando.executeQuery();
		ArrayList<Produto> retorno = new ArrayList<Produto>();
		while (resultSet.next()) {
			Fabricante f = new Fabricante();
			f.setCodigo(resultSet.getLong("f.codigo"));
			f.setDescricao(resultSet.getString("f.descricao"));

			Produto p = new Produto();
			p.setCodigo(resultSet.getLong("p.codigo"));
			p.setDescricao(resultSet.getString("p.descricao"));
			p.setPreco(resultSet.getDouble("p.preco"));
			p.setQuantidade(resultSet.getInt("p.quantidade"));
			p.setFabricante(f);
			retorno.add(p);
		}
		return retorno;
	}

	public void excluir(Produto produto) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM drogaria.produto ");
		sql.append("WHERE codigo = ? ");

		Connection connection = ConexaoFactory.conectar();
		PreparedStatement comando = connection.prepareStatement(sql.toString());
		comando.setLong(1, produto.getCodigo());
		comando.executeUpdate();
	}

	public void editar(Produto produto) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE drogaria.produto ");
		sql.append("SET descricao = ? ");
		sql.append("SET preco = ? ");
		sql.append("SET quantidade = ? ");
		sql.append("SET codigo_fabricante = ? ");
		sql.append("WHERE codigo = ? ");

		Connection connection = ConexaoFactory.conectar();
		PreparedStatement comando = connection.prepareStatement(sql.toString());
		comando.setString(1, produto.getDescricao());
		comando.setDouble(2, produto.getPreco());
		comando.setLong(3, produto.getQuantidade());
		comando.setLong(4, produto.getFabricante().getCodigo());
		comando.setLong(5, produto.getCodigo());
		comando.executeUpdate();
	}
}
