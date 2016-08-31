package facade;

public class Multifuncion {

	private Escaner escaner;
	private Impresora impresora;

	public Multifuncion() {
		escaner = new Escaner();
		impresora = new Impresora();
	}

	public void imprimir() {
		impresora.imprime();
	}

	public void escanear() {
		escaner.escanear();
	}

}
