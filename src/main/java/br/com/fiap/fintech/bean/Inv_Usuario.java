package br.com.fiap.fintech.bean;


import java.util.Calendar;

public class Inv_Usuario {
	private int inv_usuario_id;
	private int usuarioid;
	private int investimentoid;
	private Calendar dt_Investimento;
	
	public Inv_Usuario(int inv_usuario_id, int usuarioid, int investimentoid, Calendar dt_Investimento) {
		super();
		this.inv_usuario_id = inv_usuario_id;
		this.usuarioid = usuarioid;
		this.investimentoid = investimentoid;
		this.dt_Investimento = dt_Investimento;
	}

	public int getInv_usuario_id() {
		return inv_usuario_id;
	}

	public void setInv_usuario_id(int inv_usuario_id) {
		this.inv_usuario_id = inv_usuario_id;
	}

	public int getUsuarioid() {
		return usuarioid;
	}

	public void setUsuarioid(int usuarioid) {
		this.usuarioid = usuarioid;
	}

	public int getInvestimentoid() {
		return investimentoid;
	}

	public void setInvestimentoid(int investimentoid) {
		this.investimentoid = investimentoid;
	}

	public Calendar getDt_Investimento() {
		return dt_Investimento;
	}

	public void setDt_Investimento(Calendar dt_Investimento) {
		this.dt_Investimento = dt_Investimento;
	}


	

}
