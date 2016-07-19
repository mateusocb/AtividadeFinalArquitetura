package cliente.fabrica_abstrata.arqsw.tads.ifrn;

import java.io.IOException;
import java.util.Scanner;

import fabrica_abstrata.arqsw.tads.ifrn.FabricaAbstrata;
import produtos.fabrica_abstrata.arqsw.tads.ifrn.CalculadoraAbstrata;
import produtos.fabrica_abstrata.arqsw.tads.ifrn.EscritorAbstrato;

public class Cliente {
	
	public static void main(String args[]) throws IOException {
		FabricaAbstrata fabrica = FabricaAbstrata.getFabrica();
		EscritorAbstrato escritor = fabrica.createEscritor();
		CalculadoraAbstrata calculadora = fabrica.createCalculadora();
		
		Scanner in = new Scanner(System.in);
		System.out.println("Digite o primeiro valor: ");
		double valorA = in.nextDouble();
		System.out.println("Digite o segundo valor: ");
		double valorB = in.nextDouble();
		
		escritor.escreve("O resultado da soma é = "+ calculadora.soma(valorA, valorB));
		
		in.close();
	}

}
