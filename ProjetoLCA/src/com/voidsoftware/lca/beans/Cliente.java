package com.voidsoftware.lca.beans;

public class Cliente extends Pessoa{
	
	
	public Cliente(){
		
	}
	
	private String razaoSocial;
	private Integer cnpj;
	private Integer inscEstadual;
	
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public Integer getCnpj() {
		return cnpj;
	}
	public void setCnpj(Integer cnpj) {
		this.cnpj = cnpj;
	}
	public Integer getInscEstadual() {
		return inscEstadual;
	}
	public void setInscEstadual(Integer inscEstadual) {
		this.inscEstadual = inscEstadual;
	}
	
	
}
