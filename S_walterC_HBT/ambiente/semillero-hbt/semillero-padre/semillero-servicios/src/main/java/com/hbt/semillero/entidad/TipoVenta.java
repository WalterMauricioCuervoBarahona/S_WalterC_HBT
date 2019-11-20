/**
 * EstadoEnum.java
 */
package com.hbt.semillero.entidad;

/**
 * <b>Descripción:<b>Clase que determina la enumeracion para representar los
 * tipos de estados aceptados por un comic
 * 
 * @author walter cuervo
 * @version
 */
public enum TipoVenta {

	PEDIDO("enum.venta.pedido"), 
	VENTA("enum.venta.venta");
	/**
	 * Atributo que contiene la clave del mensaje para la internacionalizacion
	 */
	private String codigoMensaje;

	/**
	 * Constructor que recibe como parametro el codigo del mensaje
	 * 
	 * @param codigoMensaje, Clave del mensaje para para internacionalizacion
	 */
	TipoVenta(String codigoMensaje) {
		this.codigoMensaje = codigoMensaje;
	}

	/**
	 * Metodo que retorna el valor del atributo
	 * 
	 * @return cadena con el codigo del mensaje
	 */
	public String getCodigoMensaje() {
		return codigoMensaje;
	}

	/**
	 * Metodo que establece el valor del atributo
	 *
	 * @param codigoMensaje
	 */
	public void setCodigoMensaje(String codigoMensaje) {
		this.codigoMensaje = codigoMensaje;
	}
}
