/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensajeria;

/**
 *
 * @author Mauricio Gamboa
 */
public class Registro {
    String fecha=null;
    String accion; 
    String origen; 
    String estado_origen; 
    String destino; 
    String mensaje; 
    
    
    public Registro(String accion,String origen, String estado, String destino, String mensaje){
        this.fecha= fecha_actual(); 
        this.accion=accion; 
        this.origen=origen; 
        this.estado_origen=estado; 
        this.destino=destino; 
        this.mensaje=mensaje; 
        
    }
    
    public String fecha_actual(){
        java.util.Date utilDate = new java.util.Date();
        long lnMilisegundos = utilDate.getTime();
        java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos);
        utilDate = sqlTimestamp;
        return utilDate.toString(); 
    }
}
