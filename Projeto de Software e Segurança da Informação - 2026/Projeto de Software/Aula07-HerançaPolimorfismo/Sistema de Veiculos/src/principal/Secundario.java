package principal;

import java.util.ArrayList;
import java.util.Scanner;

import entidades.Caminhao;
import entidades.Carro;
import entidades.Moto;
import entidades.Veiculo;
import servicos.Alugavel;

public class Secundario {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Veiculo> listaVeiculos = new ArrayList<>();
		
		System.out.print("Quantos veículos deseja cadastrar? ");
		int quantidade = sc.nextInt();
		sc.nextLine(); // Limpar buffer
		
		for (int i = 0; i < quantidade; i++) {
			System.out.println("\nCadastro do veículo #" + (i + 1));
			System.out.print("Tipo de veículo (1-Carro | 2-Moto | 3-Caminhão): ");
			int tipo = sc.nextInt();
			sc.nextLine(); // Limpar buffer

			System.out.print("Marca: ");
			String marca = sc.nextLine();

			System.out.print("Modelo: ");
			String modelo = sc.nextLine();

			System.out.print("Ano: ");
			int ano = sc.nextInt();

			System.out.print("Valor diário do aluguel: ");
			double valorDiario = sc.nextDouble();
			sc.nextLine(); // Limpar buffer

			switch (tipo) {
				case 1:
					System.out.print("Possui ar-condicionado? (true/false): ");
					boolean arCondicionado = sc.nextBoolean();
					listaVeiculos.add(new Carro(marca, modelo, ano, valorDiario, arCondicionado));
					break;
				case 2:
					System.out.print("Cilindradas: ");
					int cilindrada = sc.nextInt();
					listaVeiculos.add(new Moto(marca, modelo, ano, valorDiario, cilindrada));
					break;
				case 3:
					System.out.print("Capacidade de carga (em kg): ");
					int capacidade = sc.nextInt();
					listaVeiculos.add(new Caminhao(marca, modelo, ano, valorDiario, capacidade));
					break;
				default:
					System.out.println("Tipo inválido. Veículo não cadastrado.");
					i--; // Não contar esse veículo
			}
		}
		
		System.out.print("Quantos dias você deseja alugar: ");
		int dias = sc.nextInt();
		
		System.out.println("\n--- Lista de Veículos Cadastrados ---");
		for (Veiculo v : listaVeiculos) {
			System.out.println(v.toString());
			if (v instanceof Alugavel) {
				Alugavel a = (Alugavel) v;
				System.out.println("Valor do aluguel por " + dias + " dias: R$ " + a.calcularAluguel(dias));
			}
			System.out.println("-------------------------------------");
		}

		sc.close();
	}
}
