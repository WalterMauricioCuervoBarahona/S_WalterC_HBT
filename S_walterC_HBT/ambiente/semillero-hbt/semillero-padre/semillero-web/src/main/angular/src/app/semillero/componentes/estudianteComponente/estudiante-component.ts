import { Component, OnInit } from '@angular/core';
import { ComicDTO } from '../../dto/comic.dto';

/**
 * @description componente app-Estudiante, el cuál contiene unos atributos
 * @author Walter Mauricio Cuervo Barahona <walter.cuervo@uptc.edu.co>
 */
@Component({
    selector: 'app-EstudianteComponent',
    templateUrl: './estudiante-component.html',
    styleUrls: ['./estudiante-component.css']
})

export class EstudianteComponent implements OnInit {
    /**
     * atributo que contendra el nombre del estudiante
     */
    public nombre: string;
    /**
     * atributo que contendra la ciudad del estudiante
     */
    public ciudad: string;
    /**
     * atributo que contendra la URL del repositorio en github
     */
    public repositorio: string;
    /**
     * atributo de cualquier tipo que contendra un objeto
     */
    private miVariable: any = {};
    /**
     * lista de string
     */
    public listaNombre: Array<string> = Array<string>();
    /**
     * variale de tipo comicDTO
     */
    public comicDTO: ComicDTO;
    /**
     * constructor para inyeccion de dependencias
     */
    constructor() {
    }

    /**
     * EJERCICIO DE LA SESIÓN 2 DE ANGULAR
     * se inicializa las variables y métodos
     */
    ngOnInit(): void{
        this.inicializarVariable();
        let variableLocal: string = "variable local";
        console.log("Ejemplo de una " + variableLocal);
        this.miVariable = {
            id: 1,
            nombre: 'Walter',
            direccion: 'Cll 53a #10-34',
        };
        this.miVariable.id = 3;
        this.miVariable.genero= 'Masculino';
        delete this.miVariable.genero;        
        this.listaNombre.push(this.miVariable);

        console.log(this.miVariable);
        console.log(this.suma());        
        this.inicializarComponente();

        let mapa: Map<string, string>;
        mapa = new Map<string, string>();
        mapa.set("1", "semillero2019");
        console.log(mapa.get("1"));

        let fecha = new Date();
        console.log(fecha);

        this.comicDTO = new ComicDTO();
        this.comicDTO.autores = "Goku"
        this.comicDTO.fechaVenta = new Date();
        console.log(this.comicDTO);

        this.listaNombre.forEach(element => {
            console.log(element);
        });
    }

    /**
     * @description método que sirve para inicializar variables y no congestionar el Oninit
     * @author SemilleroHBT2019
     * 
     */
    public inicializarVariable(): void {
        this.ciudad = "Tunja";
        this.nombre = "Walter Mauricio Cuervo Barahona";
        this.repositorio = "https://github.com/WalterMauricioCuervoBarahona/S_WalterC_HBT.git";
        console.log("hola " + this.ciudad + " "  + this.nombre + " " +this.repositorio);
    }

    /**
     * @description metodo para inicializar componentes y hacer pruebas
     * @author SemilleroHBT2019
     */
    public suma(): number {
        let numero: number = 10;
        return numero;
    }

    /**
     * * EJERCICIO SESIÓN 2 ANGULAR
     * @description metodo para inicializar componentes y hacer pruebas
     * @author SemilleroHBT2019
     */
    public inicializarComponente(): Array<string> {
        let retorno : any;
        let objeto = undefined;
        if(objeto !== null && objeto !== undefined){
            console.log("No es nulo")
        } else {
            console.log("Si es nulo");
        }
 
        console.log(1 == 1);
       // console.log("1" == 1);
        console.log(1 === 1);
       // console.log("1" === 1);
        return retorno;
    }
}