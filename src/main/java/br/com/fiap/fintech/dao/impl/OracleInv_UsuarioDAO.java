package br.com.fiap.fintech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.fintech.bean.Inv_Usuario;
import br.com.fiap.fintech.dao.InvestimentoUsuarioDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.singleton.ConnectionManager;

public class OracleInv_UsuarioDAO implements InvestimentoUsuarioDAO{
	private Connection conexao;

	@Override
	public void cadastrarInvUsuario(Inv_Usuario invUsuario) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO INV_USUARIO ( INV_USUARIO_ID , USUARIOID , INVESTIMENTOID , DT_INVESTIMENTO ) VALUES (SQ_TB_PRODUTO.NEXTVAL , ? , ? , ? )";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, invUsuario.getUsuarioid());
			stmt.setInt(2,invUsuario.getInvestimentoid());
			java.sql.Date dataInv = new java.sql.Date(invUsuario.getDt_Investimento().getTimeInMillis());
			stmt.setDate(3, dataInv);
			
			

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastradar Investimneto do usuario.");
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
	public void removerInvUsuario(int invUsuarioId) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sqlDelete = "DELETE FROM INV_USUARIO WHERE INV_USUARIO_ID = ?";
			stmt = conexao.prepareStatement(sqlDelete);
			stmt.setInt(1, invUsuarioId);
			stmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao remover INVESTIMENTO DO USUARIO");
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
	public List<Inv_Usuario> todosInvUsuario() {
		List<Inv_Usuario> todosInvUsuario = new ArrayList<Inv_Usuario>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM INV_USUARIO");
			rs = stmt.executeQuery();
			
			
			
			while(rs.next()) {
				int codigoInvUsuario = rs.getInt("INV_USUARIO_ID");
				int codigoUsuario = rs.getInt("USUARIOID");
				int investimentoid = rs.getInt("INVESTIMENTOID");
				java.sql.Date data = rs.getDate("DT_INVESTIMENTO");
				Calendar dataInvestimento = Calendar.getInstance();
				dataInvestimento.setTimeInMillis(data.getTime());
				
				Inv_Usuario invUsuario = new Inv_Usuario(codigoInvUsuario,codigoUsuario , investimentoid, dataInvestimento);
				
				todosInvUsuario.add(invUsuario);
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
			return todosInvUsuario;
	}

}
