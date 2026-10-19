import './App.css'
import FormularioEvento from "./components/FormularioEvento/FormularioEvento.jsx"

function App() {

  return (
    <main>
      <header className="header">
        <div className="header-conteudo">
          <span className="header-logo">VIVA CULTURA</span>
        </div>
      </header>

      <section className="banner">
        <img
          className="banner-imagem"
          src="banner.png"
          alt="Cultura que conecta. A cidade tem muito para viver."
        />
      </section>

      <FormularioEvento/>

    </main>

  )
}

export default App
