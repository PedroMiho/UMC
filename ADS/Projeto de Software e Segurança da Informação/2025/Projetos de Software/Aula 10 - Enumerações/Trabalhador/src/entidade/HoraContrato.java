package entidade;

import java.util.Date;

public class HoraContrato {
	
	private Date date;
	private Double valorPorHora;
	private int horas;
	
	
	public HoraContrato(Date date, Double valorPorHora, int horas) {
		this.date = date;
		this.valorPorHora = valorPorHora;
		this.horas = horas;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Double getValorPorHora() {
		return valorPorHora;
	}


	public void setValorPorHora(Double valorPorHora) {
		this.valorPorHora = valorPorHora;
	}


	public int getHoras() {
		return horas;
	}


	public void setHoras(int horas) {
		this.horas = horas;
	}
	
	
	public double valorTotal() {
		return valorPorHora * horas;
	}
	
	
	
	
}
