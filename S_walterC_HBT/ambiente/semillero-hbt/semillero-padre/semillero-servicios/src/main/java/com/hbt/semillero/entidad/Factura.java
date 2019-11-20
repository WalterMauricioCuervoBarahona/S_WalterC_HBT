 package com.hbt.semillero.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * 
 * <b>Descripción:<b> Clase que determina una factura
 * <b>Caso de Uso:<b> 
 * @author Walter Cuervo
 * @version
 */
@Entity
@Table(name = "TC_FACTURA")
public class Factura  implements Serializable{

	/**
	 * Serializar es pasar un Objeto a un array de bytes y viceversa. Atributo que
	 * determina serialVersionUID es el id único que identifica una clase cuando lo
	 * serializamos. ;ediante este id podemos identificar el objeto convertido en un
	 * array de bytes.
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Persona cliente;
	private Proveedor proveedor;
	private Long iva;
	private BigDecimal valorTotalPedido;
	private TipoVenta tipoVenta;
	private EstadoPedido estadoPedido;
	private List<FacturaDetalle> listaFacturaDetalle;
	
	
	/**
	 * Constructor de la clase.
	 */
	public Factura() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Constructor de la clase.
	 * @param id
	 * @param cliente
	 * @param proveedor
	 * @param iva
	 * @param valorTotalPedido
	 * @param tipoVenta
	 * @param estadoPedido
	 */
	public Factura(Long id, Persona cliente, Proveedor proveedor, Long iva, BigDecimal valorTotalPedido,
			TipoVenta tipoVenta, EstadoPedido estadoPedido) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.proveedor = proveedor;
		this.iva = iva;
		this.valorTotalPedido = valorTotalPedido;
		this.tipoVenta = tipoVenta;
		this.estadoPedido = estadoPedido;
	}
	
	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * @return El id asociado a la clase
	 */
	@Id
	@Column(name = "SFID")
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
	 * Metodo encargado de retornar el valor del atributo cliente
	 * @return El cliente asociado a la clase
	 */
	@ManyToOne
    @JoinColumn(name="SFCLIENTE", nullable = false)
	public Persona getCliente() {
		return cliente;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo cliente
	 * @param cliente El nuevo cliente a modificar.
	 */
	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo proveedor
	 * @return El proveedor asociado a la clase
	 */
	@ManyToOne
    @JoinColumn(name="SFPROVEEDOR", nullable=false)
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
	 * Metodo encargado de retornar el valor del atributo iva
	 * @return El iva asociado a la clase
	 */
	@Column(name = "SFIVA")
	public Long getIva() {
		return iva;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo iva
	 * @param iva El nuevo iva a modificar.
	 */
	public void setIva(Long iva) {
		this.iva = iva;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo valorTotalPedido
	 * @return El valorTotalPedido asociado a la clase
	 */
	@Column(name = "SFTOTAL")
	public BigDecimal getValorTotalPedido() {
		return valorTotalPedido;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo valorTotalPedido
	 * @param valorTotalPedido El nuevo valorTotalPedido a modificar.
	 */
	public void setValorTotalPedido(BigDecimal valorTotalPedido) {
		this.valorTotalPedido = valorTotalPedido;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo tipoVenta
	 * @return El tipoVenta asociado a la clase
	 */
	@Column(name = "SFTIPO")
	@Enumerated(value = EnumType.STRING)
	public TipoVenta getTipoVenta() {
		return tipoVenta;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo tipoVenta
	 * @param tipoVenta El nuevo tipoVenta a modificar.
	 */
	public void setTipoVenta(TipoVenta tipoVenta) {
		this.tipoVenta = tipoVenta;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo estadoPedido
	 * @return El estadoPedido asociado a la clase
	 */
	@Column(name = "SFESTADO")
	@Enumerated(value = EnumType.STRING)
	public EstadoPedido getEstadoPedido() {
		return estadoPedido;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo estadoPedido
	 * @param estadoPedido El nuevo estadoPedido a modificar.
	 */
	public void setEstadoPedido(EstadoPedido estadoPedido) {
		this.estadoPedido = estadoPedido;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo listaFacturaDetalle
	 * @return El listaFacturaDetalle asociado a la clase
	 */
	@OneToMany(mappedBy = "factura")
	public List<FacturaDetalle> getListaFacturaDetalle() {
		return listaFacturaDetalle;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo listaFacturaDetalle
	 * @param listaFacturaDetalle El nuevo listaFacturaDetalle a modificar.
	 */
	public void setListaFacturaDetalle(List<FacturaDetalle> listaFacturaDetalle) {
		this.listaFacturaDetalle = listaFacturaDetalle;
	}
	
	
	
	/*

	



	@OneToMany(mappedBy = "factura")
	public List<FacturaDetalle> getListaFacturaDetalle() {
		return listaFacturaDetalle;
	}

	public void setListaFacturaDetalle(List<FacturaDetalle> listaFacturaDetalle) {
		this.listaFacturaDetalle = listaFacturaDetalle;
	}
	
	
*/
}
