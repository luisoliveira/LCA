package com.voidsoftware.lca.beans;

import java.io.Serializable;
import java.util.Date;

public class Processo implements Serializable {
	
	private static final long serialVersionUID = -5653538023743584304L;
	
	
	public Processo(){
		
	}
	
	private int numero;
	private int codigoPessoaForum;
	private int codigoPessoaCliente;
	private int codigoCausa;
	private int codigoCobranca;
	private String descricao;
	private Date dataAbertura;
	private Date dataFechamento;
	private int diaVencimento;
	private int codigoResultado;
	private String observacao;

	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getCodigoPessoaForum() {
		return codigoPessoaForum;
	}
	public void setCodigoPessoaForum(int codigoPessoaForum) {
		this.codigoPessoaForum = codigoPessoaForum;
	}
	public int getCodigoPessoaCliente() {
		return codigoPessoaCliente;
	}
	public void setCodigoPessoaCliente(int codigoPessoaCliente) {
		this.codigoPessoaCliente = codigoPessoaCliente;
	}
	public int getCodigoCausa() {
		return codigoCausa;
	}
	public void setCodigoCausa(int codigoCausa) {
		this.codigoCausa = codigoCausa;
	}
	public int getCodigoCobranca() {
		return codigoCobranca;
	}
	public void setCodigoCobranca(int codigoCobranca) {
		this.codigoCobranca = codigoCobranca;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public Date getDataFechamento() {
		return dataFechamento;
	}
	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}
	public int getDiaVencimento() {
		return diaVencimento;
	}
	public void setDiaVencimento(int diaVencimento) {
		this.diaVencimento = diaVencimento;
	}
	public int getCodigoResultado() {
		return codigoResultado;
	}
	public void setCodigoResultado(int codigoResultado) {
		this.codigoResultado = codigoResultado;
	}
	public String getObservacoes() {
		return observacao;
	}
	public void setObservacoes(String observacoes) {
		this.observacao = observacoes;
	}
	
	
	
}
