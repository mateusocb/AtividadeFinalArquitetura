package produtos.fabrica_abstrata.arqsw.tads.ifrn;

public class CalculadoraMatematica extends CalculadoraAbstrata {

	@Override
	public double soma(double valA, double valB) {
		return Double.sum(valA, valB);
	}

	@Override
	public double subtrai(double valA, double valB) {
		return Math.subtractExact(Math.round(valA), Math.round(valB));
	}

	@Override
	public double divide(double valA, double valB) {
		return Math.floorDiv(Math.round(valA), Math.round(valB));
	}

	@Override
	public double multiplica(double valA, double valB) {
		return Math.multiplyExact(Math.round(valA), Math.round(valB));
	}
}
