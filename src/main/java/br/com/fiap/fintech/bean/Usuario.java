package br.com.fiap.fintech.bean;

public class Usuario {
	
	
	private Integer usuarioid;
	private String nome;
	private String email;
	private String senha;
	private String telefone;
	
	
	
	
	
	public Usuario(Integer usuarioid, String nome, String email, String senha, String telefone) {
		super();
		this.usuarioid = usuarioid;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
	}
	public Integer getUsuarioid() {
		return usuarioid;
	}
	public void setUsuarioid(Integer usuarioid) {
		this.usuarioid = usuarioid;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	
}
