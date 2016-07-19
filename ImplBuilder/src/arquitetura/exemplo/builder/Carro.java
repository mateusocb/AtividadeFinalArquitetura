package arquitetura.exemplo.builder;

public abstract class Carro {
	private String motor;
	private String tracao;
	private int portas;
	private String rodas;
	
	public Carro(String motor, String tracao, int portas, String rodas) {
		super();
		this.motor = motor;
		this.tracao = tracao;
		this.portas = portas;
		this.rodas = rodas;
	}
	
	@Override
	public String toString() {
		return motor + ", " + tracao + ", " + portas + " portas e rodas " + rodas;
	}
}