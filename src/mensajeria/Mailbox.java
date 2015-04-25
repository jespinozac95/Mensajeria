/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensajeria;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Adrian
 */
public class Mailbox {
    
    public String nombre;
    public int largo;
    public ArrayList<Proceso> conectados = new ArrayList();
    public Bitacora bitacora; 
    public Cola contenido;
    
    
    public Mailbox(String nomb){
        this.nombre = nomb;
        this.largo = Globales.TamanoCola;
        List <Registro> r= new LinkedList<Registro>(); 
        bitacora = new Bitacora (r); 
        this.contenido = new Cola();
    }
    
    public void conectar(Proceso Px){
        conectados.add(Px);
    }
    
    public void desconectar(Proceso Px){
        conectados.remove(Px);
    }
    
    public void eliminar(){
       if (Globales.FIFO==true){
           this.contenido.eliminar_inicio();
       }
       else{
           //this.contenido.e
       }
    }
        
    
}
