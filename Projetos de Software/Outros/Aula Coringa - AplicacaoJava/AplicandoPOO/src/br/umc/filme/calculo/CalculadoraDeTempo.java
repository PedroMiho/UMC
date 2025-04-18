package br.umc.filme.calculo;
import br.umc.filme.modelos.Titulo;

public class CalculadoraDeTempo {
		
	private int tempoTotal;

	public int getTempoTotal() {
		return tempoTotal;
	}
	
	public void inclui(Titulo t) {
		this.tempoTotal += t.getDuracaoMinutos();
	}
	
	
}
