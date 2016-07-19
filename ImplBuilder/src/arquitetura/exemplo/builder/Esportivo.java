package arquitetura.exemplo.builder;

public class Esportivo extends Carro {

	public Esportivo(String motor, String tracao, int portas, String rodas) {
		super(motor, tracao, portas, rodas);
	}

	@Override
	public String toString() {
		return "Esportivo: " + super.toString();
	}	
}