/**
 * ProductHub — cadastro.js
 * Lógica da página "Cadastrar Produto"
 * -----------------------------------------------
 * Responsabilidades:
 *   1. Capturar o submit do formulário
 *   2. Validar todos os campos (incluindo valores negativos)
 *   3. Construir o objeto produto
 *   4. Ler/gravar no localStorage
 *   5. Exibir feedback visual de sucesso
 *   6. Limpar o formulário
 *   7. Redirecionar automaticamente para produtos.html
 */

// ============================================================
// 1. CONSTANTES E REFERÊNCIAS AO DOM
// ============================================================

/** Chave do localStorage — mesma usada em produtos.js */
const STORAGE_KEY = 'produtos';

/** Tempo (ms) antes de redirecionar após sucesso */
const REDIRECT_DELAY = 2000;

/** Referências aos elementos do formulário */
const form         = document.getElementById('form-cadastro');
const btnCadastrar = document.getElementById('btn-cadastrar');
const alertaSucesso = document.getElementById('alerta-sucesso');
const alertaMensagem = document.getElementById('alerta-mensagem');

/** Referências aos campos de input */
const campoNome       = document.getElementById('nome');
const campoMarca      = document.getElementById('marca');
const campoTamanho    = document.getElementById('tamanho');
const campoPreco      = document.getElementById('preco');
const campoQuantidade = document.getElementById('quantidade');

/** Referências às divs de mensagem de erro */
const erroNome       = document.getElementById('erro-nome');
const erroMarca      = document.getElementById('erro-marca');
const erroPreco      = document.getElementById('erro-preco');
const erroQuantidade = document.getElementById('erro-quantidade');


// ============================================================
// 2. VALIDAÇÃO DOS CAMPOS
// ============================================================

/**
 * Exibe ou limpa a mensagem de erro de um campo específico.
 * Adiciona/remove as classes visuais is-invalid e is-valid.
 *
 * @param {HTMLElement} campo   - O input/select a validar.
 * @param {HTMLElement} errDiv  - A div que recebe a mensagem de erro.
 * @param {string}      mensagem - Mensagem de erro (vazia = sem erro).
 */
function definirEstadoCampo(campo, errDiv, mensagem) {
  if (mensagem) {
    // Estado inválido
    campo.classList.add('is-invalid');
    campo.classList.remove('is-valid');
    errDiv.textContent = mensagem;
  } else {
    // Estado válido
    campo.classList.remove('is-invalid');
    campo.classList.add('is-valid');
    if (errDiv) errDiv.textContent = '';
  }
}

/**
 * Valida todos os campos do formulário.
 * Retorna true se todos passarem, false caso contrário.
 *
 * @returns {boolean} Resultado geral da validação.
 */
function validarFormulario() {
  let valido = true;

  // --- Validação: Nome ---
  const nome = campoNome.value.trim();
  if (!nome) {
    definirEstadoCampo(campoNome, erroNome, 'Informe o nome do produto.');
    valido = false;
  } else if (nome.length < 2) {
    definirEstadoCampo(campoNome, erroNome, 'O nome deve ter pelo menos 2 caracteres.');
    valido = false;
  } else {
    definirEstadoCampo(campoNome, erroNome, '');
  }

  // --- Validação: Marca ---
  const marca = campoMarca.value.trim();
  if (!marca) {
    definirEstadoCampo(campoMarca, erroMarca, 'Informe a marca do produto.');
    valido = false;
  } else {
    definirEstadoCampo(campoMarca, erroMarca, '');
  }

  // --- Validação: Preço ---
  // parseFloat converte o valor para número de ponto flutuante
  const preco = parseFloat(campoPreco.value);
  if (!campoPreco.value) {
    definirEstadoCampo(campoPreco, erroPreco, 'Informe o preço do produto.');
    valido = false;
  } else if (isNaN(preco)) {
    definirEstadoCampo(campoPreco, erroPreco, 'O preço deve ser um número válido.');
    valido = false;
  } else if (preco <= 0) {
    // Não permite valores negativos ou zero
    definirEstadoCampo(campoPreco, erroPreco, 'O preço deve ser maior que R$ 0,00.');
    valido = false;
  } else {
    definirEstadoCampo(campoPreco, erroPreco, '');
  }

  // --- Validação: Quantidade ---
  // parseInt converte para número inteiro
  const quantidade = parseInt(campoQuantidade.value, 10);
  if (!campoQuantidade.value) {
    definirEstadoCampo(campoQuantidade, erroQuantidade, 'Informe a quantidade em estoque.');
    valido = false;
  } else if (isNaN(quantidade)) {
    definirEstadoCampo(campoQuantidade, erroQuantidade, 'A quantidade deve ser um número inteiro.');
    valido = false;
  } else if (quantidade <= 0) {
    // Não permite valores negativos ou zero
    definirEstadoCampo(campoQuantidade, erroQuantidade, 'A quantidade deve ser pelo menos 1.');
    valido = false;
  } else {
    definirEstadoCampo(campoQuantidade, erroQuantidade, '');
  }

  return valido;
}


// ============================================================
// 3. OPERAÇÕES COM LOCALSTORAGE
// ============================================================

/**
 * Lê e retorna o array de produtos salvo no localStorage.
 * Em caso de dados corrompidos, retorna array vazio.
 *
 * @returns {Array} Lista de objetos produto.
 */
function carregarProdutos() {
  try {
    const dados = localStorage.getItem(STORAGE_KEY);
    return JSON.parse(dados) || [];
  } catch (erro) {
    console.error('[ProductHub] Erro ao ler localStorage:', erro);
    return [];
  }
}

/**
 * Salva o array de produtos no localStorage.
 *
 * @param {Array} produtos - Lista de objetos produto a salvar.
 */
function salvarProdutos(produtos) {
  localStorage.setItem(STORAGE_KEY, JSON.stringify(produtos));
}


// ============================================================
// 4. FEEDBACK VISUAL E REDIRECT
// ============================================================

/**
 * Exibe o alerta de sucesso com uma mensagem personalizada
 * e inicia a contagem regressiva para o redirecionamento.
 *
 * @param {string} nomeProduto - Nome do produto cadastrado (para personalizar a mensagem).
 */
function exibirSucesso(nomeProduto) {
  // Monta a mensagem de sucesso com o nome do produto
  alertaMensagem.textContent =
    `"${nomeProduto}" cadastrado com sucesso! Redirecionando em ${REDIRECT_DELAY / 1000}s…`;

  // Exibe o alerta (remove a classe d-none do Bootstrap)
  alertaSucesso.classList.remove('d-none');

  // Faz a página rolar suavemente até o topo para o alerta ficar visível
  window.scrollTo({ top: 0, behavior: 'smooth' });

  // Desabilita o botão para evitar duplo cadastro durante o delay
  btnCadastrar.disabled = true;
  btnCadastrar.innerHTML = '<i class="fa-solid fa-spinner fa-spin me-2"></i>Redirecionando…';

  // Redireciona após o tempo definido
  setTimeout(() => {
    window.location.href = 'produtos.html';
  }, REDIRECT_DELAY);
}


// ============================================================
// 5. LIMPAR FORMULÁRIO
// ============================================================

/**
 * Reseta o formulário e remove todos os estados visuais
 * de validação (classes is-valid e is-invalid).
 */
function limparFormulario() {
  form.reset();

  // Remove classes de validação visual de todos os inputs
  const campos = form.querySelectorAll('.form-input');
  campos.forEach((campo) => {
    campo.classList.remove('is-valid', 'is-invalid');
  });

  // Limpa as mensagens de erro
  [erroNome, erroMarca, erroPreco, erroQuantidade].forEach((div) => {
    div.textContent = '';
  });
}


// ============================================================
// 6. VALIDAÇÃO EM TEMPO REAL (feedback imediato ao digitar)
// ============================================================

/**
 * Adiciona validação em tempo real a um campo:
 * ao perder o foco (blur), valida e exibe feedback.
 * Melhora a experiência do usuário sem esperar o submit.
 */
function configurarValidacaoTempoReal() {
  // Ao sair do campo nome, valida imediatamente
  campoNome.addEventListener('blur', () => {
    const nome = campoNome.value.trim();
    if (!nome) {
      definirEstadoCampo(campoNome, erroNome, 'Informe o nome do produto.');
    } else if (nome.length < 2) {
      definirEstadoCampo(campoNome, erroNome, 'O nome deve ter pelo menos 2 caracteres.');
    } else {
      definirEstadoCampo(campoNome, erroNome, '');
    }
  });

  // Ao sair do campo marca
  campoMarca.addEventListener('blur', () => {
    const marca = campoMarca.value.trim();
    if (!marca) {
      definirEstadoCampo(campoMarca, erroMarca, 'Informe a marca do produto.');
    } else {
      definirEstadoCampo(campoMarca, erroMarca, '');
    }
  });

  // Ao sair do campo preço
  campoPreco.addEventListener('blur', () => {
    const preco = parseFloat(campoPreco.value);
    if (!campoPreco.value) {
      definirEstadoCampo(campoPreco, erroPreco, 'Informe o preço do produto.');
    } else if (isNaN(preco) || preco <= 0) {
      definirEstadoCampo(campoPreco, erroPreco, 'O preço deve ser maior que R$ 0,00.');
    } else {
      definirEstadoCampo(campoPreco, erroPreco, '');
    }
  });

  // Ao sair do campo quantidade
  campoQuantidade.addEventListener('blur', () => {
    const quantidade = parseInt(campoQuantidade.value, 10);
    if (!campoQuantidade.value) {
      definirEstadoCampo(campoQuantidade, erroQuantidade, 'Informe a quantidade em estoque.');
    } else if (isNaN(quantidade) || quantidade <= 0) {
      definirEstadoCampo(campoQuantidade, erroQuantidade, 'A quantidade deve ser pelo menos 1.');
    } else {
      definirEstadoCampo(campoQuantidade, erroQuantidade, '');
    }
  });
}


// ============================================================
// 7. HANDLER DO SUBMIT
// ============================================================

/**
 * Processa o envio do formulário:
 * valida, cria o objeto, salva e dá feedback.
 *
 * @param {Event} evento - Evento de submit do formulário.
 */
function handleSubmit(evento) {
  // Impede o comportamento padrão (recarregar a página)
  evento.preventDefault();

  // Executa a validação completa; interrompe se inválido
  if (!validarFormulario()) {
    console.warn('[ProductHub] Formulário inválido — verifique os campos.');
    return;
  }

  // Monta o objeto produto com os valores dos campos
  // parseFloat converte preço para número decimal (ex: "49.90" → 49.90)
  // parseInt  converte quantidade para inteiro     (ex: "10"   → 10)
  const produto = {
    nome:       campoNome.value.trim(),
    marca:      campoMarca.value.trim(),
    tamanho:    campoTamanho.value,
    preco:      parseFloat(campoPreco.value),
    quantidade: parseInt(campoQuantidade.value, 10),
  };

  // Carrega o array existente do localStorage
  const produtos = carregarProdutos();

  // Adiciona o novo produto ao final do array
  produtos.push(produto);

  // Salva o array atualizado de volta no localStorage
  salvarProdutos(produtos);

  console.log('[ProductHub] Produto cadastrado:', produto);
  console.log('[ProductHub] Total de produtos no localStorage:', produtos.length);

  // Limpa o formulário
  limparFormulario();

  // Exibe feedback visual e inicia redirecionamento
  exibirSucesso(produto.nome);
}


// ============================================================
// 8. INICIALIZAÇÃO
// ============================================================

/**
 * Ponto de entrada: executado quando o DOM está pronto.
 */
document.addEventListener('DOMContentLoaded', () => {
  console.log('%c[ProductHub] Página de cadastro carregada.', 'color: #3ecf8e; font-weight: bold;');

  // Registra o listener de submit no formulário
  form.addEventListener('submit', handleSubmit);

  // Ativa a validação em tempo real (ao sair de cada campo)
  configurarValidacaoTempoReal();
});