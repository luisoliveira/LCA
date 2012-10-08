package com.voidsoftware.lca.persistence.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.voidsoftware.lca.beans.Processo;
import com.voidsoftware.lca.persistence.interfaces.ProcessoDao;
import com.voidsoftware.lca.persistence.jdbc.ConnectionFactory;

public class OracleProcessoDao implements ProcessoDao {

	public void cadastrar(Processo processo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = ConnectionFactory.obterConexaoOracle();
			conn.setAutoCommit(false);
			
			String sql = 
					"INSERT INTO AM_processo " +
					"( CD_PESSOA_FORUM, CD_PESSOA_CLIENTE, CD_CAUSA, CD_COBRANCA, DS_PROCESSO," +
					"	DT_ABERTURA,DT_FECHAMENTO,DD_DIA_VENCIMENTO,CD_RESULTADO,DS_OBSERVACAO) " +
					"VALUES (?,?,?,?,?,?,?,?,?,?)";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, processo.getNumero());
			stmt.setInt(2, processo.getForum().getCodigo());
			stmt.setInt(3, processo.getCliente().getCodigo());
			stmt.setInt(4, processo.getTipoCausa().getCodigo());
			stmt.setInt(5, processo.getTipoCobranca().getCodigo());
			stmt.setString(6, processo.getDescricao());
			stmt.setDate(7, (Date) processo.getDataAbertura());
			stmt.setDate(8, (Date) processo.getDataFechamento());
			stmt.setInt(9, processo.getCodigoResultado());
			stmt.setString(10, processo.getObservacao());
			
			
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
	public void atualizar(Processo processo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = ConnectionFactory.obterConexaoOracle();
			conn.setAutoCommit(false);
			
			String sql = "UPDATE AM_PROCESSO SET CD_PESSOA_FORUM = ?, CD_PESSOA_CLIENTE = ?, CD_CAUSA = ?, CD_COBRANCA = ?, DS_PROCESSO = ?, DT_ABERTURA = ?, DT_FECHAMENTO = ?, DD_DIA_VENCIMENTO = ?, CD_RESULTADO = ?,CD_OBSERVACAO = ? WHERE NR_PROCESSO = ?";
			
			stmt = conn.prepareStatement(sql);
			
			
			stmt.setInt(1, processo.getNumero());
			stmt.setInt(2, processo.getForum().getCodigo());
			stmt.setInt(3, processo.getCliente().getCodigo());
			stmt.setInt(4, processo.getTipoCausa().getCodigo());
			stmt.setString(5, processo.getDescricao());
			stmt.setDate(6, new java.sql.Date(processo.getDataAbertura().getTime()));
			stmt.setDate(7, (Date) processo.getDataFechamento());
			stmt.setInt(8, processo.getDiaVencimento());
			stmt.setInt(9, processo.getCodigoResultado());
			stmt.setString(10, processo.getObservacao());
			stmt.setInt(11, processo.getNumero());
			
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
	public void remover(int codigoprocesso) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = ConnectionFactory.obterConexaoOracle();
			conn.setAutoCommit(false);

			String sql = "DELETE FROM AM_PROCESSO WHERE CD_PROCESSO = ?";

			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, codigoprocesso);

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

	@Override
	public Processo consultar(int codigoprocesso) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Processo processo = new Processo();

		try {
			conn = ConnectionFactory.obterConexaoOracle();

			String sql = "SELECT NR_PROCESSO, CD_PESSOA_FORUM, CD_PESSOA_CLIENTE, CD_CAUSA, CD_COBRANCA, DS_PROCESSO," +
					"	DT_ABERTURA,DT_FECHAMENTO,DD_DIA_VENCIMENTO,CD_RESULTADO,DS_OBSERVACAO FROM AM_processo WHERE CD_processo = ?";

			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, codigoprocesso);

			rs = stmt.executeQuery();

			if (rs.next()) {
				processo.setNumero(rs.getInt("NR_PROCESSO"));
				processo.getForum().setCodigo(rs.getInt("CD_PESSOA_FORUM"));
				processo.getCliente().setCodigo(rs.getInt("CD_PESSOA_CLIENTE"));
				processo.getTipoCausa().setCodigo(rs.getInt("CD_CAUSA"));
				processo.getTipoCobranca().setCodigo(rs.getInt("CD_COBRANCA"));
				processo.setDescricao(rs.getString("DS_PROCESSO"));
				processo.setDataAbertura(rs.getDate("DT_ABERTURA"));
				processo.setDataFechamento(rs.getDate("DT_FECHAMENTO"));
				processo.setDiaVencimento(rs.getInt("DD_DIA_VENCIMENTO"));
				processo.setCodigoResultado(rs.getInt("CD_RESULTADO"));
				processo.setObservacao("DS_OBSERVACAO");
				
				
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

		return processo;
	}

	@Override
	public List<Processo> listaProcessosEmAberto() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Processo processo = new Processo();
		List<Processo> lista = new ArrayList<Processo>(); 
		
		try {
			conn = ConnectionFactory.obterConexaoOracle();
			
			String sql = "SELECT NR_PROCESSO, CD_PESSOA_FORUM, CD_PESSOA_CLIENTE, CD_CAUSA, CD_COBRANCA, DS_PROCESSO, DT_ABERTURA,DT_FECHAMENTO,DD_DIA_VENCIMENTO,CD_RESULTADO,DS_OBSERVACAO"+ 
							"FROM AM_processo WHERE DT_FECHAMENTO IS NULL;";
			
			stmt = conn.prepareStatement(sql);
			
			
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				processo = new Processo();
				
				processo.setNumero(rs.getInt("NR_PROCESSO"));
				processo.getForum().setCodigo(rs.getInt("CD_PESSOA_FORUM"));
				processo.getCliente().setCodigo(rs.getInt("CD_PESSOA_CLIENTE"));
				processo.getTipoCausa().setCodigo(rs.getInt("CD_CAUSA"));
				processo.getTipoCobranca().setCodigo(rs.getInt("CD_COBRANCA"));
				processo.setDescricao(rs.getString("DS_PROCESSO"));
				processo.setDataAbertura(rs.getDate("DT_ABERTURA"));
				processo.setDataFechamento(rs.getDate("DT_FECHAMENTO"));
				processo.setDiaVencimento(rs.getInt("DD_DIA_VENCIMENTO"));
				processo.setCodigoResultado(rs.getInt("CD_RESULTADO"));
				processo.setObservacao("DS_OBSERVACAO");
				lista.add(processo);
				processo = null;
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