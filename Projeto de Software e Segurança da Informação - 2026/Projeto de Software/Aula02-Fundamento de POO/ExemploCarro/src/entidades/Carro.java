package entidades;

public class Carro {
	String fabricante;
    String modelo;
    String cor;
    int ano;

    public void exibirInfo() {
        System.out.println(
        		"Fabricante: " + fabricante +
        		", Modelo: " + modelo + 
        		", Cor:" + cor +
        		", Ano: " + ano
        );
    }
}
