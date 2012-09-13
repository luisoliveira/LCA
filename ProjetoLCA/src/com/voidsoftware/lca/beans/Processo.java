package com.voidsoftware.lca.beans;

import java.io.Serializable;
import java.util.Date;

public class Processo implements Serializable {
	
	private static final long serialVersionUID = -5653538023743584304L;
		
	public Processo(){
		
	}
	
	private int numero;
	private String descricao;
	private Date dataAbertura;
	private Date dataFechamento;
	private int diaVencimento;
	private char resultadoCausa;
	private String observacoes;
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
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
	public char getResultadoCausa() {
		return resultadoCausa;
	}
	public void setResultadoCausa(char resultadoCausa) {
		this.resultadoCausa = resultadoCausa;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
}
