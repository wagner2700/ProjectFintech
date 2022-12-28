package br.com.fiap.fintech.bean;

public class Investimentos {
	private int investimentoId;
	private String tipo_investimento;
	
	
	public Investimentos(int investimentoId, String tipo_investimento) {
		super();
		this.investimentoId = investimentoId;
		this.tipo_investimento = tipo_investimento;
	}


	public int getInvestimentoId() {
		return investimentoId;
	}


	public void setInvestimentoId(int investimentoId) {
		this.investimentoId = investimentoId;
	}


	public String getTipo_investimento() {
		return tipo_investimento;
	}


	public void setTipo_investimento(String tipo_investimento) {
		this.tipo_investimento = tipo_investimento;
	}
	
	

}
