package io.github.samirsales.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import io.github.samirsales.dao.FabricanteDAO;
import io.github.samirsales.dao.ProdutoDAO;
import io.github.samirsales.domain.Fabricante;
import io.github.samirsales.domain.Produto;
import io.github.samirsales.util.JSFUtil;

@SuppressWarnings("deprecation")
@ManagedBean(name = "MBProduto")
@ViewScoped
public class ProdutoBean {
	private ArrayList<Produto> items;
	private ArrayList<Produto> itemsFiltrados;
	
	private Produto produto;
	
	private ArrayList<Fabricante> comboFabricantes;

	public ArrayList<Produto> getItems() {
		return items;
	}

	public void setItems(ArrayList<Produto> items) {
		this.items = items;
	}

	public ArrayList<Produto> getItemsFiltrados() {
		return itemsFiltrados;
	}

	public void setItemsFiltrados(ArrayList<Produto> itemsFiltrados) {
		this.itemsFiltrados = itemsFiltrados;
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ArrayList<Fabricante> getComboFabricantes() {
		return comboFabricantes;
	}

	public void setComboFabricantes(ArrayList<Fabricante> comboFabricantes) {
		this.comboFabricantes = comboFabricantes;
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
	
	public void prepararNovo(){
		produto = new Produto();
		try {
			FabricanteDAO fDao = new FabricanteDAO();
			comboFabricantes = fDao.listar();
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	
	public void novo(){
		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.salvar(produto);
			JSFUtil.adicionarMensagemSucesso("Produto salvo com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	
	public void prepararEditar(){
		try {
			FabricanteDAO fDao = new FabricanteDAO();
			comboFabricantes = fDao.listar();
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	
	public void editar(){
		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.editar(produto);
			JSFUtil.adicionarMensagemSucesso("Produto editado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	
	public void excluir(){
		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.excluir(produto);
			JSFUtil.adicionarMensagemSucesso("Produto excluído com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
}
