function verificarLogin() {
    let usuario = document.getElementById("usuario").value.trim();
    let senha = document.getElementById("senha").value.trim();
    let mensagem = document.getElementById("mensagem");

    if (usuario === "admin" && senha === "1234") {
        mensagem.style.color = "green";
        mensagem.innerText = "✅ Login bem-sucedido!";
    } else if (usuario === "admin") {
        mensagem.style.color = "red";
        mensagem.innerText = "❌ Senha incorreta!";
    } else {
        mensagem.style.color = "orange";
        mensagem.innerText = "⚠️ Usuário não encontrado!";
    }
}