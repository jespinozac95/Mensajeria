/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensajeria;

/**
 *
 * @author Jespi_000
 */
public class Globales {
    public static String[] FuncionesPermitidas = new String[] {"view","create","reset","send","receive","connect_mailbox","disconnect_mailbox","create_mailbox"};
    public static String TextoAyuda = "";
    //Datos (reseteables) de configuración
    public static boolean SendBlocking = true;
    public static String Receive = "Blocking"; //Blocking, Non-Blocking o Prueba de llegada
    public static boolean ReceiveExplicito = true;
    public static boolean DireccionamientoDirecto = false;
    public static boolean IndirectoEstatico = false;
    public static boolean LargoMsjFijo = true;
    public static int LargoMsj = 0;
    public static boolean FIFO = false;
    public static int Procesos = 0;
    public static Mailbox[] mails = new Mailbox[10];
    public static Proceso[] procs = new Proceso[6];
    public static String [] NombresProcesos = new String[6]; 
    public static int TamanoCola = 0;
    
    public static Mailbox buscarMB(String MB){
        int j = Globales.mails.length;
        for (int i=0; i<j;i++){
            if (Globales.mails[i].nombre.equals(MB)) // buscarlo ********
            {return Globales.mails[i]; }
        }
        return Globales.mails[0]; 
    }
    
    public static Proceso buscarPro(String name){
        int j = Globales.procs.length;
        for (int i=0; i<j;i++){
            if (Globales.procs[i].nombre.equals(name)) // buscarlo ********
            {return Globales.procs[i]; }
        }
        return Globales.procs[0]; 
    }
    
}
