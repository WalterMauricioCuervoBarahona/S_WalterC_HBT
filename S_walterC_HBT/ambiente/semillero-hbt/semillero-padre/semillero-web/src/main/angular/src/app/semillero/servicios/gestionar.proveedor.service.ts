import { Injectable } from '@angular/core';
import { Injector } from "@angular/core";
import { Observable } from 'rxjs';
import 'rxjs/add/operator/toPromise';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ComicDTO } from '../dto/comic.dto';
import { AbstractService } from '../services/template.service';
import { Headers } from '@angular/http';
import { ProveedorDTO } from '../dto/proveedorDto';


/**
 * @description Servicio encargado de llamar a los servicios REST de gestionar comic
 * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
 */
@Injectable({
  providedIn: 'root'
})
export class GestionarProveedorService extends AbstractService {

  /**
   * Constructor de la clase
   */
  constructor(injector: Injector, private httpClient : HttpClient) {
    super(injector);
  }
  
  /**
   * @description Metodo encargado de invocar el servicio REST consultar lista de comics
   * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
   */
  public consultarProveedores(): Observable<any> {
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarProveedor/consultarProveedores');
  }

  /**
   * @description Metodo encargado de invocar el servicio REST crear comic
   * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
   * @param comicDTO contiene la informacion del comic a persistir
   */
  public crearProveedor(proveedor: ProveedorDTO, id: any): Observable<any> {
    return this.httpClient.post(`${'http://localhost:8085/semillero-servicios/rest/GestionarProveedor/crear?idPro='}${id}`, ProveedorDTO);
  }

  /**
   * @description Metodo encargado eliminar un comic
   * @author Walter Mauricio Cuervo Barahona <walter.cuervo@uptc.edu.co>
   * @param idComic 
   */
  public eliminarComic(idComic: any): Observable<any> {
  //return this.httpClient.delete('http://localhost:8085/semillero-servicios/rest/GestionarComic/eliminar?idComic=', idComic);
 return this.httpClient.delete(`${'http://localhost:8085/semillero-servicios/rest/GestionarComic/eliminar?idComic='}${idComic}`);
   }

   /**
    * @description Metodo encargado consultar un comic
    * @author Walter Mauricio Cuervo Barahona <walter.cuervo@uptc.edu.co>
    */
   public consultarProveedor(idPro: any): Observable<any> {
    return this.httpClient.get(`${'http://localhost:8085/semillero-servicios/rest/GestionarProveedor/consultarProveedor?idPro='}${idPro}`);
   }

   /**
    * @description Metodo encargado modificar un comic
    * @author Walter Mauricio Cuervo Barahona <walter.cuervo@uptc.edu.co>
    * @param comicDTO metodo encargado 
    */
   public addDireccionProveedor(direccion: string, id: number): Observable<any> {
     return this.httpClient.get(`${'http://localhost:8085/semillero-servicios/rest/GestionarProveedor/modificarDireccion?id='}${id}${'&direccion='}${direccion}`);
   }

     public modiicarProveedor(monto: any, nombre: any, id: any): Observable<any> {
      return this.httpClient.get(`${'http://localhost:8085/semillero-servicios/rest/GestionarProveedor/modificar?monto='}${monto}${'&nombre='}${nombre}${'&idPro'}${id}`);
   }

}
