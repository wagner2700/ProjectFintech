package br.com.fiap.fintech.dao;

import java.util.List;

import br.com.fiap.fintech.bean.Receita;
import br.com.fiap.fintech.exception.DBException;

public interface ReceitaDAO {
	void cadastrarReceita(Receita receita) throws DBException;
	void editarReceita(Receita receita) throws DBException;
	void removerReceitao(int receitaid) throws DBException;
	Receita buscarReceita(int receitaid);
	List<Receita>todasReceitas();

}
