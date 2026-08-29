// 5) PRINT
void main() {
  // Print simples
  print('Olá, Barbara!');

  // Print com variável
  String nome = 'Barbara';
  print(nome);

  // Print com interpolação de string ($)
  int idade = 25;
  print('Nome: $nome, Idade: $idade');

  // Print com expressão dentro de ${}
  int a = 10, b = 5;
  print('A soma é: ${a + b}');

  // Print concatenando com +
  print('Nome: ' + nome + ', Idade: ' + idade.toString());

  // Print de múltiplas linhas
  print('''
  Linha 1
  Linha 2
  Linha 3
  ''');
}
