package br.com.fiap.fintech.factory;

import br.com.fiap.fintech.dao.InvestimentoUsuarioDAO;
import br.com.fiap.fintech.dao.impl.OracleInv_UsuarioDAO;

public class DAOInvUsuarioFactory {
	
	public static InvestimentoUsuarioDAO getInvUsuarioDAO() {
		return new OracleInv_UsuarioDAO();
	}

}
