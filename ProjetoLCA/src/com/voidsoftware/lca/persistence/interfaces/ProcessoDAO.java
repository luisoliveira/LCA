package com.voidsoftware.lca.persistence.interfaces;


import com.voidsoftware.lca.beans.Processo;

public interface ProcessoDAO {
	
	public void cadastrar(Processo processo);
	public void atualizar(Processo processo);
	public void remover(int numeroProcesso);
	public Processo consultar(int numeroProcesso);

}
