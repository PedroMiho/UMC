class Produto {
  String _nome = '';
  double _preco = 0;
  int _quantidade = 0;

  Produto(String nome, double preco, int quantidade) {
    // Utiliza os setters para validar os dados do cadastro.
    this.nome = nome;
    this.preco = preco;
    this.quantidade = quantidade;
  }

  // Getters: permitem consultar os atributos.   
  //String get nome => _nome;   
  //double get preco => _preco;   
  //int get quantidade => _quantidade;   
  //double get valorEmEstoque => _preco * _quantidade;

  String get nome {
    return _nome;
  }

  double get preco {
    return _preco;
  }

  int get quantidade {
    return _quantidade;
  }

  double get valorEmEstoque {
    return _preco * _quantidade;
  }

  // Setters: validam antes de alterar os atributos.
  set nome(String novoNome) {
    if (novoNome.trim().isEmpty) {
      throw ArgumentError('O nome não pode ficar vazio.');
    }

    _nome = novoNome.trim();
  }

  set preco(double novoPreco) {
    if (!novoPreco.isFinite || novoPreco <= 0) {
      throw ArgumentError('O preço deve ser um número positivo.');
    }

    _preco = novoPreco;
  }

  set quantidade(int novaQuantidade) {
    if (novaQuantidade < 0) {
      throw ArgumentError('A quantidade não pode ser negativa.');
    }

    _quantidade = novaQuantidade;
  }


}