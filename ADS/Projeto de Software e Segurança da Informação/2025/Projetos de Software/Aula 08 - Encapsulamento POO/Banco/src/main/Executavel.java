package main;

import entidades.ContaBancaria;

public class Executavel {

	public static void main(String[] args) {
		
		ContaBancaria pedro = new ContaBancaria("Pedro", 300);
		
		pedro.depositar(500);
		pedro.sacar(500);
		
		System.out.println(pedro);
	}

}
