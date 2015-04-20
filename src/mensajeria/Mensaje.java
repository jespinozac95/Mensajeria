/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author Adrian
 */
public class Mensaje {
    //cabecera
    public Proceso origen;
    public Proceso destino;
    public int longitud;
    public int prioridad;
    public boolean recibido = false;
    //cuerpo
    public String contenido;
    
    
    public Mensaje(Proceso P1,Proceso P2,int longit, char priori,String conte){
        this.origen = P1;
        this.destino = P2;
        this.longitud = longit;
        this.prioridad = priori;
        this.contenido = conte;
    }
    
    public Mensaje(Proceso P1,Proceso P2, char priori,String conte){
        this.origen = P1;
        this.destino = P2;
        this.longitud = Globales.LargoVariable;
        this.prioridad = priori;
        this.contenido = conte;
    }
    
    
    
    
}
