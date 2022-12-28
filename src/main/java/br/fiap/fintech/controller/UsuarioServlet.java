	package br.fiap.fintech.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fintech.bean.Usuario;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/cadastroUsuario")
public class UsuarioServlet extends HttpServlet {
	
	
	
	private static final long serialVersionUID = 1L;
	
	
		private UsuarioDAO dao ;
	
		
	   
		@Override
		 public void init() throws ServletException{ 
			 super.init();
			 dao = DAOFactory.getUsuarioDAO();
			 }
		 
		 
	  
	  
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response ) throws ServletException, IOException {
		request.getRequestDispatcher("NewFile.jsp").forward(request, response);
	}
	
	
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response )throws ServletException, IOException{
		 
	
		
		
		try {
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			String confirmaSenha = request.getParameter("confirmaSenha");
			String telefone = request.getParameter("telefone");
			
			System.out.println(nome);
			System.out.println(email);
			System.out.println(senha);
			System.out.println(confirmaSenha);
			System.out.println(telefone);
			
			
			Usuario usuario1 = new Usuario(3 ,nome,email , senha ,telefone);
			
			
			
			dao.cadastrarUsuario(usuario1);
	
					
			request.setAttribute("msg","Usuario cadastrado");
			request.getRequestDispatcher("sucesso.jsp").forward(request, response);
			
		
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("Erro", "Valide os dados");
			
			
		
		
  
		}
		}
	}

