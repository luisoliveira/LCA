package com.voidsoftware.lca.persistence.interfaces;

import java.util.List;

import com.voidsoftware.lca.beans.Despesa;

public interface DespesaDao {
	
	public void cadastrar(Despesa despesa);
	public void atualizar(Despesa despesa);
	public void remover(int codigoDespesa);
	public Despesa consultar(int codigoDespesa);
	public List<Despesa> listaPorProcesso(int codProcesso);

}
