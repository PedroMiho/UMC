//Eventos de click

const caixa = document.querySelector("#caixa")

// // Adicionando eventos de click
caixa.addEventListener("click" , () => {
    caixa.style.backgroundColor = "blue"
})


// // Adicionando eventos de double click
// caixa.addEventListener("dblclick" , () => {
//     caixa.style.backgroundColor = "aquamarine"
// })

//Comenta os dois acima de ir para esse

// Adicionando eventos de mouse pressionado
// caixa.addEventListener("mousedown" , () => {
//     caixa.style.backgroundColor = "red"
// })

// // Adicionando eventos de mouse solto
// caixa.addEventListener("mouseup" , () => {
//     caixa.style.backgroundColor = "pink"
// })

//Comenta os dois acima de ir para esse

// Adicionando eventos mouse entrando no elemento
caixa.addEventListener("mousemove" , () => {
    caixa.style.backgroundColor = "orange"
})

// Adicionando eventos mouse saindo do elemento
caixa.addEventListener("mouseleave" , () => {
    caixa.style.backgroundColor = "yellow"
})