package factory;

public class Circulo implements IFiguraGeometrica {
	
	// singleton
	private static Circulo circulo = new Circulo();

	private Circulo() {
	}

	@Override
	public String calcularArea() {
		return "Calcular area circulo ";

	}

	public static Circulo getInstance() {
		return circulo;
	}

}
