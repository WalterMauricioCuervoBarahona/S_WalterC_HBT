import { Identifiers } from '@angular/compiler/src/render3/r3_identifiers';

/**
 * @description Clase ComicEstudianteDTO que contiene la informacion de un comic
 * @author Walter Mauricio Cuervo Barahona <walter.cuervo@uptc.edu.co>
 */
export class ComicEstudianteDTO {

    /**
    * Indicador de resultado.
    */
    public id: number;

    /**
    * Indicador de resultado.
    */
    public nombre: string;

    /**
    * Indicador de resultado.
    */
    public editorial: string;

    /**
    * Indicador de resultado.
    */
    public tematica: string;

    /**
    * Indicador de resultado.
    */
    public numeroPaginas: number;

    /**
    * Indicador de resultado.
    */
    public precio: number;

    /**
    * Indicador de resultado.
    */
    public autores: string;

    /**
    * Indicador de resultado.
    */
    public color: boolean;

    /**
    * Indicador de resultado.
    */
    public fechaVenta: Date;

    /**
    * Indicador de resultado.
    */
    public estado: string;

    /**
     * constructor de la clase comicEstudianteDTO
     * @param id 
     * @param nombre 
     * @param editorial 
     * @param tematica 
     * @param numeroPaginas 
     * @param precio 
     * @param autores 
     * @param color 
     * @param fechaVenta 
     * @param estado 
     */
    constructor(id: number, nombre: string, editorial: string, tematica: string, numeroPaginas: number,
        precio: number, autores: string, color: boolean, fechaVenta: Date, estado: string) {
            this.id = id;
            this.nombre = nombre;
            this.editorial = editorial;
            this.tematica = tematica;
            this.numeroPaginas = numeroPaginas;
            this.precio = precio;
            this.autores = autores;
            this.color = color;
            this.fechaVenta = fechaVenta;
            this.estado = estado;
    }
}