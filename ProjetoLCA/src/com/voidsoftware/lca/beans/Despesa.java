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
	
	private int codigo;
	private TipoDespesa tipoDespesa;
	private Processo processo;
	private Date data;
	private double valor;
	private String observacao;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public TipoDespesa getTipoDespesa() {
		return tipoDespesa;
	}
	public void setTipoDespesa(TipoDespesa tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}
	public Processo getProcesso() {
		return processo;
	}
	public void setProcesso(Processo processo) {
		this.processo = processo;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
