async function buscaEndereço(cep){

    var mensagemErro = document.querySelector("#erro")
    mensagemErro.innerHTML = ''

    try {
        let consultaCEP = await fetch(`https://viacep.com.br/ws/${cep}/json/`)
        let consultaCEPJSON = await consultaCEP.json( )

        if(consultaCEPJSON.erro) {
            throw Error ('CEP inexistente')
        }

        validacoesDeCampos(consultaCEPJSON)

        return consultaCEPJSON


    }   
    catch (erro) {
        mensagemErro.innerHTML = `<p> CEP Inválido, Tente Novamente !! </p>`

        console.log(erro)
    }
}

const cep = document.querySelector("#cep")


cep.addEventListener("focusout", (evento) => {
    let cep = evento.target
    buscaEndereço(cep.value)
})

function validacoesDeCampos(cepDigitado) {
    const endereco = document.querySelector("#endereco")
    const numero = document.querySelector("#numero")
    const bairro = document.querySelector("#bairro")
    const cidade = document.querySelector("#cidade")
    const estado = document.querySelector("#estado")
    
    endereco.value = cepDigitado.logradouro
    bairro.value = cepDigitado.bairro
    cidade.value = cepDigitado.localidade
    estado.value = cepDigitado.uf
}


    

