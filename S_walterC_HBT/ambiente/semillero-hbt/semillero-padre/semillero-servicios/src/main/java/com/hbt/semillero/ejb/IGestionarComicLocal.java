package com.hbt.semillero.ejb;

	import java.util.List;

	import javax.ejb.Local;

	import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.Comic;

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
		 * Metodo encargado de crear un comic y persistirlo
		 * 
		 * @author ccastano
		 * 
		 * @param comicNuevo informacion nueva a crear
		 */
		public void crearComic(ComicDTO comicNuevo);
		
		/**
		 * 
		 * Metodo encargado de consultar un comic modificarlo y guardarlo
		 * 
		 * @author ccastano
		 * 
		 * @param comicModificar informacion nueva a modificar
		 */
		public void modificarComic(Long id, String nombre, ComicDTO comicNuevo);

		/**
		 * 
		 * Metodo encargado de eliminar un comic modificarlo y guardarlo
		 * 
		 * @author ccastano
		 * 
		 * @param comicEliminar informacion a eliminar
		 */
		public void eliminarComic(Long idComic);

		/**
		 * 
		 * Metodo encargado de retornar la informacion de un comic
		 * 
		 * @param idComic identificador del comic a ser consultado
		 * @return comic Resultado de la consulta
		 * @throws Exception si no se recibe idComic
		 */
		public ComicDTO consultarComic(String idComic);
		
		/**
		 * 
		 * Metodo encargado de retornar una lista de comics
		 * 
		 * @return
		 */
		public List<ComicDTO> consultarComics();
		
		/**
		 * 
		 * Metodo encargado de crear un comic y persistirlo, ademas lo retorna para saber si el servicio fue exitoso
		 * <b>Caso de Uso</b>
		 * @author Walter Cuervo
		 * 
		 * @param comicDTO
		 * @return Comic creado
		 */
		public Comic createComic(ComicDTO comicDTO);
		
		/**
		 * 
		 * Metodo encargado de eliminar un comic y persistirlo, además lo retorna para saber si fue exitoso el servicio
		 * <b>Caso de Uso</b>
		 * @author Walter Cuervo
		 * 
		 * @param idComic
		 * @return Comic eliminado
		 */
		public ComicDTO deleteComic(Long idComic);
		
		/**
		 * 
		 * Metodo encargado de modificar un comic y persistirlo, además lo retorna para saber si fue exitoso. 
		 * <b>Caso de Uso</b>
		 * @author Walter Cuervo
		 * 
		 * @param comicDTO
		 * @return Comic eliminado
		 */
		public ComicDTO modificateComic(ComicDTO comicDTO);		
}
