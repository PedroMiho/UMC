package entidades;

public class ContaMes {

	public double alimentacao;
	public double agua;
	public double energia;
		

	public double somaConta() {
		double contaMes = alimentacao + agua + energia;
		return contaMes;
	}



}

