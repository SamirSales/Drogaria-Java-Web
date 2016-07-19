package io.github.samirsales.domain;

public class Fabricante {
	private Long codigo;
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	@Override
	public String toString(){
		return "Código:"+codigo+" Descrição:"+descricao;
	}
}
