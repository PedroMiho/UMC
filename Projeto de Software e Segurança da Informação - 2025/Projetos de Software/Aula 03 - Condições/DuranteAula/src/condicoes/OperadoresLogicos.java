package condicoes;

public class OperadoresLogicos {

	public static void main(String[] args) {
		boolean condicaoA = 10 > 11;
		boolean condicaoB = 10 > 2;
		
		if (!condicaoA) {
			System.out.println("Verdadeiro");
		}
		else {
			System.out.println("Falso");
		}
		
		if (condicaoA && condicaoB) {
			System.out.println("Verdadeiro");
		}
		else {
			System.out.println("Falso");
		}
		
		if (condicaoA || condicaoB) {
			System.out.println("Verdadeiro");
		}
		else {
			System.out.println("Falso");
		}
		
	}

}
