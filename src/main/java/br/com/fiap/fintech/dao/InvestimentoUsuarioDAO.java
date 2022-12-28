package br.com.fiap.fintech.dao;

import java.util.List;

import br.com.fiap.fintech.bean.Inv_Usuario;
import br.com.fiap.fintech.exception.DBException;

public interface InvestimentoUsuarioDAO {
	
	void cadastrarInvUsuario(Inv_Usuario invUsuario) throws DBException;
	//void editarInvUsuario(Inv_Usuario invUsuario) throws DBException;
	void removerInvUsuario(int invUsuarioId) throws DBException;
	List<Inv_Usuario>todosInvUsuario();

}
