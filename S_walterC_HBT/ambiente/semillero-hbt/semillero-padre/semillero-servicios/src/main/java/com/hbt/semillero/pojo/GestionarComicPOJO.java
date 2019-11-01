package com.hbt.semillero.pojo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.TematicaEnum;

/**
 * 
 * <b>Descripción:<b> Clase que determina <b>Caso de Uso:<b>
 * 
 * @author SemilletoHBT
 * @version
 */
public class GestionarComicPOJO {

	/**
	 * lista de comics
	 */
	private List<ComicDTO> listaComics = null;
	
	/**
	 * 
	 * Metodo encargado de crear un comicDTO y agregarlo a la lista
	 * <b>Caso de Uso</b>
	 * @author SemilletoHBT
	 *
	 */
	public void crearComicDTO() {
		ComicDTO comicDTO = new ComicDTO();
		comicDTO.setId("1");
		comicDTO.setNombre("Dragon Ball Yamcha");
		comicDTO.setAutor("Dragon Garow Lee");
		comicDTO.setCantidad(20L);
		comicDTO.setColeccion("Manga Shonen");
		comicDTO.setColor(Boolean.FALSE);
		comicDTO.setEditorial("Planeta Cómic");
		comicDTO.setEstado(EstadoEnum.ACTIVO);
		comicDTO.setFechaVenta(LocalDate.now());
		comicDTO.setNumeroPaginas(144);
		comicDTO.setPrecio(new BigDecimal(2100));
		comicDTO.setTematica(TematicaEnum.AVENTURAS);
		
		if(listaComics == null) {
			listaComics = new ArrayList<ComicDTO>();
		}
		listaComics.add(comicDTO);
	}
	
	/**
	 * 
	 * Metodo encargado de crear y retornar un comicDTO
	 * <b>Caso de Uso</b>
	 * @author SemilletoHBT
	 * 
	 * @param id
	 * @param nombre
	 * @param editorial
	 * @param tematicaEnum
	 * @param coleccion
	 * @param numeroPaginas
	 * @param precio
	 * @param autor
	 * @param color
	 * @param fechaVenta
	 * @param estado
	 * @param cantidad
	 * @return
	 */
	public ComicDTO CrearcomicDTO(String id, String nombre, String editorial, TematicaEnum tematicaEnum, String coleccion,
			Integer numeroPaginas, BigDecimal precio, String autor,  Boolean color, LocalDate fechaVenta,  EstadoEnum estado,Long cantidad) {
		return new ComicDTO(id, nombre, editorial, tematicaEnum, coleccion, numeroPaginas, precio, autor, color, fechaVenta, estado, cantidad);
	}
	
	/**
	 * 
	 * Metodo encargado de agregar un comicDTO a la lista de comics
	 * <b>Caso de Uso</b>
	 * @author SemilletoHBT
	 * 
	 * @param comicDTO
	 */
	public void agregarComicDTOLista(ComicDTO comicDTO) {
		if(listaComics == null) {
			listaComics = new ArrayList<ComicDTO>();
		}
		listaComics.add(comicDTO);
	}
	
	/**
	 * 
	 * Metodo encargado de buscar por id un comic en la lista y si lo encuentra modiica el nomre
	 * <b>Caso de Uso</b>
	 * @author SemilletoHBT
	 * 
	 * @param id
	 * @param nombre
	 */
	public void modificarComicDTO(String id, String nombre) {
		if(!isListaVacia()) {
			buscarComicDTO(id).setNombre(nombre);
		}
	}
	
	/**
	 * EJERCICIO SESION 3
	 * Metodo encargado de buscar y retornar un comicDTO 
	 * <b>Caso de Uso</b>
	 * @author mauro
	 * 
	 * @param id
	 * @return
	 */
	public ComicDTO buscarComicDTO(String id) {
		ComicDTO comicDTO = null;
		for (ComicDTO comic : listaComics) {
			if(comic.getId().equals(id)) {
				comicDTO = comic;
			}
		}
		return comicDTO;		
	}
	
	/**
	 * EJERCICIO SESION 3
	 * Metodo encargado de eliminar un comicDTO de la lista 
	 * <b>Caso de Uso</b>
	 * @author mauro
	 * 
	 * @param id
	 */
	public void eliminarComicDTO(String id) {
		if(!isListaVacia()) {
			int cont = 0;
			while (cont <= listaComics.size()) {
				if(buscarComicDTO(id) != null) {
					listaComics.remove(buscarComicDTO(id));
					return;
				}				
				cont ++;
			}
		}		
	}
	
	/**
	 * 
	 * Metodo encargado de verificar si una lista esta vacía 
	 * <b>Caso de Uso</b>
	 * @author mauro
	 * 
	 * @return
	 */
	public Boolean isListaVacia() {
		return listaComics.isEmpty();
	}

	/**
	 * Metodo encargado de retornar el valor del atributo listaComics
	 * 
	 * @return El listaComics asociado a la clase
	 */
	public List<ComicDTO> getListaComics() {
		return listaComics;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo listaComics
	 * 
	 * @param listaComics El nuevo listaComics a modificar.
	 */
	public void setListaComics(List<ComicDTO> listaComics) {
		this.listaComics = listaComics;
	}
}