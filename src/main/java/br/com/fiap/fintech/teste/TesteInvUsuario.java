package br.com.fiap.fintech.teste;

import java.util.Calendar;

import br.com.fiap.fintech.bean.Inv_Usuario;
import br.com.fiap.fintech.dao.InvestimentoUsuarioDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOInvUsuarioFactory;

public class TesteInvUsuario {
	
	public static void main(String[] args) {
		
		InvestimentoUsuarioDAO invUsuarioDAO = DAOInvUsuarioFactory.getInvUsuarioDAO();
		
		Inv_Usuario invUsuario = new Inv_Usuario(0,5,41, Calendar.getInstance());
		
		try {
			invUsuarioDAO.cadastrarInvUsuario(invUsuario);
			System.out.println("Investimento cadastrado.");
		
		} catch (DBException e) {
			e.printStackTrace();
		}
		
	}

}
