package com.tienda;

import java.util.stream.Stream;

import com.tienda.datos.TipoCalidad;
import com.tienda.datos.NombresProductos;

class LaTienda {
	Producto[] productos;

	public LaTienda(Producto[] productos) {
		this.productos = productos;
	}

	/**
	 * Actualiza la lista de productos una vez al d�a
	 */
	public void actualizarProductos() {
		
		/* productos calidad a�ejas */
		Stream.of(productos)
				.filter(producto -> producto.nombre
						.equals(NombresProductos.VINO.getNombreProducto()))
				.forEach(
						productoAumentarCalidad -> {
							CalcularCalidad.calcularCalidad(
									TipoCalidad.A�EJA.getTipoCalidad(),
									productoAumentarCalidad);
						});
		
		
		/* productos calidad VIP */
		Stream.of(productos)
				.filter(producto -> producto.nombre.equals(NombresProductos.VIP
						.getNombreProducto()))
				.forEach(
						productoVIP -> {
							CalcularCalidad.calcularCalidad(
									TipoCalidad.VIP.getTipoCalidad(),
									productoVIP);
						});
		
		
		/* productos calidad DIARIA */
		Stream.of(productos)
				.filter(producto -> !producto.nombre
						.equals(NombresProductos.VIP.getNombreProducto())
						&& !producto.nombre.equals(NombresProductos.QUESO
								.getNombreProducto())
						&& !producto.nombre.equals(NombresProductos.VINO
								.getNombreProducto()))
				.forEach(
						productoCalidadDiaria -> {
							CalcularCalidad.calcularCalidad(
									TipoCalidad.DIARIA.getTipoCalidad(),
									productoCalidadDiaria);
						});
		
		
		/* producto calidad no aplica */
		Stream.of(productos)
				.filter(producto -> producto.nombre
						.equals(NombresProductos.QUESO.getNombreProducto()))
				.forEach(
						productoNoAfectado -> {
							CalcularCalidad.calcularCalidad(
									TipoCalidad.NOAPLICA.getTipoCalidad(),
									productoNoAfectado);
						});

		
	}
}
