let tarefas = [];
let tarefaEditando = null; // Para identificar qual tarefa está sendo editada

function adicionarTarefa() {
    const input = document.getElementById("nova-tarefa");
    const tarefa = input.value.trim();

    if (tarefa) {
        if (tarefaEditando !== null) {
            // Editar tarefa existente
            tarefas[tarefaEditando] = tarefa;
            tarefaEditando = null; // Resetar o índice de edição
        } else {
            // Adicionar nova tarefa
            tarefas.push(tarefa);
        }
        exibirTarefas();
        input.value = ""; // Limpar o campo após adicionar/editar
    }
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

        const botaoAlterar = document.createElement("button");
        botaoAlterar.textContent = "Alterar";
        botaoAlterar.classList.add("alterar");
        botaoAlterar.onclick = () => editarTarefa(index);

        li.appendChild(botaoAlterar);
        li.appendChild(botaoRemover);
        lista.appendChild(li);
    });
}

function removerTarefa(index) {
    tarefas.splice(index, 1); // Remove a tarefa do array
    exibirTarefas();
}

function editarTarefa(index) {
    const input = document.getElementById("nova-tarefa");
    input.value = tarefas[index]; // Preencher o campo com a tarefa que será editada
    tarefaEditando = index; // Armazenar o índice da tarefa sendo editada
}
