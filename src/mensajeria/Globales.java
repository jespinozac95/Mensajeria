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
 * @author Jespi_000
 */
public class Globales {
    public static String[] FuncionesPermitidas = new String[] {"view","reset","send","receive","connect_mailbox","disconnect_mailbox","create_mailbox"};
    public static String TextoAyuda = "";
    public static boolean reset = false;
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
    public static int TamanoCola = 0;
    public static int UltimoIndiceMailbox = 0;
    public static Pantalla_principal PantPrincipal;
    public static View view;
    public static ViewCola viewcola;
    public static InformacionView[] InformacionDeElementosParaView = new InformacionView[13];
    public static int UltimoIndiceElementos = 0;
    public static int NumeroElementos = 0;
    public static List<Registro> LogCentral = new LinkedList(); 
    public static List<Registro> LogCentralActivo;
    public static List <Mensaje> m = new LinkedList<Mensaje>();
    public static Cola ColaCentral = new Cola(m);
    
    public static InformacionView buscarElemento(String nombre){
        InformacionView elemento = null;
        boolean cambio = false;
        for (int i = 0;i<UltimoIndiceElementos;i++){
            /*if (Globales.InformacionDeElementosParaView[i] == null){
                break;
            }
            else{*/
            InformacionView e = Globales.InformacionDeElementosParaView[i];
            if (e.nombre.equals(nombre)){
                elemento = e;
                cambio = true;
                break;
                //}
            }
        }
        if (cambio==false){
            System.out.println("En buscarElemento, no se encontró el elemento.");
        }
        return elemento;
    }
    
    public static Mailbox buscarMB(String MB){
        int j = Globales.mails.length; 
        for (int i=0; i<j;i++){
            try{
                if (Globales.mails[i].nombre.equals(MB)) // buscarlo ********
                {return Globales.mails[i]; }
            }
            catch(Exception e){
                    break;
            }
        }
        return null;
        //return Globales.mails[0];
    }
    
    public static Proceso buscarPro(String name){
        int j = Globales.Procesos;
        for (int i=0; i<j;i++){
            try{
                if (Globales.procs[i].nombre.equals(name)) // buscarlo ********
                {
                return Globales.procs[i]; }
            }
            catch(Exception exe){
                break;
            }
        }
        return null;
        //return Globales.procs[0];
    }

    public static void ImprimirElementos() {
        for (int i=0;i<Globales.NumeroElementos;i++){
            System.out.println("Elemento: "+Globales.InformacionDeElementosParaView[i].nombre);
            for (int e=0;e<Globales.InformacionDeElementosParaView[i].bitacoraInfo.length;e++){
                try{
                    System.out.println("    Dato en bitacora: "+Globales.InformacionDeElementosParaView[i].bitacoraInfo[i][1].toString());
                }
                catch (Exception ex){
                    
                }
            }
        }
    }
    
}
