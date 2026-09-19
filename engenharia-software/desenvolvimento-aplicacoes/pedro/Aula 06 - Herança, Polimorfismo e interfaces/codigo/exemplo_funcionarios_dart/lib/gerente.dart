import 'bonificavel.dart';
import 'funcionario.dart';

// Gerente herda de Funcionario e implementa a interface Bonificavel.
class Gerente extends Funcionario implements Bonificavel {
  final String setor;

  Gerente(String nome, double salario, this.setor)
      : super(nome, salario);

  @override
  String get cargo {
    return 'Gerente';
  }

  @override
  double calcularBonificacao() {
    return salario * 0.20;
  }

  @override
  void exibirInformacoes() {
    super.exibirInformacoes();
    print('Setor: $setor');
  }
}

