/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensajeria;

/**
 *
 * @author Adrian
 */
public class Mensaje {
    //cabecera
    private int idX;
    public int id;
    public Proceso origen;
    public Proceso destino;
    public int longitud;
    public int prioridad;
    public boolean recibido = false;
    //cuerpo
    public String contenido;
    

    public Mensaje(Proceso P1,Proceso P2,String conte, int priori){
        this.id=idX;
        idX++;
        this.origen = P1;
        this.destino = P2;
        this.prioridad = priori;
        this.contenido = conte;
        if (Globales.LargoMsjFijo==true){
            this.longitud = Globales.LargoMsj;
        }
    }
    
    public Mensaje(Proceso P1,Proceso P2,String conte){
        this.id=idX;
        idX++;
        this.origen = P1;
        this.destino = P2;
        this.contenido = conte;
        if (Globales.LargoMsjFijo==true){
            this.longitud = Globales.LargoMsj;
        }
    }
    
    public void recibir(){
        this.recibido=true;
    }
    
    
    
    
}
