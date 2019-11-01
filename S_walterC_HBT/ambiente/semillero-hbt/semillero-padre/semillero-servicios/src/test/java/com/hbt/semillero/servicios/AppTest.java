package com.hbt.semillero.servicios;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.hbt.semillero.entidades.Comic;
import com.hbt.semillero.entidades.EstadoEnum;

/**
 * 
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author SemilletoHBT
 * @version
 */
public class AppTest {
	
	/**
	 * atributo enum que representa un estado
	 */
	private EstadoEnum estadoEnum;
	
	/**
	 * 
	 * Metodo encargado de 
	 * <b>Caso de Uso</b>
	 * @author SemilletoHBT
	 *
	 */
	public void shouldAnswerWithTrue() {

	}
		
	/**
	 * EJERCICIO SESION 2
	 * Metodo encargado de gestionar los datos de la clase EstadoEnum, ademas de realizar unas pruebas unitaria y mostrar los datos
	 * <b>Caso de Uso</b>
	 * @author walter cuervo
	 *
	 */
	@Test(enabled=false)
	public void gestionEstadoEnumTest() {
		this.estadoEnum = EstadoEnum.ACTIVO;
        String nombre = nombreEstadoEnum(estadoEnum);
        String nombreEsperado = "enum.estado.activo";
        int posicion = posicionEstadoEnum(estadoEnum);
        int posicionEsperado = 0;
        EstadoEnum[] lista = listaEstadoEnum(estadoEnum);
        
        Assert.assertEquals(nombre, nombreEsperado);
        Assert.assertEquals(posicion, posicionEsperado);
        Assert.assertTrue(compararEstadoEnum(estadoEnum, lista, posicion));
        
        System.out.println("El nombre es: " + nombre);
        System.out.println("La posición es: " + posicion);
        System.out.println("los elementos del enumerados son: ");
        mostrarListaEnum(lista);
        System.out.println("la posicion de la variable y del enum son las mismas: " + compararEstadoEnum(estadoEnum, lista, posicion));
	}
	
	/**
	 * 
	 * Metodo encargado de retornar una posicion segun un enumerado
	 * <b>Caso de Uso</b>
	 * @author walter cuervo
	 * 
	 * @param estadoEnum
	 * @return
	 */
	public int posicionEstadoEnum(EstadoEnum estadoEnum) {
		return estadoEnum.ordinal();
	}
	
	/**
	 * 
	 * Metodo encargado de retornar un nombre segun un enumerado
	 * <b>Caso de Uso</b>
	 * @author walter cuervo
	 * 
	 * @param estadoEnum
	 * @return
	 */
	public String nombreEstadoEnum(EstadoEnum estadoEnum) {
		return estadoEnum.getCodigoMensaje();
	}
	
	/**
	 * 
	 * Metodo encargado de retornar una lista con los valores que tenga una clase enumerado
	 * <b>Caso de Uso</b>
	 * @author walter cuervo
	 * 
	 * @param estadoEnum
	 * @return
	 */
	public EstadoEnum[] listaEstadoEnum(EstadoEnum estadoEnum) {
		return estadoEnum.values();
	}
	
	/**
	 * 
	 * Metodo encargado de de comparar si el parametro enum es el mismo orden del declarado
	 * <b>Caso de Uso</b>
	 * @author walter cuervo
	 * 
	 * @param estadoEnum
	 * @param lista
	 * @param posicion
	 * @return
	 */
	public Boolean compararEstadoEnum(EstadoEnum estadoEnum, EstadoEnum[] lista, int posicion) {
		return estadoEnum.getCodigoMensaje().equals(lista[posicion].getCodigoMensaje());
	}
	
	/**
	 * 
	 * Metodo encargado de mostrar una lista de enumerados
	 * <b>Caso de Uso</b>
	 * @author Walter cuervo
	 * 
	 * @param lista
	 */
	public void mostrarListaEnum(EstadoEnum[] lista) {
		 for (int i = 0; i < lista.length ; i++) {
	            System.out.println(lista[i].getCodigoMensaje());
	        }
	}	

	/**
	 * 
	 * Metodo encargado de 
	 * <b>Caso de Uso</b>
	 * @author SemilletoHBT
	 * 
	 * @param cadena
	 * @return
	 */
	private String invertirCadena(String cadena) {
		String cadenaInvertida = "";
		for (int x = cadena.length() - 1; x >= 0; x--) {
			cadenaInvertida = cadenaInvertida + cadena.charAt(x);
		}
		return cadenaInvertida;
	}

	
	/**
	 * EJERCICIO SESION 1
	 * Metodo encargado de realizar pruebas unitarias al metodo invertirCadena
	 * <b>Caso de Uso</b>
	 * @author walter cuervo
	 *
	 */
	@Test(enabled=false)
	public void invertirCadenaTest() {
		String resultadoEsperado = "aloH";
		String inversion = invertirCadena("Hola");
		String inversion2 = invertirCadena("");
		Assert.assertNotNull(inversion);
		Assert.assertTrue(!inversion2.isEmpty());
		Assert.assertEquals(inversion, resultadoEsperado);
	}

	/**
	 * 
	 * Metodo encargado de mostrar la información de un determinado comic
	 * <b>Caso de Uso</b>
	 * @author mauro
	 * 
	 * @return
	 */
	public String informacionComic(Comic comic) {
		return comic.toString();
	}

	
	  @Test(enabled=false)
	  public void primeraPrueba() { 
		  Long resultadoEsperado = 150L; Long
	  sumando1 = 100L; Long sumando2 = 50L; Long resultado = sumando1+sumando2;
	  Assert.assertEquals(resultado, resultadoEsperado); Long resultadoEsperadoDos
	  = 200L; Assert.assertNotEquals(resultado, resultadoEsperadoDos); }
	 
}