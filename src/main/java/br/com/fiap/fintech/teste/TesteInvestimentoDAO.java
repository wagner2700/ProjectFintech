package br.com.fiap.fintech.teste;

import br.com.fiap.fintech.bean.Investimentos;
import br.com.fiap.fintech.dao.InvestimentoDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOInvestimentoFactory;

public class TesteInvestimentoDAO {
	

	public static void main(String[] args) {
		
		InvestimentoDAO inv_dao = DAOInvestimentoFactory.getInvestimentoDAO();
		
	
		Investimentos investimento = new Investimentos(0,"Poupança");
		
		try {
			inv_dao.cadastrarInvestimento(investimento);
			System.out.println("Investimento cadastrado.");
		
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		investimento  = inv_dao.buscarInvestimento(1);
		investimento.setTipo_investimento("teste");
		try {
			inv_dao.editarInvestimento(investimento);
			System.out.println("Investimento atualizado.");
		}
		catch (DBException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
}