// 2) ENTRADA DE DADOS
import 'dart:io';

void main() {
  print('Digite seu nome: ');
  String? nome = stdin.readLineSync();

  print('Digite sua idade: ');
  String? idadeTexto = stdin.readLineSync();
  int idade = int.parse(idadeTexto!);

  print('Olá, $nome! Você tem $idade anos.');
}
