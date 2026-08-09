package condicoes;

public class Swtich {

	public static void main(String[] args) {
		int dia = 2;

		switch (dia) {
		    case 1:
		        System.out.println("1 - Enfermeiro");
		        break;
		    case 2:
		        System.out.println("2 - Fisioterapeuta");
		        break;
		    default:
		        System.out.println("3 - Clinico Geral");
		        break;
		}

	}

}
