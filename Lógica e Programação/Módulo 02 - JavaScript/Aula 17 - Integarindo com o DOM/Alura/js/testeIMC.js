var pacientes = document.querySelectorAll(".paciente")

for(i=0; i <= pacientes.length; i++){

    var tdPeso = pacientes[i].querySelector(".info-peso")
    var tdAltura = pacientes[i].querySelector ('.info-altura')
    var tdIMC = pacientes[i].querySelector(".info-imc")

    var peso = tdPeso.textContent   
    var altura = tdAltura.textContent

    tdIMC.textContent = calculaIMC(peso, altura)

    var imc = tdIMC.textContent
}

function calculaIMC (peso, altura, paciente) {
    var verPeso = true
    var verAltura = true
    
    if (peso > 100 || peso <= 0)  {
        verPeso = false
        return "Peso Invalido"
    }

    if (altura <= 0 || altura >= 3){
        verAltura = false
        return "Altura invalida"

    }

    if (verAltura && verPeso){
        let imcFinal = peso / (altura**2)
        return imcFinal.toFixed(2)
    }
}