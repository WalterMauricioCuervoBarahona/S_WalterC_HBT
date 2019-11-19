package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ResultadoDTO;

/**
 * Expone los métodos del EJB GestionarComic Las interfaces determinan una
 * especie de contrato donde se define las firmas de los metodos, define que se
 * necesita implementar pero no el como eso lo realiza la clase que la
 * implementa Palabras claves interface e implements
 * 
 * @author ccastano
 *
 */
@Local
public interface IGestionarComicLocal {
	
	/**
	 * 
	 * Metodo encargado de retornar la informacion de un comic
	 * 
	 * @param idComic identificador del comic a ser consultado
	 * @return comic Resultado de la consulta
	 * @throws Exception si no se recibe idComic
	 */
	public ComicDTO consultarComic(String idComic) throws Exception;
	
	/**
	 * 
	 * Metodo encargado de retornar una lista de comics
	 * 
	 * @return
	 */
	public List<ComicDTO> consultarComics();

	/**
	 * 
	 * Metodo encargado de crear un comic y persistirlo y retornar un resultado
	 * 
	 * @author ccastano
	 * 
	 * @param comicNuevo informacion nueva a crear
	 * @throws  
	 */
	public ResultadoDTO crearComic(ComicDTO comicNuevo);
	
	/**
	 * 
	 * Metodo encargado de eliminar un comic y retornar un resultado
	 * 
	 * @author ccastano
	 * 
	 * @param comicEliminar informacion a eliminar
	 */
	public ResultadoDTO eliminarComic(Long idComic);

	/**
	 * 
	 * Metodo encargado de modificarlo un comic y retornar un resultado
	 * 
	 * @author ccastano
	 * 
	 * @param comicModificar informacion nueva a modificar
	 */
	public ResultadoDTO modificarComic(ComicDTO comicNuevo);
}
