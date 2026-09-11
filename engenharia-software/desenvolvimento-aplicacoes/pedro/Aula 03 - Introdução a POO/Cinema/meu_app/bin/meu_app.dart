void main() {
  Filme filme = Filme(
    titulo: "Homem-Aranha: Um novo dia",
    genero: "Ação",
    classificacao: 12,
    duracao: 145
  );

  filme.exibirInformacoes();


}


class Filme {
  String titulo;
  String genero;
  int classificacao;
  int duracao;

  Filme({
    required this.titulo,
    required this.classificacao,
    required this.duracao,
    required this.genero
  });

  void exibirInformacoes(){
    print("Filme $titulo , genero $genero, classificação $classificacao e duracao de $duracao");
  }

}
