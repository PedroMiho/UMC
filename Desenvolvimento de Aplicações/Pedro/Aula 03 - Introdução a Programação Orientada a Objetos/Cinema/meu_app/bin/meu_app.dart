void main() {
  Filme filme = Filme();
  filme.titulo = "Homem-Aranha: Um novo dia";
  filme.genero = "Ação";
  filme.classificacao = 12;
  filme.duracao = 145;

  filme.infoFilme();

  print(filme.podeAssistir(15));
}


class Filme {
  String titulo = "";
  String genero = "";
  int classificacao = 0;
  int duracao = 0 ;

  void infoFilme() {
    print("titulo $titulo, Gênero $genero,classificação $classificacao e tem duração de $duracao");
  }
  
  bool podeAssistir(int idade) { 
    return idade >= classificacao;
  } 	
}
