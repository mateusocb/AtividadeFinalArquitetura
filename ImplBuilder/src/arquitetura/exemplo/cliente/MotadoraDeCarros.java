package arquitetura.exemplo.cliente;

import java.util.Scanner;

import arquitetura.exemplo.builder.Carro;
import arquitetura.exemplo.builder.CarroBuilder;

public class MotadoraDeCarros {
	private static CarroBuilder builder;
	
	public static void main (String args[]) {
		Scanner entrada = new Scanner(System.in);
		while(true) {
			System.out.println("Qual o tipo de carro deseja criar?");
			System.out.println("(1) esportivo, (2) passeio e (3) utilitário - (9) encerrar");
			int opcao = entrada.nextInt();
			String tipo = "";
			switch (opcao) {
				case 1:
					tipo = "esportivo";
					break;
				case 2:
					tipo = "passeio";
					break;
				case 3:
					tipo = "utilitario";
					break;
				case 9:
					entrada.close();
					System.exit(0);
				default:
					System.out.println("Entrada inválida - tente novamente!");
					break;
			}
			builder = CarroBuilder.getBuilder(tipo);
			if (builder != null) {
				Carro carro = builder.build();
				System.out.println(carro);
			}
			System.out.println("\n");
		}
	}
}
