package br.com.fiap.fintech.teste;

import br.com.fiap.fintech.bean.Receita;
import br.com.fiap.fintech.dao.ReceitaDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOReceitaFactory;

public class TesteReceitaDAO {
	public static void main(String[] args) {
	
	ReceitaDAO daoReceita = DAOReceitaFactory.getReceitaDAO();
	
	Receita receita = new Receita(0 , "salario");
	
	try {
		daoReceita.cadastrarReceita(receita);
		System.out.println("Receita cadastrada");
	}catch (DBException e) {
		e.printStackTrace();
	}
}
}