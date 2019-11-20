package com.hbt.semillero.entidad;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * <b>Descripción:<b> Clase que determina las detalles de una factura
 * <b>Caso de Uso:<b> 
 * @author walter Cuervo
 * @version
 */
@Entity
@Table(name = "TC_FACTURA_DETALLE")
public class FacturaDetalle implements Serializable{

	/**
	 * Serializar es pasar un Objeto a un array de bytes y viceversa. Atributo que
	 * determina serialVersionUID es el id único que identifica una clase cuando lo
	 * serializamos. ;ediante este id podemos identificar el objeto convertido en un
	 * array de bytes.
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Factura factura;
	private Comic comic;
	private Long cantidad;
	private BigDecimal precioUnitario;
	
	/**
	 * Constructor de la clase.
	 */
	public FacturaDetalle() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de la clase.
	 * @param id
	 * @param factura
	 * @param comic
	 * @param cantidad
	 * @param precioUnitario
	 */
	public FacturaDetalle(Long id, Factura factura, Comic comic, Long cantidad, BigDecimal precioUnitario) {
		super();
		this.id = id;
		this.factura = factura;
		this.comic = comic;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * @return El id asociado a la clase
	 */
	@Id
	@Column(name = "SDID")
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
	 * Metodo encargado de retornar el valor del atributo factura
	 * @return El factura asociado a la clase
	 */
	@ManyToOne
    @JoinColumn(name="SFID", nullable=false)
	public Factura getFactura() {
		return factura;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo factura
	 * @param factura El nuevo factura a modificar.
	 */
	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo comic
	 * @return El comic asociado a la clase
	 */
	@ManyToOne
    @JoinColumn(name="SCID", nullable=false)
	public Comic getComic() {
		return comic;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo comic
	 * @param comic El nuevo comic a modificar.
	 */
	public void setComic(Comic comic) {
		this.comic = comic;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo cantidad
	 * @return El cantidad asociado a la clase
	 */
	@Column(name = "SDCANTIDAD")
	public Long getCantidad() {
		return cantidad;
	}
	
	/**
	 * Metodo encargado de modificar el valor del atributo cantidad
	 * @param cantidad El nuevo cantidad a modificar.
	 */
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo precioUnitario
	 * @return El precioUnitario asociado a la clase
	 */
	@Column(name = "SDPRECIO_UNITARIO")
	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo precioUnitario
	 * @param precioUnitario El nuevo precioUnitario a modificar.
	 */
	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
}
