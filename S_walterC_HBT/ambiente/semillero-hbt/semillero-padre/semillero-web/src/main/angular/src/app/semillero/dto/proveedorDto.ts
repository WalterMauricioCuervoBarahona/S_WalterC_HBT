/**
 * @description Clase ComicDTO que contiene la informacion de un comic
 * 
 * @author walter mauricio cuervo barahona <walter.cuervo@uptc.edu.co>
 */
export class ProveedorDTO {

    /**
    * Indicador de resultado.
    */
    public id: string;

    /**
    * Indicador de resultado.
    */
    public direccion: string;

    /**
    * Indicador de resultado.
    */
    public fechaCreacion: Date;

    /**
    * Indicador de resultado.
    */
    public estadoEnum: string;

    /**
    * Indicador de resultado.
    */
    public montoCredito: number;  
    
    public persona: number;
}