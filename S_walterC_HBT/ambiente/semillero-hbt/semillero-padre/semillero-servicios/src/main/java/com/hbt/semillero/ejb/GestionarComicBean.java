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
 * 
 * <b>Descripción:<b> Clase que implememnta una interface para gestionar metodos del comic
 * <b>Caso de Uso:<b> 
 * @author mauro
 * @version
 */
@Stateless
public class GestionarComicBean implements IGestionarComicLocal{
	/**
	 * atributo que contiene la interfaz EntityManager
	 */
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * metodo que crea un comic
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#crearComic(com.hbt.semillero.dto.ComicDTO)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearComic(ComicDTO comicDTO) {
	      Comic comic = convertirComicDTOToComic(comicDTO);
	      em.persist(comic);
	}
	
	/**
	 * 
	 * Metodo encargado de modiicar un comic
	 * <b>Caso de Uso</b>
	 * @author SemilleroHBT2019
	 * 
	 * @param comicModificar
	 */
	/*
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void modificarComic(Comic comicModificar) {
		Comic comic = new Comic();
		comic.setId(comicModificar.getId());
		em.merge(comic);
	}*/
	
	/**
	 * metodo encargado de crear un comicDTO
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#consultarComic(java.lang.String)
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public ComicDTO consultarComic(String idComic) {
		Comic comic = em.find(Comic.class, idComic); 
		ComicDTO comicDTO = convertirComicToComicDTO(comic);
		return comicDTO;		
	}	
	
	/**
	 * 
	 * Metodo encargado de 
	 * <b>Caso de Uso</b>
	 * @author SemilleroHBT2019
	 * 
	 * @return
	 */
	/*
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<ComicDTO> consultarComic() {
		List<Comic> resultados = (List<Comic>) em.createQuery("select c from Comic").getResultList(); 
		return null;
	}*/

	/**
	 * metodo que modifica un comic
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#modificarComic(java.lang.Long, java.lang.String, com.hbt.semillero.dto.ComicDTO)
	 */
	//@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void modificarComic(Long id, String nombre, ComicDTO comicNuevo) {
				//TODO
		//cual es el resultado del llamar modificarComic
		Comic comicModificar;
		if(comicNuevo == null) {
			comicModificar = em.find(Comic.class, id); //manejar la entidad para que el entityManager pueda manejarla
		}else {
			comicModificar = convertirComicDTOToComic(comicNuevo);
		}
		//TODO
		//validar si el parametro llega con un valor
		comicModificar.setNombre(nombre);
		em.merge(comicModificar);
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
	 * metodo encargado de consultar una lista de comics
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#consultarComics()
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	//TODO
	//hacer que la lista de resultados sea null y mirar que pasa
	public List<ComicDTO> consultarComics() {
		List<ComicDTO> resultadosComicDTO = new ArrayList<ComicDTO>();
		List<Comic> resultados = em.createQuery("select c from Comic c").getResultList();//permite realizar consultas de forma nativa y obtener
		for (Comic comic : resultados) {
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
	private Comic convertirComicDTOToComic(ComicDTO comicDTO) {
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
	
	/**
	 * 
	 * Metodo encargado de convertir un comic a comicDTO
	 * <b>Caso de Uso</b>
	 * @author SemilleroHBT2019
	 * 
	 * @param comic
	 * @return
	 */
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
		if(idComic != null) {
			return em.find(Comic.class, idComic); //busca una entidad comic con la llave primaria
		}
		return null;
	}

}
