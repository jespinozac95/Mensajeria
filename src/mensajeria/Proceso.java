package mensajeria;

import java.util.LinkedList;
import java.util.List;
import java.lang.*;


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
            
            List <Registro> r= new LinkedList<Registro>(); 
            bitacora = new Bitacora (r); 
            List <Mensaje> m = new LinkedList<Mensaje>();
            cola = new Cola(m);
            if (Globales.IndirectoEstatico==true){
                //System.out.println("Voy a conectar el proceso "+name+" a su mailbox");
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
        //System.out.println("Conectado en mailbox --> proceso");
        this.mailbox_conectado = Globales.buscarMB(nameMBox).nombre;
        //System.out.println("Conectado en proceso --> mb");
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
        this.Bloqueado=false;
        System.out.println("estoy running");
    }
    
    void sending(String destino, String contenido){
        System.out.println("enviando el mensaje "+contenido+ "; a "+destino);
    }
    
    void receiving(){
        System.out.println("recibiendo mensaje(P)");
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
        else{
            this.sending(NombreProcesoDestino, msg);
        }
        Proceso procesoDestino = Globales.buscarPro(NombreProcesoDestino);
        Mensaje NewMsj = new Mensaje(this,procesoDestino,msg);
        Registro NewReg = new Registro("send()",this.nombre,Boolean.toString(this.Bloqueado),procesoDestino.nombre,msg); 
        Registro NewReg2 = new Registro("Mensaje Recibido",this.nombre,Boolean.toString(procesoDestino.Bloqueado),procesoDestino.nombre,msg); 
        //System.out.println("Creó mensaje");
        procesoDestino.cola.agregar_final(NewMsj);
        Globales.ColaCentral.agregar_final(NewMsj);
        this.bitacora.agregar_final(NewReg);
        Globales.LogCentral.add(NewReg); 
        procesoDestino.bitacora.agregar_final(NewReg2);
        Globales.LogCentral.add(NewReg2);
        //System.out.println("Agregó msj al origen");
        this.running();
    }
    
    void sendDirecto(String NombreProcesoDestino, String msg, int Prioridad){
        this.running();
        if (Globales.SendBlocking==true){
            this.bloquear();
            this.sending(NombreProcesoDestino, msg);
            this.desbloquear();
        }
        else{
        this.sending(NombreProcesoDestino, msg);
        }
        Mensaje NewMsj = new Mensaje(this,Globales.buscarPro(NombreProcesoDestino),msg,Prioridad);
        Registro NewReg = new Registro("send()",this.nombre,Boolean.toString(this.Bloqueado),NombreProcesoDestino,msg); 
        Registro NewReg2 = new Registro("Mensaje Recibido",this.nombre,Boolean.toString(Globales.buscarPro(NombreProcesoDestino).Bloqueado),NombreProcesoDestino,msg);
        this.bitacora.agregar_final(NewReg);
        Globales.LogCentral.add(NewReg);
        Globales.LogCentral.add(NewReg2);
        Globales.buscarPro(NombreProcesoDestino).cola.agregar_final(NewMsj);
        Globales.ColaCentral.agregar_final(NewMsj);
        Globales.buscarPro(NombreProcesoDestino).bitacora.agregar_final(NewReg2);
        this.running();
    }
    
    void sendIndirecto(String NombreMailboxDestino, String msg){
        //if (this.mailbox_conectado.equals(NombreMailboxDestino)){
         
        this.running();
        if (Globales.SendBlocking==true){
            this.bloquear();
            this.sending(NombreMailboxDestino, msg);
            this.desbloquear();
        }
        else{
        this.sending(NombreMailboxDestino, msg);
        }
        Mensaje NewMsj = new Mensaje(this,Globales.buscarMB(NombreMailboxDestino),msg);
        //System.out.println("Creó msj");
        Registro NewReg = new Registro("send()",this.nombre,Boolean.toString(this.Bloqueado),NombreMailboxDestino,msg); 
        Registro NewReg2 = new Registro("Mensaje Recibido",this.nombre,"",NombreMailboxDestino,msg);
        //System.out.println("Creó registros");
        Globales.buscarMB(NombreMailboxDestino).contenido.agregar_final(NewMsj);
        Globales.ColaCentral.agregar_final(NewMsj);
        //System.out.println("Mandó msj");
        this.bitacora.agregar_final(NewReg);
        Globales.LogCentral.add(NewReg);
        //System.out.println("Asignó reg a Proceso");
        Globales.buscarMB(NombreMailboxDestino).bitacora.agregar_final(NewReg2);
        Globales.LogCentral.add(NewReg2);
        //System.out.println("Asignó reg2 a MB");
        this.running();
    }
    
    void sendIndirecto(String NombreMailboxDestino, String msg, int Prioridad){
        this.running();
        if (Globales.SendBlocking==true){
            this.bloquear();
            this.sending(NombreMailboxDestino, msg);
            this.desbloquear();
        }
        else{
        this.sending(NombreMailboxDestino, msg);
        }
        Mensaje NewMsj = new Mensaje(this,Globales.buscarMB(NombreMailboxDestino),msg,Prioridad);
        //System.out.println("Creó msj");
        Registro NewReg = new Registro("send()",this.nombre,Boolean.toString(this.Bloqueado),NombreMailboxDestino,msg); 
        Registro NewReg2 = new Registro("Mensaje Recibido",this.nombre,"",NombreMailboxDestino,msg);
        //System.out.println("Creó registros");
        Globales.buscarMB(NombreMailboxDestino).contenido.agregar_final(NewMsj);
        Globales.ColaCentral.agregar_final(NewMsj);
        Globales.buscarMB(NombreMailboxDestino).bitacora.agregar_final(NewReg2);
        this.bitacora.agregar_final(NewReg);
        Globales.LogCentral.add(NewReg);
        Globales.LogCentral.add(NewReg2);
        //System.out.println("Creó asignó reg2 a MB");
        this.running();
    }  
       
    
    
    void receiveD(){
        System.out.println("(╯°□°）╯︵ ┻━┻)");
        this.running();
        Mensaje msj;
        if (Globales.Receive=="Blocking"){
            System.out.println("aca estoy *******************0");
            this.bloquear();
            if (this.cola.estoyVacio()==false){
                System.out.println("aca estoy *******************0.0");
                if (Globales.FIFO==true){
                    msj= this.cola.obtener_mensaje();
                    this.cola.eliminar_inicio();
                    System.out.println("aca estoy *******************0.01");
                }
                else{
                    msj= this.cola.devolver_mayor_prioridad();
                    System.out.println("aca estoy *******************0.001");
                }
                if (msj==null){
                    this.bloquear("no me han llegado msj");
                    System.out.println("aca estoy *******************0.0001");
                }
                else{
                    msj.recibir();
                    Registro NewReg2 = new Registro("receive()",msj.origen.nombre,Boolean.toString(Globales.buscarPro(this.nombre).Bloqueado),this.nombre,msj.contenido);
                    this.bitacora.agregar_final(NewReg2);
                    Globales.LogCentral.add(NewReg2);
                    msj.leer();
                    this.receiving();
                    this.desbloquear();
                    this.running();
                    System.out.println("aca estoy *******************0.00001");
                }
            }
            else{
                this.bloquear("no me han llegado msj");                    
            }
        }
        else{
            System.out.println("aca estoy *******************0.1");
            if (Globales.Receive=="Non-Blocking"){
                System.out.println("aca estoy *******************0.10");
                if (this.cola.estoyVacio()==false){
                    System.out.println("aca estoy *******************0.100");
                    if (Globales.FIFO==true){
                        System.out.println("aca estoy *******************0.11a");
                        msj= this.cola.obtener_mensaje();
                        System.out.println("aca estoy *******************0.11b");
                        this.cola.eliminar_inicio();
                        System.out.println("aca estoy *******************0.11d");
                    }
                    else{
                        System.out.println("aca estoy *******************0.12a");
                        msj= this.cola.devolver_mayor_prioridad();
                        System.out.println("aca estoy *******************0.12b");
                        //revisar si se elimina o se debe eliminar desde aca
                    }
                    if (msj==null){
                        this.bloquear("no me han llegado msj");
                        this.running();
                        System.out.println("aca estoy *******************0.13");
                    }
                    else{
                        msj.recibir();
                        Registro NewReg2 = new Registro("receive()",msj.origen.nombre,Boolean.toString(Globales.buscarPro(this.nombre).Bloqueado),this.nombre,msj.contenido);
                        this.bitacora.agregar_final(NewReg2);
                        Globales.LogCentral.add(NewReg2);
                        msj.leer();
                        this.receiving();
                        this.running();
                        System.out.println("aca estoy *******************0.14");
                    }
                }
                else{
                    this.bloquear("no me han llegado MENSAJES");       
                    this.running();
                    System.out.println("aca estoy *******************0.15");
                }
            }
            else{
                System.out.println("aca estoy *******************0.2");
                if (Globales.Receive=="Prueba de llegada"){
                    this.receiveDAUX();
                }
            }
            }
    }
    
    void receiveDAUX(){
        Mensaje msj;
        this.bloquear();
        for (int i = 0; i<100;i++){
            if (i==99)
            {
                this.bloquear("se intento hacer la prueba de llegada el maximo de veces, el proceso continuara");  
                this.running();
            }
            else{
                    if (this.cola.estoyVacio()==false){
                        if (Globales.FIFO==true){
                             msj= this.cola.obtener_mensaje();
                             this.cola.eliminar_inicio();
                             System.out.println("aca estoy *******************3");
                        }
                    else{
                        msj= this.cola.devolver_mayor_prioridad();
                    }
                    if (msj==null){
                        this.bloquear("no me han llegado msj");
                        this.running();
                        this.bloquear("pero continuare a la espera");
                    }
                    else{
                        msj.recibir();
                        Registro NewReg2 = new Registro("receive()",msj.origen.nombre,Boolean.toString(Globales.buscarPro(this.nombre).Bloqueado),this.nombre,msj.contenido);
                        this.bitacora.agregar_final(NewReg2);
                        Globales.LogCentral.add(NewReg2);
                        msj.leer();
                        this.receiving();
                        this.running();
                        break;
                    }
                }
                else{
                    this.bloquear("Prueba de llegada, # "+Integer.toString(i+1));  
                    this.bloquear("no me han llegado MSJS, seguire haciendo pruebas de llegada");       
                    this.running();
                    //Thread.sleep(4000);
                    //contador++;
                }
            }
        }
        }
    
    void receiveDAUX(String NombreProcesoOrigen){
        Mensaje msj;
        this.bloquear();
        for (int i = 0; i<100;i++){
            if (i==99)
            {
                this.bloquear("se intento hacer la prueba de llegada el maximo de veces, el proceso continuara");  
                this.running();
            }
            else{
    
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
                        this.bloquear("pero continuare a la espera");
                    }
                    else{
                        msj.recibir();
                        Registro NewReg2 = new Registro("receive()",msj.origen.nombre,Boolean.toString(Globales.buscarPro(this.nombre).Bloqueado),this.nombre,msj.contenido);
                        this.bitacora.agregar_final(NewReg2);
                        Globales.LogCentral.add(NewReg2);
                        msj.leer();
                        this.receiving();
                        this.running();
                        System.out.println("aca estoy *******************2.9");
                        break;
                    }
                }
                else{
                    this.bloquear("Prueba de llegada, # "+Integer.toString(i+1));  
                    this.bloquear("no me han llegado MSJS, seguire haciendo pruebas de llegada");    
                    //Thread.sleep(4000);
                }
            }
            }
    }
     
    void receiveD(String NombreProcesoOrigen){
        System.out.println("(╯°□°）╯︵ ┻━┻)");
        this.running();
        Mensaje msj;
        try{
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
                    Registro NewReg2 = new Registro("receive()",msj.origen.nombre,Boolean.toString(Globales.buscarPro(this.nombre).Bloqueado),this.nombre,msj.contenido);
                    this.bitacora.agregar_final(NewReg2);
                    Globales.LogCentral.add(NewReg2);
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
            if (Globales.Receive=="Non-Blocking"){
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
                        Registro NewReg2 = new Registro("receive()",msj.origen.nombre,Boolean.toString(Globales.buscarPro(this.nombre).Bloqueado),this.nombre,msj.contenido);
                        this.bitacora.agregar_final(NewReg2);
                        Globales.LogCentral.add(NewReg2);
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
                    this.receiveDAUX(NombreProcesoOrigen);
                }
            }
            }
        }
        catch(Exception e){
            PantallaError pe = new PantallaError("No se encontró un mensaje de dicho proceso para ser recibido.");
        }
        }
 
    
    
    void receiveI(){
        System.out.println("(╯°□°）╯︵ ┻━┻)");
        this.running();
        Mensaje msj;
        if (Globales.Receive=="Blocking"){
            if (this.conectado==true){
                Mailbox MB =Globales.buscarMB(this.mailbox_conectado);
                this.bloquear();
                if (MB.contenido.estoyVacio()==false){
                    if (Globales.FIFO==true){
                        msj= MB.contenido.obtener_mensaje();
                        MB.contenido.eliminar_inicio();
                    }
                    else{
                        msj= MB.contenido.devolver_mayor_prioridad();
                    }
                    if (msj==null){
                        this.bloquear("no me han llegado msj");
                    }
                    else{
                        msj.recibir();
                        Registro NewReg2 = new Registro("receive()",msj.origen.nombre,Boolean.toString(Globales.buscarPro(this.nombre).Bloqueado),this.nombre,msj.contenido);
                        this.bitacora.agregar_final(NewReg2);
                        Globales.LogCentral.add(NewReg2);
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
            if (Globales.Receive=="Non-Blocking"){
                if (this.conectado==true){
                    Mailbox MB =Globales.buscarMB(this.mailbox_conectado);
                    if (MB.contenido.estoyVacio()==false){
                        if (Globales.FIFO==true){
                            msj= MB.contenido.obtener_mensaje();
                            MB.contenido.eliminar_inicio();
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
                            Registro NewReg2 = new Registro("receive()",msj.origen.nombre,Boolean.toString(Globales.buscarPro(this.nombre).Bloqueado),this.nombre,msj.contenido);
                            this.bitacora.agregar_final(NewReg2);
                            Globales.LogCentral.add(NewReg2);
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
                                MB.contenido.eliminar_inicio();
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
                                Registro NewReg2 = new Registro("receive()",msj.origen.nombre,Boolean.toString(Globales.buscarPro(this.nombre).Bloqueado),this.nombre,msj.contenido);
                                this.bitacora.agregar_final(NewReg2);
                                Globales.LogCentral.add(NewReg2);
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
        System.out.println("(╯°□°）╯︵ ┻━┻)");
        this.running();
        Mensaje msj;
        try{
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
                        Registro NewReg2 = new Registro("receive()",msj.origen.nombre,Boolean.toString(Globales.buscarPro(this.nombre).Bloqueado),this.nombre,msj.contenido);
                        this.bitacora.agregar_final(NewReg2);
                        Globales.LogCentral.add(NewReg2);
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
            if (Globales.Receive=="Non-Blocking"){
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
                            Registro NewReg2 = new Registro("receive()",msj.origen.nombre,Boolean.toString(Globales.buscarPro(this.nombre).Bloqueado),this.nombre,msj.contenido);
                            this.bitacora.agregar_final(NewReg2);
                            Globales.LogCentral.add(NewReg2);
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
                                Registro NewReg2 = new Registro("receive()",msj.origen.nombre,Boolean.toString(Globales.buscarPro(this.nombre).Bloqueado),this.nombre,msj.contenido);
                                this.bitacora.agregar_final(NewReg2);
                                Globales.LogCentral.add(NewReg2);
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
        catch(Exception e){
            PantallaError pe = new PantallaError("No se encontró un mensaje de dicho proceso para ser recibido.");
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