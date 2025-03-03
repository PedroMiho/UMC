var texto = document.querySelector(".titulo")
texto.textContent = "LISTA DE PACIENTES"

var pacientes = document.querySelectorAll(".paciente")

for(i = 0; i <= pacientes.length; i++){
    
    var tdPeso = pacientes[i].querySelector(".info-peso")   
    var peso = tdPeso.textContent

    var tdAltura = pacientes[i].querySelector(".info-altura")
    var altura = tdAltura.textContent

    var tdImc = pacientes[i].querySelector(".info-imc")

    tdImc.textContent = calculoIMC(peso, altura, pacientes)

    function calculoIMC (peso,altura,pacientes){
 
        if(peso < 0 || peso > 200 ){
            return pacientes.classList.add("pacienteInvalido") , "Peso Invalido" 
        }
        else if (altura < 0 || altura > 2.50){
            return pacientes.classList.add("pacienteInvalido") , "Peso Invalido" 
        }
        else{
            var imc = peso/(altura**2)
            return imc.toFixed(2)   
        }
    }

}

