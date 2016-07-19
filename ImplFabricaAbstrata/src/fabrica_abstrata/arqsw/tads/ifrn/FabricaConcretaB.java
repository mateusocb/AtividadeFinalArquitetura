package fabrica_abstrata.arqsw.tads.ifrn;

import produtos.fabrica_abstrata.arqsw.tads.ifrn.CalculadoraAbstrata;
import produtos.fabrica_abstrata.arqsw.tads.ifrn.CalculadoraMatematica;
import produtos.fabrica_abstrata.arqsw.tads.ifrn.EscritorAbstrato;
import produtos.fabrica_abstrata.arqsw.tads.ifrn.EscritorMinusculas;

public class FabricaConcretaB extends FabricaAbstrata {

	@Override
	public EscritorAbstrato createEscritor() {
		return new EscritorMinusculas();
	}

	@Override
	public CalculadoraAbstrata createCalculadora() {
		return new CalculadoraMatematica();
	}
}
