package com.voidsoftware.lca.beans;

import java.io.Serializable;
import java.util.Date;

public class Audiencia implements Serializable {

	private static final long serialVersionUID = 3221757252085335525L;

	public Audiencia() {

	}

	private int codigoAudiencia;
	private Processo processo;
	private Advogado advogado;
	private Date dataHoraAgenda;
	private int salaForum;

	public int getCodigoAudiencia() {
		return codigoAudiencia;
	}

	public void setCodigoAudiencia(int codigoAudiencia) {
		this.codigoAudiencia = codigoAudiencia;
	}

	public Advogado getAdvogado() {
		return advogado;
	}

	public void setAdvogado(Advogado advogado) {
		this.advogado = advogado;
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
