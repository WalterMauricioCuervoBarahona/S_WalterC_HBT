package com.hbt.semillero.rest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
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
	 * atributo de la interace rest
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
	 * Metodo encargado de mostrar un comic en el navegador
	 * <b>Caso de Uso</b>
	 * @author SemilleroHBT2019
	 * 
	 * @param idComic
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
}