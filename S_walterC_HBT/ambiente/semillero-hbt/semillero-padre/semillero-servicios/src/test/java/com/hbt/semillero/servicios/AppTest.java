package com.hbt.semillero.servicios;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {

	public void shouldAnswerWithTrue() {

	}
	
	private String invertirCadena(String cadena) {
		String cadenaInvertida = "";
		for (int x = cadena.length() - 1; x >= 0; x--) {
			cadenaInvertida = cadenaInvertida + cadena.charAt(x);
		}
		return cadenaInvertida;
	}	
			
	@Test
	public void invertirCadenaTest() {
		String resultadoEsperado = "aloH";
		String inversion = invertirCadena("Hola");
		String inversion2 = invertirCadena("");
		Assert.assertNotNull(inversion);
		Assert.assertTrue(!inversion2.isEmpty());
		Assert.assertEquals(inversion, resultadoEsperado);		
	}
	
	
	/*
	@Test
	public void primeraPrueba() {
		Long resultadoEsperado = 150L;
		Long sumando1 = 100L;
		Long sumando2 = 50L;
		Long resultado = sumando1+sumando2;
		Assert.assertEquals(resultado, resultadoEsperado);
		Long resultadoEsperadoDos = 200L;
		Assert.assertNotEquals(resultado, resultadoEsperadoDos);
	}*/
	
	
}
