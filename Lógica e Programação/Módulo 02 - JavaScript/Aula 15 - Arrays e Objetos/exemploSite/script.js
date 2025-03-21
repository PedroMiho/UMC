const tarefas = [];

function adicionarTarefa() {
    const input = document.getElementById("nova-tarefa");
    const tarefa = input.value

    if (tarefa) {
        tarefas.push(tarefa);
        exibirTarefas();
        input.value = ""; // Limpar o campo após adicionar
    }

    console.log(tarefas)
}

function exibirTarefas() {
    const lista = document.getElementById("lista-tarefas");
    lista.innerHTML = ""; // Limpa a lista antes de recriá-la

    tarefas.forEach((tarefa, index) => {
        const li = document.createElement("li");
        li.textContent = tarefa;

        const botaoRemover = document.createElement("button");
        botaoRemover.textContent = "Remover";
        botaoRemover.onclick = () => removerTarefa(index);

        li.appendChild(botaoRemover);    
        lista.appendChild(li);
    });
}

function removerTarefa(index) {
    console.log(index);
    tarefas.splice(index, 1); // Remove a tarefa do array
    exibirTarefas();
}
