// Parte 1 – Somente JavaScript (console)

// Criar um array vazio chamado alunos.

// Cada aluno deve ser um objeto com as propriedades:

// nome (string)

// idade (número)

// curso (string)

// Implementar funções para:

// Adicionar aluno ao array.

// Listar todos os alunos no console.

// Buscar aluno pelo nome.

// 📌 Exemplo esperado no console:

let alunos = [];

// Função para adicionar aluno
function adicionarAluno(nome, idade, curso) {
  alunos.push({ nome, idade, curso });
}

// Função para listar alunos
function listarAlunos() {
  console.log("Lista de Alunos:");
  alunos.forEach((aluno, index) => {
    console.log(`${index + 1}. ${aluno.nome} - ${aluno.idade} anos - Curso: ${aluno.curso}`);
  });
}

// Função para buscar aluno pelo nome
function buscarAluno(nome) {
  let encontrado = alunos.find(aluno => aluno.nome === nome);
  if (encontrado) {
    console.log(`Encontrado: ${encontrado.nome}, ${encontrado.idade} anos, Curso: ${encontrado.curso}`);
  } else {
    console.log("Aluno não encontrado.");
  }
}

// Testando
adicionarAluno("Ana", 20, "TI");
adicionarAluno("Carlos", 22, "Redes");
listarAlunos();
buscarAluno("Ana");
