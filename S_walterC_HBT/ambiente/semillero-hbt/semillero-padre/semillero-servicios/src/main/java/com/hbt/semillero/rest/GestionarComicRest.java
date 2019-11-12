package com.hbt.semillero.rest;

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
import com.hbt.semillero.ejb.IGestionarComicLocal;

/**
 * 
 * <b>Descripción:<b> Clase que permite llamar los servicios rest de gestionar un comic
 * <b>Caso de Uso:<b> 
 * @author SemilleroHBT2019
 * @version
 */
@Path("/GestionarComic")
public class GestionarComicRest {
	
	/**
	 * atributo del bean gestionar Comic
	 */
	@EJB
	private IGestionarComicLocal gestionarComicEJB;
	
	/**
	 * 
	 * Metodo encargado de mostrar un mensaje rest
	 * <b>Caso de Uso</b>
	 * @author SemilleroHBT2019
	 * 
	 * @return
	 */
	@GET
	@Path("/saludo")
	@Produces(MediaType.APPLICATION_JSON)
	public String miPrimerRest() {
		return "Hola mundo";
	}
	
	/**
	 * 
	 * Metodo encargado de mostrar un comicDTO en el rest
	 * <b>Caso de Uso</b>
	 * @author SemilleroHBT2019
	 * 
	 * @param idComic, necesario para buscar el comic
	 * @return
	 */
	@GET
	@Path("/consultarComic")
	@Produces(MediaType.APPLICATION_JSON)
	public ComicDTO consultarComic(@QueryParam("idComic")Long idComic) {
		if(idComic != null) {
			return gestionarComicEJB.consultarComic(idComic.toString());
		}
		return null;
	}
	
	/**
	 * 
	 * Metodo encargado de crear un comic y persistirlo, además de crear y retornat un comicDTO en el rest, recibe y envía un comicDTO en formato JSON
	 * <b>Caso de Uso</b>
	 * @author Walter Cuervo
	 * 
	 * @param comicDTO
	 * @return
	 */
	@POST
	@Path("/crearComic")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ComicDTO crearComic(ComicDTO comicDTO) {
		Long idComic = gestionarComicEJB.createComic(comicDTO).getId(); 
		return gestionarComicEJB.consultarComic(idComic.toString());		
	}	
	
	/**
	 * 
	 * Metodo encargado de eliminar un comic y persistirlo, ademas retorna un comicDTO para mostrarlo en el rest y saber cuál se elimino
	 * 
	 * <b>Caso de Uso</b>
	 * @author Walter Cuervo
	 * 
	 * @param idComic, query para especificar el comic a eliminar
	 * @return
	 */
	@DELETE
	@Path("/eliminarComic")
	@Produces(MediaType.APPLICATION_JSON)
	public ComicDTO eliminarComic(@QueryParam("id")Long idComic) {
		 return gestionarComicEJB.deleteComic(idComic);
	}
	
	/**
	 * 
	 * Metodo encargado de editar un comic y persistirlo, luego se crea y retorna un comicDTO en el rest
	 * <b>Caso de Uso</b>
	 * @author Walter Cuervo
	 * 
	 * @param comicDTO, parametro comicDTO que va a modificar el comic
	 * @return
	 */
	@PUT
	@Path("/editarComic")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ComicDTO editarComic(ComicDTO comicDTO) {
		return gestionarComicEJB.modificateComic(comicDTO);
	}	
}