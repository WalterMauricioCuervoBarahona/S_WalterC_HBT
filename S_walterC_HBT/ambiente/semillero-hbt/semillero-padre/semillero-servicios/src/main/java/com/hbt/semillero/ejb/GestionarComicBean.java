package com.hbt.semillero.ejb;

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
 * <b>Descripción:<b> Clase que utilizara servicio rest
 * <b>Caso de Uso:<b> 
 * @author mauro
 * @version
 */
@Stateless
public class GestionarComicBean {
	
	@PersistenceContext
	private EntityManager em;
	
	//TODO
	/**
	 * agregar interface y comentarios
	 * 
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crearComic(ComicDTO comicDTO) {
	      Comic comic = new Comic();
	        comic.setId(comicDTO.getId());
	        
	        //TODO
	        /**
	         * llenar los demás datos
	         */
		em.persist(comic);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void modificarComic(Comic comicModificar) {
		Comic comic = new Comic();
		comic.setId(comicModificar.getId());
		em.merge(comic);
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public ComicDTO consultarComic(String idComic) {
		Comic comic = em.find(Comic.class, idComic); 
		ComicDTO comicDTO = new ComicDTO(comic.getId(), comic.getNombre());
		return comicDTO;		
	}
	
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<ComicDTO> consultarComic() {
		List<Comic> resultados = (List<Comic>) em.createQuery("select c from Comic").getResultList();
		return null;
	}

}
