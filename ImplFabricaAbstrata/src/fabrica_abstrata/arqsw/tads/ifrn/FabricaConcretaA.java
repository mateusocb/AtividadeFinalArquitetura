package fabrica_abstrata.arqsw.tads.ifrn;

import produtos.fabrica_abstrata.arqsw.tads.ifrn.CalculadoraAbstrata;
import produtos.fabrica_abstrata.arqsw.tads.ifrn.CalculadoraManual;
import produtos.fabrica_abstrata.arqsw.tads.ifrn.EscritorAbstrato;
import produtos.fabrica_abstrata.arqsw.tads.ifrn.EscritorMaiusculas;

public class FabricaConcretaA extends FabricaAbstrata {

	@Override
	public EscritorAbstrato createEscritor() {
		return new EscritorMaiusculas();
	}

	@Override
	public CalculadoraAbstrata createCalculadora() {
		return new CalculadoraManual();
	}
}
