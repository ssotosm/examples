package factory;

public class FactoryFiguras {

	public FactoryFiguras() {
	
	}
	
	public  void create(String string) {
		// clase factory
		IFiguraGeometrica figuraGeometrica = null;

		if (string.equals("Circulo")) {
			figuraGeometrica = Circulo.getInstance();
			System.out.println(figuraGeometrica.calcularArea());
		} else {
			figuraGeometrica=Triangulo.getInstance();
			System.out.println(figuraGeometrica.calcularArea());
		}

	}
	
}
