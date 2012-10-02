package com.voidsoftware.lca.beans;

public class Advogado extends Pessoa {
	
	public Advogado(){
		
	}
	
	private Integer oab;
	private String cpf;
	private String rg;
	private String email;
	private String password;
	
	
	public Integer getOab() {
		return oab;
	}
	public void setOab(Integer oab) {
		this.oab = oab;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	 
}
