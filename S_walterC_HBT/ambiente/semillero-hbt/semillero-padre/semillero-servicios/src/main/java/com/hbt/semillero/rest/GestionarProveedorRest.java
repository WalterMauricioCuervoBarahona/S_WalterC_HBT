/**
 * GestionarProveedorRest.java
 */
package com.hbt.semillero.rest;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ProveedorDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.ejb.IGestionarProveedorLocal;
import com.hbt.semillero.entidad.Proveedor;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author mauro
 * @version 
 */
@Path("/GestionarProveedor")
public class GestionarProveedorRest {
	
	@EJB
	private IGestionarProveedorLocal gestionarProveedor;
	
	/**
	 * 
	 * Metodo encargado de  realizar prueba rest
	 * <b>Caso de Uso</b>
	 * @author mauro
	 * 
	 * @return
	 */
	@GET
	@Path("/saludo")
	@Produces(MediaType.APPLICATION_JSON)
	public String primerRest() {
		return "Prueba inicial servicios rest en el semillero java hbt";
	} 
	
	/**
	 * 
	 * Metodo encargado de consultar un proveedor 
	 * <b>Caso de Uso</b>
	 * @author mauro
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GET
	@Path("/consultarProveedor")
	@Produces(MediaType.APPLICATION_JSON)
	public ProveedorDTO consultarProveedor(@QueryParam("idPro") Long id) throws Exception {
			 return gestionarProveedor.consultarProveedor(id.toString());
	}

	/**
	 * 
	 * Metodo encargado de consultar una lista de proveedores 
	 * <b>Caso de Uso</b>
	 * @author mauro
	 * 
	 * @return
	 */
	@GET
	@Path("/consultarProveedores")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProveedorDTO> consultarProveedores() {
		return gestionarProveedor.consultarProveedores();

	}
	
	/**
	 * 
	 * Metodo encargado de crear un proveedor 
	 * <b>Caso de Uso</b>
	 * @author mauro
	 * 
	 * @param proveedorDTO
	 * @return
	 */
	@POST
	@Path("/crear")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearProveedor(ProveedorDTO proveedorDTO, @QueryParam("idPro") Long id) {
		return gestionarProveedor.crearProveedor(proveedorDTO, id);		
	}
	
	/**
	 * 
	 * Metodo encargado de modificar un proveedor 
	 * <b>Caso de Uso</b>
	 * @author mauro
	 * 
	 * @param comicDTO
	 * @return
	 */
	@PUT
	@Path("/modificar")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultadoDTO modificarProveedor(@QueryParam("monto")BigDecimal monto,@QueryParam("nombre") String nombre,@QueryParam("idPro") Long id) {
		return gestionarProveedor.modificarProveedor(monto, nombre, id);
	}
	
	/**
	 * 
	 * Metodo encargado de eliminar un proveedor 
	 * <b>Caso de Uso</b>
	 * @author mauro
	 * 
	 * @param id
	 * @return
	 */
	@DELETE
	@Path("/eliminar")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultadoDTO eliminarProveedor(@QueryParam("id") Long id) {
			return  gestionarProveedor.eliminarProveedor(id);
	}
	
	/**
	 * 
	 * Metodo encargado de inahbilitar un proveedor 
	 * <b>Caso de Uso</b>
	 * @author mauro
	 * 
	 * @param id
	 * @return
	 */
	@PUT
	@Path("/inahbilitar")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultadoDTO inhabilitarProveedor(@QueryParam("id") Long id) {
		return gestionarProveedor.inahbilitarProveedor(id);
	}
	
	/**
	 * 
	 * Metodo encargado de modificar la direccion de un proveedor 
	 * <b>Caso de Uso</b>
	 * @author mauro
	 * 
	 * @param id
	 * @param direccion
	 * @return
	 */
	@GET
	@Path("/modificarDireccion")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultadoDTO modificarDireccion(@QueryParam("id") Long id, @QueryParam("direccion") String direccion) {
		return gestionarProveedor.addDireccionProveedor(id.toString(), direccion);
	}
}
