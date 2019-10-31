import { Component, OnInit } from '@angular/core';

/**
 * @description componente app-Estudiante, el cuál contiene unos atributos
 * 
 * @author Walter Mauricio Cuervo Barahona <walter.cuervo@uptc.edu.co>
 */
@Component({
    selector: 'app-EstudianteComponent',
    templateUrl: './estudiante-component.html',
    styleUrls: ['./estudiante-component.css']
})

export class EstudianteComponent implements OnInit{
    
    /**
     * atributo que contendra el nombre del estudiante
     */
    nombre: String;
    /**
     * atributo que contendra la ciudad del estudiante
     */
    ciudad: String;
    /**
     * atributo que contendra la URL del repositorio en github
     */
    repositorio: String;

    /**
     * constructor que tendrá a los atributos inicializados
     */
    constructor() {
        this.ciudad = 'Tunja';
        this.nombre = 'Walter Mauricio Cuervo Barahona';
        this.repositorio = 'https://github.com/WalterMauricioCuervoBarahona/S_WalterC_HBT.git';
    }

    ngOnInit(){}
}