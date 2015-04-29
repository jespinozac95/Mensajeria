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
public class MapeadorFunciones {
    public static boolean IsProceso(String nombre){
        //System.out.println("Globales.procs.length = "+Globales.procs.length);
        for (int e=0;e<Globales.procs.length;e++){
            try{
                if (Globales.procs[e].nombre.equals(nombre)){
                    return true;
                }
            }
            catch(Exception ex){
                return false;
            }
        }
        return false;
    }
    public static boolean IsMailbox(String nombre){
        //System.out.println("Globales.mails.length = "+Globales.mails.length);
        for (int i=0;i<Globales.mails.length;i++){
            try{
                if (Globales.mails[i].nombre.equals(nombre)){
                    return true;
                }
            }
            catch(Exception ex){
                return false;
            }
        }
        return false;
    }
    public static boolean Mapear(String funcion, String[] parametros){
        boolean exito = false;
        //System.out.println("Funcion = "+funcion);
        //System.out.println("Exito = "+exito);
        try{
            switch (funcion){
                case "view":
                    if (parametros[0].equals("")){
                        if (Globales.view == null){
                            View v = new View();
                            Globales.view = v;
                            ViewCola vc = new ViewCola();
                            Globales.viewcola = vc;
                        }
                        //mappear la funcion
                        Object [][] o = Globales.PantPrincipal.CreaTabla();
                        Globales.PantPrincipal.MostrarTabla(o);
                        //Limpiar LOGS DE PROCESOS
                        for (int i =0;i<Globales.Procesos;i++){
                            List <Registro> r= new LinkedList<Registro>();
                            r = Globales.procs[i].bitacora.listaR ;
                        }
                        for (int e = 0;e<Globales.mails.length;e++){
                            if (Globales.mails[e]==null){
                                break;
                            }
                            else{
                                List <Registro> r= new LinkedList<Registro>();
                                Globales.mails[e].bitacora.listaR = r;
                            }
                        }
                        exito = true;
                    }
                    break;
                case "reset":
                    if (parametros[0].equals("")){
                        //resetear variables
                        Globales.reset = true;
                        Globales.LargoMsj = 0;
                        Globales.UltimoIndiceMailbox = 0;
                        Globales.mails = new Mailbox[10];
                        
                        //Limpiar LOGS DE PROCESOS
                        for (int i =0;i<Globales.Procesos;i++){
                            Globales.procs[i] = new Proceso(Globales.procs[i].nombre);
                        }
                                
                        VentanaInicio v = new VentanaInicio();
                        v.setVisible(true);
                        exito = true;
                    }
                    break;
                case "send":
                    if ((Globales.LargoMsjFijo) && (parametros[2].length() > Globales.LargoMsj)){
                        PantallaError pe = new PantallaError("El largo del mensaje sobrepasa el largo que especificó");
                        exito = false;
                        break;
                    }
                    if (Globales.DireccionamientoDirecto){
                        if (Globales.FIFO){
                            if ((!(parametros[0].equals(""))) && (!(parametros[1].equals(""))) && (!(parametros[2].equals(""))) && (IsProceso(parametros[0])) && (IsProceso(parametros[1])) && (!(parametros[0].equals(parametros[1] ))) ){
                                //mappear la funcion
                                Proceso emisor = Globales.buscarPro(parametros[0]);
                                Proceso receptor = Globales.buscarPro(parametros[1]);
                                if (receptor.cola.lista.size() < Globales.TamanoCola){
                                    emisor.sendDirecto(parametros[1], parametros[2]);
                                    exito = true;                                    
                                }
                                else{
                                    PantallaError pe = new PantallaError("El proceso receptor tiene su cola de mensajes llena");
                                    exito = false;
                                }
                                //System.out.println("Exito en send 1 dentro if= "+exito);
                            }
                            /*else{
                                System.out.println("parametros[0] = "+parametros[0]);
                                System.out.println("parametros[1] = "+parametros[1]);
                                System.out.println("IsProceso(parametros[0]) = "+IsProceso(parametros[0]));
                                System.out.println("IsProceso(parametros[1]) = "+IsProceso(parametros[1]));
                            }*/
                            //System.out.println("Exito en send 1 fuera if= "+exito);
                        }
                        else{
                            if ((!(parametros[0].equals(""))) && (!(parametros[1].equals(""))) && (!(parametros[2].equals(""))) && (!(parametros[3].equals(""))) && (IsProceso(parametros[0])) && (IsProceso(parametros[1])) && (!(parametros[0].equals(parametros[1] ))) ){
                                //mappear la funcion
                                int prioridad = Integer.parseInt(parametros[2]);
                                if ((prioridad < 4)&&(prioridad > 0)){
                                    Proceso emisor = Globales.buscarPro(parametros[0]);
                                    Proceso receptor = Globales.buscarPro(parametros[1]);
                                    if (receptor.cola.lista.size() < Globales.TamanoCola){
                                        emisor.sendDirecto(parametros[1], parametros[2],prioridad);
                                        exito = true;                                    
                                    }
                                    else{
                                        PantallaError pe = new PantallaError("El proceso receptor tiene su cola de mensajes llena");
                                        exito = false;
                                    }
                                }
                                else{    
                                    PantallaError pe = new PantallaError("La prioridad del mensaje que ingresó no es entre 1 y 3.");
                                    exito = false;
                                }
                                //System.out.println("Exito en send dentro if 2= "+exito);
                            }
                            //System.out.println("Exito en send 2 fuera if= "+exito);
                        }
                    }
                    else{
                        if (Globales.FIFO){
                            if ((!(parametros[0].equals(""))) && (!(parametros[1].equals(""))) && (!(parametros[2].equals(""))) && (IsMailbox(parametros[1])) && (IsProceso(parametros[0]))){
                                //mappear con la funcion
                                Proceso p = Globales.buscarPro(parametros[0]);
                                if (Globales.buscarMB(parametros[1]).contenido.lista.size() < Globales.TamanoCola){
                                    p.sendIndirecto(parametros[1], parametros[2]);
                                    exito = true;
                                }
                                else{
                                    PantallaError pe = new PantallaError("El buzón ya está lleno. No se le puede enviar un mensaje. Debe recibir uno antes.");
                                    exito = false;
                                }
                            }
                        }
                        else{
                            if ((!(parametros[0].equals(""))) && (!(parametros[1].equals(""))) && (!(parametros[2].equals(""))) && (!(parametros[3].equals(""))) && (IsMailbox(parametros[1])) && (IsProceso(parametros[0]))){
                                //mappear la funcion
                                Proceso p = Globales.buscarPro(parametros[0]);
                                int prioridad = Integer.parseInt(parametros[3]);
                                if ((prioridad < 4)&&(prioridad > 0)){
                                    if (Globales.buscarMB(parametros[1]).contenido.lista.size() < Globales.TamanoCola){
                                        p.sendIndirecto(parametros[1], parametros[2], prioridad);
                                        exito = true;
                                    }
                                    else{
                                        PantallaError pe = new PantallaError("El buzón ya está lleno. No se le puede enviar un mensaje. Debe recibir uno antes");
                                        exito = false;
                                    }
                                }
                                else{    
                                    PantallaError pe = new PantallaError("La prioridad del mensaje que ingresó no es entre 1 y 3.");
                                    exito = false;
                                }
                            }
                        }
                    }
                    break;
                case "receive":
                    if (Globales.DireccionamientoDirecto){
                        if (Globales.ReceiveExplicito){
                            if ((!(parametros[0].equals(""))) && (!(parametros[1].equals(""))) && (IsProceso(parametros[0])) && (IsProceso(parametros[1])) && (!(parametros[0].equals(parametros[1] ))) ){
                                //mappear la funcion
                                Globales.buscarPro(parametros[0]).receiveD(parametros[1]);
                                exito = true;
                            }
                        }
                        else{
                            if ((!(parametros[0].equals(""))) && (IsProceso(parametros[0]))){
                                //mappear con la funcion
                                Globales.buscarPro(parametros[0]).receiveD();
                                exito = true;
                            }
                        }
                    }
                    else{
                        if (Globales.ReceiveExplicito){
                            if ((!(parametros[0].equals(""))) && (!(parametros[1].equals(""))) && (IsProceso(parametros[0])) && (IsProceso(parametros[1])) && (!(parametros[0].equals(parametros[1] ))) ){
                                //mappear con la funcion
                                Globales.buscarPro(parametros[0]).receiveI(parametros[1]);
                                exito = true;
                            }
                        }
                        else{
                            if ((!(parametros[0].equals(""))) && (IsProceso(parametros[0]))){
                                //mappear con la funcion
                                Globales.buscarPro(parametros[0]).receiveI();
                                exito = true;
                            }
                        }
                    }
                    break;
                case "connect_mailbox":
                    if ((!(parametros[0].equals(""))) && (!(parametros[1].equals(""))) && (IsMailbox(parametros[1])) && (IsProceso(parametros[0]))){
                        //mappear con la funcion
                        Globales.buscarPro(parametros[0]).conectar(parametros[1]);
                        exito = true;
                    }
                    break;
                case "disconnect_mailbox":
                    if ((!(parametros[0].equals(""))) && (!(parametros[1].equals(""))) && (IsMailbox(parametros[1])) && (IsProceso(parametros[0]))){
                        //mappear con la funcion
                        Globales.buscarPro(parametros[0]).desconectar();
                        exito = true;
                    }
                    break;    
                case "create_mailbox":
                    if (!(Globales.IndirectoEstatico)){
                        /*if ((!(parametros[0].equals(""))) && (!(parametros[1].equals(""))) && (!(IsMailbox(parametros[1]))) && (IsProceso(parametros[0]))){
                            //mappear con la funcion
                            exito = true;
                        }
                    }
                    else{*/
                        if ((!(parametros[0].equals(""))) && (!(IsMailbox(parametros[0])))){
                            //mappear con la funcion
                            Globales.procs[0].create_MB(parametros[0]);
                            exito = true;
                        }   
                    }
                    break;
            }
            //System.out.println("Exito final try = "+exito);
            return exito;
        }
        catch (Exception e){
            exito = false;
        }
        //System.out.println("Exito fuera try = "+exito);
        return exito;
    }
    public static boolean ValidarFuncion(String funcion){
        if (Globales.DireccionamientoDirecto){
            if ((funcion.equals("create_mailbox")) || (funcion.equals("connect_mailbox")) || (funcion.equals("disconnect_mailbox"))){
                PantallaError e = new PantallaError("No puede utilizar los comandos para buzones (mailbox) en el direccionamiento directo.");
                return false;
            }
        }
        return true;
    }
}
