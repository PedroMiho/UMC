import 'bonificavel.dart';
import 'funcionario.dart';

// Vendedor também é um Funcionario e possui uma regra própria de bonificação.
class Vendedor extends Funcionario implements Bonificavel {
  final double totalVendas;

  Vendedor(String nome, double salario, this.totalVendas)
      : super(nome, salario) {
    if (totalVendas < 0) {
      throw ArgumentError('O total de vendas não pode ser negativo.');
    }
  }

  @override
  String get cargo {
    return 'Vendedor';
  }

  @override
  double calcularBonificacao() {
    return totalVendas * 0.05;
  }

  @override
  void exibirInformacoes() {
    super.exibirInformacoes();
    print('Total de vendas: R$ ${totalVendas.toStringAsFixed(2)}');
  }
}

