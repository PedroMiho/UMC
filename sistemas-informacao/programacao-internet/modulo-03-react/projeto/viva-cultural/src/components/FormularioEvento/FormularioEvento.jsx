import "./FormularioEvento.css"


// props é um OBJETO
// props .children
function TituloFormulario(props){
  return(
    <h2>{props.children}</h2>
  )
}

function TextoFormulario(props){
  return (
    <p className={props.className}>
      {props.children}
    </p>
  )
}

// Componente reutilizável que recebe props
function CampoFormulario({ id, label, tipo, placeholder }) {
  return (
    <div className="evento-campo">
      <label htmlFor={id}>{label}</label>

      <input
        id={id}
        name={id}
        type={tipo}
        placeholder={placeholder}
        required
      />
    </div>
  )
}


export default function FormularioEvento() {
  function criarEvento(evento) {
    evento.preventDefault()
    alert("Formulário preenchido!")
  }

  return (
    <section className="cadastro-evento">
      
      <TituloFormulario >
        Sua ideia também faz parte da agenda
      </TituloFormulario>

      <TextoFormulario className="cadastro-descricao">
        Compartilhe um encontro cultural com a comunidade
      </TextoFormulario>

      <form className="evento-formulario" onSubmit={criarEvento}>
        <h3>Preencha para criar um evento</h3>

        <div className="evento-campos">

          <CampoFormulario
            id="nome"
            label="Nome do evento"
            tipo="text"
            placeholder="Ex.: Sarau na praça"
          />

          <CampoFormulario
            id="data"
            label="Data do Evento"
            tipo="date"
          />


          <div className="evento-campo">
            <label htmlFor="categoria">Categoria</label>

            <select id="categoria" name="categoria" defaultValue="" required>
              <option value="" disabled>Selecione uma opção</option>
              <option value="musica">Música</option>
              <option value="arte-cinema">Arte e cinema</option>
              <option value="oficinas">Oficinas</option>
            </select>
          </div>

        </div>

        <button className="evento-botao" type="submit">
          Criar evento
        </button>


        <TextoFormulario className="evento-aviso">
          Nome, data e categoria são obrigatórios.
        </TextoFormulario>

      </form>

    </section>
  )
}