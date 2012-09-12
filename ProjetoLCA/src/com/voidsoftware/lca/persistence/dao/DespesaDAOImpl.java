package com.voidsoftware.lca.persistence.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.voidsoftware.lca.beans.Despesa;
import com.voidsoftware.lca.persistence.interfaces.DespesaDAO;
import com.voidsoftware.lca.persistence.jdbc.ConnectionFactory;

public class DespesaDAOImpl implements DespesaDAO {

	@Override
	public void cadastrar(Despesa despesa) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = ConnectionFactory.obterConexaoMySQL();
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO AM_DESPESA (CD_LANCAMENTO, DT_DESPESA, VL_DESPESA, DS_OBSERVACAO) VALUES (?, ?, ?, ?)";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, despesa.getCodigo());
			stmt.setDate(2, (Date) despesa.getData()); 
			stmt.setDouble(3, despesa.getValor());
			stmt.setString(4, despesa.getObservacao());
			
			
			stmt.execute();
			
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void atualizar(Despesa despesa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(int codigoDespesa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Despesa consultar(int codigoDespesa) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
