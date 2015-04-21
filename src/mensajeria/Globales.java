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
}
