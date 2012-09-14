package com.voidsoftware.lca.persistence.interfaces;

import com.voidsoftware.lca.beans.Audiencia;


public interface AudienciaDao {
	
	public void cadastrar(Audiencia audiencia);
	public void atualizar(Audiencia audiencia);
	public void remover(int codigoAudiencia);
	public Audiencia consultar(int codigoAudiencia);

}
