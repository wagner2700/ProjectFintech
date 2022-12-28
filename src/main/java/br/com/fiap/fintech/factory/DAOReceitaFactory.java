package br.com.fiap.fintech.factory;

import br.com.fiap.fintech.dao.ReceitaDAO;
import br.com.fiap.fintech.dao.impl.OracleReceitaDAO;

public class DAOReceitaFactory {
	
	public static ReceitaDAO getReceitaDAO() {
		return (ReceitaDAO) new OracleReceitaDAO();
	}

}
