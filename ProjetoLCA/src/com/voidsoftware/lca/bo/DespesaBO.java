package com.voidsoftware.lca.bo;

import java.util.List;

import com.voidsoftware.lca.beans.Despesa;
import com.voidsoftware.lca.persistence.dao.DAOFactory;
import com.voidsoftware.lca.persistence.dao.OracleDespesaDao;
import com.voidsoftware.lca.persistence.interfaces.DespesaDao;

public class DespesaBO {
	
	
	public List<Despesa> listaDespesas(int codProcesso) {
		DespesaDao despDao = DAOFactory.getDespesaDao();
		return despDao.listaPorProcesso(codProcesso);
			
	}
	
	
	public void lancarDespesa(Despesa despesa){
		
		DespesaDao despDao = DAOFactory.getDespesaDao();
		despDao.cadastrar(despesa);
				
		
	}
		
}
