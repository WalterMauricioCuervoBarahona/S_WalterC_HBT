package com.hbt.semillero.servicios;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 
 * <b>Descripción:<b> Clase que determina unas validaciones a variables de tipo String
 * <b>Caso de Uso:<b> 
 * @author SemilleroHBT
 * @version
 */
public class Sesion4App {
	
	/**
	 * 
	 * Metodo encargado de realizar pruebas a metodos con string
	 * <b>Caso de Uso</b>
	 * @author SemilleroHBT
	 *
	 */
	@Test(enabled=false)
	public void probarCadenaString() {
		String s1= "hola";
		String s2;
		s2 = new String("hola");
		Assert.assertTrue(s1 == s2, "si son iguales");
		Assert.assertEquals(s1, s2);
	}
}
