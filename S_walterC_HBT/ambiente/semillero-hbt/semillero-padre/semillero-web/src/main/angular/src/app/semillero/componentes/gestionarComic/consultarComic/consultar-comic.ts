import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Params } from '@angular/router';

/**
 * @description Componenete consultar comic
 * 
 * @author Walter Mauricio Cuervo Barahona <walter.cuervo@uptc.edu.co>
 */
@Component({
    selector: 'App-ConsultarComic',
    templateUrl: './consultar-comic.html',
    styleUrls: ['./consultar-comic.css']
})
export class ConsultarComicComponent implements OnInit {

    /**
     * Atributo que contendra la informacion del comic
     */
    public comic: any;
    /**
     * Atributo que contiene los controles del formulario
     */
    public consultarComicForm: FormGroup;

    /**
     * @description Este es el constructor del componente GestionarComicComponent
     * @author Walter Mauricio Cuervo Barahona <walter.cuervo@uptc.edu.co>
     */
    constructor(private fb: FormBuilder, private router: Router, private activatedRoute: ActivatedRoute) {
        this.consultarComicForm = this.fb.group({
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
     * @author Walter Mauricio Cuervo Barahona <walter.cuervo@uptc.edu.co>
     */
    ngOnInit(): void {
        this.comic = this.activatedRoute.snapshot.params;
        this.buscarComic();
    }

    /**
     * metodo que se encarga de asignar a la ventana consultar comic los datos de un comic, ademas desahbilita la edicion de campos
     */
    public buscarComic(): void {
        this.consultarComicForm.controls.autores.setValue(this.comic.autores);
        this.consultarComicForm.controls.cantidad.setValue(this.comic.cantidad);
        this.consultarComicForm.controls.coleccion.setValue(this.comic.coleccion);
        this.consultarComicForm.controls.color.setValue(this.comic.color);
        this.consultarComicForm.controls.editorial.setValue(this.comic.editorial);
        this.consultarComicForm.controls.estadoEnum.setValue(this.comic.estadoEnum);
        this.consultarComicForm.controls.fechaVenta.setValue(this.comic.fechaVenta);
        this.consultarComicForm.controls.nombre.setValue(this.comic.nombre);
        this.consultarComicForm.controls.numeroPaginas.setValue(this.comic.numeroPaginas);
        this.consultarComicForm.controls.precio.setValue(this.comic.precio);
        this.consultarComicForm.controls.tematicaEnum.setValue(this.comic.tematicaEnum);
        this.consultarComicForm.controls.nombre.disable();
        this.consultarComicForm.controls.editorial.disable();
        this.consultarComicForm.controls.tematicaEnum.disable();
        this.consultarComicForm.controls.coleccion.disable();
        this.consultarComicForm.controls.numeroPaginas.disable();
        this.consultarComicForm.controls.precio.disable();
        this.consultarComicForm.controls.autores.disable();
        this.consultarComicForm.controls.color.disable();
        this.consultarComicForm.controls.cantidad.disable();
        this.consultarComicForm.controls.estadoEnum.disable();
        this.consultarComicForm.controls.fechaVenta.disable();
    }

    /**
     * metodo que permite regresar al componente de gestionar comic
     */
    public irAtras(): void {
        this.router.navigate(['gestionar-comic']);
    }
}