package com.tienda;

import com.tienda.datos.NombresProductos;

/**
 * Clase que nos calcula la calidad por cada uno de los productos y dependiendo del tipo que sea
 * 
 * @author ssotos
 *
 */
public class CalcularCalidad {
/**
 * Función estática para calcular la calidad dependiendo del producto que tengamos que actualizar
 * @param tipoCalidad
 * @param productoAfectado
 */
	public static void calcularCalidad(Integer tipoCalidad,
			Producto productoAfectado) {

		/* Dependiendo del tipo de calidad la calculamos de una forma u otra */
		switch (tipoCalidad) {
		case 1:
			disminuirCalidadProducto(productoAfectado);
			break;
		case 2:
			aumentarCalidadProducto(productoAfectado);
			break;
		case 3:
			calcularCalidadVIP(productoAfectado);
			break;
		case 4:
			/* producto no afectado por la calidad */
			break;
		default:
			System.out
					.println("Al producto indicado no contemplamos una forma de calcular su calidad");
			break;

		}
	}

	/**
	 * Comprobamos si el producto tiene el máximo de calidad
	 * 
	 * @param productoAfectado
	 * @return
	 */
	private static Boolean comprobarSiTieneMaximoCalidad(
			Producto productoAfectado) {
		return productoAfectado.valor >= 50 ? true : false;
	}

	/**
	 * Calcular calidad VIP para productos de este tipo VIP
	 * 
	 * @param productoAfectado
	 */
	private static void calcularCalidadVIP(Producto productoAfectado) {

		// TODO pendiente de definir la historia de usuario hay que contrastarla
		// con el cliente.Nos habla de productos y Acceso VIP Eric Mauller es
		// una persona

	}

	/**
	 * Función que nos aumenta la calidad del producto y disminuye su caducidad
	 * 
	 * @param productoAfectado
	 */
	private static void aumentarCalidadProducto(Producto productoAfectado) {

		/* Si no es cero restamos */
		if (productoAfectado.caducidad > 0) {
			productoAfectado.caducidad = productoAfectado.caducidad - 1;
		}

		/* Si tiene el máximo no continuamos */
		if (!comprobarSiTieneMaximoCalidad(productoAfectado)) {
			productoAfectado.valor = productoAfectado.valor + 1;
		}

	}

	/**
	 * Función que nos disminuye la caliad del producto y la caducidad
	 * 
	 * @param productoAfectado
	 */
	private static void disminuirCalidadProducto(Producto productoAfectado) {

		int numeroADisminuir = calculateCantidadADisminuir(productoAfectado);

		// si la caduciad no es 0 restamos
		if (productoAfectado.caducidad > 0) {
			productoAfectado.caducidad = productoAfectado.caducidad - 1;
		}

		productoAfectado.valor = productoAfectado.valor - numeroADisminuir;
	}

	/**
	 * Es un producto normal si no es una Tarta de manzana o la caducidad es 0.
	 * 
	 * @param productoAfectado
	 * @return numeroADisminuir
	 */
	private static int calculateCantidadADisminuir(Producto productoAfectado) {
		/* Si es un producto normal disminuimos uno */
		int numeroADisminuir = 1;

		/* Si es tarta de manzana restaremos el doble */
		if (productoAfectado.nombre.equals(NombresProductos.TARTA_MANZANA
				.getNombreProducto()) || productoAfectado.caducidad == 0) {
			numeroADisminuir = 2;
		}
		return numeroADisminuir;
	}

}
