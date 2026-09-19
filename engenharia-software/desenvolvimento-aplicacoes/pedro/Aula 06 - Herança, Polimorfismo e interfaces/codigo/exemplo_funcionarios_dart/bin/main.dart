import '../lib/bonificavel.dart';
import '../lib/estagiario.dart';
import '../lib/funcionario.dart';
import '../lib/gerente.dart';
import '../lib/vendedor.dart';

void main() {
  // Objetos diferentes armazenados em variáveis do tipo Funcionario.
  Funcionario gerente = Gerente('Ana', 8000, 'Tecnologia');
  Funcionario vendedor = Vendedor('Bruno', 3500, 20000);
  Funcionario estagiario = Estagiario('Carla', 1800, 'ADS');

  // Uma única coleção pode armazenar diferentes subclasses.
  List<Funcionario> equipe = [
    gerente,
    vendedor,
    estagiario,
  ];

  print('===== EQUIPE =====');

  // Polimorfismo: cada objeto executa sua versão de exibirInformacoes().
  for (Funcionario funcionario in equipe) {
    funcionario.exibirInformacoes();

    // Verifica se o objeto implementa a interface Bonificavel.
    if (funcionario is Bonificavel) {
      double bonus = funcionario.calcularBonificacao();
      print('Bonificação: R$ ${bonus.toStringAsFixed(2)}');
    } else {
      print('Este cargo não recebe bonificação.');
    }

    print('------------------------------');
  }
}

