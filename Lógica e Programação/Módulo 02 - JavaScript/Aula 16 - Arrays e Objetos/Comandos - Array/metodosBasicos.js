let times = ["Santos", "São Paulo", "Palmeiras"]

//Acessar um item da lista
console.log(times[0]);

//Verificando o tamanho da lista
console.log(times.length); //3

//Adicionando itens no Array
times.push("Ponte Preta") //["Santos", "São Paulo", "Palmeiras","Ponte Preta"]

//Adicionando itens no inicio do array
times.unshift("Guarani")
console.log(times);

//splice - Removendo
times.splice(1,1)
console.log(times);

//splice - Trocando
times.splice(1,1,"Corinthians")
console.log(times);

//splice - Adicionando
times = ["Santos", "São Paulo", "Palmeiras"]
times.splice(1,0,"Corinthians")
console.log(times);