/**
 * ProveedorDTO.java
 */
package com.hbt.semillero.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.hbt.semillero.entidad.EstadoEnum;
import com.hbt.semillero.entidad.Persona;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author mauro
 * @version 
 */
public class ProveedorDTO implements Serializable {

	/**
	 * Atributo que determina  
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String direccion;
	private LocalDate fechaCreacion;
	private EstadoEnum estadoEnum;
	private BigDecimal montoCredito;
	private Persona persona;
	
	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * @return El id asociado a la clase
	 */
	public String getId() {
		return id;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo id
	 * @param id El nuevo id a modificar.
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo direccion
	 * @return El direccion asociado a la clase
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo direccion
	 * @param direccion El nuevo direccion a modificar.
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo fechaCreacion
	 * @return El fechaCreacion asociado a la clase
	 */
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo fechaCreacion
	 * @param fechaCreacion El nuevo fechaCreacion a modificar.
	 */
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo estadoEnum
	 * @return El estadoEnum asociado a la clase
	 */
	public EstadoEnum getEstadoEnum() {
		return estadoEnum;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo estadoEnum
	 * @param estadoEnum El nuevo estadoEnum a modificar.
	 */
	public void setEstadoEnum(EstadoEnum estadoEnum) {
		this.estadoEnum = estadoEnum;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo montoCredito
	 * @return El montoCredito asociado a la clase
	 */
	public BigDecimal getMontoCredito() {
		return montoCredito;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo montoCredito
	 * @param montoCredito El nuevo montoCredito a modificar.
	 */
	public void setMontoCredito(BigDecimal montoCredito) {
		this.montoCredito = montoCredito;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo persona
	 * @return El persona asociado a la clase
	 */
	public Persona getPersona() {
		return persona;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo persona
	 * @param persona El nuevo persona a modificar.
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	/** 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return JsonUtils.toStringJson(this);
	}
}