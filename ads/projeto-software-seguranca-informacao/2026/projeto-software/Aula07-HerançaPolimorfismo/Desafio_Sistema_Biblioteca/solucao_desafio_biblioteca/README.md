# Solução do desafio Sistema de Biblioteca

Projeto Java para praticar classe abstrata, herança, sobrescrita de métodos e interfaces.

## Estrutura

- `ItemBiblioteca`: classe abstrata com os atributos comuns.
- `Livro`: item emprestável identificado pelo ISBN.
- `Revista`: item emprestável identificado pela edição.
- `Ebook`: item digital que pode ser baixado, mas não emprestado.
- `Emprestavel`: interface para empréstimo e devolução.
- `Baixavel`: interface do desafio extra.

O projeto não utiliza `ArrayList`.

## Execução

Na pasta do projeto, compile e execute:

```bash
javac -d out src/entidades/*.java src/Main.java
java -cp out Main
```
