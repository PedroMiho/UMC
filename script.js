(async () => {
  // Usa o documento do elemento selecionado no Inspecionar.
  const selecionado = typeof $0 !== "undefined" ? $0 : null;
  let pagina = selecionado?.ownerDocument || document;

  // Procura também nos frames acessíveis, se necessário.
  if (!pagina.querySelector('input[name^="rgm."]')) {
    const documentos = [];
    const visitados = new Set();

    function procurar(doc) {
      if (!doc || visitados.has(doc)) return;
      visitados.add(doc);

      if (doc.querySelector('input[name^="rgm."]') &&
          doc.querySelector('input[name^="M1_nova."]')) {
        documentos.push(doc);
      }

      doc.querySelectorAll("iframe, frame").forEach(frame => {
        try {
          procurar(frame.contentDocument);
        } catch {}
      });
    }

    procurar(document);

    if (documentos.length !== 1) {
      alert(
        "Não foi possível identificar uma única página de notas. " +
        "Inspecione uma caixa de nota e execute novamente este código."
      );
      return;
    }

    pagina = documentos[0];
  }

  const alunos = [
    ...pagina.querySelectorAll('input[name^="rgm."]')
  ];

  if (!alunos.length) {
    alert("Não encontrei os campos de RGM na página selecionada.");
    return;
  }

  if (!window.XLSX) {
    try {
      await new Promise((resolve, reject) => {
        const script = document.createElement("script");
        script.src =
          "https://cdn.jsdelivr.net/npm/xlsx@0.18.5/dist/xlsx.full.min.js";
        script.onload = resolve;
        script.onerror = reject;
        document.head.appendChild(script);
      });
    } catch {
      alert("Não foi possível carregar a biblioteca de leitura do Excel.");
      return;
    }
  }

  document.getElementById("importador-notas-excel")?.remove();

  const painel = document.createElement("dialog");
  painel.id = "importador-notas-excel";
  painel.style.cssText = `
    width:min(800px,90vw);max-height:85vh;overflow:auto;
    padding:24px;border:1px solid #ccc;border-radius:12px;
    background:white;color:#222;font:14px Arial;
  `;

  painel.innerHTML = `
    <h2>Importar notas M1</h2>
    <p>${alunos.length} registros de alunos encontrados no portal.</p>
    <input data-id="arquivo" type="file" accept=".xlsx,.xls">
    <div data-id="opcoes" hidden>
      <p>Aba: <select data-id="aba"></select></p>
      <p>Coluna RGM: <select data-id="rgm"></select></p>
      <p>Coluna nota: <select data-id="nota"></select></p>
      <p>Separador decimal:
        <select data-id="decimal">
          <option value=".">Ponto — 6.5</option>
          <option value=",">Vírgula — 6,5</option>
        </select>
      </p>
      <button type="button" data-id="conferir">Conferir notas</button>
      <button type="button" data-id="preencher" disabled>
        Preencher na página
      </button>
    </div>
    <p data-id="mensagem"></p>
    <div data-id="previa"></div>
    <p><button type="button" data-id="fechar">Fechar</button></p>
  `;

  document.body.appendChild(painel);
  painel.showModal();

  const el = id => painel.querySelector(`[data-id="${id}"]`);
  const rgmTexto = valor =>
    String(valor ?? "").trim().replace(/\.0$/, "");

  let livro;
  let linhas = [];
  let plano = [];

  function limpar() {
    plano = [];
    el("preencher").disabled = true;
    el("mensagem").textContent = "";
    el("previa").replaceChildren();
  }

  function carregarAba() {
    limpar();

    linhas = XLSX.utils.sheet_to_json(
      livro.Sheets[el("aba").value],
      { header: 1, raw: true, defval: "" }
    );

    const titulos = linhas[0] || [];

    for (const id of ["rgm", "nota"]) {
      el(id).replaceChildren();

      titulos.forEach((titulo, indice) => {
        el(id).add(new Option(
          `${XLSX.utils.encode_col(indice)} — ${titulo || "Sem título"}`,
          String(indice)
        ));
      });
    }

    const normalizar = valor => String(valor).trim().toLowerCase();
    const indiceRgm = titulos.findIndex(
      titulo => normalizar(titulo) === "rgm"
    );

    let indiceNota = -1;

    for (const nome of ["nota final", "prova", "m1"]) {
      indiceNota = titulos.findIndex(
        titulo => normalizar(titulo) === nome
      );
      if (indiceNota >= 0) break;
    }

    if (indiceRgm >= 0) el("rgm").value = String(indiceRgm);
    if (indiceNota >= 0) el("nota").value = String(indiceNota);
  }

  el("arquivo").onchange = async () => {
    limpar();
    el("opcoes").hidden = true;

    const arquivo = el("arquivo").files[0];
    if (!arquivo) return;

    try {
      livro = XLSX.read(await arquivo.arrayBuffer(), { type: "array" });
      el("aba").replaceChildren();

      livro.SheetNames.forEach(nome =>
        el("aba").add(new Option(nome, nome))
      );

      carregarAba();
      el("opcoes").hidden = false;
    } catch (erro) {
      el("mensagem").textContent = "Erro ao ler o Excel: " + erro.message;
    }
  };

  el("aba").onchange = carregarAba;

  for (const id of ["rgm", "nota", "decimal"]) {
    el(id).onchange = limpar;
  }

  el("conferir").onclick = () => {
    limpar();

    if (!linhas.length || el("rgm").value === "" ||
        el("nota").value === "") {
      el("mensagem").textContent = "A aba está vazia.";
      return;
    }

    if (el("rgm").value === el("nota").value) {
      el("mensagem").textContent =
        "Escolha colunas diferentes para RGM e nota.";
      return;
    }

    const notas = new Map();
    const duplicados = new Set();
    const contagem = new Map();

    linhas.slice(1).forEach(linha => {
      const rgm = rgmTexto(linha[Number(el("rgm").value)]);
      if (!rgm) return;

      if (notas.has(rgm)) duplicados.add(rgm);
      notas.set(rgm, linha[Number(el("nota").value)]);
    });

    alunos.forEach(input => {
      const rgm = rgmTexto(input.value);
      contagem.set(rgm, (contagem.get(rgm) || 0) + 1);
    });

    const resultado = alunos.map(input => {
      const rgm = rgmTexto(input.value);
      const linha = input.closest("tr");
      const indice = input.name.substring("rgm.".length);

      // Busca a nota na mesma linha do aluno e pelo nome exato.
      const campo = [...(linha?.querySelectorAll("input") || [])]
        .find(item => item.name === `M1_nova.${indice}`);

      const nome = linha?.cells[1]?.textContent.trim() || "";
      const valor = notas.get(rgm);
      let nota = "";
      let status = "";

      if (duplicados.has(rgm) || contagem.get(rgm) > 1) {
        status = "RGM duplicado — revise";
      } else if (!notas.has(rgm)) {
        status = "RGM ausente no Excel";
      } else if (!campo || campo.disabled || campo.readOnly) {
        status = "Campo M1 indisponível";
      } else if (valor == null || String(valor).trim() === "") {
        status = "Nota vazia — não preencher";
      } else {
        const texto = String(valor).trim().replace(",", ".");
        const numero = Number(texto);

        if (!/^\d+(\.\d+)?$/.test(texto) ||
            !Number.isFinite(numero) || numero < 0 || numero > 10) {
          status = "Nota inválida";
        } else {
          nota = String(Number(numero.toFixed(10)))
            .replace(".", el("decimal").value);

          if (campo.maxLength >= 0 && nota.length > campo.maxLength) {
            status = "Nota longa demais — revise o arredondamento";
          } else {
            status = campo.value.trim()
              ? `Substituir ${campo.value.trim()} por ${nota}`
              : "Pronto";

            plano.push({ campo, nota });
          }
        }
      }

      return { RGM: rgm, Nome: nome, Nota: nota, Status: status };
    });

    const tabela = document.createElement("table");
    tabela.style.cssText = "width:100%;border-collapse:collapse";

    const cabecalho = tabela.createTHead().insertRow();
    ["RGM", "Nome", "Nota", "Status"].forEach(titulo => {
      const celula = document.createElement("th");
      celula.textContent = titulo;
      celula.style.cssText = "text-align:left;padding:8px";
      cabecalho.appendChild(celula);
    });

    const corpo = tabela.createTBody();

    resultado.forEach(registro => {
      const linha = corpo.insertRow();
      Object.values(registro).forEach(valor => {
        const celula = linha.insertCell();
        celula.textContent = valor;
        celula.style.cssText = "padding:8px;border-bottom:1px solid #ddd";
      });
    });

    el("previa").appendChild(tabela);
    el("mensagem").textContent =
      `${plano.length} nota(s) pronta(s). Confira antes de preencher.`;
    el("preencher").disabled = plano.length === 0;
    console.table(resultado);
  };

  el("preencher").onclick = () => {
    let preenchidas = 0;

    plano.forEach(({ campo, nota }) => {
      if (!campo.isConnected || campo.disabled || campo.readOnly) return;

      const Janela = campo.ownerDocument.defaultView;
      campo.value = nota;
      campo.dispatchEvent(new Janela.Event("input", { bubbles: true }));
      campo.dispatchEvent(new Janela.Event("change", { bubbles: true }));
      preenchidas++;
    });

    el("mensagem").textContent =
      `${preenchidas} nota(s) preenchida(s). ` +
      "Feche esta janela, confira e clique em Enviar no portal.";
    el("preencher").disabled = true;
  };

  el("fechar").onclick = () => painel.close();
  painel.onclose = () => painel.remove();
})();