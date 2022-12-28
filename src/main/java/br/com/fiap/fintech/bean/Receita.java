package br.com.fiap.fintech.bean;

public class Receita {
	
	private int receitaid;
	private String nomeReceita;
	
	
	public Receita(int receitaid, String nomeReceita) {
		super();
		this.receitaid = receitaid;
		this.nomeReceita = nomeReceita;
	}


	public int getReceitaid() {
		return receitaid;
	}


	public void setReceitaid(int receitaid) {
		this.receitaid = receitaid;
	}


	public String getNomeReceita() {
		return nomeReceita;
	}


	public void setNomeReceita(String nomeReceita) {
		this.nomeReceita = nomeReceita;
	}
	
	
	
	

}
