/**
 * GestionarComicRest.java
 */
package com.hbt.semillero.rest;

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
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.ejb.IGestionarComicLocal;

/**
 * <b>Descripción:<b> Clase que determina el servicio rest que permite gestionar
 * un comic
 * 
 * @author ccastano
 * @version
 */
@Path("/GestionarComic")
public class GestionarComicRest {

	/**
	 * Atriburo que permite gestionar un comic
	 */
	@EJB
	private IGestionarComicLocal gestionarComicEJB;

	/**
	 * 
	 * Metodo encargado de traer la informacion de un comic determiando
	 * http://localhost:8085/semillero-servicios/rest/GestionarComic/saludo
	 * 
	 * @param idComic
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
	 * Metodo encargado de traer la informacion de un comic determiando
	 * http://localhost:8085/semillero-servicios/rest/GestionarComic/consultarComic?idComic=1
	 * 
	 * @param idComic
	 * @return
	 * @throws Exception 
	 */
	@GET
	@Path("/consultarComic")
	@Produces(MediaType.APPLICATION_JSON)
	public ComicDTO consultarComic(@QueryParam("idComic") Long idComic) throws Exception {
			 return gestionarComicEJB.consultarComic(idComic.toString());
	}

	/**
	 * 
	 * Metodo encargado de traer la informacion de una lista de comic´s
	 * http://localhost:8085/semillero-servicios/rest/GestionarComic/consultarComics
	 * 
	 * @param idComic
	 * @return
	 */
	@GET
	@Path("/consultarComics")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ComicDTO> consultarComic() {
		return gestionarComicEJB.consultarComics();

	}

	/**
	 * Crea un comic
	 * http://localhost:8085/semillero-servicios/rest/GestionarComic/crear
	 * @param persona
	 * @return
	 */
	@POST
	@Path("/crear")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearComic(ComicDTO comicDTO) {
		return gestionarComicEJB.crearComic(comicDTO);		
	}

	/**
	 * 
	 * Metodo encargado de eliminar un comic dado el id
	 * 
	 * @param idComic identificador del comic
	 * @throws Exception 
	 */
	@DELETE
	@Path("/eliminar")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultadoDTO eliminarComic(@QueryParam("idComic") Long idComic) {
			return gestionarComicEJB.eliminarComic(idComic);
	}
	
	/**
	 * 
	 * Metodo encargado de modificar un comic
	 * http://localhost:8085/semillero-servicios/rest/GestionarComic/modificar?idComic=1&nombre=nuevonombre
	 * @param idComic identificador del comic a buscar
	 * @param nombre nombre nuevo del comic
	 */
	@PUT
	@Path("/modificar")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultadoDTO modificarComic(ComicDTO comicDTO) {
		return gestionarComicEJB.modificarComic(comicDTO);
	}

}
