package com.voidsoftware.lca.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO gerar javadoc
 * @author lholiveira
 *
 */
public class Despesa implements Serializable{
	

	public Despesa (){
		
	}
	
	
	private static final long serialVersionUID = -5953858768380671698L;
	
	private int codigoDespesa;
	private int codigoLancamento;
	private int codigoTipoDespesa;
	private int numeroProcesso;
	private Date data;
	private double valor;
	private String observacao;
	
	
	
	public int getCodigoDespesa() {
		return codigoDespesa;
	}
	public void setCodigoDespesa(int codigoDespesa) {
		this.codigoDespesa = codigoDespesa;
	}
	public int getCodigoLancamento() {
		return codigoLancamento;
	}
	public void setCodigoLancamento(int codigoLancamento) {
		this.codigoLancamento = codigoLancamento;
	}
	public int getCodigoTipoDespesa() {
		return codigoTipoDespesa;
	}
	public void setCodigoTipoDespesa(int codigoTipoDespesa) {
		this.codigoTipoDespesa = codigoTipoDespesa;
	}
	public int getNumeroProcesso() {
		return numeroProcesso;
	}
	public void setNumeroProcesso(int numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
}
