package com.voidsoftware.lca.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			
			String sql = "INSERT INTO AM_DESPESA ( CD_DESPESA, NR_PROCESSO, DT_DESPESA, VL_DESPESA, DS_OBSERVACAO) VALUES (?, ?, ?, ?, ?)";
			
			stmt = conn.prepareStatement(sql);
			
			
			
			
			stmt.setInt(1, despesa.getCodigo());
			stmt.setInt(2, despesa.getProcesso().getNumero());
			//stmt.setDate(3, despesa.getData().getTime()); 
			stmt.setDouble(4, despesa.getValor());
			stmt.setString(5, despesa.getObservacao());
			
			
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
				//conn.close();
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
			
			String sql = "UPDATE AM_DESPESA SET NR_PROCESSO = ?, DT_DESPESA = ?, VL_DESPESA = ?, DS_OBSERVACAO = ? WHERE CD_DESPESA = ?";
			
			stmt = conn.prepareStatement(sql);
			
			
			stmt.setInt(1, despesa.getProcesso().getNumero());
			stmt.setDate(2, new java.sql.Date(despesa.getData().getTime())); 
			stmt.setDouble(3, despesa.getValor());
			stmt.setString(4, despesa.getObservacao());
			stmt.setInt(5, despesa.getCodigo());
			
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
				//conn.close();
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
				//conn.close();
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
				despesa.setCodigo(rs.getInt("CD_LANCAMENTO"));
				
				despesa.getProcesso().setNumero(rs.getInt("NR_PROCESSO"));
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
				//conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return despesa;
	}

	@Override
	public List<Despesa> listaPorProcesso(int codProcesso) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Despesa despesa = new Despesa();
		List<Despesa> lista = new ArrayList<Despesa>(); 
		
		try {
			conn = ConnectionFactory.obterConexaoOracle();
			
			String sql = "SELECT CD_LANCAMENTO,CD_DESPESA,NR_PROCESSO,DT_DESPESA,VL_DESPESA,DS_OBSERVACAO FROM AM_DESPESA WHERE NR_PROCESSO = ?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, codProcesso);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				despesa = new Despesa();
				despesa.setCodigo(rs.getInt("CD_LANCAMENTO"));
				despesa.getProcesso().setNumero(rs.getInt("NR_PROCESSO"));
				despesa.setData(rs.getDate("DT_DESPESA"));
				despesa.setValor(rs.getDouble("VL_DESPESA"));
				despesa.setObservacao(rs.getString("DS_OBSERVACAO"));
				lista.add(despesa);
				despesa = null;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				rs.close();
				stmt.close();
				//conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return lista;
	}
	
	

}
