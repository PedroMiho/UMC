/**
 * ProductHub — script.js
 * Comportamento e interações da página principal
 * -----------------------------------------------
 * Organização:
 *   1. Utilitários
 *   2. Animação de entrada (cards)
 *   3. Efeito de clique nos cards
 *   4. Log de navegação no console
 *   5. Inicialização
 */

// ============================================================
// 1. UTILITÁRIOS
// ============================================================

/**
 * Seleciona um elemento do DOM de forma segura.
 * @param {string} selector - Seletor CSS.
 * @returns {Element|null}
 */
function qs(selector) {
  return document.querySelector(selector);
}

/**
 * Seleciona múltiplos elementos do DOM.
 * @param {string} selector - Seletor CSS.
 * @returns {NodeList}
 */
function qsAll(selector) {
  return document.querySelectorAll(selector);
}


// ============================================================
// 2. ANIMAÇÃO DE ENTRADA DOS CARDS
// ============================================================

/**
 * Aplica animação de entrada escalonada (stagger)
 * nos cards ao carregar a página.
 * Cada card aparece com um leve atraso em relação ao anterior.
 */
function animateCardsOnLoad() {
  const cards = qsAll('.ph-card');

  // Define o estado inicial: invisível e deslocado para baixo
  cards.forEach((card) => {
    card.style.opacity    = '0';
    card.style.transform  = 'translateY(28px)';
    card.style.transition = 'opacity 0.55s ease, transform 0.55s ease';
  });

  // Após um pequeno delay, revela cada card com atraso escalonado
  cards.forEach((card, index) => {
    setTimeout(() => {
      card.style.opacity   = '1';
      card.style.transform = 'translateY(0)';
    }, 150 + index * 180); // 150ms base + 180ms por card
  });
}


// ============================================================
// 3. EFEITO DE CLIQUE NOS CARDS
// ============================================================

/**
 * Adiciona uma classe 'clicked' ao card no momento do clique,
 * gerando um breve efeito de "pressão" visual.
 * A classe é removida logo em seguida para permitir repetição.
 */
function setupCardClickEffect() {
  const cards = qsAll('.ph-card');

  cards.forEach((card) => {
    card.addEventListener('mousedown', () => {
      card.classList.add('clicked');
    });

    // Remove a classe após a animação (100ms)
    card.addEventListener('mouseup', () => {
      setTimeout(() => card.classList.remove('clicked'), 150);
    });

    // Garante remoção mesmo se o mouse sair do card durante o clique
    card.addEventListener('mouseleave', () => {
      card.classList.remove('clicked');
    });
  });
}


// ============================================================
// 4. LOG DE NAVEGAÇÃO NO CONSOLE
// ============================================================

/**
 * Registra no console qual card foi clicado,
 * útil para debug e rastreamento de navegação.
 */
function setupCardNavigationLog() {
  const cards = qsAll('.ph-card');

  cards.forEach((card) => {
    card.addEventListener('click', (event) => {
      const label    = card.dataset.label || card.id;
      const destino  = card.getAttribute('href');

      console.group('%c[ProductHub] Navegação', 'color: #5e9bfc; font-weight: bold;');
      console.log('Módulo  :', label);
      console.log('Destino :', destino);
      console.log('Evento  :', event.type);
      console.log('Hora    :', new Date().toLocaleTimeString('pt-BR'));
      console.groupEnd();
    });
  });
}


// ============================================================
// 5. INICIALIZAÇÃO
// ============================================================

/**
 * Ponto de entrada principal.
 * Aguarda o DOM estar completamente carregado antes de executar.
 */
document.addEventListener('DOMContentLoaded', () => {
  console.log('%c ProductHub carregado com sucesso! ', 'background:#343a40;color:#5e9bfc;font-weight:bold;padding:4px 8px;border-radius:4px;');

  // Inicia as animações e interações
  animateCardsOnLoad();
  setupCardClickEffect();
  setupCardNavigationLog();
});