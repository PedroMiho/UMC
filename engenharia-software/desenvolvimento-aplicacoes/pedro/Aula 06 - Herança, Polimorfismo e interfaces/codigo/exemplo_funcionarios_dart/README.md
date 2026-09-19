# Exemplo de POO com Dart

Projeto didático para demonstrar herança, polimorfismo, classes abstratas e interfaces.

## Estrutura

- `Funcionario`: classe abstrata com os dados comuns.
- `Gerente`: herda de `Funcionario` e implementa `Bonificavel`.
- `Vendedor`: herda de `Funcionario` e implementa `Bonificavel`.
- `Estagiario`: herda de `Funcionario`, mas não recebe bonificação.
- `Bonificavel`: interface que exige o método `calcularBonificacao()`.

## Execução

Abra o terminal na pasta do projeto e execute:

```bash
dart run
```

## Conceitos demonstrados

1. `extends` cria a relação de herança.
2. `super` chama o construtor ou um método da classe pai.
3. `@override` indica a sobrescrita de um membro.
4. `implements` faz a classe assumir o contrato de uma interface.
5. `List<Funcionario>` demonstra o polimorfismo pela classe pai.
6. `is Bonificavel` verifica se o objeto possui a capacidade de calcular bonificação.

