/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensajeria;


import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author Mauricio Gamboa
 */
public class Bitacora {
    public List<Registro> listaR; 
    
    public Bitacora(){
        this.listaR=null; 
    }
    
    public Bitacora(List<Registro> lista){
        this.listaR=lista; 
    }
    void agregar_final(Registro ms1){
        listaR.add(ms1);
    }
    public int tamano(){
        return listaR.size(); 
    }
    
    public String obtener_registro(){ 
        List<Registro> ListaMSN= this.listaR; 
        int tamano_lista= ListaMSN.size();
        if (tamano_lista>0){
            Registro primero= listaR.get(0); 
            //this.eliminar_inicio();
            //System.out.println(primero.contenido); 
            return primero.fecha; 
        }
        else{
            return null; 
        }
        
    }
    
    void eliminar_inicio(){
        listaR.remove(0); 
    }
}
