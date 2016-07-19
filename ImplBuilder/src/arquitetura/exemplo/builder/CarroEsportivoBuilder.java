package arquitetura.exemplo.builder;

public class CarroEsportivoBuilder extends CarroBuilder {
	
	@Override
	public void buildMotor() {
		motor = "2.0, V12, Biturbo";
	}

	@Override
	public void buildTracao() {
		tracao = "4x2 dianteira";
	}

	@Override
	public void buildPortas() {
		portas = 2;
	}

	@Override
	public void buildRodas() {
		rodas = "aro 17 de liga leve";
	}

	@Override
	public Carro build() {
		super.buildParts();
		return new Esportivo(motor, tracao, portas, rodas);
	}
}
