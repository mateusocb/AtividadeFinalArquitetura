package arquitetura.exemplo.builder;

public class CarroPasseioBuilder extends CarroBuilder {

	@Override
	public void buildMotor() {
		motor = "1.0 flex";
	}

	@Override
	public void buildTracao() {
		tracao = "4x2 dianteira";
	}

	@Override
	public void buildPortas() {
		portas = 4;
	}

	@Override
	public void buildRodas() {
		rodas = "aro 15 com calota";
	}

	@Override
	public Carro build() {
		super.buildParts();
		return new Passeio(motor, tracao, portas, rodas);
	}
}
