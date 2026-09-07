void main() {
  // Criando uma conta
  ContaBancaria conta = ContaBancaria('João');

  // Exibindo os dados iniciais
  print('Titular: ${conta.titular}');
  print('Saldo inicial: ${conta.saldo}');

  // Realizando um depósito
  conta.depositar(1000);

  // Consultando o saldo
  print('Saldo após depósito: ${conta.saldo}');

  // Realizando um saque
  conta.sacar(300);

  // Consultando o saldo novamente
  print('Saldo após saque: ${conta.saldo}');

  // Tentando sacar um valor maior que o saldo
  conta.sacar(1000);

  // Exibindo o saldo final
  print('Saldo final: ${conta.saldo}');
}

class ContaBancaria {
  String titular;
  double _saldo = 0;

  ContaBancaria(this.titular);

  // Método para depositar dinheiro
  void depositar(double valor) {
    if (valor > 0) {
      _saldo += valor;
      print('Depósito realizado com sucesso!');
    } else {
      print('O valor do depósito deve ser maior que zero.');
    }
  }

  // Método para sacar dinheiro
  bool sacar(double valor) {
    if (valor <= 0) {
      print('O valor do saque deve ser maior que zero.');
      return false;
    }

    if (valor > _saldo) {
      print('Saldo insuficiente.');
      return false;
    }

    _saldo -= valor;
    print('Saque realizado com sucesso!');
    return true;
  }

  // Método que retorna o saldo
  double consultarSaldo() {
    return _saldo;
  }

  // Getter para consultar o saldo
  double get saldo => _saldo;
}


