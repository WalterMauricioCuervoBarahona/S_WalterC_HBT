/**
 * GestionarProveedorBean.java
 */
package com.hbt.semillero.ejb;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ProveedorDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.dto.Utilidades;
import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.entidad.EstadoEnum;
import com.hbt.semillero.entidad.Persona;
import com.hbt.semillero.entidad.Proveedor;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author mauro
 * @version 
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarProveedorBean implements IGestionarProveedorLocal{
	
	/**
	 * Atributo em que se usa para interacturar con el contexto de persistencia.
	 */
	@PersistenceContext
	private EntityManager em;

	/** 
	 * @see com.hbt.semillero.ejb.IGestionarProveedorLocal#addDireccionProveedor(java.lang.String, java.lang.String)
	 */
	@Override
	public ResultadoDTO addDireccionProveedor(String id, String direccion) {
		Proveedor proveedor = buscarProveedor(Long.parseLong(id));
		if(proveedor != null) {
			proveedor.setDireccion(direccion);
			em.merge(proveedor);
			return new ResultadoDTO(Boolean.TRUE, "se ha modificado exitosamente la direccion proveedor");
		}
		return new ResultadoDTO(Boolean.TRUE, "se ha modificado la direccion proveedor");
	}

	/** 
	 * @see com.hbt.semillero.ejb.IGestionarProveedorLocal#crearProveedor(com.hbt.semillero.dto.ProveedorDTO)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	@Override
	public ResultadoDTO crearProveedor(ProveedorDTO proveedorDTO, Long id) {
		if(proveedorDTO != null) {
			Persona persona = em.find(Persona.class, id);
			Proveedor proveedorNuevo = convertirProveedorDTOToProveedor(proveedorDTO);
			proveedorNuevo.setPersona(persona);
			List<String> listNombres = em.createQuery("select p.nombre from Persona p").getResultList();
			Boolean verificar = Utilidades.isNombreRepetido(listNombres, proveedorNuevo.getPersona().getNombre());
				em.persist(proveedorNuevo);
				return new ResultadoDTO(Boolean.TRUE, "se ha creado exitosamente el proveedor");
		}
		return new ResultadoDTO(Boolean.FALSE, "No se ha podico crear el proveedor");
	}

	/** 
	 * @see com.hbt.semillero.ejb.IGestionarProveedorLocal#consultarProveedor(java.lang.Long)
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ProveedorDTO consultarProveedor(String id) throws Exception{
		Proveedor proveedor = new Proveedor(); 
		proveedor = buscarProveedor(Long.parseLong(id));
		if(proveedor != null) {
			return convertirProveedorToProveedorDTO(proveedor);
		}
			throw new Exception("no se ha podido encontrar al proveedor ");
	}

	/** 
	 * @see com.hbt.semillero.ejb.IGestionarProveedorLocal#consultarProveedores()
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ProveedorDTO> consultarProveedores() {
		Persona persona = new Persona();
		List<ProveedorDTO> list = new ArrayList<ProveedorDTO>();
		List<Proveedor> resultado = em.createQuery("select p from Proveedor p").getResultList();
		for (Proveedor proveedor : resultado) {
			list.add(convertirProveedorToProveedorDTO(proveedor));
		}
		return list;
	}

	/** 
	 * @see com.hbt.semillero.ejb.IGestionarProveedorLocal#modificarProveedor(com.hbt.semillero.dto.ProveedorDTO)
	 */
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ResultadoDTO modificarProveedor(BigDecimal monto, String nombre, Long id) {
		Proveedor proveedorM = buscarProveedor(id);
		if(proveedorM != null) {
			proveedorM.setMontoCredito(monto);
			proveedorM.getPersona().setNombre(nombre);
//			proveedorM = convertirProveedorDTOToProveedor(proveedorDTO);
			em.merge(proveedorM);
			return new ResultadoDTO(Boolean.TRUE, "Proveedor modificado exitosamente");
		}else {
			return new ResultadoDTO(Boolean.FALSE, "No se pudo modificar el Proveedor");
		}
	}
	
	/*
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ResultadoDTO modificarProveedor(ProveedorDTO proveedorDTO) {
		
		Proveedor proveedorM = buscarProveedor(Long.parseLong(proveedorDTO.getId()));
		if(proveedorM != null) {
			
		//	proveedorM.setMontoCredito(monto);
		//	proveedorM.getPersona().setNombre(nombre);
			proveedorM = convertirProveedorDTOToProveedor(proveedorDTO);
			em.merge(proveedorM);
			return new ResultadoDTO(Boolean.TRUE, "Proveedor modificado exitosamente");
		}else {
			return new ResultadoDTO(Boolean.FALSE, "No se pudo modificar el Proveedor");
		}
	}*/

	/** 
	 * @see com.hbt.semillero.ejb.IGestionarProveedorLocal#eliminarProveedor(java.lang.Long)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ResultadoDTO eliminarProveedor(Long id) {
		Proveedor proveedor = buscarProveedor(id);
		if(proveedor != null) {
			em.remove(proveedor);
			return new ResultadoDTO(Boolean.TRUE, "Se ha eliminado exitosamente el Proveedor");
		}
		return new ResultadoDTO(Boolean.FALSE, "No se ha eliminado el Proveedor");
	}

	/** 
	 * @see com.hbt.semillero.ejb.IGestionarProveedorLocal#inahbilitarProveedor(java.lang.Long)
	 */
	@Override
	public ResultadoDTO inahbilitarProveedor(Long id) {
		Proveedor proveedor = buscarProveedor(id);
		if(proveedor != null) {
			proveedor.setEstadoEnum(EstadoEnum.INACTIVO);
			em.merge(proveedor);
			return new ResultadoDTO(Boolean.TRUE, "Se ha inhabilitado exitosamente el Proveedor");
		}
		return new ResultadoDTO(Boolean.FALSE, "No se ha inahbilitado el Proveedor");
	}

	/**
	 * 
	 * Metodo encargado de convertir un proveedorDTO a provedor 
	 * <b>Caso de Uso</b>
	 * @author mauro
	 * 
	 * @param proveedorDTO
	 * @return
	 */
	private Proveedor convertirProveedorDTOToProveedor(ProveedorDTO proveedorDTO) {
		Proveedor proveedor = new Proveedor();
		if(proveedorDTO.getId() != null) {
			proveedor.setId(Long.parseLong(proveedorDTO.getId()));
		}
		proveedor.setDireccion(proveedorDTO.getDireccion());
		proveedor.setEstadoEnum(proveedorDTO.getEstadoEnum());
		proveedor.setFechaCreacion(proveedorDTO.getFechaCreacion());
		proveedor.setMontoCredito(proveedorDTO.getMontoCredito());
		//proveedor.setPersona(proveedorDTO.getPersona());
		return proveedor;
	}

	/**
	 * 
	 * Metodo encargado de convertir un provedor a proveedorDTO  
	 * <b>Caso de Uso</b>
	 * @author mauro
	 * 
	 * @param proveedor
	 * @return
	 */
	private ProveedorDTO convertirProveedorToProveedorDTO(Proveedor proveedor) {
		ProveedorDTO proveedorDTO = new ProveedorDTO();
		if (proveedor.getId() != null) {
			proveedorDTO.setId(proveedor.getId().toString());
		}
		proveedorDTO.setDireccion(proveedor.getDireccion());
		proveedorDTO.setEstadoEnum(proveedor.getEstadoEnum());
		proveedorDTO.setFechaCreacion(proveedor.getFechaCreacion());
		proveedorDTO.setMontoCredito(proveedor.getMontoCredito());	
		//proveedorDTO.setPersona(proveedor.getPersona());
		
		return proveedorDTO;
	}

	/**
	 * 
	 * Metodo encargado de buscar un proveedor,
	 * de Uso</b>
	 * 
	 * @author Walter Cuervo
	 * 
	 * @param id
	 * @return
	 */
	private Proveedor buscarProveedor(Long id) {
		return id != null ? em.find(Proveedor.class, id) : null;
	}

}
