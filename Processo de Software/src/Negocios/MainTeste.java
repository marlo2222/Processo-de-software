package Negocios;

import java.util.Scanner;

public class MainTeste {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		Controler controler = new Controler();
		int op;
		do {
			System.out.println("1-cadastra restaurante");
			System.out.println("2-sair");
			op = ler.nextInt();
			switch (op) {
			case 1:
				controler.cadastraProprieatrio();
				break;

			default:
				break;
			}
			
		}while(op!=2);
	}

}