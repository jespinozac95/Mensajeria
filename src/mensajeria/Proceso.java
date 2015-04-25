
package mensajeria;

import java.util.LinkedList;
import java.util.List;


public class Proceso {
    public String nombre;
    public boolean conectado;
    public String mailbox_conectado;
    //public String log = "C:\\Users\\Adrian\\Desktop\\Mensajeria\\app\\log\\log"; // path
    public Bitacora bitacora; 
    public Cola cola; //para direccionamiento directo
    public boolean Bloqueado;
    
    public Proceso(String name){
        if (Globales.DireccionamientoDirecto==true){
            this.nombre = name;
            //this.log= this.log+this.nombre+".txt";  
            List <Registro> r= new LinkedList<Registro>(); 
            bitacora = new Bitacora (r); 
            List <Mensaje> m = new LinkedList<Mensaje>();
            cola = new Cola(m);
            this.Bloqueado = false;
        }
        else{
            if (Globales.IndirectoEstatico==true){
                this.nombre = name;
                //this.log= this.log+this.nombre+".txt";
                Mailbox mb = new Mailbox("MB"+this.nombre);
                Globales.mails[Globales.UltimoIndiceMailbox]=mb;
                //System.out.println("Globales.mails["+Globales.UltimoIndiceMailbox+"] = "+Globales.mails[Globales.UltimoIndiceMailbox].nombre);
                Globales.UltimoIndiceMailbox++;
                this.conectar(mb.nombre);
                this.Bloqueado = false;
            }
            else{
                this.nombre = name;
                //this.log= this.log+this.nombre+".txt";
                this.mailbox_conectado = "";
                this.conectado = false;
                this.Bloqueado = false;
            }
        }
    }

    void conectar(String nameMBox){
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
    
    void error(){
        System.out.println("ERROR. no estoy conectado en ningun lugar, no puedo recibir mensaje");
    }
    
    void sendDirecto(String NombreProcesoDestino, String msg){
        this.running();
        if (Globales.SendBlocking==true){
            this.bloquear();
            this.sending(NombreProcesoDestino, msg);
            this.desbloquear();
        }
        Proceso procesoDestino = Globales.buscarPro(NombreProcesoDestino);
        Mensaje NewMsj = new Mensaje(this,procesoDestino,msg);
        System.out.println("Creó mensaje");
        procesoDestino.cola.agregar_final(NewMsj);
        System.out.println("Agregó msj al origen");
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
        this.running();
        Mensaje msj;
        if (Globales.Receive=="Blocking"){
            if (this.conectado==true){
                Mailbox MB =Globales.buscarMB(this.mailbox_conectado);
                this.bloquear();
                if (MB.contenido.estoyVacio()==false){
                    if (Globales.FIFO==true){
                        msj= MB.contenido.obtener_mensaje();
                    }
                    else{
                        msj= MB.contenido.devolver_mayor_prioridad();
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
                this.error();
            }
        }
        else{
            if (Globales.Receive=="NonBlocking"){
                if (this.conectado==true){
                    Mailbox MB =Globales.buscarMB(this.mailbox_conectado);
                    if (MB.contenido.estoyVacio()==false){
                        if (Globales.FIFO==true){
                            msj= MB.contenido.obtener_mensaje();
                        }
                        else{
                            msj= MB.contenido.devolver_mayor_prioridad();
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
                    this.error();
                }
            }
            else{
                if (Globales.Receive=="Prueba de llegada"){
                    if (this.conectado==true){
                        Mailbox MB =Globales.buscarMB(this.mailbox_conectado);
                        this.bloquear();
                        if (MB.contenido.estoyVacio()==false){
                            if (Globales.FIFO==true){
                                msj= MB.contenido.obtener_mensaje();
                            }
                            else{
                                msj= MB.contenido.devolver_mayor_prioridad();
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
                    else{
                        this.error();
                    }
                }
            }
        }
    }
    
    void receiveI(String NombreProcesoOrigen){
        this.running();
        Mensaje msj;
        if (Globales.Receive=="Blocking"){
            if (this.conectado==true){
                Mailbox MB =Globales.buscarMB(this.mailbox_conectado);
                this.bloquear();
                if (MB.contenido.estoyVacio()==false){
                    if (Globales.FIFO==true){
                        msj= MB.contenido.obtener_mensaje_explicito(NombreProcesoOrigen);
                    }
                    else{
                        msj= MB.contenido.devolver_mayor_prioridad_explícito(NombreProcesoOrigen);
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
                this.error();
            }
        }
        else{
            if (Globales.Receive=="NonBlocking"){
                if (this.conectado==true){
                    Mailbox MB =Globales.buscarMB(this.mailbox_conectado);
                    if (MB.contenido.estoyVacio()==false){
                        if (Globales.FIFO==true){
                            msj= MB.contenido.obtener_mensaje_explicito(NombreProcesoOrigen);
                        }
                        else{
                            msj= MB.contenido.devolver_mayor_prioridad_explícito(NombreProcesoOrigen);
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
                    this.error();
                }
            }
            else{
                if (Globales.Receive=="Prueba de llegada"){
                    if (this.conectado==true){
                        Mailbox MB =Globales.buscarMB(this.mailbox_conectado);
                        this.bloquear();
                        if (MB.contenido.estoyVacio()==false){
                            if (Globales.FIFO==true){
                                msj= MB.contenido.obtener_mensaje_explicito(NombreProcesoOrigen);
                            }
                            else{
                                msj= MB.contenido.devolver_mayor_prioridad_explícito(NombreProcesoOrigen);
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
                    else{
                        this.error();
                    }
                }
            }
        }
    }
    
       
    void create_MB(String nombre){
        //maximo son 6 MB
        if (Globales.UltimoIndiceMailbox == 6){
            PantallaError pe = new PantallaError("Ya hay 6 buzones (mailbox) en ejecución, no puede crear más.");
        }
        else{
            Mailbox mb = new Mailbox("MB"+nombre);
            Globales.mails[Globales.UltimoIndiceMailbox]=mb;
            //System.out.println("Globales.mails["+Globales.UltimoIndiceMailbox+"] = "+Globales.mails[Globales.UltimoIndiceMailbox].nombre);
            Globales.UltimoIndiceMailbox++;
            //System.out.println("creó el mb: "+mb.nombre+" y lo insertó el el arreglo global de mb");
        }
    }

}