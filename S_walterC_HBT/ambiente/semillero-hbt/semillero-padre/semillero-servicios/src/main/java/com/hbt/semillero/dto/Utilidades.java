package com.hbt.semillero.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * 
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author mauro
 * @version
 */
public class Utilidades {
	public static final Integer DAY_YEAR = 365;
	
	/**
	 * 
	 * Metodo encargado de  
	 * <b>Caso de Uso</b>
	 * @author mauro
	 * 
	 * @param listaNombres
	 * @param nombre
	 * @return
	 */
	public static Boolean isNombreRepetido(List<String> listaNombres, String nombre) {
		for (String nombres : listaNombres) {
			if(nombres.equals(nombre)) {
				return true;
			}
		}
		return false;
	}
    
	/*
    public static Boolean isExpirarUsuario(UsuarioDTO usuarioDTO) {
    	LocalDate dateUser = usuarioDTO.getFechaCreacion();
    	LocalDate dateActual = LocalDate.now();
    	Integer año = DAY_YEAR * (dateActual.getYear() - dateUser.getYear());
    	Integer dia = dateActual.getDayOfYear() - dateUser.getDayOfYear();
    	Integer diferencia = año+dia;
    	if(diferencia >= DAY_YEAR) {
    		return true;
    	}
    	return false;
    }
  */
    
    public static void main(String[] args) {
    	//UsuarioDTO usuarioDTO = new UsuarioDTO();
    	//usuarioDTO.setFechaCreacion(LocalDate.of(2019, 8, 19) );
    	//System.out.println(isExpirarUsuario(usuarioDTO));
    	List<String> lista = new ArrayList<String>();
    	lista.add("walter");
    	lista.add("walte");
    	lista.add("walt");
    	lista.add("wal");
    	System.out.println(Utilidades.isNombreRepetido(lista, "walter"));
    	
	}

}
