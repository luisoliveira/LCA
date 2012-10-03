package com.voidsoftware.lca.beans;

import java.io.Serializable;
import java.util.Date;

public class Processo implements Serializable {

	private static final long serialVersionUID = -5653538023743584304L;

	
		
	private int numero;
	private Forum forum;
	private Cliente cliente;
	private TipoCausa tipoCausa;
	private TipoCobranca tipoCobranca;
	private String descricao;
	private Date dataAbertura;
	private Date dataFechamento;
	private int diaVencimento;
	private int codigoResultado;
	private String observacao;
	
	public Processo() {
		
		forum = new Forum();
		cliente = new Cliente();
		tipoCausa = new TipoCausa();
		tipoCobranca = new TipoCobranca();
	}
	
	
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public TipoCausa getTipoCausa() {
		return tipoCausa;
	}

	public void setTipoCausa(TipoCausa tipoCausa) {
		this.tipoCausa = tipoCausa;
	}
	
	public TipoCobranca getTipoCobranca() {
		return tipoCobranca;
	}
	
	public void setTipoCobranca(TipoCobranca tipoCobranca) {
		this.tipoCobranca = tipoCobranca;
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
	
	public String getObservacao() {
		return observacao;
	}
	
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
} 
