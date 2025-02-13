import {conectaApi} from "./conectaApi.js"

const form = document.querySelector("[data-form]")

async function inserirVideos(evento){
    
    evento.preventDefault()
    
    const img = document.querySelector("[data-imagem]").value;
    const url = document.querySelector("[data-url]").value;
    const titulo = document.querySelector("[data-titulo]").value;
    const descricao = Math.floor(Math.random() * 10).toString();

    try{
        await conectaApi.criaVideos(titulo, descricao, url, img)
        window.location.href = "../pages/envio-concluido.html"
    }
    catch(e){
        alert(e)
    }


    
}

form.addEventListener("submit", evento => inserirVideos(evento))