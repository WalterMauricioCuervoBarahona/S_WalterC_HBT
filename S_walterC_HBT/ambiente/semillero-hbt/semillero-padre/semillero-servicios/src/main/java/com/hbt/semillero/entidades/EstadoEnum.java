package com.hbt.semillero.entidades;

/**
 * 
 * <b>Descripción:<b> Clase que determina <b>Caso de Uso:<b>
 * 
 * @author walter cuervo
 * @version
 */
public enum EstadoEnum {
	ACTIVO("enum.estado.activo"), INACTIVO("enum.estado.inactivo");

	/**
	 * atributo para acceder a la descripcion de un enum
	 */
	private String codigoMensaje;

	/**
	 * 
	 * Constructor de la clase.
	 * @param codMensaje
	 */
	private EstadoEnum(String codMensaje) {
		this.codigoMensaje = codMensaje;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo codigoMensaje
	 * 
	 * @return El codigoMensaje asociado a la clase
	 */
	public String getCodigoMensaje() {
		return codigoMensaje;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo codigoMensaje
	 * 
	 * @param codigoMensaje El nuevo codigoMensaje a modificar.
	 */
	public void setCodigoMensaje(String codigoMensaje) {
		this.codigoMensaje = codigoMensaje;
	}
}