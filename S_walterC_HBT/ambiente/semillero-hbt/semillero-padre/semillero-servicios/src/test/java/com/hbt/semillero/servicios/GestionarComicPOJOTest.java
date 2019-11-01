package com.hbt.semillero.servicios;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.TematicaEnum;
import com.hbt.semillero.pojo.GestionarComicPOJO;

/**
 * 
 * <b>Descripción:<b> Clase test de los comics
 * <b>Caso de Uso:<b> 
 * @author semilleroHBT
 * @version
 */
public class GestionarComicPOJOTest {
	private GestionarComicPOJO comicPOJO = new GestionarComicPOJO();
	
	/**
	 * EJERCICIO SESION 3
	 * Metodo encargado de hacer prueba al metodo de crear comic
	 * <b>Caso de Uso</b>
	 * @author semilleroHBT
	 *
	 */
	@Test
	public void crearComicDTOTest() {
		this.comicPOJO.crearComicDTO();
		Assert.assertNotNull(comicPOJO.getListaComics());
		Assert.assertTrue(comicPOJO.getListaComics().size() >= 1);
		Assert.assertTrue(!comicPOJO.getListaComics().isEmpty());
	}
	
	/**
	 * EJERCICIO SESION 3
	 * Metodo encargado de crear dos comicDTO y agregarlos a una lista, ejercicio sesión tres
	 * <b>Caso de Uso</b>
	 * @author semilleroHBT
	 *
	 */
	@Test
	public void CrearcomicDTOTest() {
		ComicDTO comicDTO = comicPOJO.CrearcomicDTO("2", "Captain America Corps 1-5 USA", "Panini Comics ", TematicaEnum.FANTASTICO, "BIBLIOTECA MARVEL ", 128, new BigDecimal(5000), "Phillippe Briones, Roger Stern ", Boolean.FALSE, LocalDate.now(), EstadoEnum.ACTIVO, 5L);
		this.comicPOJO.agregarComicDTOLista(comicDTO);		
		Assert.assertNotNull(comicPOJO.getListaComics());
		Assert.assertTrue(!comicPOJO.getListaComics().isEmpty());		
		comicDTO = new ComicDTO("3", "The Spectacular Spider-Man v2 USA", "Panini Comics ", TematicaEnum.FANTASTICO, "MARVEL COMICS", 208, new BigDecimal(6225), "Straczynski,Deodato Jr.,Barnes,Eaton", Boolean.TRUE, LocalDate.now(), EstadoEnum.INACTIVO, 0L);
		this.comicPOJO.agregarComicDTOLista(comicDTO);		
		Assert.assertTrue(comicPOJO.getListaComics().size() >= 1);				
	}
	
	/**
	 * EJERCICIO SESION 3
	 * Metodo encargado de modificar el nombre de un comic segun un posicion indicada 
	 * <b>Caso de Uso</b>
	 * @author mauro
	 *
	 */
	@Test
	public void modificarComicDTO() {
		String textoNuevo= "Saint seiya pegasus";
		String textoOriginal = "Captain America Corps 1-5 USA";
		this.comicPOJO.modificarComicDTO("2", textoNuevo);
		System.out.println(textoOriginal);
		System.out.println(comicPOJO.buscarComicDTO("2").getNombre());
		Assert.assertNotEquals(textoOriginal, comicPOJO.buscarComicDTO("2").getNombre());
	}
	
	/**
	 * EJERCICIO SESION 3
	 * Metodo encargado de eliminar un comic de la lista y hacer el test 
	 * <b>Caso de Uso</b>
	 * @author mauro
	 *
	 */
	@Test
	public void eliminarComicDTOTest() {
		Long tamañeVectorEsperado = 2L;
		comicPOJO.eliminarComicDTO("1");
		Assert.assertTrue(comicPOJO.getListaComics().size() == tamañeVectorEsperado);
		Assert.assertTrue(comicPOJO.buscarComicDTO("1") == null);
	}
}