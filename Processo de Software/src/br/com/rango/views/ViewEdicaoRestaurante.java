package br.com.rango.views;

import java.util.Scanner;

public class ViewEdicaoRestaurante {
	Scanner input = new Scanner(System.in);
	public char menuEditarRest() {
		System.out.println("1- atualizar informações restaurante");
		System.out.println("2- remover restaurante");
		System.out.println("3 - sair");
		return input.nextLine().charAt(0);
	}
}
