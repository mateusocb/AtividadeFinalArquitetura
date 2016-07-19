package produtos.fabrica_abstrata.arqsw.tads.ifrn;

public class EscritorMaiusculas extends EscritorAbstrato {

	@Override
	public void escreve(String texto) {
		System.out.println(texto.toUpperCase());
	}
}
