import {conectaApi} from "./conectaApi.js"
import constroiCard from "./mostraVideo.js";

async function buscarVideos(evento){
    evento.preventDefault()
    const dadosDePesquisa = document.querySelector("[data-pesquisa]").value;
    const busca = await conectaApi.filtraVideos(dadosDePesquisa);
    
    const lista = document.querySelector("[data-lista]")
   
    while(lista.firstChild){
        lista.removeChild(lista.firstChild)
    }

    busca.forEach(elemento => lista.appendChild(
        constroiCard(elemento.titulo, elemento.descricao, elemento.url, elemento.imagem)
    ))

    if(busca.length == 0){
        lista.innerHTML = `<h2 class="mensagem__titulo">Não existem videos com este termo</h2>`
    }

}

const botao = document.querySelector("[data-button]")

botao.addEventListener('click', evento => buscarVideos(evento))