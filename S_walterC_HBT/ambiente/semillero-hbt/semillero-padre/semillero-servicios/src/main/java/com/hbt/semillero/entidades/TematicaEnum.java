package com.hbt.semillero.entidades;

/**
 * 
 * <b>Descripción:<b> Clase que determina <b>Caso de Uso:<b>
 * 
 * @author mauro
 * @version
 */
public enum TematicaEnum {
	AVENTURAS("enum.tematica.aventuras"), BELICO("enum.tematica.belico"), HUMORISTICO("enum.tematica.humoristico"),
	DEPORTIVO("enum.tematica.deportivo"), FANTASTICO("enum.tematica.fantastico"),
	CIENCIA_FICCION("enum.tematica.ciencia_ficcion"), HISTORICO("enum.tematica.historico"),
	HORROR("enum.tematica.horror");

	/**
	 * atributo 
	 */
	private String codigomensaje;

	/**
	 * 
	 * Constructor de la clase.
	 * 
	 * @param codmensaje
	 */
	private TematicaEnum(String codmensaje) {
		this.codigomensaje = codmensaje;

	}

	/**
	 * Metodo encargado de retornar el valor del atributo codigomensaje
	 * 
	 * @return El codigomensaje asociado a la clase
	 */
	public String getCodigomensaje() {
		return codigomensaje;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo codigomensaje
	 * 
	 * @param codigomensaje El nuevo codigomensaje a modificar.
	 */
	public void setCodigomensaje(String codigomensaje) {
		this.codigomensaje = codigomensaje;
	}
}