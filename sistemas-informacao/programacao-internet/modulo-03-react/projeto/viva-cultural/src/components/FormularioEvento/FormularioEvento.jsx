import "./FormularioEvento.css"

export default function FormularioEvento() {
  function criarEvento(evento) {
    evento.preventDefault()
    alert("Formulário preenchido!")
  }

  return (
    <section className="cadastro-evento">
      <h2>Sua ideia também faz parte da agenda.</h2>

      <p className="cadastro-descricao">
        Compartilhe um encontro cultural com a comunidade.
      </p>

      <form className="evento-formulario" onSubmit={criarEvento}>
        <h3>Preencha para criar um evento</h3>

        <div className="evento-campos">
          <div className="evento-campo">
            <label htmlFor="nome">Nome do evento</label>
            <input
              id="nome"
              name="nome"
              type="text"
              placeholder="Ex.: Sarau na praça"
              required
            />
          </div>

          <div className="evento-campo">
            <label htmlFor="data">Data do evento</label>
            <input id="data" name="data" type="date" required />
          </div>

          <div className="evento-campo">
            <label htmlFor="categoria">Categoria</label>
            <select
              id="categoria"
              name="categoria"
              defaultValue=""
              required
            >
              <option value="" disabled>
                Selecione uma opção
              </option>
              <option value="musica">Música</option>
              <option value="arte-cinema">Arte e cinema</option>
              <option value="oficinas">Oficinas</option>
            </select>
          </div>
        </div>

        <button className="evento-botao" type="submit">
          Criar evento
        </button>

        <p className="evento-aviso">
          Nome, data e categoria são obrigatórios.
        </p>
      </form>
    </section>
  )
}