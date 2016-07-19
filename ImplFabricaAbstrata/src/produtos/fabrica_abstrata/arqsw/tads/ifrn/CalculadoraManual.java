package produtos.fabrica_abstrata.arqsw.tads.ifrn;

public class CalculadoraManual extends CalculadoraAbstrata {

	@Override
	public double soma(double valA, double valB) {
		return valA + valB;
	}

	@Override
	public double subtrai(double valA, double valB) {
		return valA - valB;
	}

	@Override
	public double divide(double valA, double valB) {
		return valA / valB;
	}

	@Override
	public double multiplica(double valA, double valB) {
		return valA * valB;
	}
}
