package produtos.fabrica_abstrata.arqsw.tads.ifrn;

public class EscritorMinusculas extends EscritorAbstrato {

	@Override
	public void escreve(String texto) {
		System.out.println(texto.toLowerCase());
	}
}
