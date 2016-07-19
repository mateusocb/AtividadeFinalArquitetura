package arquitetura.exemplo.builder;

public class Passeio extends Carro {

	public Passeio(String motor, String tracao, int portas, String rodas) {
		super(motor, tracao, portas, rodas);
	}
	
	@Override
	public String toString() {
		return "Passeio: " + super.toString();
	}
}
