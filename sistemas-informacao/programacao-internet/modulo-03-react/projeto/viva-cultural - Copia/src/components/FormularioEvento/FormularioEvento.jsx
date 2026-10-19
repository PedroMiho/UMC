import "./FormularioEvento.css"
import TituloFormulario from "../TituloFormulario/TituloFormulario"


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
      {/* O htmlFor é uma propriedade do JSX que associa uma tag <label> a um campo de formulário, como <input> ou <select>. */}
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

function SelectFormulario(props) {
  return (
    <div className={props.campoClasse}>
      <label htmlFor={props.id}>{props.label}</label>

      <select id={props.id} name={props.id} defaultValue="" required>
        <option value="" disabled>Selecione uma opção</option>
        {props.children}
      </select>
    </div>
  )
}

function BotaoFormulario(props) {
  return (
    <button className={props.botaoClasse} type={props.tipo}>
      {props.children}
    </button>
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

          <SelectFormulario
            id="categoria"
            label="Categoria"
            campoClasse="evento-campo"
          >
            <option value="musica">Música</option>
            <option value="arte-cinema">Arte e cinema</option>
            <option value="oficinas">Oficinas</option>
          </SelectFormulario>
          
        </div>

        <BotaoFormulario botaoClasse="evento-botao" tipo="submit">
          Criar evento
        </BotaoFormulario>  


        <TextoFormulario className="evento-aviso">
          Nome, data e categoria são obrigatórios.
        </TextoFormulario>

      </form>

    </section>
  )
}