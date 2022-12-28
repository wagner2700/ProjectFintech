package br.com.fiap.fintech.dao;

import java.util.List;

import br.com.fiap.fintech.bean.Usuario;
import br.com.fiap.fintech.exception.DBException;

public interface UsuarioDAO {
	
	void cadastrarUsuario(Usuario usuario) throws DBException ;
	void atualizarUsuario(Usuario usuario) throws DBException;
	void removerUsuario(int usuarioid) throws DBException;
	Usuario buscarUsuario(int codigoid);
	List<Usuario>todosUsuarios();
	//Usuario login(String email , String senha ) throws DBException;

}
