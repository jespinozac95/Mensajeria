
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
        System.out.println("me conecte");
    }
    
    void desconectar(){
        Globales.buscarMB(this.mailbox_conectado).desconectar(this);
        this.mailbox_conectado = "";
        this.conectado = false;
        System.out.println("me desconecte");
    }
        
    void bloquear(){
        this.Bloqueado=true;
        System.out.println("me bloquee, estoy bloqueado");
    }
    
    void bloquear(String algo){
        System.out.println(algo);
    }
    
    void desbloquear(){
        this.Bloqueado=false;
        System.out.println("me desbloquee, estoy desbloqueado");
    }
    
    void running(){
        System.out.println("estoy running");
    }
    
    void sending(String destino, String contenido){
        System.out.println("enviando el mensaje "+contenido+ "; a "+destino);
    }
    
    void receiving(){
        System.out.println("recibiendo mensaje");
    }
    
    void sendDirecto(String NombreProcesoDestino, String msg){
        this.running();
        if (Globales.SendBlocking==true){
            this.bloquear();
            this.sending(NombreProcesoDestino, msg);
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
            this.sending(NombreProcesoDestino, msg);
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
            this.sending(NombreMailboxDestino, msg);
            this.desbloquear();
        }
        Mensaje NewMsj = new Mensaje(this,null,msg);
        Globales.buscarMB(NombreMailboxDestino).contenido.agregar_final(NewMsj);
        this.running();
    }
    
    void sendIndirecto(String NombreMailboxDestino, String msg, int Prioridad){
        this.running();
        if (Globales.SendBlocking==true){
            this.bloquear();
            this.sending(NombreMailboxDestino, msg);
            this.desbloquear();
        }
        Mensaje NewMsj = new Mensaje(this,null,msg,Prioridad);
        Globales.buscarMB(NombreMailboxDestino).contenido.agregar_final(NewMsj);
        this.running();
    }  
        
    void receiveD(){
        this.running();
        Mensaje msj;
        if (Globales.Receive=="Blocking"){
            this.bloquear();
            if (this.cola.estoyVacio()==false){
                if (Globales.FIFO==true){
                    msj= this.cola.obtener_mensaje();
                }
                else{
                    msj= this.cola.devolver_mayor_prioridad();
                }
                if (msj==null){
                    this.bloquear("no me han llegado msj");
                }
                else{
                    msj.recibir();
                    msj.leer();
                    this.receiving();
                    this.desbloquear();
                    this.running();
                }
            }
            else{
                this.bloquear("no me han llegado msj");                    
            }
        }
        else{
            if (Globales.Receive=="NonBlocking"){
                if (this.cola.estoyVacio()==false){
                    if (Globales.FIFO==true){
                        msj= this.cola.obtener_mensaje();
                    }
                    else{
                        msj= this.cola.devolver_mayor_prioridad();
                    }
                    if (msj==null){
                        this.bloquear("no me han llegado msj");
                        this.running();
                    }
                    else{
                        msj.recibir();
                        msj.leer();
                        this.receiving();
                        this.running();
                    }
                }
                else{
                    this.bloquear("no me han llegado msj");       
                    this.running();
                }
            }
            else{
                if (Globales.Receive=="Prueba de llegada"){
                    this.bloquear();
                    if (this.cola.estoyVacio()==false){
                        if (Globales.FIFO==true){
                             msj= this.cola.obtener_mensaje();
                        }
                    else{
                        msj= this.cola.devolver_mayor_prioridad();
                    }
                    if (msj==null){
                        this.bloquear("no me han llegado msj");
                        this.running();
                        this.receiveD();
                    }
                    else{
                        msj.recibir();
                        msj.leer();
                        this.receiving();
                        this.running();
                    }
                }
                else{
                    this.bloquear("no me han llegado msj");       
                    this.running();
                    this.receiveD();
                }
                }
            }
            }
    }
    
    void receiveD(String NombreProcesoOrigen){
        this.running();
        Mensaje msj;
        if (Globales.Receive=="Blocking"){
            this.bloquear();
            if (this.cola.estoyVacio()==false){
                if (Globales.FIFO==true){
                    msj= this.cola.obtener_mensaje_explicito(NombreProcesoOrigen);
                }
                else{
                    msj= this.cola.devolver_mayor_prioridad_explícito(NombreProcesoOrigen);
                }
                if (msj==null){
                    this.bloquear("no me han llegado msj");
                }
                else{
                    msj.recibir();
                    msj.leer();
                    this.receiving();
                    this.desbloquear();
                    this.running();
                }
            }
            else{
                this.bloquear("no me han llegado msj");                    
            }
        }
        else{
            if (Globales.Receive=="NonBlocking"){
                if (this.cola.estoyVacio()==false){
                    if (Globales.FIFO==true){
                        msj= this.cola.obtener_mensaje_explicito(NombreProcesoOrigen);
                    }
                    else{
                        msj= this.cola.devolver_mayor_prioridad_explícito(NombreProcesoOrigen);
                    }
                    if (msj==null){
                        this.bloquear("no me han llegado msj");
                        this.running();
                    }
                    else{
                        msj.recibir();
                        msj.leer();
                        this.receiving();
                        this.running();
                    }
                }
                else{
                    this.bloquear("no me han llegado msj");       
                    this.running();
                }
            }
            else{
                if (Globales.Receive=="Prueba de llegada"){
                    this.bloquear();
                    if (this.cola.estoyVacio()==false){
                        if (Globales.FIFO==true){
                             msj= this.cola.obtener_mensaje_explicito(NombreProcesoOrigen);
                        }
                    else{
                        msj= this.cola.devolver_mayor_prioridad_explícito(NombreProcesoOrigen);
                    }
                    if (msj==null){
                        this.bloquear("no me han llegado msj");
                        this.running();
                        this.receiveD(NombreProcesoOrigen);
                    }
                    else{
                        msj.recibir();
                        msj.leer();
                        this.receiving();
                        this.running();
                    }
                }
                else{
                    this.bloquear("no me han llegado msj");       
                    this.running();
                    this.receiveD(NombreProcesoOrigen);
                }
                }
            }
            }
        }
    
    void receiveI(){
        if(Globales.DireccionamientoDirecto == true){
            
        }
        else{
            
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