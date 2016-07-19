package arquitetura.exemplo.builder;

public class CarroUtilitarioBuilder extends CarroBuilder {
	
	@Override
	public void buildMotor() {
		motor = "2.0 diesel";
	}

	@Override
	public void buildTracao() {
		tracao = "4x4";
	}

	@Override
	public void buildPortas() {
		portas = 5;
	}

	@Override
	public void buildRodas() {
		rodas = "aro 19";
	}

	@Override
	public Carro build() {
		super.buildParts();
		return new Utilitario(motor, tracao, portas, rodas);
	}
}
