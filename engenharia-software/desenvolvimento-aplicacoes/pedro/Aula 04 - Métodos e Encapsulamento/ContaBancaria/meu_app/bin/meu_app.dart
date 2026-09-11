void main() {
  //Instância do objeto
  Roupa camisa = Roupa("Camisa", 150, 15);
  print(camisa.exibirInformacaoRoupa());
  camisa.acescentarCamisa(10);
  print(camisa.exibirInformacaoRoupa());
  camisa.decrementarCamisas(10);
  print(camisa.exibirInformacaoRoupa());
}

class Roupa {
  String tipo;
  double valor;
  int quantidade;

  //Construtor
  Roupa(this.tipo, this.valor, this.quantidade);

  //Métodos

  //Método void
  //Acrescentar camisa no estoque
  void acescentarCamisa(int quantidade) {
    if (quantidade > 0) {
      this.quantidade += quantidade;
    } else {
      print("Quantidade inválida");
    }
  }

  //Retirar camisas do estoque
  void decrementarCamisas(int quantidade) {
    if (quantidade > 0 && this.quantidade >= quantidade) {
      this.quantidade -= quantidade;
    } else {
      print("Quantidade inválida");
    }
  }

  //Método calcular valor no estoque
  double valorTotal() {
    double valorTotal = valor * quantidade;
    return valorTotal;
  }

  //Método exibir informações
  String exibirInformacaoRoupa() {
    return "Produto: $tipo\n"
        "Valor: R\$ $valor\n"
        "Quantidade: $quantidade\n"
        "Valor total no estoque: R\$ ${valorTotal()}";
  }
}
