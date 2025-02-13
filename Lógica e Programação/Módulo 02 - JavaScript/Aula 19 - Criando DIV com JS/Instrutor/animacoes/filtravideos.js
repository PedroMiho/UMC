import { conectaApi } from "./conectaApi.js"
import constroCard from "./mostrarVideos.js"

const botao = document.querySelector("[data-button]")

async function buscarVideos(evento){
    evento.preventDefault()

    const dadosDePesquisa = document.querySelector("[data-pesquisa]").value
    const busca = await conectaApi.buscaVideo(dadosDePesquisa);

    const lista = document.querySelector('[data-lista]')

    while(lista.firstChild){
        lista.removeChild(lista.firstChild)
    }

    busca.forEach( elemento => lista.appendChild(
        constroCard(elemento.titulo, elemento.descricao, elemento.url, elemento.imgaem)
    ))

    if(busca.length == 0 ){
        lista.innerHTML= `<h2 class="mensagem__titulo">Não existe vídeos com esse termo</h2>`
    }


}

botao.addEventListener("click" , evento => buscarVideos(evento))

