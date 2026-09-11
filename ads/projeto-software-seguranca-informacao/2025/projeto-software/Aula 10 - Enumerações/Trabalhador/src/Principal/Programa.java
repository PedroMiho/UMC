package Principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entidade.Departamento;
import entidade.Funcionario;
import entidade.HoraContrato;
import entidades.enums.NivelFuncionario;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		System.out.println("Informe o seu departamento: ");
		String nomeDepartamento = sc.nextLine();
		
		System.out.println("Informe os dados do serviço: ");
		
		System.out.println("Nome: ");
		String nome = sc.nextLine();
		
		System.out.println("Nivel: ");
		String nivelFuncionario = sc.nextLine();
		
		System.out.println("Salario Base: ");
		double salarioBase = sc.nextDouble();
		
		Funcionario Pedro = new Funcionario(nome, 
					NivelFuncionario.valueOf(nivelFuncionario), 
					salarioBase, 
					new Departamento(nomeDepartamento)
				);
		
		System.out.println("Informe o numero de contratos do funcionario: ");

		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Informe o contrato" + i + " :");
			
			System.out.print("Informe a data: ");
			Date dataContrato = sdf.parse(sc.next());
			
			System.out.print("Valor por hora: ");
			double valorPorHora = sc.nextDouble();
			
			System.out.print("Duracao Contrato: ");
			int horas = sc.nextInt();
			
			HoraContrato contrato = new HoraContrato(dataContrato, valorPorHora, horas);
			Pedro.addContrato(contrato);
		}	
		
		System.out.println();
		System.out.print("Informe o mes e ano para calcular a renda (MM/ANO): ");
		String mesAno = sc.next();
		
		int mes = Integer.parseInt(mesAno.substring(0, 2));
		int ano = Integer.parseInt(mesAno.substring(3));
		
		System.out.println("Nome: " + Pedro.getName());
		System.out.println("Departamento: " + Pedro.getDepartamento().getNome());
		System.out.println("Salario em:" + mesAno + ":" + Pedro.renda(ano, mes));
		
		
		sc.close();
		
	}


}
