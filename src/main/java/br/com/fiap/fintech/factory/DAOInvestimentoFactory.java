package br.com.fiap.fintech.factory;

import br.com.fiap.fintech.dao.InvestimentoDAO;
import br.com.fiap.fintech.dao.impl.OracleInvestimentoDAO;

public class DAOInvestimentoFactory {
	
	public static InvestimentoDAO getInvestimentoDAO() {
		return new OracleInvestimentoDAO();
	}

}
