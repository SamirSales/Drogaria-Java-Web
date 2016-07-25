package io.github.samirsales.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import io.github.samirsales.dao.FabricanteDAO;
import io.github.samirsales.domain.Fabricante;
import io.github.samirsales.util.JSFUtil;

@SuppressWarnings("deprecation")
@ManagedBean(name = "MBFabricante")
@ViewScoped
public class FabricanteBean {
	private ArrayList<Fabricante> items;
	private ArrayList<Fabricante> itemsFiltrados;
	private Fabricante fabricante;

	public ArrayList<Fabricante> getItems() {
		return items;
	}

	public void setItems(ArrayList<Fabricante> items) {
		this.items = items;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	/**
	 * The action happens when the page is loaded.
	 */
	@PostConstruct
	public void prepararPesquisa() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			items = dao.listar();
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void prepararNovo() {
		fabricante = new Fabricante();
	}

	public void novo() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.salvar(fabricante);
			items = dao.listar();
			JSFUtil.adicionarMensagemSucesso("Fabricante salvo com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void excluir() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.excluir(fabricante);
			items = dao.listar();
			JSFUtil.adicionarMensagemSucesso("Fabricante excluído com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void editar() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.editar(fabricante);
			items = dao.listar();
			JSFUtil.adicionarMensagemSucesso("Fabricante editado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public ArrayList<Fabricante> getItemsFiltrados() {
		return itemsFiltrados;
	}

	public void setItemsFiltrados(ArrayList<Fabricante> itemsFiltrados) {
		this.itemsFiltrados = itemsFiltrados;
	}

}
