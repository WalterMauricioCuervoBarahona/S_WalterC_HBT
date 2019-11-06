import { Component, OnInit } from '@angular/core';

/**
 * @description Componente bienvenida, el cual contiene la imagen de bienvenida al semillero
 * 
 * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
 */
@Component({
  selector: 'bienvenida',
  templateUrl: './bienvenida-component.html',
})
export class BienvenidaComponent implements OnInit{

  public urlImagen: string;
  
  ngOnInit(): void {
    this.urlImagen = "https://www.elempleo.com/sitios-empresariales/colombia/heinsohn-business-technology/img/elempleo-02.jpg";
  }

  /**
   * 
   * @description Metodo encargado de mostrar un alert segun un parametro
   * @author SemileroHBT2019 
   */
  public ejecucionEventoClick(parametro: string): void {
    alert("Hola " + parametro);
  }

}