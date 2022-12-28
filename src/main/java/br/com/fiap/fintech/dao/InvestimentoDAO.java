package br.com.fiap.fintech.dao;

import java.util.List;

import br.com.fiap.fintech.bean.Investimentos;
import br.com.fiap.fintech.exception.DBException;

public interface InvestimentoDAO {
	
	void cadastrarInvestimento(Investimentos investimento) throws DBException;
	void editarInvestimento(Investimentos investimentos) throws DBException;
	void removerInvestimento(int investimentoid) throws DBException;
	Investimentos buscarInvestimento(int investimentoid);
	List<Investimentos>todosInvestimentos();
	

}
