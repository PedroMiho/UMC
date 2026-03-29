/**
 * ProductHub — produtos.js
 * Lógica da página "Lista de Produtos"
 * -----------------------------------------------
 * Responsabilidades:
 *   1. Buscar produtos do localStorage
 *   2. Calcular valor de estoque por produto
 *   3. Renderizar as linhas na tabela dinamicamente
 *   4. Exibir estado vazio quando não há dados
 *   5. Atualizar o contador de registros
 */

// ============================================================
// 1. CONSTANTES E REFERÊNCIAS AO DOM
// ============================================================

/** Chave usada para armazenar/recuperar os produtos no localStorage */
const STORAGE_KEY = 'produtos';

/** Referência ao <tbody> onde as linhas serão inseridas */
const tbody = document.getElementById('tbody-produtos');

/** Referência ao elemento que exibe o estado vazio */
const emptyState = document.getElementById('empty-state');

/** Referência ao elemento que exibe o total de registros */
const totalCount = document.getElementById('total-count');


// ============================================================
// 2. FUNÇÕES UTILITÁRIAS
// ============================================================

/**
 * Formata um número para o padrão monetário brasileiro.
 * Exemplo: 1500.5 → "R$ 1.500,50"
 *
 * @param {number} valor - Valor numérico a formatar.
 * @returns {string} Valor formatado como moeda BRL.
 */
function formatarMoeda(valor) {
  return valor.toLocaleString('pt-BR', {
    style: 'currency',
    currency: 'BRL'
  });
}

/**
 * Lê o array de produtos salvo no localStorage.
 * Caso a chave não exista ou o JSON seja inválido,
 * retorna um array vazio para evitar erros.
 *
 * @returns {Array} Lista de objetos produto.
 */
function carregarProdutos() {
  try {
    const dados = localStorage.getItem(STORAGE_KEY);
    // JSON.parse retorna null se dados for null,
    // por isso usamos o operador || para garantir array vazio
    return JSON.parse(dados) || [];
  } catch (erro) {
    // JSON malformado: registra no console e retorna vazio
    console.error('[ProductHub] Erro ao ler localStorage:', erro);
    return [];
  }
}


// ============================================================
// 3. RENDERIZAÇÃO DA TABELA
// ============================================================

/**
 * Cria e retorna um elemento <tr> para um produto.
 *
 * @param {Object} produto  - Objeto com os dados do produto.
 * @param {number} indice   - Posição no array (usado como ID visual).
 * @returns {HTMLTableRowElement} Linha da tabela preenchida.
 */
function criarLinhaProduto(produto, indice) {
  // Calcula o valor total do estoque para este produto
  const valorEstoque = produto.preco * produto.quantidade;

  // Cria o elemento <tr>
  const tr = document.createElement('tr');

  // Define o conteúdo HTML da linha
  // Os valores são inseridos via textContent para evitar XSS,
  // exceto onde precisamos de HTML (classe valorEstoque)
  tr.innerHTML = `
    <td>${indice + 1}</td>
    <td>${escapeHTML(produto.nome)}</td>
    <td>${escapeHTML(produto.marca)}</td>
    <td>${escapeHTML(produto.tamanho)}</td>
    <td>${formatarMoeda(Number(produto.preco))}</td>
    <td>${Number(produto.quantidade)}</td>
    <td class="valor-estoque">${formatarMoeda(valorEstoque)}</td>
  `;

  return tr;
}

/**
 * Escapa caracteres HTML especiais para evitar injeção de código.
 * Substitui <, >, &, " e ' pelos seus equivalentes HTML entities.
 *
 * @param {string} texto - Texto a ser sanitizado.
 * @returns {string} Texto seguro para inserção via innerHTML.
 */
function escapeHTML(texto) {
  const mapa = { '&': '&amp;', '<': '&lt;', '>': '&gt;', '"': '&quot;', "'": '&#039;' };
  return String(texto).replace(/[&<>"']/g, (char) => mapa[char]);
}

/**
 * Renderiza todos os produtos na tabela.
 * - Se a lista estiver vazia, exibe o estado vazio e oculta a tabela.
 * - Se houver produtos, oculta o estado vazio e preenche o tbody.
 *
 * @param {Array} produtos - Lista de objetos produto.
 */
function renderizarTabela(produtos) {
  // Limpa qualquer conteúdo anterior do tbody
  tbody.innerHTML = '';

  // Atualiza o contador de registros no badge
  totalCount.textContent = produtos.length;

  // Verifica se há produtos para exibir
  if (produtos.length === 0) {
    // Exibe o estado vazio e oculta a tabela
    emptyState.classList.remove('d-none');
    tbody.closest('.table-wrapper').classList.add('d-none');
    return;
  }

  // Há produtos: garante que a tabela e o estado correto sejam exibidos
  emptyState.classList.add('d-none');
  tbody.closest('.table-wrapper').classList.remove('d-none');

  // Percorre o array e insere uma linha por produto
  produtos.forEach((produto, indice) => {
    const linha = criarLinhaProduto(produto, indice);
    tbody.appendChild(linha);
  });

  console.log(`[ProductHub] ${produtos.length} produto(s) carregado(s) na tabela.`);
}


// ============================================================
// 4. DADOS DE DEMONSTRAÇÃO (opcional)
// ============================================================

/**
 * Insere dados fictícios no localStorage caso esteja vazio.
 * Útil para demonstração e testes sem precisar cadastrar produtos.
 * Remova ou comente este bloco em produção.
 */
function inserirDadosDemostracao() {
  const jaExiste = localStorage.getItem(STORAGE_KEY);
  if (jaExiste) return;  // Não sobrescreve dados reais

  const demo = [
    { nome: 'Notebook Gamer',    marca: 'Dell',    tamanho: '15"',  preco: 5499.90, quantidade: 8  },
    { nome: 'Mouse Sem Fio',     marca: 'Logitech', tamanho: 'M',   preco: 189.90,  quantidade: 25 },
    { nome: 'Teclado Mecânico',  marca: 'Redragon', tamanho: 'TKL', preco: 349.00,  quantidade: 15 },
    { nome: 'Monitor 24"',       marca: 'LG',       tamanho: '24"', preco: 1199.00, quantidade: 6  },
    { nome: 'Headset USB',       marca: 'HyperX',   tamanho: 'G',   preco: 299.90,  quantidade: 20 },
  ];

  localStorage.setItem(STORAGE_KEY, JSON.stringify(demo));
  console.info('[ProductHub] Dados de demonstração inseridos no localStorage.');
}


// ============================================================
// 5. INICIALIZAÇÃO
// ============================================================

/**
 * Ponto de entrada: executado quando o DOM está pronto.
 * O script é carregado no final do <body>, então o DOM
 * já está disponível — não precisamos de DOMContentLoaded,
 * mas mantemos para maior segurança e clareza.
 */
document.addEventListener('DOMContentLoaded', () => {

  // (Opcional) Insere dados demo se o localStorage estiver vazio
  inserirDadosDemostracao();

  // Carrega os produtos do localStorage
  const produtos = carregarProdutos();

  // Renderiza os dados na tabela
  renderizarTabela(produtos);
});