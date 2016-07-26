package io.github.samirsales.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import io.github.samirsales.dao.ProdutoDAO;
import io.github.samirsales.domain.Produto;
import io.github.samirsales.util.JSFUtil;

@SuppressWarnings("deprecation")
@ManagedBean(name = "MBProduto")
@ViewScoped
public class ProdutoBean {
	private ArrayList<Produto> items;

	public ArrayList<Produto> getItems() {
		return items;
	}

	public void setItems(ArrayList<Produto> items) {
		this.items = items;
	}

	public void carregarListagem() {

		try {
			ProdutoDAO dao = new ProdutoDAO();
			items = dao.listar();
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
}
