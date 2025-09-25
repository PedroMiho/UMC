let alunos = [];

function adicionarAluno() {
  let nome = document.getElementById("nome").value;
  let idade = document.getElementById("idade").value;
  let curso = document.getElementById("curso").value;

  if (nome && idade && curso) {
    alunos.push({ nome, idade, curso });
    alert("Aluno adicionado com sucesso!");
    document.getElementById("nome").value = "";
    document.getElementById("idade").value = "";
    document.getElementById("curso").value = "";
  } else {
    alert("Preencha todos os campos!");
  }
}

function listarAlunos() {
  let lista = document.getElementById("listaAlunos");
  lista.innerHTML = "";

  alunos.forEach(aluno => {
    let li = document.createElement("li");
    li.textContent = `${aluno.nome} - ${aluno.idade} anos - Curso: ${aluno.curso}`;
    lista.appendChild(li);
  });
}
