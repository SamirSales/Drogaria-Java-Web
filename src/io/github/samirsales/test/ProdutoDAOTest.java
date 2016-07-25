package io.github.samirsales.test;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import io.github.samirsales.dao.ProdutoDAO;
import io.github.samirsales.domain.Fabricante;
import io.github.samirsales.domain.Produto;

public class ProdutoDAOTest {

	@Test
	@Ignore
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
	
	@Test
	public void listar() throws SQLException{
		ProdutoDAO dao = new ProdutoDAO();
		ArrayList<Produto> produtos = dao.listar();
		
		for(Produto produto : produtos){
			System.out.println(produto.toString());
		}
	}
}
