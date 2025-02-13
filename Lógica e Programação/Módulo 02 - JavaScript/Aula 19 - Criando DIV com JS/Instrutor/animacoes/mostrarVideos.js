import { conectaApi } from "./conectaApi.js"

const lista = document.querySelector("[data-lista]")

export default function constroCard(titulo, descricao, url, imagem){
    const video = document.createElement('li')
    video.classList.add('videos__item')

    video.innerHTML = `
        <iframe width="100%" height="72%" src="${url}"
        title="${titulo}" frameborder="0"
        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
        allowfullscreen></iframe>
        <div class="descricao-video">
        <img src="${imagem}" alt="logo canal alura">
        <h3>${titulo}</h3>
        <p>${descricao}</p>
    `
    return video
}

async function listaVideos(){
    
    try{
        const listaApi = await conectaApi.listaVideos()
        listaApi.forEach( elemento => lista.appendChild(constroCard(elemento.titulo, elemento.descricao, elemento.url, elemento.imagem)))
    } 
    catch {
        lista.innerHTML = `<h2 class="mensagem_titulo>Não foi possivel carregar a lista de videos</h2>`
    }
}

listaVideos()