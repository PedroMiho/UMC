package filme;
import br.umc.filme.modelos.Filme;

public class Main {

	public static void main(String[] args) {
		//Instanciando a classe filme
		Filme filmeFavorito = new Filme();
		
		//Atribuindo valores para as propriedades da classe
		filmeFavorito.setNome("O Poderoso chefão");
		filmeFavorito.setAnoLancamento(1970);;
		filmeFavorito.setDuracaoMinutos(180);;
		
		//Chamando o metodo que mostra as informações do Filme
		filmeFavorito.exibeFichaTecnica();
		
		// Inserindo valores para o calculo da media do filme
		filmeFavorito.avalia(8);
		filmeFavorito.avalia(4);
		filmeFavorito.avalia(3);
		
		// Chamando os metodos Getters e o calculaMedia
		System.out.println(filmeFavorito.calculaMedia());
		System.out.println(filmeFavorito.getTotalAvaliacao());
		System.out.println(filmeFavorito.getSomaAvaliacao());
	}

}