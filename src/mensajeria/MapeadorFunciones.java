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
                        //mappear la funcion
                        Globales.PantPrincipal.CreaTabla();
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
                        break;
                    }
                    if (Globales.DireccionamientoDirecto){
                        if (Globales.FIFO){
                            if ((!(parametros[0].equals(""))) && (!(parametros[1].equals(""))) && (!(parametros[2].equals(""))) && (IsProceso(parametros[0])) && (IsProceso(parametros[1])) && (!(parametros[0].equals(parametros[1] ))) ){
                                //mappear la funcion
                                Globales.buscarPro(parametros[0]).sendDirecto(parametros[1], parametros[2]);
                                exito = true;
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
                                    Globales.buscarPro(parametros[0]).sendDirecto(parametros[0], parametros[1], prioridad);
                                    exito = true;
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
                                if (p.mailbox_conectado.equals(parametros[1])){
                                    p.sendIndirecto(parametros[1], parametros[2]);
                                    exito = true;
                                }
                                else{
                                    PantallaError pe = new PantallaError("El proceso en cuestión no está conectado con el buzón especificado.");
                                    exito = false;
                                }
                            }
                        }
                        else{
                            if ((!(parametros[0].equals(""))) && (!(parametros[1].equals(""))) && (!(parametros[2].equals(""))) && (!(parametros[3].equals(""))) && (IsMailbox(parametros[1])) && (IsProceso(parametros[0]))){
                                //mappear la funcion
                                Proceso p = Globales.buscarPro(parametros[0]);
                                if (p.mailbox_conectado.equals(parametros[1])){
                                    int prioridad = Integer.parseInt(parametros[3]);
                                    if ((prioridad < 4)&&(prioridad > 0)){
                                        p.sendIndirecto(parametros[1], parametros[2], prioridad);
                                        exito = true;
                                    }
                                    else{    
                                        PantallaError pe = new PantallaError("La prioridad del mensaje que ingresó no es entre 1 y 3.");
                                        exito = false;
                                    }
                                }
                                else{
                                    PantallaError pe = new PantallaError("El proceso en cuestión no está conectado con el buzón especificado.");
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
