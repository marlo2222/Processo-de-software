package br.com.rango.views;

import java.util.Scanner;

public class PreTelaRestaurante {
	Scanner input = new Scanner(System.in);
	
	public char menuLogin() {
		
		System.out.println("1- logar");
		System.out.println("2- cadastrar");
		System.out.println("3- sair");
		return input.nextLine().charAt(0);
	}
}
