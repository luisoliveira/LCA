package com.voidsoftware.lca.beans;

public class TipoCobranca {

	public TipoCobranca() {

	}

	private Integer codigo;
	private String descricao;
	private Integer taxaJuros;
	private Integer moraDiaria;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getTaxaJuros() {
		return taxaJuros;
	}

	public void setTaxaJuros(Integer taxaJuros) {
		this.taxaJuros = taxaJuros;
	}

	public Integer getMoraDiaria() {
		return moraDiaria;
	}

	public void setMoraDiaria(Integer moraDiaria) {
		this.moraDiaria = moraDiaria;
	}

}
