package br.com.fiap.fintech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.bean.Receita;
import br.com.fiap.fintech.dao.ReceitaDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.singleton.ConnectionManager;

public class OracleReceitaDAO implements ReceitaDAO{
	private Connection conexao;
	

	@Override
	public void cadastrarReceita(Receita receita) throws DBException {
		PreparedStatement stmt = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO RECEITA (RECEITAID, NOME_RECEITA ) VALUES (SQ_TB_PRODUTO.NEXTVAL, ? )";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, receita.getNomeReceita() );

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastradar receita.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void editarReceita(Receita receita) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sqlUpdate = "UPDATE RECEITA SET NOME_RECEITA = ? ";
		
			
			stmt = conexao.prepareStatement(sqlUpdate);
			stmt.setInt(1,receita.getReceitaid());
			stmt.setString(2,receita.getNomeReceita());
			
			stmt.executeUpdate();
				
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar Investimento");
		}finally {
			try {
				stmt.close();
				conexao.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void removerReceitao(int receitaid) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sqlDelete = "DELETE FROM RECEITA WHERE RECEITAID = ?";
			stmt = conexao.prepareStatement(sqlDelete);
			stmt.setInt(1, receitaid);
			stmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao remover Receita");
		}finally {
			try {
				stmt.close();
				conexao.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public Receita buscarReceita(int receitaid) {
		Receita receita = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement(""
					+ "SELECT * FROM RECEITA "
					+ "WHERE RECEITAID = ?");
			stmt.setInt(1, receitaid);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				int codigoReceita = rs.getInt("RECEITAID");
				String nomeReceita = rs.getString("NOME_RECEITA");

				receita = new Receita(codigoReceita,nomeReceita);
			}
		}catch (SQLException e) {
			e.printStackTrace();
			try {
				stmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
		}return receita;
	}

	@Override
	public List<Receita> todasReceitas() {
		List<Receita> todasReceitas = new ArrayList<Receita>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM RECEITA");
			rs = stmt.executeQuery();
			
			
			
			while(rs.next()) {
				int codigoInvestimento = rs.getInt("RECEITAID");
				String tipoInvestimento = rs.getString("NOME_RECEITA");
				
				Receita receita = new Receita(codigoInvestimento,tipoInvestimento );
				
				todasReceitas.add(receita);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conexao.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
			return todasReceitas;
	}

}
