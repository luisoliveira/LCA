package com.voidsoftware.lca.persistence.interfaces;

import com.voidsoftware.lca.beans.Despesa;

public interface DespesaDAO {
	
	public void cadastrar(Despesa despesa);
	public void atualizar(Despesa despesa);
	public void remover(int codigoDespesa);
	public Despesa consultar(int codigoDespesa);

}
