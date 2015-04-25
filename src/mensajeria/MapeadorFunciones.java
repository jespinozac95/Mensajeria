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
        try{
            switch (funcion){
                case "view":
                    if (parametros[0].equals("")){
                        //mappear la funcion
                        exito = true;
                    }
                    break;
                case "reset":
                    if (parametros[0].equals("")){
                        Globales.reset = true;
                        VentanaInicio v = new VentanaInicio();
                        v.setVisible(true);
                        exito = true;
                        //LIMPIAR LOGS
                    }
                    break;
                case "send":
                    if (Globales.DireccionamientoDirecto){
                        if (Globales.FIFO){
                            if ((!(parametros[0].equals(""))) && (!(parametros[1].equals(""))) && (!(parametros[2].equals(""))) && (IsProceso(parametros[0])) && (IsProceso(parametros[1])) && (!(parametros[0].equals(parametros[1] ))) ){
                                //mappear la funcion
                                exito = true;
                            }
                        }
                        else{
                            if ((!(parametros[0].equals(""))) && (!(parametros[1].equals(""))) && (!(parametros[2].equals(""))) && (!(parametros[3].equals(""))) && (IsProceso(parametros[0])) && (IsProceso(parametros[1])) && (!(parametros[0].equals(parametros[1] ))) ){
                                //mappear la funcion
                                int prioriodad = Integer.parseInt(parametros[2]);
                                
                                exito = true;
                            }
                        }
                    }
                    else{
                        if (Globales.FIFO){
                            if ((!(parametros[0].equals(""))) && (!(parametros[1].equals(""))) && (!(parametros[2].equals(""))) && (IsMailbox(parametros[1])) && (IsProceso(parametros[0]))){
                                //mappear con la funcion
                                exito = true;
                            }
                        }
                        else{
                            if ((!(parametros[0].equals(""))) && (!(parametros[1].equals(""))) && (!(parametros[2].equals(""))) && (!(parametros[3].equals(""))) && (IsMailbox(parametros[1])) && (IsProceso(parametros[0]))){
                                //mappear la funcion
                                int prioriodad = Integer.parseInt(parametros[2]);

                                exito = true;
                            }
                        }
                    }
                    break;
                case "receive":
                    if (Globales.DireccionamientoDirecto){
                        if (Globales.ReceiveExplicito){
                            if ((!(parametros[0].equals(""))) && (!(parametros[1].equals(""))) && (IsProceso(parametros[0])) && (IsProceso(parametros[1])) && (!(parametros[0].equals(parametros[1] ))) ){
                                //mappear la funcion
                                exito = true;
                            }
                        }
                        else{
                            if ((!(parametros[0].equals(""))) && (IsProceso(parametros[0]))){
                                //mappear con la funcion
                                exito = true;
                            }
                        }
                    }
                    else{
                        if ((!(parametros[0].equals(""))) && (IsProceso(parametros[0]))){
                            //mappear con la funcion
                            exito = true;
                        }
                    }
                    break;
                case "connect_mailbox":
                    if ((!(parametros[0].equals(""))) && (!(parametros[1].equals(""))) && (IsMailbox(parametros[0])) && (IsProceso(parametros[1]))){
                        //mappear con la funcion
                        exito = true;
                    }
                    break;
                case "disconnect_mailbox":
                    if ((!(parametros[0].equals(""))) && (!(parametros[1].equals(""))) && (IsMailbox(parametros[0])) && (IsProceso(parametros[1]))){
                        //mappear con la funcion
                        exito = true;
                    }
                    break;    
                case "create_mailbox":
                    if (Globales.IndirectoEstatico){
                        if ((!(parametros[0].equals(""))) && (!(parametros[1].equals(""))) && (!(IsMailbox(parametros[1]))) && (IsProceso(parametros[0]))){
                            //mappear con la funcion
                            exito = true;
                        }
                    }
                    else{
                        if ((!(parametros[0].equals(""))) && (!(IsMailbox(parametros[0])))){
                            //mappear con la funcion
                            exito = true;
                        }   
                    }
                    break;
            }
        }
        catch (Exception e){
            exito = false;
        }
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
