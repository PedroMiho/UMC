const form = document.getElementById('loginForm');

form.addEventListener('submit', function(event) {
    event.preventDefault();

    const email = document.getElementById('email').value;
    const senha = document.getElementById('senha').value;

    const dados = {
        email: email,
        senha: senha
    };

    fetch('http://localhost:8080/usuarios/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(dados)
    })
    .then(async response => {
        const mensagem = document.getElementById('mensagem');
        
        if (response.ok) {
            const usuario = await response.json();

            // Salva os dados no localStorage
            localStorage.setItem('usuarioLogado', JSON.stringify(usuario));

            // Redireciona para a página de perfil
            window.location.href = 'perfil.html';
        } else {
            const erro = await response.text();
            mensagem.innerText = `❌ ${erro || 'Email ou senha inválidos!'}`;
            mensagem.classList.remove('text-success');
            mensagem.classList.add('text-danger');
            throw new Error(erro);
        }
    })
    .catch(error => {
        const mensagem = document.getElementById('mensagem');
        mensagem.innerText = `❌ Erro na requisição: ${error.message}`;
        mensagem.classList.remove('text-success');
        mensagem.classList.add('text-danger');
    });
});
