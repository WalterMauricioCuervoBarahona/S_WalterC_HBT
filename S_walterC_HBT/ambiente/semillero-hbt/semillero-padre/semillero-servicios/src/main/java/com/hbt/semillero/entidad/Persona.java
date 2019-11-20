package com.hbt.semillero.entidad;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * <b>Descripción:<b> Clase que determina una persona
 * <b>Caso de Uso:<b> 
 * @author walter cuervo
 * @version 
 */
@Entity
@Table(name = "TC_PERSONA")
public class Persona implements Serializable {

	/**
	 * Serializar es pasar un Objeto a un array de bytes y viceversa. Atributo que
	 * determina serialVersionUID es el id único que identifica una clase cuando lo
	 * serializamos. ;ediante este id podemos identificar el objeto convertido en un
	 * array de bytes.
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nombre;
	private Long numeroidentificacion;
	private Proveedor proveedor;
	private Usuario usuario;
	private List<Factura> listaFacturas;
	
	
	/**
	 * Constructor de la clase.
	 */
	public Persona() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor de la clase.
	 * @param id
	 * @param nombre
	 * @param numeroidentificacion
	 * @param proveedor
	 * @param usuario
	 */
	public Persona(Long id, String nombre, Long numeroidentificacion, Proveedor proveedor, Usuario usuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.numeroidentificacion = numeroidentificacion;
		this.proveedor = proveedor;
		this.usuario = usuario;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * @return El id asociado a la clase
	 */
	@Id
	@Column(name = "SPID")
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
	@Column(name = "SCNOMBRE")
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
	 * Metodo encargado de retornar el valor del atributo numeroidentificacion
	 * @return El numeroidentificacion asociado a la clase
	 */
	@Column(name = "SCNUMIDENTIFICACION")
	public Long getNumeroidentificacion() {
		return numeroidentificacion;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo numeroidentificacion
	 * @param numeroidentificacion El nuevo numeroidentificacion a modificar.
	 */
	public void setNumeroidentificacion(Long numeroidentificacion) {
		this.numeroidentificacion = numeroidentificacion;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo proveedor
	 * @return El proveedor asociado a la clase
	 */
	@OneToOne(mappedBy = "persona")
	public Proveedor getProveedor() {
		return proveedor;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo proveedor
	 * @param proveedor El nuevo proveedor a modificar.
	 */
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo usuario
	 * @return El usuario asociado a la clase
	 */
	@OneToOne(mappedBy = "persona")
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo usuario
	 * @param usuario El nuevo usuario a modificar.
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo listaFacturas
	 * @return El listaFacturas asociado a la clase
	 */
	@OneToMany(mappedBy = "cliente")
	public List<Factura> getListaFacturas() {
		return listaFacturas;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo listaFacturas
	 * @param listaFacturas El nuevo listaFacturas a modificar.
	 */
	public void setListaFacturas(List<Factura> listaFacturas) {
		this.listaFacturas = listaFacturas;
	}
}