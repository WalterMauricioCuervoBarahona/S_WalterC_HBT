/**
 * GestionarComicBean.java
 */
package com.hbt.semillero.ejb;
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
import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.entidad.Proveedor;

/**
 * <b>Descripción:<b> Clase que determina el bean para realizar las gestion de
 * los comics
 * 
 * @author ccastano
 * @version
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarComicBean implements IGestionarComicLocal {

	/**
	 * Atributo em que se usa para interacturar con el contexto de persistencia.
	 */
	@PersistenceContext
	private EntityManager em;

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#consultarComic(java.lang.String)
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ComicDTO consultarComic(String idComic) throws Exception {
		Comic comic = new Comic();
		comic = buscarComic(Long.parseLong(idComic));
		if(comic != null) {
			return convertirComicToComicDTO(comic);
		}else {
			throw new Exception("no se ha podido encontrar al comic " + idComic);
		}		
	}

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#consultarComics()
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ComicDTO> consultarComics() {
		List<ComicDTO> resultadosComicDTO = new ArrayList<ComicDTO>();
		List<Comic> resultados = em.createQuery("select c from Comic c").getResultList();
		for (Comic comic : resultados) {
			resultadosComicDTO.add(convertirComicToComicDTO(comic));
		}
		return resultadosComicDTO;
	}

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#crearComic(com.hbt.semillero.dto.ComicDTO)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public ResultadoDTO crearComic(ComicDTO comicNuevo) {
		if(comicNuevo != null) {
			Comic comic = convertirComicDTOToComic(comicNuevo);
			em.persist(comic);
			return new ResultadoDTO(Boolean.TRUE, "se ha creado exitosamente el comic");
		}
		return new ResultadoDTO(Boolean.FALSE, "No se ha podico crear el comci");
	}
	
	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#eliminarComic(java.lang.Long)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ResultadoDTO eliminarComic(Long idComic) {
		Comic comicEliminar = buscarComic(idComic);
		if (comicEliminar != null) {
			em.remove(comicEliminar);
			return new ResultadoDTO(Boolean.TRUE, "Se ha eliminado exitosamente el comic");
		}
		return new ResultadoDTO(Boolean.FALSE, "No se ha eliminado el comic");
	}
	
	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#modificarComic(com.hbt.semillero.dto.ComicDTO)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ResultadoDTO modificarComic(ComicDTO comicNuevo) {
		Comic comicModificar = buscarComic(Long.parseLong(comicNuevo.getId()));
		if (comicModificar != null) {
			comicModificar = convertirComicDTOToComic(comicNuevo);
			em.merge(comicModificar);
			return new ResultadoDTO(Boolean.TRUE, "Comic modificado exitosamente");
		} else {
			return new ResultadoDTO(Boolean.FALSE, "No se pudo modificar el comic");
		}		
	}

	/**
	 * 
	 * Metodo encargado de transformar un comic a un comicDTO
	 * 
	 * @param comic
	 * @return
	 */
	private ComicDTO convertirComicToComicDTO(Comic comic) {
		ComicDTO comicDTO = new ComicDTO();
		if (comic.getId() != null) {
			comicDTO.setId(comic.getId().toString());
		}
		comicDTO.setNombre(comic.getNombre());
		comicDTO.setEditorial(comic.getEditorial());
		comicDTO.setTematicaEnum(comic.getTematicaEnum());
		comicDTO.setColeccion(comic.getColeccion());
		comicDTO.setNumeroPaginas(comic.getNumeroPaginas());
		comicDTO.setPrecio(comic.getPrecio());
		comicDTO.setAutores(comic.getAutores());
		comicDTO.setColor(comic.getColor());
		comicDTO.setFechaVenta(comic.getFechaVenta());
		comicDTO.setEstadoEnum(comic.getEstadoEnum());
		comicDTO.setCantidad(comic.getCantidad());
		return comicDTO;
	}

	/**
	 * 
	 * Metodo encargado de transformar un comicDTO a un comic
	 * 
	 * @param comic
	 * @return
	 */
	private Comic convertirComicDTOToComic(ComicDTO comicDTO) {
		Comic comic = new Comic();
		if (comicDTO.getId() != null) {
			comic.setId(Long.parseLong(comicDTO.getId()));
		}
		comic.setNombre(comicDTO.getNombre());
		comic.setEditorial(comicDTO.getEditorial());
		comic.setTematicaEnum(comicDTO.getTematicaEnum());
		comic.setColeccion(comicDTO.getColeccion());
		comic.setNumeroPaginas(comicDTO.getNumeroPaginas());
		comic.setPrecio(comicDTO.getPrecio());
		comic.setAutores(comicDTO.getAutores());
		comic.setColor(comicDTO.getColor());
		comic.setFechaVenta(comicDTO.getFechaVenta());
		comic.setEstadoEnum(comicDTO.getEstadoEnum());
		comic.setCantidad(comicDTO.getCantidad());
		return comic;
	}

	/**
	 * 
	 * Metodo encargado de buscar un comic, COMPLEMENTO PARA TAREA SESION 4 <b>Caso
	 * de Uso</b>
	 * 
	 * @author Walter Cuervo
	 * 
	 * @param idComic
	 * @return
	 */
	private Comic buscarComic(Long idComic) {
		return idComic != null ? em.find(Comic.class, idComic) : null;
	}
}