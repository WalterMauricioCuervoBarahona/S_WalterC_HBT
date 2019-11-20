/**
 * IGestionarproveedor.java
 */
package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.ProveedorDTO;
import com.hbt.semillero.dto.ResultadoDTO;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author mauro
 * @version 
 */
@Local
public interface IGestionarProveedorLocal {

	/**
	 * 
	 * Metodo encargado de buscar un proveedor y agregarle o modificarle una direccion 
	 * <b>Caso de Uso</b>
	 * @author mauro
	 * 
	 * @param id
	 * @param direccion
	 * @return
	 */
	public ResultadoDTO addDireccionProveedor(String id, String direccion);
	
	/**
	 * 
	 * Metodo encargado de crear un proveedor 
	 * <b>Caso de Uso</b>
	 * @author mauro
	 * 
	 * @param proveedorDTO
	 * @return
	 */
	public ResultadoDTO crearProveedor(ProveedorDTO proveedorDTO);
	
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
	public ProveedorDTO consultarProveedor(String id) throws Exception;
	
	/**
	 * 
	 * Metodo encargado de consultar una lista de proveedores 
	 * <b>Caso de Uso</b>
	 * @author mauro
	 * 
	 * @return
	 */
	public List<ProveedorDTO> consultarProveedores();
	
	/**
	 * 
	 * Metodo encargado de modificar un de proveedores 
	 * <b>Caso de Uso</b>
	 * @author mauro
	 * 
	 * @param proveedorDTO
	 * @return
	 */
	public ResultadoDTO modificarProveedor(ProveedorDTO proveedorDTO);
	
	/**
	 * 
	 * Metodo encargado de eliminar un proveedor 
	 * <b>Caso de Uso</b>
	 * @author mauro
	 * 
	 * @param id
	 * @return
	 */
	public ResultadoDTO eliminarProveedor(Long id);
	
	/**
	 * 
	 * Metodo encargado de inhabilitar un proveedor 
	 * <b>Caso de Uso</b>
	 * @author mauro
	 * 
	 * @param id
	 * @return
	 */
	public ResultadoDTO inahbilitarProveedor(Long id);
}
