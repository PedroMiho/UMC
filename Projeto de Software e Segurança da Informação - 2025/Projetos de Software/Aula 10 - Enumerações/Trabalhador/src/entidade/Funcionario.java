package entidade;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidades.enums.NivelFuncionario;

public class Funcionario {
	
	private String name;
	private NivelFuncionario level;
	private Double salarioBase;
	
	//Criando uma relação entre as classes departamento e HoraContrato
	private Departamento departamento;
	private List<HoraContrato> contratos = new ArrayList<>();
	
	//Construtores
	public Funcionario() {
		
	}

	//Não inclui as listas aqui
	public Funcionario(String name, NivelFuncionario level, Double salarioBase, Departamento departamento) {
		this.name = name;
		this.level = level;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public NivelFuncionario getLevel() {
		return level;
	}

	public void setLevel(NivelFuncionario level) {
		this.level = level;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<HoraContrato> getContratos() {
		return contratos;
	}
	
	public void addContrato (HoraContrato contrato) {
		contratos.add(contrato);
	}
	
	public void removeContrato (HoraContrato contrato) {
		contratos.remove(contrato);
	}
	
	public Double renda (int year, int month) {
		double soma = salarioBase;
		
		Calendar cal = Calendar.getInstance();
		
		for (HoraContrato c : contratos) {
			
			cal.setTime(c.getDate());
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = 1+cal.get(Calendar.MONTH);
			
			if (year == c_ano && month == c_mes ) {
				soma += c.valorTotal();
			}
		}
		return soma;
	}
}
