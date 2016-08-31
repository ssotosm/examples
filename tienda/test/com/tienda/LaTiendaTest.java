package com.tienda;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tienda.datos.NombresProductos;

public class LaTiendaTest {

	@Test
	public void actualizarCalidadProductoQueSuTipoAumentaCalidad() {

		Producto[] productos = new Producto[] { new Producto(
				NombresProductos.VINO.getNombreProducto(), 10, 1) };

		LaTienda app = new LaTienda(productos);

		app.actualizarProductos();
		assertTrue(app.productos[0].caducidad == 9);// debería disminuir en uno
													// la fecha de caducidad
		assertTrue(app.productos[0].valor == 2);// aumenta el valor

	}

	@Test
	public void aumentarCalidadProductoCaducidadNoAumenta() {

		Producto[] productos = new Producto[] { new Producto(
				NombresProductos.VINO.getNombreProducto(), 0, 1) };

		LaTienda app = new LaTienda(productos);

		app.actualizarProductos();
		assertTrue(app.productos[0].caducidad == 0);
		assertTrue(app.productos[0].valor == 2);

	}

	@Test
	public void aumentarCalidadMaximaNoAumenta() {

		Producto[] productos = new Producto[] { new Producto(
				NombresProductos.VINO.getNombreProducto(), 1, 50) };

		LaTienda app = new LaTienda(productos);

		app.actualizarProductos();
		assertTrue(app.productos[0].caducidad == 0);
		assertTrue(app.productos[0].valor == 50);
	}

	@Test
	public void disminuirCalidadProductoNormal() {

		Producto[] productos = new Producto[] { new Producto(
				NombresProductos.COLONIA.getNombreProducto(), 1, 50) };

		LaTienda app = new LaTienda(productos);

		app.actualizarProductos();
		assertTrue(app.productos[0].caducidad == 0);
		assertTrue(app.productos[0].valor == 49);
	}

	@Test
	public void disminuirCalidadProductoTartaDeManzanaDoble() {

		Producto[] productos = new Producto[] { new Producto(
				NombresProductos.TARTA_MANZANA.getNombreProducto(), 1, 50) };

		LaTienda app = new LaTienda(productos);

		app.actualizarProductos();
		assertTrue(app.productos[0].caducidad == 0);
		assertTrue(app.productos[0].valor == 48);
	}

	@Test
	public void noAumentaNiDisminuyeCalidadNiCaduciad() {

		Producto[] productos = new Producto[] { new Producto(
				NombresProductos.QUESO.getNombreProducto(), 1, 50) };

		LaTienda app = new LaTienda(productos);

		app.actualizarProductos();
		assertTrue(app.productos[0].caducidad == 1);
		assertTrue(app.productos[0].valor == 50);

	}

	@Test
	public void devuelveMismoProductoSiEsVIP() {

		Producto[] productos = new Producto[] { new Producto(
				NombresProductos.VIP.getNombreProducto(), 1, 50) };

		LaTienda app = new LaTienda(productos);

		app.actualizarProductos();
		assertTrue(app.productos[0].caducidad == 1);
		assertTrue(app.productos[0].valor == 50);
	}

	@Test
	public void calcularCalidadListaDeProductos() {

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

		LaTienda app = new LaTienda(productos);
		app.actualizarProductos();
		/**/
		assertTrue(app.productos[0].caducidad == 9);
		assertTrue(app.productos[0].valor == 19);
		/**/
		assertTrue(app.productos[1].caducidad == 1);
		assertTrue(app.productos[1].valor == 1);
		/**/
		assertTrue(app.productos[2].caducidad == 4);
		assertTrue(app.productos[2].valor == 6);
		/**/
		assertTrue(app.productos[3].caducidad == 0);
		assertTrue(app.productos[3].valor == 80);
		/**/
		assertTrue(app.productos[4].caducidad == -1);
		assertTrue(app.productos[4].valor == 80);
		/**/
		assertTrue(app.productos[5].caducidad == 15);
		assertTrue(app.productos[5].valor == 20);
		/**/
		assertTrue(app.productos[6].caducidad == 10);
		assertTrue(app.productos[6].valor == 47);
		/**/
		assertTrue(app.productos[7].caducidad == 2);
		assertTrue(app.productos[7].valor == 4);
	}
}
