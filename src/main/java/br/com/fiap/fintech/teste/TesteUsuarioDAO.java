package br.com.fiap.fintech.teste;

import java.util.List;

import br.com.fiap.fintech.bean.Usuario;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;


public class TesteUsuarioDAO {

	public static void main(String[] args) {
		
		UsuarioDAO dao = DAOFactory.getUsuarioDAO();
		
		
		// cadastrar
		Usuario usuario = new Usuario(1,"Jdsdso" , "222@GMAIL","12dsd56","58dsds111");
		
		try {
			dao.cadastrarUsuario(usuario);
			System.out.println("2");
			System.out.println("Produto cadastrado.");
		} catch (DBException e) {
			e.printStackTrace();
		}
	}}
		/*//Buscar um produto pelo código e atualizar
		usuario = dao.buscarUsuario(20);
		usuario.setNome("teste");
		usuario.setSobrenome("teste1");
		try {
			dao.atualizarUsuario(usuario);
			System.out.println("Produto atualizado.");
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		//Listar os produtos
		List<Usuario>todosUsuarios = dao.todosUsuarios();
		for (Usuario UsuarioItem : todosUsuarios) {
			System.out.println(UsuarioItem.getUsuarioid() + " - " + UsuarioItem.getNome() + " -  " + UsuarioItem.getSobrenome());
		}
		
		//Remover um produto
		try {
			dao.removerUsuario(20);
			System.out.println("Produto removido.");
		} catch (DBException e) {
			e.printStackTrace();
		}	
}
}*/