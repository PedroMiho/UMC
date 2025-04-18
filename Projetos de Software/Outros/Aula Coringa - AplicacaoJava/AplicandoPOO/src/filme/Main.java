package filme;
import java.util.ArrayList;

import br.umc.filme.calculo.CalculadoraDeTempo;
import br.umc.filme.calculo.FiltroRecomendacao;
import br.umc.filme.modelos.Episodios;
import br.umc.filme.modelos.Filme;
import br.umc.filme.modelos.Serie;

public class Main {

	public static void main(String[] args) {
		//Instanciando a classe filme
		Filme filmeFavorito = new Filme();
		
		//Atribuindo valores para as propriedades da classe
		filmeFavorito.setNome("O Poderoso chefão");
		filmeFavorito.setAnoLancamento(1970);
		filmeFavorito.setDuracaoMinutos(180);
		// Inserindo valores para o calculo da media do filme
		filmeFavorito.avalia(8);
		filmeFavorito.avalia(10);
		filmeFavorito.avalia(10);
		filmeFavorito.exibeFichaTecnica();
		// Chamando os metodos Getters e o calculaMedia
		System.out.println(filmeFavorito.calculaMedia());
		System.out.println(filmeFavorito.getTotalAvaliacao());
		System.out.println(filmeFavorito.getSomaAvaliacao());	
		System.out.println(filmeFavorito.getClassificacao());
		System.out.println();

		//Criando a serie suits
		Serie suits = new Serie();
		suits.setNome("Suits");
		suits.setAnoLancamento(2000);
		suits.exibeFichaTecnica();
		suits.setTemporadas(6);
		suits.setEspidiosPorTemporada(8);
		suits.setMinutosPorEpisodio(40);
		System.out.println("Duração em minutos em uma serie: " + suits.getDuracaoMinutos());
		
		//Criando o Filme Vingadores
		Filme vingadores = new Filme();
		vingadores.setNome("Vingadores: Ultimato");
		vingadores.setAnoLancamento(2019);
		vingadores.setDuracaoMinutos(182);
		vingadores.setDiretor("Anthony Russo");
		System.out.println();
		vingadores.exibeFichaTecnica();
		System.out.println();
		
		//Criando lista
		ArrayList<Filme> listaDeFilmes = new ArrayList<>();
		listaDeFilmes.add(vingadores);
		listaDeFilmes.add(filmeFavorito);
		System.out.println("Tamanho da lista " + listaDeFilmes.size());
		System.out.println("Primeiro Filme" + listaDeFilmes.get(0).getNome());
		System.out.println("Segundo Filme" + listaDeFilmes.get(1).getNome());
		
		
		//Calculando o tempo total de tempo
		CalculadoraDeTempo calculadoraFilme = new CalculadoraDeTempo();
		calculadoraFilme.inclui(filmeFavorito);
		calculadoraFilme.inclui(vingadores);
		calculadoraFilme.inclui(suits);
		System.out.println("O tempo total para assistir todos os filmes e series: " + calculadoraFilme.getTempoTotal());
		System.out.println();
		
		FiltroRecomendacao filtro = new FiltroRecomendacao();
		
		System.out.print("O seu filme favorito: ");
		filtro.filtra(filmeFavorito);
		
		Episodios episodio = new Episodios();
		episodio.setNumero(1);
		episodio.setSerie(suits);
		episodio.setTotalVisualizacoes(300);
		System.out.print("O primeiro episodio da serie Suits : ");
		filtro.filtra(episodio);
		
	}

}