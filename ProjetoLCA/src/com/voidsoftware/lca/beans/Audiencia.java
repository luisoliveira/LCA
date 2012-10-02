package com.voidsoftware.lca.beans;

import java.io.Serializable;
import java.util.Date;

public class Audiencia implements Serializable {
		

	private static final long serialVersionUID = 3221757252085335525L;
	
	public Audiencia(){
		
		
	}
	
	private int codigoAudiencia;
	private Processo processo;
	private int codigoAdvogado;
	private Date dataHoraAgenda;
	private int salaForum;
	
	
	public int getCodigoAudiencia() {
		return codigoAudiencia;
	}
	public void setCodigoAudiencia(int codigoAudiencia) {
		this.codigoAudiencia = codigoAudiencia;
	}
	public int getCodigoAdvogado() {
		return codigoAdvogado;
	}
	public void setCodigoAdvogado(int codigoAdvogado) {
		this.codigoAdvogado = codigoAdvogado;
	}
	public Date getDataHoraAgenda() {
		return dataHoraAgenda;
	}
	public void setDataHoraAgenda(Date dataHoraAgenda) {
		this.dataHoraAgenda = dataHoraAgenda;
	}
	public int getSalaForum() {
		return salaForum;
	}
	public void setSalaForum(int salaForum) {
		this.salaForum = salaForum;
	}
	public Processo getProcesso() {
		return processo;
	}
	public void setProcesso(Processo processo) {
		this.processo = processo;
	}
	
	
	
}
