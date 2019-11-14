package com.hbt.semillero.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Ejercicios {
	
	private ArrayList<Integer> listaNum;
	
	public Ejercicios() {
		listaNum = new ArrayList<Integer>();
	}
	
	/**
	 * verifica si un numero es primo
	 * Metodo encargado de 
	 * <b>Caso de Uso</b>
	 * @author mauro
	 * 
	 * @return
	 */
	public boolean isPrime(int value){
		int count = 0;
		for (int i = 1; i <= value && count<=3; i++) {
			if(value % i == 0){
				count++;
			}
		}
		return (count <= 2 && count >= 1);
	}
	
	
	/**
	 * 
	 * Metodo encargado de agregar numeros a una lista
	 * <b>Caso de Uso</b>
	 * @author mauro
	 * 
	 * @param number
	 */
	public void ejercicio5(int number) {
		this.listaNum.add(number);
	}
	
	/**
	 * 
	 * Metodo encargado de ordenar una lista
	 * <b>Caso de Uso</b>
	 * @author mauro
	 *
	 */
	public void ejercicio5() {
		Collections.sort(this.listaNum);
	}

	/**
	 * Metodo encargado de retornar el valor del atributo listaNum
	 * @return El listaNum asociado a la clase
	 */
	public ArrayList<Integer> getListaNum() {
		return listaNum;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo listaNum
	 * @param listaNum El nuevo listaNum a modificar.
	 */
	public void setListaNum(ArrayList<Integer> listaNum) {
		this.listaNum = listaNum;
	}
	
	
	/**
	 * 
	 * Metodo encargado de 
	 * <b>Caso de Uso</b>
	 * @author mauro
	 * 
	 * @param listPuntosFedere
	 * @param listPuntosThiem
	 */
	public void ejercicio7(ArrayList<Integer> listPuntosFedere, ArrayList<Integer> listPuntosThiem) {
		String Federer = "Federer";
		String Thiem = "Thiem";
		Random randomF = new Random();
		Random randomT = new Random();
		Boolean Ganador = true;
		int set = 3;
		int juego = 6;
		int contadorJuego = 0;
		int contadorSet = 0;
		while (Ganador) {		
			while (contadorSet <= set) {
				for (int i = 0; i < juego; i++) {
					if(randomF.nextInt() > randomT.nextInt()) {
						
					}
				}
			}
		}
	}

	/**
	 * 
	 * Metodo encargado de 
	 * <b>Caso de Uso</b>
	 * @author mauro
	 *
	 */
	public void ejercicio8(ArrayList<Integer> listaMonedas, int moneda) {
		 int max = 0;
		 boolean seguir = true;
		 ArrayList<Integer> monedas = new ArrayList<Integer>();
	       while (seguir) {
	    	   for (int i = 0; i < listaMonedas.size(); i++) {
		            if (listaMonedas.get(i) > max) {
		                max = listaMonedas.get(i);
		            }
		        }
	    	   if(moneda % max != 0) {
	    		   monedas.add(moneda / max);   
	    	   }
		}		
	}
	
	/**
	 * 
	 * Metodo encargado de verificar una excepcion 
	 * <b>Caso de Uso</b>
	 * @author mauro
	 *
	 */
	public void ejercicio9() throws Exception {
		throw new Exception();
	}
	
	
}
