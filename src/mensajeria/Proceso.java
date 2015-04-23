
package mensajeria;

public class Proceso {
    public String nombre;
    public boolean conectado;
    public String mailbox_conectado;
    public String log = "C:\\Users\\Adrian\\Desktop\\Mensajeria\\app\\log\\log"; // path
    public ListaSimple cola; //para direccionamiento directo
    public boolean Bloqueado;
   
    
    public Proceso(String name){
        if (Globales.DireccionamientoDirecto==true){
            this.nombre = name;
            this.log= this.log+this.nombre+".txt";  
            cola = new ListaSimple();
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
    
    
    /*public Mailbox buscarMB(String MB){
        int j = Globales.mails.length;
        for (int i=0; i<j;i++){
            if (Globales.mails[i].nombre.equals(MB)) // buscarlo ********
            {return Globales.mails[i]; }
        }
        return Globales.mails[0]; 
    }
    
    public Proceso buscarPro(String name){
        int j = Globales.procs.length;
        for (int i=0; i<j;i++){
            if (Globales.procs[i].nombre.equals(name)) // buscarlo ********
            {return Globales.procs[i]; }
        }
        return Globales.procs[0]; 
    }*/
    
    void bloquear(){
        this.Bloqueado=true;
    }
    
    void desbloquear(){
        this.Bloqueado=false;
    }
    
    void send(String nombre, String msg, int Prioridad){
        //if ((Globales.SendBlocking==true) && (this.Bloqueado==true)){
        if (this.Bloqueado==true){
            //MENSAJE DE ERROR; ESTOY BLOQUEADO
        }
        else{
            if (Globales.DireccionamientoDirecto==true){
                Mensaje msj = new Mensaje(this,Globales.buscarPro(nombre),Prioridad,msg);
                Globales.buscarPro(nombre).cola.InsertaFinal(msj.id);
                Globales.buscarPro(nombre).cola.UltimoNodo.msj.contenido=msj.contenido;
            }
            else{ // si es indirecto
                if (this.conectado==true){
                    Mensaje msj = new Mensaje(this,Globales.buscarPro(nombre),Prioridad,msg);   
                    Globales.buscarMB(this.mailbox_conectado).contenido.InsertaFinal(msj.id);
                    Globales.buscarMB(this.mailbox_conectado).contenido.UltimoNodo.msj.contenido=msj.contenido;
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
                Globales.buscarPro(nombre).cola.InsertaFinal(msj.id);
                Globales.buscarPro(nombre).cola.UltimoNodo.msj=msj;
            }
            else{ // si es indirecto
                if (this.conectado==true){
                    Mensaje msj = new Mensaje(this,Globales.buscarPro(nombre),msg);    
                    Globales.buscarMB(this.mailbox_conectado).contenido.InsertaFinal(msj.id);
                    Globales.buscarMB(this.mailbox_conectado).contenido.UltimoNodo.msj=msj;
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