package factory;

public class Triangulo implements IFiguraGeometrica {
	//singleton
	public static Triangulo triangulo = new Triangulo();
	
	private Triangulo() {
	
	}

	@Override
	public String calcularArea() {
		return "Calculo area circulo ";
	}

	public static Triangulo getInstance() {
		return triangulo;
	}
}
