package com.tienda;

import com.tienda.datos.NombresProductos;

public class App {

	private final static int NUMERO_DIAS = 2;

	public static void main(String[] args) {
		System.out.println("LA TIENDA SL : ACTUALIZACIÓN DIARIA!");

		/* Leemos nuestros productos y los añadimos a la tienda */
		Producto[] misProductos = misProductos();
		LaTienda app = new LaTienda(misProductos);

		for (int i = 0; i < NUMERO_DIAS; i++) {

			System.out.println("\n -------- day " + i + " --------");
			System.out.println("nombre, caducidad, valor");

			for (Producto producto : misProductos) {
				System.out.println(producto);
			}
			/* Actualizamos los productos al final de cada día */
			app.actualizarProductos();
		}
	}

	/**
	 * Función privada para inicializar productos
	 * 
	 * @return
	 */
	private static Producto[] misProductos() {
		Producto[] productos = new Producto[] {
				new Producto(NombresProductos.MACARRONES.getNombreProducto(),
						10, 20),
				new Producto(NombresProductos.VINO.getNombreProducto(), 2, 0),
				new Producto(NombresProductos.COLONIA.getNombreProducto(), 5, 7),
				new Producto(NombresProductos.QUESO.getNombreProducto(), 0, 80),
				new Producto(NombresProductos.QUESO.getNombreProducto(), -1, 80),
				new Producto(NombresProductos.VIP.getNombreProducto(), 15, 20),
				new Producto(NombresProductos.VIP.getNombreProducto(), 10, 47),
				new Producto(
						NombresProductos.TARTA_MANZANA.getNombreProducto(), 3,
						6) };
		return productos;
	}
}
