package principal;

import entidades.Caminhao;
import entidades.Carro;
import entidades.Moto;
import entidades.Veiculo;

public class Main {

	public static void main(String[] args) {
		
		Veiculo veiculo = new Veiculo("Toyota", "Corolla", 2022, 150);
		System.out.println(veiculo.toString() + '\n');
		
		Carro carro = new Carro("Fiat", "Uno", 2022, 150, false);
		System.out.println(carro.toString());
		System.out.println("O valor do Aluguel desse carro foi de; R$ " + carro.calcularAluguel(5) + '\n');
		
		Moto moto = new Moto("Suzuki", "Hayabusa", 2023, 150, 1340);
		System.out.println(moto.toString());
		System.out.println("O valor do Aluguel dessa moto foi de; R$ " + moto.calcularAluguel(5) + '\n');
		
		
		Caminhao caminhao = new Caminhao("Volvo", "FH 540", 2024, 1000, 1000);
		System.out.println(caminhao.toString());
		System.out.println("O valor do Aluguel dessa moto foi de; R$ " + caminhao.calcularAluguel(5) + '\n');

	}

}
