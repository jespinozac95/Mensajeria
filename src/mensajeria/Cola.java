
package mensajeria;

import java.util.LinkedList;
import java.util.List;


public class Cola {
    
    public List<Mensaje> lista; 
    
    public Cola(){
        this.lista=null; 
    }
    
    public Cola(List<Mensaje> lista){
        this.lista=lista; 
    }
    
    void agregar_final(Mensaje ms1){
        lista.add(ms1);
    }
    
    void eliminar_inicio(){
        lista.remove(0); 
    }
    
    public int tamano(){
        return lista.size(); 
    }
    
    //Obtiene en primer mensaje de la cola. FIFO. 
    public String obtener_mensaje(){ 
        List<Mensaje> ListaMSN= this.lista; 
        int tamano_lista= ListaMSN.size();
        if (tamano_lista>0){
            Mensaje primero= lista.get(0); 
            this.eliminar_inicio();
            System.out.println(primero.contenido); 
            return primero.contenido; 
        }
        else{
            return null; 
        }
        
    }
    
    
    
    
    public Mensaje devolver_mayor_prioridad(){ //Mayor Prioridad Fifo Implícito
        List<Mensaje> ListaMSN= this.lista; 
        int tamano_lista= ListaMSN.size();
        System.out.println("Tamaño");
        System.out.println(ListaMSN.size());
        int contador=1;
        Mensaje res;
        res= ListaMSN.get(0);
        if (tamano_lista>1){
        while (contador<tamano_lista){
            if (ListaMSN.get(contador).prioridad<res.prioridad){
                res=ListaMSN.get(contador);
            }
            else{
                contador++;
            }
        }
        System.out.println(res.contenido);
        return res;
        }
        else{
            if (tamano_lista==1){
                System.out.println(res.contenido);
                return res; 
                
            }
            else{
                System.out.println("error");
                return null; 
            }
        }
    } 
    
      public Mensaje devolver_mayor_prioridad_explícito(String proceso){ //Mayor Prioridad Fifo Explícito
        List<Mensaje> ListaMSN= this.lista; 
        int tamano_lista= ListaMSN.size();
        System.out.println("Tamaño");
        System.out.println(ListaMSN.size());
        int contador=1;
        Mensaje res;
        res= ListaMSN.get(0);
        if (tamano_lista>1){
        while (contador<tamano_lista){
            if ((ListaMSN.get(contador).prioridad<res.prioridad)&&(ListaMSN.get(contador).origen.nombre.equalsIgnoreCase(proceso))){
                res=ListaMSN.get(contador);
            }
            else{
                contador++;
            }
        }
        
        if (res.origen.nombre.equalsIgnoreCase(proceso)){
            System.out.println(res.contenido);
            return res; 
        }
        else{
            
            return null; 
        }
        }
        else{
            if (tamano_lista==1){
                
                if (res.origen.nombre.equalsIgnoreCase(proceso)){
                System.out.println(res.contenido);
                return res; 
                }
                else{
                    return null; 
                }
                
            }
            else{
                System.out.println("error");
                return null; 
            }
        }
    } 
    
    
    
    
    
    public static void main(String[] args) {
        Proceso p1 = new Proceso("Proceso1"); 
        Proceso p2 = new Proceso("Proceso2"); 
        Proceso p3 = new Proceso("Proceso3"); 
        
        List <Mensaje> ListaMensajes = new LinkedList<Mensaje>(); 
        Mensaje ms1 = new Mensaje(p1,p2,"Mensaje hola",1); 
        Mensaje ms2 = new Mensaje(p1,p3,"Mensaje hola2",2);
        Mensaje ms3 = new Mensaje(p3,p2,"Mensaje hola3",1);
        Mensaje ms4 = new Mensaje(p2,p1,"Mensaje hola4",3);
        Mensaje ms5 = new Mensaje(p2,p3,"Mensaje hola5",2);
        Mensaje ms6 = new Mensaje(p3,p1,"Mensaje hola6",2);
   
        Cola x = new Cola(ListaMensajes);
        x.agregar_final(ms1);
        x.agregar_final(ms2);
        x.agregar_final(ms3);
        x.agregar_final(ms4);
        x.agregar_final(ms5);
        x.agregar_final(ms6);
        
        //System.out.println(ListaMensajes.get(0).contenido);
        //ListaMensajes.remove(0);
        //System.out.println(ListaMensajes.get(0).contenido);
        
        System.out.println("Mayor Prioridad");
        
        x.devolver_mayor_prioridad(); 
        System.out.println("Mayor Prioridad Explícito FIFO");
        x.devolver_mayor_prioridad_explícito("Proceso3"); 
        x.obtener_mensaje(); 
    }
    
}
