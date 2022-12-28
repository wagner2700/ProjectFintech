package br.com.fiap.fintech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.bean.Investimentos;
import br.com.fiap.fintech.dao.InvestimentoDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.singleton.ConnectionManager;

public class OracleInvestimentoDAO implements InvestimentoDAO{
	
	private Connection conexao;

	@Override
	public void cadastrarInvestimento(Investimentos investimento) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO INVESTIMENTO (INVESTIMENTOID, TIPO_INVESTIMENTO ) VALUES (SQ_TB_PRODUTO.NEXTVAL, ? )";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, investimento.getTipo_investimento() );

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastradar Investimneto.");
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
public void editarInvestimento(Investimentos investimentos) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sqlUpdate = "UPDATE INVESTIMENTO SET TIPO_INVESTIMENTO = ? ,"
					+ " WHERE INVESTIMENTOID = ?";
			
			stmt = conexao.prepareStatement(sqlUpdate);
			stmt.setString(1,investimentos.getTipo_investimento());
			stmt.setInt(2,investimentos.getInvestimentoId());
			
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
public void removerInvestimento(int investimentoid) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sqlDelete = "DELETE FROM INVESTIMENTO WHERE INVESTIMENTOID = ?";
			stmt = conexao.prepareStatement(sqlDelete);
			stmt.setInt(1, investimentoid);
			stmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao remover INVESTIMENTO");
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
public Investimentos buscarInvestimento(int investimentoid) {
		
		Investimentos investimentos = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement(""
					+ "SELECT * FROM INVESTIMENTO "
					+ "WHERE INVESTIMENTOID = ?");
			stmt.setInt(1, investimentoid);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				int codigoInvestimento = rs.getInt("INVESTIMENTOID");
				String tipoInvestimento = rs.getString("TIPO_INVESTIMENTO");

				investimentos = new Investimentos(codigoInvestimento,tipoInvestimento);
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
		}return investimentos;
	}

	@Override
	public List<Investimentos> todosInvestimentos() {
		List<Investimentos> todosInvestimentos = new ArrayList<Investimentos>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM INVESTIMENTO");
			rs = stmt.executeQuery();
			
			
			
			while(rs.next()) {
				int codigoInvestimento = rs.getInt("INVESTIMENTOID");
				String tipoInvestimento = rs.getString("TIPO_INVESTIMENTO");
				
				Investimentos investimento = new Investimentos(codigoInvestimento,tipoInvestimento );
				
				todosInvestimentos.add(investimento);
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
			return todosInvestimentos;
		
		
	}
}
	
	

