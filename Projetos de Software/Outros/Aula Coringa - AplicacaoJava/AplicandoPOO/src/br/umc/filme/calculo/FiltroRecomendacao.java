package br.umc.filme.calculo;

public class FiltroRecomendacao {
	
	public void filtra(Classificavel classificavel) {
		if (classificavel.getClassificacao() >= 4) {
			System.out.println("Está entre os preferidos");
		}
		
		else if (classificavel.getClassificacao() >= 2) {
			System.out.println("Esta bem avaliado");
		}
		
		else {
			System.out.println("Coloque na sua lista para assitir depois");
		}
	}
	
}
