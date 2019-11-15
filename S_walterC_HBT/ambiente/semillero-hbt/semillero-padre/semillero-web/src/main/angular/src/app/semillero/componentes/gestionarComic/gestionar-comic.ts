import { ComicDTO } from '../../dto/comic.dto';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Alert } from 'selenium-webdriver';

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
    public gestionarComicForm: FormGroup;

    /**
     * Atributo que contendra la informacion del comic
     */
    public comic: ComicDTO;

    /**
     * Atributo que contendra la lista de comics creados
     */
    public listaComics: Array<ComicDTO>;

    /**
     * atributo que va aumentando secuencial cada vez que se crea un comic
     */
    public idComic: number = 0;

    /**
     * atributo para guardar la posicion del comic en la lista
     */
    public numeroPosicion: number;

    /**
     * Atributo que indica si se envio a validar el formulario
     */
    public submitted: boolean;

    /**
     * Atributo que me indica si un comic fue editado
     */
    public isEdit: boolean;

    /**
     * @description Este es el constructor del componente GestionarComicComponent
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    constructor(private fb: FormBuilder,
        private router: Router) {
        this.gestionarComicForm = this.fb.group({
            //deben ser el mismo nombre del comicDTO
            //recibe una lista de validaciones, primero se inicializa en null y el validators dice que es un cmpo requerido
            //en el html se coloca solo el nombre del control (nombre, tematica, color)
            nombre: [null, Validators.required],
            tematica: [null],
            color: [null],
            editorial: [null],
            coleccion: [null],
            numeroPaginas: [null],
            precio: [null],
            autores: [null]
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
        this.isEdit = false;
    }

    /**
     * @description Metodo que permite validar el formulario y crear o actulizar un comic
     */
    public crearActualizarComic(): void {
        this.submitted = true;//bandera para validar el formulario se usa en el ngclass
        if (this.gestionarComicForm.invalid) { //
            return;
        }
        if (this.isEdit) {
            this.crearComic();
            this.comic.id = this.numeroPosicion + 1 +"";
            this.listaComics[this.numeroPosicion] = this.comic;
            this.isEdit = false;
        } else {
            this.crearComic();
            this.idComic++;
            this.comic.id = this.idComic + "";
            this.listaComics.push(this.comic);
        }
        this.limpiarFormulario();
    }

    /**
     * metodo para crear un comic con los valores FormGroup
     */
    public crearComic(): void {
        this.comic = new ComicDTO();
        this.comic.nombre = this.gestionarComicForm.controls.nombre.value;
        this.comic.editorial = this.gestionarComicForm.controls.editorial.value;
        this.comic.tematica = this.gestionarComicForm.controls.tematica.value;
        this.comic.coleccion = this.gestionarComicForm.controls.coleccion.value;
        this.comic.numeroPaginas = this.gestionarComicForm.controls.numeroPaginas.value;
        this.comic.precio = this.gestionarComicForm.controls.precio.value;
        this.comic.autores = this.gestionarComicForm.controls.autores.value;
        this.comic.color = this.gestionarComicForm.controls.color.value;
    }

    /**
   * Metodo que permite consultar un comic de la tabla y sus detalles e inhabilitar el formulario
   * @param posicion en la lista del comic seleccionado
   */
    public editarComic(comic: ComicDTO, numero: number): void {
        this.isEdit = true; //bandera para saber si se edito un comic
        this.gestionarComicForm.controls.nombre.setValue(comic.nombre);
        this.gestionarComicForm.controls.editorial.setValue(comic.editorial);
        this.gestionarComicForm.controls.tematica.setValue(comic.tematica);
        this.gestionarComicForm.controls.coleccion.setValue(comic.coleccion);
        this.gestionarComicForm.controls.numeroPaginas.setValue(comic.numeroPaginas);
        this.gestionarComicForm.controls.precio.setValue(comic.precio);
        this.gestionarComicForm.controls.autores.setValue(comic.autores);
        this.gestionarComicForm.controls.color.setValue(comic.color);
        this.numeroPosicion = numero;
    }

    /**
     * metodo que permite eliminar un comic de la lista
     * @param posicion en la lista del comic seleccionado
     */
    public eliminarComic(posicion: number): void {
        alert("Se ha eliminado a " + this.listaComics[posicion].nombre);
        this.listaComics.splice(posicion, 1);
    }

    /**
     * Metodo que se encarga de limpiar los campos de texto una vez es creado un comic o editado
     */
    private limpiarFormulario(): void {
        this.submitted = false;
        this.gestionarComicForm.controls.nombre.setValue(null);
        this.gestionarComicForm.controls.editorial.setValue(null);
        this.gestionarComicForm.controls.tematica.setValue(null);
        this.gestionarComicForm.controls.coleccion.setValue(null);
        this.gestionarComicForm.controls.numeroPaginas.setValue(null);
        this.gestionarComicForm.controls.precio.setValue(null);
        this.gestionarComicForm.controls.autores.setValue(null);
        this.gestionarComicForm.controls.color.setValue(null);
    }

    /**
     * @description Metodo que obtiene los controles y sus propiedades
     * @author Diego Fernando Alvarez Silva
     */
    public get f() {
        return this.gestionarComicForm.controls;//lista de controles, nombre, tematica y color
    }
}