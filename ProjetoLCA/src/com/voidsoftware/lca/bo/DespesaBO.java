package com.voidsoftware.lca.bo;

import java.util.List;

import com.voidsoftware.lca.beans.Despesa;
import com.voidsoftware.lca.persistence.dao.DespesaDaoImpl;

public class DespesaBO {
	
	
	public List<Despesa> listaDespesas(int codProcesso) {
		DespesaDaoImpl despImpl = new DespesaDaoImpl();
		return despImpl.listaPorProcesso(codProcesso);
			
	}
	
	
	public void lancarDespesa(Despesa despesa){
		
		DespesaDaoImpl despImpl = new DespesaDaoImpl();
		despImpl.cadastrar(despesa);
				
		
	}
		
}
