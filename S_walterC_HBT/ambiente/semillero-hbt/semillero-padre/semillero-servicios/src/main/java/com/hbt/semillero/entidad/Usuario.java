/**
 * Usuario.java
 */
package com.hbt.semillero.entidad;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * <b>Descripción:<b> Clase que determina un usuario
 * <b>Caso de Uso:<b> 
 * @author walter cuervo
 * @version 
 */
@Entity
@Table(name = "TC_USUARIO")
public class Usuario  implements Serializable{
	
	/**
	 * Atributo que determina  
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nombre;
	private LocalDate fechaCreacion;
	private EstadoEnum estadoEnum;
	private Persona persona;
	
	/**
	 * Constructor de la clase.
	 */
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de la clase.
	 * @param id
	 * @param nombre
	 * @param fechaCreacion
	 * @param estadoEnum
	 * @param persona
	 */
	public Usuario(Long id, String nombre, LocalDate fechaCreacion, EstadoEnum estadoEnum, Persona persona) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.estadoEnum = estadoEnum;
		this.persona = persona;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * @return El id asociado a la clase
	 */
	@Id
	@Column(name = "SUID")
	public Long getId() {
		return id;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo id
	 * @param id El nuevo id a modificar.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo nombre
	 * @return El nombre asociado a la clase
	 */
	@Column(name = "SUNOMBRE")
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo nombre
	 * @param nombre El nuevo nombre a modificar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo fechaCreacion
	 * @return El fechaCreacion asociado a la clase
	 */
	@Column(name = "SUFECHA_CREACION")
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
	@Column(name = "SUESTADO")
	@Enumerated(value = EnumType.STRING)
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
	 * Metodo encargado de retornar el valor del atributo persona
	 * @return El persona asociado a la clase
	 */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "SUIDPERSONA")
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
}
