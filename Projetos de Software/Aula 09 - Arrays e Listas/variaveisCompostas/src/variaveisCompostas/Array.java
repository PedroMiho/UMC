package variaveisCompostas;

import java.util.ArrayList;
import java.util.List;

public class Array {

	public static void main(String[] args) {
		List <Integer> lista = new ArrayList<>();
		
		lista.add(10);
		lista.add(30);
		
		lista.add(2, 10);
		
		for (Integer numero : lista) {
			System.out.println(numero);
		}
		
		System.out.println(lista.size());
		


	}

}
