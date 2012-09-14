package com.voidsoftware.lca.persistence.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.voidsoftware.lca.beans.Processo;
import com.voidsoftware.lca.persistence.interfaces.ProcessoDao;
import com.voidsoftware.lca.persistence.jdbc.ConnectionFactory;

public class ProcessoDaoImpl implements ProcessoDao {

	public void cadastrar(Processo processo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = ConnectionFactory.obterConexaoOracle();
			conn.setAutoCommit(false);
			
			String sql = 
					"INSERT INTO AM_processo " +
					"(NR_PROCESSO, CD_PESSOA_FORUM, CD_PESSOA_CLIENTE, CD_CAUSA, CD_COBRANCA, DS_PROCESSO," +
					"	DT_ABERTURA,DT_FECHAMENTO,DD_DIA_VENCIMENTO,CD_RESULTADO,DS_OBSERVACAO) " +
					"VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, processo.getNumero());
			stmt.setInt(2, processo.getCodigoPessoaForum());
			stmt.setInt(3, processo.getCodigoPessoaCliente());
			stmt.setInt(4, processo.getCodigoCausa());
			stmt.setInt(5, processo.getCodigoCobranca());
			stmt.setString(6, processo.getDescricao());
			stmt.setDate(7, (Date) processo.getDataAbertura());
			stmt.setDate(8, (Date) processo.getDataFechamento());
			stmt.setInt(9, processo.getCodigoResultado());
			stmt.setString(10, processo.getObservacoes());
			
			
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
			
			
			stmt.setInt(1, processo.getCodigoPessoaForum());
			stmt.setInt(2, processo.getCodigoPessoaCliente());
			stmt.setInt(3, processo.getCodigoCausa());
			stmt.setInt(4, processo.getCodigoCobranca());
			stmt.setString(5, processo.getDescricao());
			stmt.setDate(6, new java.sql.Date(processo.getDataAbertura().getTime()));
			stmt.setDate(7, (Date) processo.getDataFechamento());
			stmt.setInt(8, processo.getDiaVencimento());
			stmt.setInt(9, processo.getCodigoResultado());
			stmt.setString(10, processo.getObservacoes());
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
				processo.setCodigoPessoaForum(rs.getInt("CD_PESSOA_FORUM"));
				processo.setCodigoPessoaCliente(rs.getInt("CD_PESSOA_CLIENTE"));
				processo.setCodigoCausa(rs.getInt("CD_CAUSA"));
				processo.setCodigoCobranca(rs.getInt("CD_COBRANCA"));
				processo.setDescricao(rs.getString("DS_PROCESSO"));
				processo.setDataAbertura(rs.getDate("DT_ABERTURA"));
				processo.setDataFechamento(rs.getDate("DT_FECHAMENTO"));
				processo.setDiaVencimento(rs.getInt("DD_DIA_VENCIMENTO"));
				processo.setCodigoResultado(rs.getInt("CD_RESULTADO"));
				processo.setObservacoes("DS_OBSERVACAO");
				
				
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

}
