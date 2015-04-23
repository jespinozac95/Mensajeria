
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
        int contador=0;
        Mensaje res;
        res= null;
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
    
    
    
    
    
    public static void main(String[] args) {
        List <Mensaje> ListaMensajes = new LinkedList<Mensaje>(); 
        Mensaje ms1 = new Mensaje(1,3,"Mensaje hola"); 
        Mensaje ms2 = new Mensaje(1,2,"Mensaje hola2");
        Mensaje ms3 = new Mensaje(1,2,"Mensaje hola3");
        Mensaje ms4 = new Mensaje(1,3,"Mensaje hola4");
        Mensaje ms5 = new Mensaje(2,2,"Mensaje hola5");
        Mensaje ms6 = new Mensaje(2,1,"Mensaje hola6");
        ListaMensajes.add(ms1); 
        ListaMensajes.add(ms2);
        ListaMensajes.add(ms3);
        ListaMensajes.add(ms4);
        Cola x = new Cola(ListaMensajes);
        x.agregar_final(ms1);
        x.agregar_final(ms5);
        x.agregar_final(ms6);
        System.out.println("Tamañoooooooooooo");
        System.out.println(x.tamano());
        System.out.println("Tamañoooooooooooo");
        System.out.println(ListaMensajes.size());
        System.out.println(ListaMensajes.get(0).contenido);
        //ListaMensajes.remove(0);
        System.out.println(ListaMensajes.get(0).contenido);
        
        System.out.println("Mayor Prioridad");
        
        x.devolver_mayor_prioridad(); 
        
        /*   
        //Inicia
        // Devolver el nodo de mayor prioridad
        int tamano_lista= ListaMensajes.size();
        System.out.println("Tamaño");
        System.out.println(ListaMensajes.size());
        int contador=1;
        Mensaje res;
        res= ListaMensajes.get(0);
        if (tamano_lista>1){
        while (contador<tamano_lista){
            if (ListaMensajes.get(contador).prioridad<res.prioridad){
                res=ListaMensajes.get(contador);
            }
            else{
                contador++;
            }
        }
        //return res;
        System.out.println(res.contenido);
        }
        else{
            if (tamano_lista==1){
                //return
                System.out.println(res.contenido);
                
            }
            else{
                System.out.println("error");
            }
        }
        
        
        //Finaliza 
        */
        
        //Inicia
        
        
        //Finaliza
    }
    
}
