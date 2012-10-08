package com.voidsoftware.lca.persistence.dao;

import com.voidsoftware.lca.persistence.interfaces.AudienciaDao;
import com.voidsoftware.lca.persistence.interfaces.DespesaDao;
import com.voidsoftware.lca.persistence.interfaces.ProcessoDao;

public abstract class DAOFactory {
	
	public static AudienciaDao getAudienciaDao(){
		return new OracleAudienciaDao();
	}
	
	public static DespesaDao getDespesaDao(){
		return new OracleDespesaDao();
	}
	
	public static ProcessoDao getProcessoDao(){
		return new OracleProcessoDao();		
	}

}
 