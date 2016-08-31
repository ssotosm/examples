package com.tienda.datos;

public enum NombresProductos {

	VINO("Botella Vino Tinto"), MACARRONES("Macarrones"), COLONIA("Colonia"), QUESO(
			"Queso Azul"), VIP("Acceso VIP Eric Mauller"), TARTA_MANZANA(
			"Tarta de manzana");

	private final String nombreProducto;

	private NombresProductos(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

}
