package com.hbt.semillero.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.Comic;
/**
 * Para empezar la comunicacion entre la base de datos
 * y la aplicacion
 * */
@Stateless
public class GestionarComicBean implements IGestionarComicLocal {
	//CMT	
	@PersistenceContext
    private EntityManager em;
	
	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#crearComic(com.hbt.semillero.dto.ComicDTO)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearComic(ComicDTO comicDTO) {
		Comic comic = convertirComicDTOtoComic(comicDTO);
		em.persist(comic);
	}	
	
	
	/*
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ComicDTO> consultarTodos(){
		//em.createNativeQuery("SELECT c FROM Comic").getResultList();
		List<Comic> resultados = (List<Comic>) em.createQuery("select c from Comic").getResultList();
		return null;
	}*/

	/**
	 * metodo que modifica un comic
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#modificarComic(java.lang.Long, java.lang.String, com.hbt.semillero.dto.ComicDTO)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void modificarComic(Long id, String nombre, ComicDTO comicNuevo) {
		Comic comicModificar;
		if(comicNuevo == null) {
			comicModificar = em.find(Comic.class, id);
		}else {
			comicModificar = convertirComicDTOtoComic(comicNuevo);
		}
		if(nombre != null) {
			comicModificar.setNombre(nombre);
			em.merge(comicModificar);
		}
	}
	
	
	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#consultarComics()
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ComicDTO> consultarComics() {
		List<ComicDTO> resultadosComicDTO = new ArrayList<ComicDTO>(); // conjunto de elementos que almacena datos con cierto orden
		List<Comic> resultados = em.createQuery("select c from Comic c").getResultList();// c hace referencia a toda la entidad
		for(Comic comic: resultados) {
			resultadosComicDTO.add(convertirComicToComicDTO(comic));
		}
		return resultadosComicDTO;
	}
		
	/**
	 * 
	 * Metodo encargado de traspasar informacion, no persiste entonces no tiene el entityManager, convierte un comicDTO a un comic
	 * <b>Caso de Uso</b>
	 * @author SemilleroHBT2019
	 * 
	 * @param comicDTO
	 * @return
	 */
	private Comic convertirComicDTOtoComic (ComicDTO comicDTO ) {
		Comic comic = new Comic();
        if(comicDTO.getId()!=null) {
            comic.setId(Long.parseLong(comicDTO.getId()));
        }
        comic.setNombre(comicDTO.getNombre());
        comic.setEditorial(comicDTO.getEditorial());
        comic.setTematicaEnum(comicDTO.getTematica());
        comic.setColeccion(comicDTO.getColeccion());
        comic.setNumeroPaginas(comicDTO.getNumeroPaginas());
        comic.setPrecio(comicDTO.getPrecio());
        comic.setAutores(comicDTO.getAutor());
        comic.setColor(comicDTO.getColor());
        comic.setFechaVenta(comicDTO.getFechaVenta());
        comic.setEstadoEnum(comicDTO.getEstado());
        comic.setCantidad(comicDTO.getCantidad());
        return comic;
	}
	
	private ComicDTO convertirComicToComicDTO(Comic comic) {
        ComicDTO comicDTO = new ComicDTO();
        if(comic.getId()!=null) {
         comicDTO.setId(comic.getId().toString());
        }
        comicDTO.setNombre(comic.getNombre());
        comicDTO.setEditorial(comic.getEditorial());
        comicDTO.setTematica(comic.getTematicaEnum());
        comicDTO.setColeccion(comic.getColeccion());
        comicDTO.setNumeroPaginas(comic.getNumeroPaginas());
        comicDTO.setPrecio(comic.getPrecio());
        comicDTO.setAutor(comic.getAutores());
        comicDTO.setColor(comic.getColor());
        comicDTO.setFechaVenta(comic.getFechaVenta());
        comicDTO.setEstado(comic.getEstadoEnum());
        comicDTO.setCantidad(comic.getCantidad());
        return comicDTO;
    }
	
	/**
	 * 
	 * Metodo encargado de buscar un comic, COMPLEMENTO PARA TAREA SESION 4
	 * <b>Caso de Uso</b>
	 * @author Walter Cuervo
	 * 
	 * @param idComic
	 * @return
	 */
	private Comic buscarComic(Long idComic) {
		return idComic != null ? em.find(Comic.class, idComic) : null;
	}
	
	/**
	 * metodo que elimina un comic,  TAREA SESIÓN 4 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#eliminarComic(java.lang.Long)
	 */
	@Override
	public void eliminarComic(Long idComic) {
		Comic comicEliminar = buscarComic(idComic);
		if(comicEliminar != null) {
			em.remove(comicEliminar);	
		}		
	}
	
	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#createComic(com.hbt.semillero.dto.ComicDTO)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Comic createComic(ComicDTO comicDTO) {
		Comic comic = convertirComicDTOtoComic(comicDTO);
		em.persist(comic);
		return comic;
	}
	
	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#consultarComic(java.lang.String)
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ComicDTO consultarComic(String idComic) {
		Comic comic = em.find(Comic.class,Long.parseLong(idComic));		
		ComicDTO comicDTO = convertirComicToComicDTO(comic);
		return comicDTO;
	}
	
	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#modificateComic(com.hbt.semillero.dto.ComicDTO)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ComicDTO modificateComic(ComicDTO comicDTO) {
		Comic comicModificar = buscarComic(Long.valueOf(comicDTO.getId()));
		if(comicModificar != null) {
			comicModificar = convertirComicDTOtoComic(comicDTO);
			em.merge(comicModificar);
		}
		return convertirComicToComicDTO(comicModificar);		
	}
	
	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#deleteComic(java.lang.Long)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public ComicDTO deleteComic(Long idComic) {
		ComicDTO comicDTO = consultarComic(idComic.toString());
		eliminarComic(idComic);
		return comicDTO;
	}
}