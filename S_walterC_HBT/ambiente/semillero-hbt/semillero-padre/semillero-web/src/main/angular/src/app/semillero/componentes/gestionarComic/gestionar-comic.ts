
import { ComicDTO } from '../../dto/comic.dto';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { GestionarComicService } from '../../servicios/gestionar.comic.service';


/**
 * @description Componenete gestionar comic, el cual contiene la logica CRUD
 * 
 * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
 */
@Component({
    selector: 'gestionar-comic',
    templateUrl: './gestionar-comic.html',
    styleUrls: ['./gestionar-comic.css']
})
export class GestionarComicComponent implements OnInit {

    /**
     * Atributo que contiene los controles del formulario
     */
    public gestionarComicForm : FormGroup;

    /**
     * Atributo que contendra la informacion del comic
     */
    public comic: ComicDTO;

    /**
     * Atributo que contendra la lista de comics creados
     */
    public listaComics : Array<ComicDTO>;

    /**
     * atributo para saber si se va a editar una entidad
     */
    public isEdit: boolean;

    /**
     * atributo para guardar el id del comic a modificar
     */
    public idComicModificar: string;

    /**
     * Atributo que indica si se envio a validar el formulario
     */
    public submitted : boolean;

    /**
     * @description Este es el constructor del componente GestionarComicComponent
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    constructor(private fb : FormBuilder,
        private router : Router,
        private gestionarComicService : GestionarComicService) {
        this.gestionarComicForm = this.fb.group({
            autores : [null],
            cantidad: [null],
            coleccion : [null],
            color : [null],
            editorial : [null],
            estadoEnum: [null],
            fechaVenta: [null],
            nombre : [null, Validators.required],
            numeroPaginas : [null],
            precio : [null],
            tematicaEnum : [null],

        });
    }

    /**
     * @description Evento angular que se ejecuta al invocar el componente
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    ngOnInit(): void {
        console.log("Ingreso al al evento oninit");
        this.comic = new ComicDTO();
        this.listaComics = new Array<ComicDTO>();
        this.consultarComics();
        this.isEdit = false;
    }

    /**
     * @description Metodo encargado de consultar los comics existentes
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    public consultarComics() : void {
        this.gestionarComicService.consultarComics().subscribe(listaComics => {
            this.listaComics = listaComics;
        }, error => {
            console.log(error);
        });
    }

    /**
     * @description Metodo encargado de crear/modificar un ocmic
     * @author Walter Mauricio Cuervo Barahona <walter.cuervo@uptc.edu.co>
     */
    public crearActualizarComic(): void {
        this.submitted = true;
        if(this.gestionarComicForm.invalid) {
            return;
        }
        if(!this.isEdit){
            this.crearComic();
            this.gestionarComicService.crearComic(this.comic).subscribe(resultadoDTO => {
                if(resultadoDTO.exitoso) {
                    this.consultarComics();
                    this.limpiarFormulario();
                }
            }, error => {
                console.log(error);
            });
        } else {
            this.crearComic();
            console.log(this.comic);
            this.gestionarComicService.modificarComic(this.comic).subscribe(resultadoDTO => {
                if (resultadoDTO.exitoso) {
                    this.consultarComics();
                    this.limpiarFormulario();
                    this.isEdit = false;
                }
            }, error => {
                console.log(error);
            });
        }
    }

    /**
     * @description Metodo encargado de crear un comic con los datos del formulario
     * @author Walter Mauricio Cuervo Barahona <walter.cuervo@uptc.edu.co>
     */
    public crearComic(): void{
        this.comic = new ComicDTO();
        this.comic.autores = this.gestionarComicForm.controls.autores.value;
        this.comic.cantidad = this.gestionarComicForm.controls.cantidad.value;
        this.comic.coleccion = this.gestionarComicForm.controls.coleccion.value;
        this.comic.color = this.gestionarComicForm.controls.color.value;
        this.comic.editorial = this.gestionarComicForm.controls.editorial.value;
        this.comic.estadoEnum = this.gestionarComicForm.controls.estadoEnum.value;
        this.comic.fechaVenta = null;
        this.comic.nombre = this.gestionarComicForm.controls.nombre.value;
        this.comic.numeroPaginas = this.gestionarComicForm.controls.numeroPaginas.value;
        this.comic.precio = this.gestionarComicForm.controls.precio.value;
        this.comic.tematicaEnum = this.gestionarComicForm.controls.tematicaEnum.value;
        this.comic.id = this.idComicModificar;
    }

    /**
     * @description Metodo encargado de agregarle los valores de un comic al formulario
     * @author Walter Mauricio Cuervo Barahona <walter.cuervo@uptc.edu.co>
     * @param comic 
     */
    public editarComic(comic: ComicDTO): void {
        this.isEdit = true; //bandera para saber si se edito un comic
        this.gestionarComicForm.controls.autores.setValue(comic.autores);
        this.gestionarComicForm.controls.cantidad.setValue(comic.cantidad);
        this.gestionarComicForm.controls.coleccion.setValue(comic.coleccion);
        this.gestionarComicForm.controls.color.setValue(comic.color);
        this.gestionarComicForm.controls.editorial.setValue(comic.editorial);
        this.gestionarComicForm.controls.estadoEnum.setValue(comic.estadoEnum);
        this.gestionarComicForm.controls.fechaVenta.setValue(null);
        this.gestionarComicForm.controls.nombre.setValue(comic.nombre);
        this.gestionarComicForm.controls.numeroPaginas.setValue(comic.numeroPaginas);
        this.gestionarComicForm.controls.precio.setValue(comic.precio);
        this.gestionarComicForm.controls.tematicaEnum.setValue(comic.tematicaEnum);
        this.idComicModificar = comic.id;
    }
    
    /**
     * @description Metodo encargado de setear los valores del formulario
     * @author Walter Mauricio Cuervo Barahona <walter.cuervo@uptc.edu.co>
     */
    private limpiarFormulario() : void {
        this.submitted = false;
        this.gestionarComicForm.controls.autores.setValue(null);
        this.gestionarComicForm.controls.cantidad.setValue(null);
        this.gestionarComicForm.controls.coleccion.setValue(null);
        this.gestionarComicForm.controls.color.setValue(null);
        this.gestionarComicForm.controls.editorial.setValue(null);
        this.gestionarComicForm.controls.estadoEnum.setValue(null);
        this.gestionarComicForm.controls.fechaVenta.setValue(null);
        this.gestionarComicForm.controls.nombre.setValue(null);
        this.gestionarComicForm.controls.numeroPaginas.setValue(null);
        this.gestionarComicForm.controls.precio.setValue(null);
        this.gestionarComicForm.controls.tematicaEnum.setValue(null);
    }

    /**
     * 
     * @description Metodo encargado de eliminar un ocmic
     * @author Walter Mauricio Cuervo Barahona <walter.cuervo@uptc.edu.co>
     */
    public eliminarComic(idComic: number): void {
        this.gestionarComicService.eliminarComic(idComic).subscribe(resultadoDTO => {
            if (resultadoDTO.exitoso) {
                this.consultarComics();
            }
        }, error => {
            console.log(error);
        });
    }

    /**
     * @description Metodo encargado de consultar un comic mostrandolos en otro componente
     * @author Walter Mauricio Cuervo Barahona <walter.cuervo@uptc.edu.co>
     * @param id 
     */
    public consultarComic(id: number): void {
       this.gestionarComicService.consultarComic(id).subscribe(comicDTO =>{
        this.router.navigate(['consultar-Comic', comicDTO]);
       }, error => {
           console.log(error);
       });
    }

    /**
     * @description Metodo que obtiene los controles y sus propiedades
     * @author Diego Fernando Alvarez Silva
     */
    get f() { 
        return this.gestionarComicForm.controls;
    }
}