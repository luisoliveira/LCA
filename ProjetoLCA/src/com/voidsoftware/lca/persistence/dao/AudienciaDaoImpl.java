package com.voidsoftware.lca.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.voidsoftware.lca.beans.Audiencia;
import com.voidsoftware.lca.persistence.interfaces.AudienciaDao;
import com.voidsoftware.lca.persistence.jdbc.ConnectionFactory;

public class AudienciaDaoImpl implements AudienciaDao {

	
	public void cadastrar(Audiencia audiencia) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = ConnectionFactory.obterConexaoOracle();
			conn.setAutoCommit(false);
			
			String sql = 
					"INSERT INTO AM_AGENDA_AUDIENCIA " +
					"( NR_PROCESSO, CD_PESSOA_ADV, DT_HORA_AGENDA, SL_FORUM ) " +
					"VALUES ( ?, ?, ?, ?)";
			
			stmt = conn.prepareStatement(sql);
			
			
			stmt.setInt(1, audiencia.getNumeroProcesso());
			stmt.setInt(2, audiencia.getCodigoAdvogado());
			stmt.setDate(3, new java.sql.Date(audiencia.getDataHoraAgenda().getTime()));
			stmt.setInt(4, audiencia.getSalaForum());
			
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

	public void atualizar(Audiencia audiencia) {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = ConnectionFactory.obterConexaoOracle();
			conn.setAutoCommit(false);
			
			String sql = "UPDATE INTO AM_AGENDA_AUDIENCIA  SET NR_PROCESSO = ?, CD_PESSOA_ADV = ?, DT_HORA_AGENDA = ?, SL_FORUM = ? WHERE CD_AGENDA = ?";
			
			stmt = conn.prepareStatement(sql);
			 
			
			stmt.setInt(1, audiencia.getNumeroProcesso());
			stmt.setInt(2, audiencia.getCodigoAdvogado());
			stmt.setDate(3, new java.sql.Date(audiencia.getDataHoraAgenda().getTime()));
			stmt.setInt(4, audiencia.getSalaForum());
			stmt.setInt(5, audiencia.getCodigoAudiencia());
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

	
	public void remover(int codigoAudiencia) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = ConnectionFactory.obterConexaoOracle();
			conn.setAutoCommit(false);

			String sql = "DELETE FROM AM_AGENDA_AUDIENCIA WHERE CD_AGENDA = ?";

			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, codigoAudiencia);

			stmt.execute();

			conn.commit();
			conn.setAutoCommit(true);

		} catch (Exception e) {
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	/* (non-Javadoc)
	 * @see com.voidsoftware.lca.persistence.interfaces.AudienciaDao#consultar(int)
	 */
	@Override
	public Audiencia consultar(int codigoAudiencia) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Audiencia audiencia = new Audiencia();

		try {
			conn = ConnectionFactory.obterConexaoOracle();

			String sql = "SELECT CD_AGENDA, NR_PROCESSO, CD_PESSOA_ADV, DT_HORA_AGENDA, SL_FORUM";

			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, codigoAudiencia);

			rs = stmt.executeQuery();

			if (rs.next()) {
				
				audiencia.setCodigoAudiencia(rs.getInt("CD_AGENDA"));
				audiencia.setCodigoAdvogado(rs.getInt("NR_PROCESSO"));
				audiencia.setCodigoAdvogado(rs.getInt("CD_PESSOA_ADV"));
				audiencia.setDataHoraAgenda(rs.getDate("DT_HORA_AGENDA"));
				audiencia.setSalaForum(rs.getInt("SL_FORUM"));
								
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				rs.close();
				stmt.close();
				//conn.close();
			} catch (Exception e) { 
				e.printStackTrace();
			}
		}

		return audiencia;
	}
	
	
	

}
