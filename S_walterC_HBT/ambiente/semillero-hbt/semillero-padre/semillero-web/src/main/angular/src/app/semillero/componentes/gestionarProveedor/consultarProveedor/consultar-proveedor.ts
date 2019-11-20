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
    selector: 'App-ConsultarProveedor',
    templateUrl: './consultar-proveedor.html',
    styleUrls: ['./consultar-proveedor.css']
})
export class ConsultarProveedorComponent implements OnInit {

    /**
     * Atributo que contendra la informacion del Proveedor
     */
    public proveedor: any;
    /**
     * Atributo que contiene los controles del formulario
     */
    public consultarProveedorForm: FormGroup;

    /**
     * @description Este es el constructor del componente
     * @author Walter Mauricio Cuervo Barahona <walter.cuervo@uptc.edu.co>
     */
    constructor(private fb: FormBuilder, private router: Router, private activatedRoute: ActivatedRoute) {
                this.consultarProveedorForm = this.fb.group({
                    direccion: [null, Validators.required],
                    fechaCreacion : [null, Validators.required],
                    estadoEnum : [null, Validators.required],
                    montoCredito : [null, Validators.required],
                    persona: [null, Validators.required],
                });
    }


    /**
     * @description Evento angular que se ejecuta al invocar el componente
     * @author Walter Mauricio Cuervo Barahona <walter.cuervo@uptc.edu.co>
     */
    ngOnInit(): void {
        this.proveedor = this.activatedRoute.snapshot.params;
        this.buscarProveedor();
    }

    /**
     * metodo que se encarga de asignar a la ventana consultar Proveedor los datos de un Proveedor, 
     * ademas desahbilita la edicion de campos
     */
    public buscarProveedor(): void {
        this.consultarProveedorForm.controls.direccion.setValue(this.proveedor.direccion);
        this.consultarProveedorForm.controls.fechaCreacion.setValue(this.proveedor.fechaCreacion);
        this.consultarProveedorForm.controls.estadoEnum.setValue(this.proveedor.estadoEnum);
        this.consultarProveedorForm.controls.montoCredito.setValue(this.proveedor.montoCredito);
        this.consultarProveedorForm.controls.persona.setValue(this.proveedor.persona);
        
        this.consultarProveedorForm.controls.direccion.disable();
        this.consultarProveedorForm.controls.fechaCreacion.disable();
        this.consultarProveedorForm.controls.estadoEnum.disable();
        this.consultarProveedorForm.controls.montoCredito.disable();
        this.consultarProveedorForm.controls.persona.disable();
    }

    /**
     * metodo que permite regresar al componente de gestionar comic
     */
    public irAtras(): void {
        this.router.navigate(['gestionar-proveedor']);
    }
}