
package mensajeria;

import java.util.LinkedList;
import java.util.List;

public class Proceso {
    public String nombre;
    public boolean conectado;
    public String mailbox_conectado;
    public String log = "C:\\Users\\Adrian\\Desktop\\Mensajeria\\app\\log\\log"; // path
    public Cola cola; //para direccionamiento directo
    public boolean Bloqueado;
   
    
    public Proceso(String name){
        if (Globales.DireccionamientoDirecto==true){
            this.nombre = name;
            this.log= this.log+this.nombre+".txt";  
            cola = new Cola();
            this.Bloqueado = false;
        }
        else{
            if (Globales.IndirectoEstatico==true){
                this.nombre = name;
                this.log= this.log+this.nombre+".txt";
                Mailbox mb = new Mailbox("MB"+this.nombre);
                this.conectar(mb.nombre);
                this.Bloqueado = false;
            }
            else{
                this.nombre = name;
                this.log= this.log+this.nombre+".txt";
                this.mailbox_conectado = "";
                this.conectado = false;
                this.Bloqueado = false;
            }
        }
    }

    private void conectar(String nameMBox){
        Globales.buscarMB(nameMBox).conectar(this);
        this.mailbox_conectado = Globales.buscarMB(nameMBox).nombre;
        this.conectado = true;
    }
    
    void desconectar(){
        Globales.buscarMB(this.mailbox_conectado).desconectar(this);
        this.mailbox_conectado = "";
        this.conectado = false;
    }
        
    void bloquear(){
        this.Bloqueado=true;
        System.out.println("me desbloquee, estoy bloqueado");
    }
    
    void desbloquear(){
        this.Bloqueado=false;
        System.out.println("me desbloquee, estoy desbloqueado");
    }
    
    void running(){
        System.out.println("estoy running");
    }
    
    void sendDirecto(String NombreProcesoDestino, String msg){
        this.running();
        if (Globales.SendBlocking==true){
            this.bloquear();
            this.desbloquear();
        }
        Mensaje NewMsj = new Mensaje(this,Globales.buscarPro(NombreProcesoDestino),msg);
        Globales.buscarPro(NombreProcesoDestino).cola.agregar_final(NewMsj);
        this.running();
    }
    
    void sendDirecto(String NombreProcesoDestino, String msg, int Prioridad){
        this.running();
        if (Globales.SendBlocking==true){
            this.bloquear();
            this.desbloquear();
        }
        Mensaje NewMsj = new Mensaje(this,Globales.buscarPro(NombreProcesoDestino),msg,Prioridad);
        Globales.buscarPro(NombreProcesoDestino).cola.agregar_final(NewMsj);
        this.running();
    }
    
    void sendIndirecto(String NombreMailboxDestino, String msg){
        this.running();
        if (Globales.SendBlocking==true){
            this.bloquear();
            this.desbloquear();
        }
        Mensaje NewMsj = new Mensaje(this,Globales.buscarPro(NombreMailboxDestino),msg);
        Globales.buscarPro(NombreMailboxDestino).cola.agregar_final(NewMsj);
        this.running();
    }
    
    void sendDirecto1(String NombreProcesoDestino, String msg, int Prioridad){
        this.running();
        if (Globales.SendBlocking==true){
            this.bloquear();
            this.desbloquear();
        }
        Mensaje NewMsj = new Mensaje(this,Globales.buscarPro(NombreProcesoDestino),msg,Prioridad);
        Globales.buscarPro(NombreProcesoDestino).cola.agregar_final(NewMsj);
        this.running();
    }
    
    
    void send(String nombre, String msg, int Prioridad){
        //if ((Globales.SendBlocking==true) && (this.Bloqueado==true)){
        if (this.Bloqueado==true){
            //MENSAJE DE ERROR; ESTOY BLOQUEADO
        }
        else{
            if (Globales.DireccionamientoDirecto==true){
                Mensaje msj = new Mensaje(this,Globales.buscarPro(nombre),msg,Prioridad);
                Globales.buscarPro(nombre).cola.agregar_final(msj);
            }
            else{ // si es indirecto
                if (this.conectado==true){
                    Mensaje msj = new Mensaje(this,Globales.buscarPro(nombre),msg,Prioridad);   
                    Globales.buscarMB(this.mailbox_conectado).contenido.agregar_final(msj);
                    }
                else{
                    //ERROR NO ESTOY CONECTADO EN NINGUN MAILBOX 
                }     
            }
        }
    }
    
    void send(Proceso Destino, String msg){
        //if ((Globales.SendBlocking==true) && (this.Bloqueado==true)){
        if (this.Bloqueado==true){
            //MENSAJE DE ERROR; ESTOY BLOQUEADO
        }
        else{
            if (Globales.DireccionamientoDirecto==true){
                Mensaje msj = new Mensaje(this,Globales.buscarPro(nombre),msg);
                Globales.buscarPro(nombre).cola.agregar_final(msj);
            }
            else{ // si es indirecto
                if (this.conectado==true){
                    Mensaje msj = new Mensaje(this,Globales.buscarPro(nombre),msg);    
                    Globales.buscarMB(this.mailbox_conectado).contenido.agregar_final(msj);
                    }
                else{
                    //ERROR NO ESTOY CONECTADO EN NINGUN MAILBOX 
                }     
            }
        }
    }
    
    
    
    
    void receiveI(Proceso Origen, String msg){
        if(Globales.DireccionamientoDirecto == true){
            
            
        }
        else{
            
        }
    }
    
    /*void receiveDDI(){
        if (Globales.FIFO==true){
            if (Globales.Receive.equals("Blocking")){
                this.bloquear();
                if (this.cola.VaciaLista()==false){
                    this.cola.PrimerNodo.MsjContenido.recibir();
                    //this.cola.PrimerNodo.MsjContenido.origen.nombre.equals("asd");
                    this.desbloquear();
                    this.cola.PrimerNodo.MsjContenido.origen.desbloquear();
                    this.cola.EliminaInicio();
                    // modificar log //si se desea devolver algo a la consola de R/ hacerlo aca *******
                }
                else{
                    //si se desea devolver msj de error que no recibio nada y que se encuentra bloqueado en la consolad R/ hacerlo aca *******
                }
            }
            else{
                if (Globales.Receive.equals("Nonblocking")){
                    if (this.cola.VaciaLista()==false){
                        this.cola.PrimerNodo.MsjContenido.recibir();      
                        this.cola.PrimerNodo.MsjContenido.origen.desbloquear();
                        this.cola.EliminaInicio();
                        // modificar log //si se desea devolver algo a la consola de R/ hacerlo aca *******
                    }
                    else{
                        //si se desea devolver msj de error que no recibio nada y que se encuentra bloqueado en la consolad R/ hacerlo aca *******
                    }
                }
                else{
                    // caso de PRUEBA DE LLEGADA
                }
            }
        }
        else{
            if (Globales.Receive.equals("Blocking")){
                this.bloquear();
                if (this.cola.VaciaLista()==false){
                    this.cola.NODO[X].MsjContenido.recibir();
                    this.desbloquear();
                    this.cola.NODO[X].MsjContenido.origen.desbloquear();
                    this.cola.EliminaInicio();
                    // modificar log //si se desea devolver algo a la consola de R/ hacerlo aca *******
                }
                else{
                    //si se desea devolver msj de error que no recibio nada y que se encuentra bloqueado en la consolad R/ hacerlo aca *******
                }
            }
            else{
                if (Globales.Receive.equals("Nonblocking")){
                    if (this.cola.VaciaLista()==false){
                        this.cola.NODO[X].MsjContenido.recibir();      
                        this.cola.NODO[X].MsjContenido.origen.desbloquear();
                        this.cola.EliminaMedio(NODO[X]);
                        // modificar log //si se desea devolver algo a la consola de R/ hacerlo aca *******
                    }
                    else{
                        //si se desea devolver msj de error que no recibio nada y que se encuentra bloqueado en la consolad R/ hacerlo aca *******
                    }
                }
                else{
                    // caso de PRUEBA DE LLEGADA
                }
            }
        }
        }*/
    
    
               
    
    /*void receiveDDE(){
        
        this.cola
        
    }*/
    
    void create_MB(){
        
    }
    /*
    void receiveDDI(){
        if (this.cola.VaciaLista()==false){
            if (Globales.FIFO==true){
                if (Globales.Receive.equals("Blocking")){
                    this.bloquear();                
                    this.cola.PrimerNodo.MsjContenido.recibir();
                    this.desbloquear();
                    this.cola.PrimerNodo.MsjContenido.origen.desbloquear();
                    this.cola.EliminaInicio();
                    // modificar log //si se desea devolver algo a la consola de R/ hacerlo aca *******
                }
                else{
                    if (Globales.Receive.equals("Nonblocking")){
                        if (this.cola.VaciaLista()==false){
                            this.cola.PrimerNodo.MsjContenido.recibir();      
                            this.cola.PrimerNodo.MsjContenido.origen.desbloquear();
                            this.cola.EliminaInicio();
                            // modificar log //si se desea devolver algo a la consola de R/ hacerlo aca *******
                        }
                    else{
                        // caso de PRUEBA DE LLEGADA
                        }
                    }
                }        
            }
            else{//prioridad
                
            }
        }
        else{
            //si se desea devolver ALGUN ERROR POR QUE LA LISTA ESTA VACIA a la consola de R/ hacerlo aca *******
        }
    }*/
}