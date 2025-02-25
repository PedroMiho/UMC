package filme;

public class Main {

	public static void main(String[] args) {
		Filme filmeFavorito = new Filme();
		
		filmeFavorito.nome = "O Poderoso chefão";
		filmeFavorito.anoLancamento = 1970;
		filmeFavorito.duracaoMinutos = 180;
		
		filmeFavorito.exibeFichaTecnica();
		filmeFavorito.avalia(8);
		filmeFavorito.avalia(4);
		filmeFavorito.avalia(3);
		System.out.println(filmeFavorito.somaAvaliacao);
		System.out.println(filmeFavorito.totalAvaliacao);
		System.out.println(filmeFavorito.pegaMedia());
	}

}
