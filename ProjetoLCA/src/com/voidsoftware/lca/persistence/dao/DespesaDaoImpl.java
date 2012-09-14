package com.voidsoftware.lca.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.voidsoftware.lca.beans.Despesa;
import com.voidsoftware.lca.persistence.interfaces.DespesaDao;
import com.voidsoftware.lca.persistence.jdbc.ConnectionFactory;

public class DespesaDaoImpl implements DespesaDao {

	@Override
	public void cadastrar(Despesa despesa) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = ConnectionFactory.obterConexaoOracle();
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO AM_DESPESA (CD_LANCAMENTO, CD_DESPESA, NR_PROCESSO, DT_DESPESA, VL_DESPESA, DS_OBSERVACAO) VALUES (?, ?, ?, ?, ?, ?)";
			
			stmt = conn.prepareStatement(sql);
			
			
			
			stmt.setInt(1, despesa.getCodigoLancamento());
			stmt.setInt(2, despesa.getCodigoDespesa());
			stmt.setInt(3, despesa.getNumeroProcesso());
			//stmt.setDate(4, despesa.getData().getTime()); 
			stmt.setDouble(5, despesa.getValor());
			stmt.setString(6, despesa.getObservacao());
			
			
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
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = ConnectionFactory.obterConexaoOracle();
			conn.setAutoCommit(false);
			
			String sql = "UPDATE AM_DESPESA SET CD_LANCAMENTO = ?, NR_PROCESSO = ?, DT_DESPESA = ?, VL_DESPESA = ?, DS_OBSERVACAO = ? WHERE CD_DESPESA = ?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, despesa.getCodigoLancamento());
			stmt.setInt(2, despesa.getNumeroProcesso());
			stmt.setDate(3, new java.sql.Date(despesa.getData().getTime())); 
			stmt.setDouble(4, despesa.getValor());
			stmt.setString(5, despesa.getObservacao());
			stmt.setInt(6, despesa.getCodigoDespesa());
			
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
	public void remover(int codigoDespesa) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = ConnectionFactory.obterConexaoOracle();
			conn.setAutoCommit(false);
			
			String sql = "DELETE FROM AM_DESPESA WHERE CD_DESPESA = ?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, codigoDespesa);
			
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
	public Despesa consultar(int codigoDespesa) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Despesa despesa = new Despesa();
		
		try {
			conn = ConnectionFactory.obterConexaoOracle();
			
			String sql = "SELECT CD_LANCAMENTO,CD_DESPESA,NR_PROCESSO,DT_DESPESA,VL_DESPESA,DS_OBSERVACAO FROM AM_DESPESA WHERE CD_DESPESA = ?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, codigoDespesa);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				despesa.setCodigoLancamento(rs.getInt("CD_LANCAMENTO"));
				despesa.setCodigoDespesa(rs.getInt("CD_DESPESA"));
				despesa.setNumeroProcesso(rs.getInt("NR_PROCESSO"));
				despesa.setData(rs.getDate("DT_DESPESA"));
				despesa.setValor(rs.getDouble("VL_DESPESA"));
				despesa.setObservacao(rs.getString("DS_OBSERVACAO"));
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return despesa;
	}
	
	

}
