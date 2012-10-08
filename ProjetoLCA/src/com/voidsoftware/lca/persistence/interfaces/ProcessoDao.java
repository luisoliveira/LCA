package com.voidsoftware.lca.persistence.interfaces;


import java.util.List;

import com.voidsoftware.lca.beans.Processo;

public interface ProcessoDao {
	
	public void cadastrar(Processo processo);
	public void atualizar(Processo processo);
	public void remover(int numeroProcesso);
	public Processo consultar(int numeroProcesso);
	public List<Processo> listaProcessosEmAberto();

}
