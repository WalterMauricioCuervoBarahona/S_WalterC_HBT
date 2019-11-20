/**
 * EstadoEnum.java
 */
package com.hbt.semillero.entidad;

/**
 * <b>Descripción:<b>Clase que determina la enumeracion para representar los
 * tipos de pedido aceptados por una factura
 * 
 * @author Walter Cuervo
 * @version
 */
public enum EstadoPedido {

	SOLICITADO("enum.pedido.solicitado"), 
	PENDIENTE("enum.pedido.pendiente"),
	ENTREGADO("enum.pedido.entregado");
	/**
	 * Atributo que contiene la clave del mensaje para la internacionalizacion
	 */
	private String codigoMensaje;

	/**
	 * Constructor que recibe como parametro el codigo del mensaje
	 * 
	 * @param codigoMensaje, Clave del mensaje para para internacionalizacion
	 */
	EstadoPedido(String codigoMensaje) {
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
