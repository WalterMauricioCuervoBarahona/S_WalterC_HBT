import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { GestionarProveedorService } from '../../servicios/gestionar.proveedor.service';
import { ProveedorDTO } from '../../dto/proveedorDto';


/**
 * @description Componenete gestionar comic, el cual contiene la logica CRUD
 * 
 * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
 */
@Component({
    selector: 'gestionar-proveedor',
    templateUrl: './gestionar-proveedor.html',
    styleUrls: ['./gestionar-proveedor.css']
})
export class GestionarProveedorComponent implements OnInit {

    /**
     * Atributo que contiene los controles del formulario
     */
    public gestionarProveedorForm : FormGroup;

    /**
     * Atributo que contendra la informacion del comic
     */
    public proveedor: ProveedorDTO;

    /**
     * Atributo que contendra la lista de comics creados
     */
    public listaProveedores : Array<ProveedorDTO>;

    /**
     * atributo para saber si se va a editar una entidad
     */
    public isEdit: boolean;

    /**
     * atributo para guardar el id del comic a modificar
     */
    public idModificar: string;

    public nombreP: string;

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
        private gestionarProveedorService : GestionarProveedorService) {
        this.gestionarProveedorForm = this.fb.group({
            direccion: [null, Validators.required],
            fechaCreacion : [null, Validators.required],
            estadoEnum : [null, Validators.required],
            montoCredito : [null, Validators.required],
            persona: [null, Validators.required],
            idPersona: [null, Validators.required],
        });
    }

    /**
     * @description Evento angular que se ejecuta al invocar el componente
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    ngOnInit(): void {
        console.log("Ingreso al al evento oninit");
        this.proveedor = new ProveedorDTO();
        this.listaProveedores = new Array<ProveedorDTO>();
        this.consultarProveedor();
        this.isEdit = false;
    }

    /**
     * @description Metodo encargado de consultar los comics existentes
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    public consultarProveedor() : void {
        this.gestionarProveedorService.consultarProveedores().subscribe( listaProveedores => {
           this.listaProveedores = listaProveedores;
        }, error => {
            console.log(error);
        });
    }

    public modificarDireccionProveedor(id: number, direccion: string): void{
        this.gestionarProveedorService.addDireccionProveedor(direccion, id).subscribe(resultDto => {
            if(resultDto.exitoso){
                this.consultarProveedor();
            }
        }, error => {
            console.log(error);
        });
    }

    /**
     * @description Metodo encargado de crear/modificar un ocmic
     * @author Walter Mauricio Cuervo Barahona <walter.cuervo@uptc.edu.co>
     */
    
    public crearActualizarProveedor(): void {
        this.submitted = true;
        if(this.gestionarProveedorForm.invalid) {
            return;
        }
        if(!this.isEdit){
            this.crearProveedor();
        this.gestionarProveedorService.crearProveedor(this.proveedor, this.idModificar).subscribe( resultDTO => {
             if(resultDTO.exitoso){
                 this.consultarProveedor();
                 this.limpiarFormulario();
                }
            }, error => {
                console.log(error);
            });
        } else {
            this.crearProveedor();
            this.gestionarProveedorService.modiicarProveedor(this.proveedor.montoCredito, "hola", this.proveedor.id).subscribe( resultDTO => {
                if(resultDTO.exitoso){
                    this.consultarProveedor();
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
    
    public crearProveedor(): void{
        this.proveedor = new ProveedorDTO();
        this.proveedor.direccion = this.gestionarProveedorForm.controls.direccion.value;
        this.proveedor.fechaCreacion = this.gestionarProveedorForm.controls.fechaCreacion.value;
        this.proveedor.estadoEnum = this.gestionarProveedorForm.controls.estadoEnum.value;
        this.proveedor.montoCredito = this.gestionarProveedorForm.controls.montoCredito.value;
        this.idModificar = this.gestionarProveedorForm.controls.idPersona.value;
        this.nombreP = this.gestionarProveedorForm.controls.persona.value;
    }

    /**
     * @description Metodo encargado de agregarle los valores de un comic al formulario
     * @author Walter Mauricio Cuervo Barahona <walter.cuervo@uptc.edu.co>
     * @param comic 
     */
    
    public editarProveedor(proveedorc: ProveedorDTO): void {
        this.isEdit = true; //bandera para saber si se edito un comic
        this.gestionarProveedorForm.controls.direccion.setValue(proveedorc.direccion);
        this.gestionarProveedorForm.controls.fechaCreacion.setValue(proveedorc.fechaCreacion);
        this.gestionarProveedorForm.controls.montoCredito.setValue(proveedorc.montoCredito);
        this.gestionarProveedorForm.controls.estadoEnum.setValue(proveedorc.estadoEnum);
        this.idModificar = proveedorc.id;
    }
    
    /**
     * @description Metodo encargado de setear los valores del formulario
     * @author Walter Mauricio Cuervo Barahona <walter.cuervo@uptc.edu.co>
     */
    public limpiarFormulario() : void {
        this.submitted = false;
        this.gestionarProveedorForm.controls.direccion.setValue(null);
        this.gestionarProveedorForm.controls.fechaCreacion.setValue(null);
        this.gestionarProveedorForm.controls.estadoEnum.setValue(null);
        this.gestionarProveedorForm.controls.montoCredito.setValue(null);
        this.gestionarProveedorForm.controls.persona.setValue(null);
        this.gestionarProveedorForm.controls.idpersona.setValue(null);
        
    }

    /**
     * 
     * @description Metodo encargado de eliminar un ocmic
     * @author Walter Mauricio Cuervo Barahona <walter.cuervo@uptc.edu.co>
     */
    
    public eliminarComic(idPro: number): void {
        /*
        this.gestionarComicService.eliminarComic(idComic).subscribe(resultadoDTO => {
            if (resultadoDTO.exitoso) {
                this.consultarComics();
            }
        }, error => {
            console.log(error);
        });*/
    }

    /**
     * @description Metodo encargado de consultar un comic mostrandolos en otro componente
     * @author Walter Mauricio Cuervo Barahona <walter.cuervo@uptc.edu.co>
     * @param id 
     */
    
    public consultarComic(id: number): void {
        this.gestionarProveedorService.consultarProveedor(id).subscribe(proveedorDTO => {
            this.router.navigate(['consultar-proveedor', proveedorDTO]);
        }, error => {
            console.log(error);
        });
   }

    /**
     * @description Metodo que obtiene los controles y sus propiedades
     * @author Diego Fernando Alvarez Silva
     */
    get f() { 
        return this.gestionarProveedorForm.controls;
    }
}