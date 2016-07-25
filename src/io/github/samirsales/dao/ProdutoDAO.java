package io.github.samirsales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
