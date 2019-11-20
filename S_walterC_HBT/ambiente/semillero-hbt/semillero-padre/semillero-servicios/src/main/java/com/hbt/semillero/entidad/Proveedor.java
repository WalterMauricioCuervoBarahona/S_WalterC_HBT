/**
 * Proveedor.java
 */
package com.hbt.semillero.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * <b>Descripción:<b> Clase que determina un proveedor
 * <b>Caso de Uso:<b> 
 * @author walter cuervo
 * @version 
 */
@Entity
@Table(name = "TC_PROVEEDOR")
public class Proveedor implements Serializable {
	
	/**
	 * Atributo que determina  
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String direccion;
	private LocalDate fechaCreacion;
	private EstadoEnum estadoEnum;
	private BigDecimal montoCredito;
	private Persona persona;
	private List<Factura> listaFacturas;
	
	/**
	 * Constructor de la clase.
	 */
	public Proveedor() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de la clase.
	 * @param id
	 * @param direccion
	 * @param fechaCreacion
	 * @param estadoEnum
	 * @param montoCredito
	 * @param persona
	 */
	public Proveedor(Long id, String direccion, LocalDate fechaCreacion, EstadoEnum estadoEnum, BigDecimal montoCredito,
			Persona persona) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.fechaCreacion = fechaCreacion;
		this.estadoEnum = estadoEnum;
		this.montoCredito = montoCredito;
		this.persona = persona;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * @return El id asociado a la clase
	 */
	@Id
	@SequenceGenerator(allocationSize = 1, name = "GENERATOR", sequenceName = "SEQ_PROVEEDOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GENERATOR")
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
	 * Metodo encargado de retornar el valor del atributo direccion
	 * @return El direccion asociado a la clase
	 */
	@Column(name = "SPDIRECCION")
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
	@Column(name = "SPFECHA_CREACION")
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
	@Column(name = "SPESTADO")
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
	 * Metodo encargado de retornar el valor del atributo montoCredito
	 * @return El montoCredito asociado a la clase
	 */
	@Column(name = "SPMONTO_CREDITO")
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
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "SPIDPERSONA", referencedColumnName = "SPID")
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
	 * Metodo encargado de retornar el valor del atributo listaFacturas
	 * @return El listaFacturas asociado a la clase
	 */
	@OneToMany(mappedBy = "proveedor")
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
