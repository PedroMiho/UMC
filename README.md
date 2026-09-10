# UMC — Materiais dos Cursos de Graduação

Este repositório reúne materiais didáticos, exemplos de código, exercícios, projetos e recursos utilizados nas disciplinas de graduação ministradas pelo professor **Pedro Henrique Miho de Souza** na Universidade de Mogi das Cruzes (UMC).

O conteúdo está organizado por curso, disciplina, período e tema, permitindo que os estudantes acompanhem a evolução das aulas e consultem os exemplos desenvolvidos em sala.

## Objetivo

Disponibilizar materiais de apoio para o desenvolvimento das competências práticas dos estudantes nas áreas de lógica de programação, desenvolvimento web, programação orientada a objetos, banco de dados, desenvolvimento de aplicações e engenharia de software.

## Cursos e áreas

O repositório contém materiais relacionados principalmente aos seguintes cursos:

- Análise e Desenvolvimento de Sistemas — ADS
- Engenharia de Software
- Sistemas de Informação — SI

## Conteúdos disponíveis

Entre os principais assuntos abordados estão:

- Lógica de programação
- HTML, CSS e JavaScript
- PHP e integração com banco de dados
- Java e Programação Orientada a Objetos
- Dart e desenvolvimento de aplicações
- Estruturas condicionais e de repetição
- Collections, listas e manipulação de dados
- Encapsulamento, herança e polimorfismo
- JDBC e persistência de dados
- APIs REST
- Spring Boot
- Spring Data JPA
- Tratamento de erros
- Spring Security
- Desenvolvimento de Software Corporativo
- Projeto de Software e Segurança da Informação

## Organização do repositório

```text
UMC/
├── ADS/
│   ├── Lógica e Programação/
│   ├── Projeto de Software e Segurança da Informação/
│   ├── Software Básico/
│   └── Tabelas/
├── ENGENHARIA DE SOFTWARE/
│   ├── Desenvolvimento de Aplicações/
│   └── Desenvolvimento de Software Corporativo/
├── SI/
│   └── Programação para Internet/
├── Modelo de Apresentação.pptx
└── README.md
```

A estrutura interna pode conter divisões adicionais por ano, módulo, aula, atividade ou projeto.

## Tecnologias utilizadas

Os exemplos e projetos podem utilizar as seguintes tecnologias:

- HTML5
- CSS3
- JavaScript
- PHP
- Java
- Spring Boot
- Spring Data JPA
- Spring Security
- Maven
- Dart
- Node.js
- SQL
- MySQL

## Como utilizar os materiais

1. Acesse a pasta correspondente ao seu curso.
2. Localize a disciplina e o período desejado.
3. Entre na pasta da aula ou do projeto.
4. Consulte os códigos, exercícios e materiais disponibilizados.
5. Leia as orientações específicas existentes dentro de cada projeto.

Para baixar todo o conteúdo:

```bash
git clone https://github.com/PedroMiho/UMC.git
```

Depois, acesse a pasta do repositório:

```bash
cd UMC
```

## Execução dos projetos

Cada projeto pode possuir requisitos diferentes.

### Projetos Java e Spring Boot

Verifique se o Java e o Maven estão instalados:

```bash
java --version
mvn --version
```

Quando existir um arquivo `pom.xml`, o projeto poderá normalmente ser executado com:

```bash
mvn spring-boot:run
```

### Projetos Dart

Verifique se o Dart SDK está instalado:

```bash
dart --version
```

Na pasta que contém o arquivo `pubspec.yaml`, execute:

```bash
dart pub get
dart run
```

### Projetos web

Projetos desenvolvidos apenas com HTML, CSS e JavaScript podem ser abertos diretamente no navegador ou executados com uma extensão de servidor local, como o Live Server.

Projetos com PHP precisam de um servidor compatível, como Apache, XAMPP ou PHP Development Server.

## Observações importantes

- Este repositório possui finalidade acadêmica e didática.
- Alguns códigos representam etapas intermediárias desenvolvidas durante as aulas.
- Determinados projetos podem exigir banco de dados ou configurações locais.
- Credenciais e informações de acesso devem ser configuradas por variáveis de ambiente e não devem ser publicadas.
- Os materiais podem ser atualizados conforme o andamento das disciplinas.

## Autor

**Pedro Henrique Miho de Souza**  
Professor de Tecnologia da Informação

- [LinkedIn](https://www.linkedin.com/in/pedro-miho)
- [GitHub](https://github.com/PedroMiho)

## Licença

Consulte o arquivo [LICENSE](LICENSE) disponível neste repositório.
