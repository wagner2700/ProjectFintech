package br.com.fiap.fintech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.bean.Usuario;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.singleton.ConnectionManager;

public class OracleUsuarioDAO implements UsuarioDAO{
	private Connection conexao;

	
	public void cadastrarUsuario (Usuario usuario) throws DBException {
		PreparedStatement stmt = null;
		

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO USUARIO (USUARIOID, NOME,EMAIL,SENHA,TELEFONE ) VALUES (? , ?, ?,?,?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1,usuario.getUsuarioid());
			stmt.setString(2, usuario.getNome());
			stmt.setString(3, usuario.getEmail());
			stmt.setString(4, usuario.getSenha());
			stmt.setString(5, usuario.getTelefone());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastradar.");
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
	public void atualizarUsuario(Usuario usuario) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sqlUpdate = "UPDATE USUARIO SET NOME = ? ,"
					+ " WHERE USUARIOID = ?";
			
			stmt = conexao.prepareStatement(sqlUpdate);
			stmt.setString(1,usuario.getNome());
			stmt.setDouble(3,usuario.getUsuarioid());
			
			stmt.executeUpdate();
				
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar");
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
	public void removerUsuario(int usuarioid) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sqlDelete = "DELETE FROM USUARIO WHERE USUARIOID = ?";
			stmt = conexao.prepareStatement(sqlDelete);
			stmt.setInt(1, usuarioid);
			stmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao remover");
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
	public  Usuario buscarUsuario(int codigoid) {
		Usuario usuario = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement(""
					+ "SELECT * FROM USUARIO "
					+ "WHERE USUARIOID = ?");
			stmt.setInt(1, codigoid);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				int codigoUsuario = rs.getInt("USUARIOID");
				String nomeUsuario = rs.getString("NOME");
				String email = rs.getString("EMAIL");
				String senha = rs.getString("SENHA");
				String telefone = rs.getString("TELEFONE");

				usuario = new Usuario(codigoUsuario,nomeUsuario,email,senha,telefone);
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
		}return usuario;
	}

	@Override
	public List<Usuario>todosUsuarios() {
		List<Usuario> todosUsuarios = new ArrayList<Usuario>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM USUARIO");
			rs = stmt.executeQuery();
			
			
			
			while(rs.next()) {
				int codigoUsuario = rs.getInt("USUARIOID");
				String nomeUsuario = rs.getString("NOME");
				String email = rs.getString("EMAIL");
				String senha = rs.getString("SENHA");
				String telefone = rs.getString("TELEFONE");
				
				Usuario usuario = new Usuario(codigoUsuario,nomeUsuario,email,senha,telefone);
				
				todosUsuarios.add(usuario);
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
			return todosUsuarios;
		
		
	}

		


	/*
	 * public Usuario login(String email, String senha) throws DBException { for
	 * (Usuario usuario : usuario ) { if (usuario.getEmail().equals(email) &&
	 * usuario.getSenha().equals(senha)) {
	 * System.out.println("Login efetuado com sucesso!"); return usuario; } } }
	 */




}

