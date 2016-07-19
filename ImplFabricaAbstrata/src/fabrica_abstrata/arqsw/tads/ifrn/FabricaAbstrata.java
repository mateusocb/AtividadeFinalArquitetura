package fabrica_abstrata.arqsw.tads.ifrn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import produtos.fabrica_abstrata.arqsw.tads.ifrn.CalculadoraAbstrata;
import produtos.fabrica_abstrata.arqsw.tads.ifrn.EscritorAbstrato;

public abstract class FabricaAbstrata {
	public abstract EscritorAbstrato createEscritor();
	public abstract CalculadoraAbstrata createCalculadora();
	
	public static FabricaAbstrata getFabrica() throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("./properties/fabrica.properties");
		prop.load(file);
		String nomeFabrica = prop.getProperty("fabrica");
		if (nomeFabrica.equals("A")) {
			return new FabricaConcretaA();
		} else if (nomeFabrica.equals("B")) {
			return new FabricaConcretaB();
		}
		return null;
	}
}
