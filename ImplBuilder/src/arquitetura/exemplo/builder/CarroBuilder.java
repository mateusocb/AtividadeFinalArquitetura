package arquitetura.exemplo.builder;

public abstract class CarroBuilder {
	
	protected String motor;
	protected String tracao;
	protected int portas;
	protected String rodas;
	
	public abstract void buildMotor();
	public abstract void buildTracao();
	public abstract void buildPortas();
	public abstract void buildRodas();
	
	public void buildParts() {
		this.buildMotor();
		this.buildPortas();
		this.buildRodas();
		this.buildTracao();
	}
	public abstract Carro build();
	
	public static CarroBuilder getBuilder(String tipo) {
		if (tipo.equals("esportivo")) {
			return new CarroEsportivoBuilder();
		} else if (tipo.equals("passeio")) {
			return new CarroPasseioBuilder();
		} else if (tipo.equals("utilitario")) {
			return new CarroUtilitarioBuilder();
		}
		return null;
	}
}
