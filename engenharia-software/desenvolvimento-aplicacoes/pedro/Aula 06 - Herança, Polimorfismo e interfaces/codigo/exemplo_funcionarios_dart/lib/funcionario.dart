// Classe abstrata que representa as características comuns dos funcionários.
// Ela não pode ser instanciada diretamente.
abstract class Funcionario {
  final String _nome;
  final double _salario;

  Funcionario(this._nome, this._salario) {
    if (_nome.trim().isEmpty) {
      throw ArgumentError('O nome não pode ficar vazio.');
    }

    if (_salario <= 0) {
      throw ArgumentError('O salário deve ser maior que zero.');
    }
  }

  // Getters permitem consultar os atributos encapsulados.
  String get nome {
    return _nome;
  }

  double get salario {
    return _salario;
  }

  // Cada subclasse deverá informar o seu próprio cargo.
  String get cargo;

  // Método concreto que pode ser utilizado por todas as subclasses.
  void exibirInformacoes() {
    print('Cargo: $cargo');
    print('Nome: $nome');
    print('Salário: R$ ${salario.toStringAsFixed(2)}');
  }
}

