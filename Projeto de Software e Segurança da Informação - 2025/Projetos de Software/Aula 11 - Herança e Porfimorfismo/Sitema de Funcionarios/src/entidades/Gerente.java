package entidades;

public class Gerente extends Funcionarios{

	private double adicionalGerencia;
	
	public Gerente(String nome, double salario, double adicionalGerencia) {
		super(nome, salario);
		this.adicionalGerencia = adicionalGerencia;
	}
	
}
