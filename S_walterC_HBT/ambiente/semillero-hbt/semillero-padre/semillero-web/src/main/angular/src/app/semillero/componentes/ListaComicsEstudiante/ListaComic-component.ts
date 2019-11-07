import { Component, OnInit } from '@angular/core';
import { ComicEstudianteDTO } from '../../dto/comicEstudiante.dto';

/**
 * @description componente app-Estudiante, el cuál contiene unos atributos
 * @author Walter Mauricio Cuervo Barahona <walter.cuervo@uptc.edu.co>
 */
@Component({
    selector: 'app-ListaComicComponent',
    templateUrl: './ListaComic-component.html',
    styleUrls: ['./ListaComic-component.css']
})

export class ListaComicComponent implements OnInit{
    /**
     * variale de tipo comicDTO
     */
    public comicDTO1: ComicEstudianteDTO;
    /**
     * lista de comics
     */
    public listaComics: Array<ComicEstudianteDTO>;
    /**
     * atributo para saber el nombre del comic eliminado
     */
    public comicEliminado: string;
    /**
     * constructor para inyeccion de dependencias
     */
    constructor() {
    }

    /**
     * EJERCICIO DE LA SESIÓN 2 DE ANGULAR
     * * se inicializa las variables y métodos
     * se crean comics para agregarlos a la lista
     */
    ngOnInit(): void{
        this.listaComics = new Array<ComicEstudianteDTO>();      
        
        this.listaComics.push(this.crearComicDTO(1, "Dragon Ball Yamcha", "Planeta Cómic", "AVENTURAS",
         144, 2100, "Dragon Garow Lee", true, new Date(), "ACTIVO"));

        this.listaComics.push(this.crearComicDTO(2, "Captain America Corps 1-5 USA", "Planeta Cómic",
         "FANTASTICO", 128, 5000, "Phillippe Briones, Roger Stern ", true, new Date(), "ACTIVO"));
        
        this.listaComics.push(this.crearComicDTO(3, "Saint seiya", "Panini Comics ", "FANTASTICO", 145,
        8100, "pegaso INC", true, new Date(), "ACTIVO"));
        
        this.listaComics.push(this.crearComicDTO(4, "Capitan Tsubasa", "Panini Comics ", "DEPORTES", 200,
        4500, "Japoneses ", true, new Date(), "ACTIVO"));
        
        this.listaComics.push(this.crearComicDTO(5, "Captain America", "Planeta Cómic", "FANTASTICO", 100,
        3800, "Steve Rogers ", false, new Date(), "INACTIVO"));        
    }

    /**
     * @description metodo que crea un comic
     * @author Walter Mauricio Cuervo Barahona <walter.cuervo@uptc.edu.co>
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
    public crearComicDTO(id: number, nombre: string, editorial: string, tematica: string, numeroPaginas: number,
        precio: number, autores: string, color: boolean, fechaVenta: Date, estado: string): ComicEstudianteDTO {
        return new ComicEstudianteDTO(id, nombre, editorial, tematica, numeroPaginas,
            precio, autores, color, fechaVenta, estado);
    }

    /**
     * @description metodo que elimina un comic según una posicion ingresada
     * @author Walter Mauricio Cuervo Barahona <walter.cuervo@uptc.edu.co>
     * @param posicion 
     */
    public eliminarComic(posicion: number): void {
            this.comicEliminado = this.listaComics[posicion].nombre;
            this.listaComics.splice(posicion, 1);
            console.log(this.listaComics);          
    }
}