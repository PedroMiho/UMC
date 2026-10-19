import "./TituloFormulario.css"

export default function TituloFormulario(props) {
  return (
    <h2 className="titulo-formulario">
      {props.children}
    </h2>
  )
}