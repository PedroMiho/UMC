package variaveisCompostas;

public class Vetores {

	public static void main(String[] args) {
		
		double [] notasAlunos = new double [3];
		
		notasAlunos[0] = 7;
		notasAlunos[1] = 10;
		notasAlunos[2] = 5;
		
		System.out.println(notasAlunos[0]);
		System.out.println(notasAlunos[1]);
		System.out.println(notasAlunos[2]);
		
		for (double notas : notasAlunos ) {
			System.out.println(notas);
		}
		
		
	}

}
