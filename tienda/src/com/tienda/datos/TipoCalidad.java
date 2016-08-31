package com.tienda.datos;

public enum TipoCalidad {

	DIARIA(1), AÑEJA(2), VIP(3),NOAPLICA(4);

	private final int tipoCalidad;

	private TipoCalidad(int tipoCalidad) {
		this.tipoCalidad = tipoCalidad;
	}

	public int getTipoCalidad() {
		return tipoCalidad;
	}

}
