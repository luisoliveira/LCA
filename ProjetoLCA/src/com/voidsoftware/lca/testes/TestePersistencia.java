package com.voidsoftware.lca.testes;

import com.voidsoftware.lca.beans.Despesa;
import com.voidsoftware.lca.persistence.dao.DespesaDaoImpl;

public class TestePersistencia {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DespesaDaoImpl despDao = new DespesaDaoImpl();
		Despesa desp = despDao.consultar(1);

		System.out.println(desp.getCodigoLancamento());
		System.out.println(desp.getCodigoDespesa());
		System.out.println(desp.getNumeroProcesso());
		System.out.println(desp.getData());
		System.out.println(desp.getValor());
		System.out.println(desp.getObservacao()); 
		System.out.println("APOS ATUALIZAR !! ");

		desp.setObservacao("NOTE BOOK 4430s - Luis");

		despDao.atualizar(desp);

		desp = despDao.consultar(1);

		System.out.println(desp.getCodigoLancamento());
		System.out.println(desp.getCodigoDespesa());
		System.out.println(desp.getNumeroProcesso());
		System.out.println(desp.getData());
		System.out.println(desp.getValor());
		System.out.println(desp.getObservacao());
	}

}
