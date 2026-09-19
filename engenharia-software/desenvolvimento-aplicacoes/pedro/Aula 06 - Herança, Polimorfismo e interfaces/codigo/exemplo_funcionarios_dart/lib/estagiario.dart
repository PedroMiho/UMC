import 'funcionario.dart';

// Estagiario herda de Funcionario, mas não implementa Bonificavel.
class Estagiario extends Funcionario {
  final String curso;

  Estagiario(String nome, double salario, this.curso)
      : super(nome, salario);

  @override
  String get cargo {
    return 'Estagiário';
  }

  @override
  void exibirInformacoes() {
    super.exibirInformacoes();
    print('Curso: $curso');
  }
}

