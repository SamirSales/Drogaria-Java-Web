package io.github.samirsales.test;

import java.sql.SQLException;

import org.junit.Test;

import io.github.samirsales.dao.ProdutoDAO;
import io.github.samirsales.domain.Fabricante;
import io.github.samirsales.domain.Produto;

public class ProdutoDAOTest {

	@Test
	public void salvar() throws SQLException{
		Produto p = new Produto();
		p.setDescricao("novalgina com 10 comprimidos");
		p.setPreco(2.45D);
		p.setQuantidade(13);
		
		Fabricante f = new Fabricante();
		f.setCodigo(1L);
		
		p.setFabricante(f);
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.salvar(p);
	}
}
