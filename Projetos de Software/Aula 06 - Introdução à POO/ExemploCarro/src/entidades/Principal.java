package entidades;

public class Principal {

	public static void main(String[] args) {
		
		Carro corolla = new Carro();
		
		corolla.fabricante = "Toyota";
		corolla.modelo = "Corolla";
		corolla.cor = "Azul";
		corolla.ano = 2011;
		
		corolla.exibirInfo();
		
		


	}

}
