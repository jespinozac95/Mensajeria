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
                        Globales.UltimoIndiceElementos = 0;
                        //mappear la funcion
                        Object [][] nombresYbotones = Globales.PantPrincipal.CreaTabla();
                        //System.out.println("\nCreó Tabla\n");
                        for (int e = 0;e<Globales.NumeroElementos-1;e++){
                            if (MapeadorFunciones.IsProceso(nombresYbotones[e][0].toString())){
                                Object [][] bitacoraElemento = Globales.PantPrincipal.ViewPorProceso(nombresYbotones[e][0].toString());
                                Object [][] colaElemento = Globales.viewcola.viewColaProceso(nombresYbotones[e][0].toString());
                                InformacionView infoElemento = new InformacionView(nombresYbotones[e][0].toString(),true,bitacoraElemento,colaElemento);
                                Globales.InformacionDeElementosParaView[Globales.UltimoIndiceElementos] = infoElemento;
                                /*System.out.println("infoElemento.nombre = "+infoElemento.nombre);
                                try{
                                    System.out.println("infoElemento.bitacoraInfo[0][1].toString() = "+infoElemento.bitacoraInfo[0][1].toString());
                                }
                                catch(Exception paa){
                                }*/
                                Globales.UltimoIndiceElementos++;
                            }
                            else {
                                Object [][] bitacoraElemento = Globales.PantPrincipal.ViewPorMB(nombresYbotones[e][0].toString());
                                Object [][] colaElemento = Globales.viewcola.viewColaMB(nombresYbotones[e][0].toString());
                                InformacionView infoElemento = new InformacionView(nombresYbotones[e][0].toString(),false,bitacoraElemento,colaElemento);
                                Globales.InformacionDeElementosParaView[Globales.UltimoIndiceElementos] = infoElemento;
                                Globales.UltimoIndiceElementos++;
                            }
                        }
                        //System.out.println("\nCreó Info\n");
                        Globales.LogCentralActivo = Globales.LogCentral;
                        Object[][] infoCC = new Object[Globales.ColaCentral.lista.size()][2];
                        for (int i=0;i<Globales.ColaCentral.lista.size();i++){
                            //System.out.println("Entrada en la colacola central con contenido: "+Globales.ColaCentral.lista.get(i).contenido);
                            infoCC[i][0] = Globales.ColaCentral.lista.get(i).contenido;
                            infoCC[i][1] = Globales.ColaCentral.lista.get(i).origen.nombre;
                        }
                        Globales.ColaCentralActiva = infoCC;
                        Globales.PantPrincipal.MostrarTabla(nombresYbotones);
                        //Globales.ImprimirElementos();
                        //System.out.println("\nMostró Tabla\n");
                        //Limpiar LOGS DE PROCESOS
                        for (int i =0;i<Globales.Procesos;i++){
                            List <Registro> r= new LinkedList<Registro>();
                            Globales.procs[i].bitacora.listaR = r;
                        }
                        for (int e = 0;e<Globales.UltimoIndiceMailbox;e++){
                            List <Registro> r= new LinkedList<Registro>();
                            Globales.mails[e].bitacora.listaR = r;
                        }
                        Globales.LogCentral = new LinkedList();
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
                        Globales.InformacionDeElementosParaView = new InformacionView[13];
                        Globales.UltimoIndiceElementos = 0;
                        Globales.NumeroElementos = 0;
                        Globales.LogCentral = new LinkedList();  
                        Globales.m = new LinkedList<Mensaje>();
                        Globales.ColaCentral = new Cola(Globales.m);
                        Globales.view = null;
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
                            if ((ValidarNumeroParametros(parametros,3)) && (!(parametros[0].equals(""))) && (!(parametros[1].equals(""))) && (!(parametros[2].equals(""))) && (IsProceso(parametros[0])) && (IsProceso(parametros[1])) && (!(parametros[0].equals(parametros[1] ))) ){
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
                            if ((ValidarNumeroParametros(parametros,4)) && (!(parametros[0].equals(""))) && (!(parametros[1].equals(""))) && (!(parametros[2].equals(""))) && (!(parametros[3].equals(""))) && (IsProceso(parametros[0])) && (IsProceso(parametros[1])) && (!(parametros[0].equals(parametros[1] ))) ){
                                //mappear la funcion
                                int prioridad = Integer.parseInt(parametros[3]);
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
                            if ((ValidarNumeroParametros(parametros,3)) && (!(parametros[0].equals(""))) && (!(parametros[1].equals(""))) && (!(parametros[2].equals(""))) && (IsMailbox(parametros[1])) && (IsProceso(parametros[0]))){
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
                            if ((ValidarNumeroParametros(parametros,4)) && (!(parametros[0].equals(""))) && (!(parametros[1].equals(""))) && (!(parametros[2].equals(""))) && (!(parametros[3].equals(""))) && (IsMailbox(parametros[1])) && (IsProceso(parametros[0]))){
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
                            if ((ValidarNumeroParametros(parametros,2)) && (!(parametros[0].equals(""))) && (!(parametros[1].equals(""))) && (IsProceso(parametros[0])) && (IsProceso(parametros[1])) ){
                                //mappear la funcion
                                Globales.buscarPro(parametros[0]).receiveD(parametros[1]);
                                exito = true;
                            }
                        }
                        else{
                            if ((ValidarNumeroParametros(parametros,1)) && (!(parametros[0].equals(""))) && (IsProceso(parametros[0]))){
                                //mappear con la funcion
                                Globales.buscarPro(parametros[0]).receiveD();
                                exito = true;
                            }
                        }
                    }
                    else{
                        if (Globales.ReceiveExplicito){
                            if ((ValidarNumeroParametros(parametros,2)) && (!(parametros[0].equals(""))) && (!(parametros[1].equals(""))) && (IsProceso(parametros[0])) && (IsProceso(parametros[1])) ){
                                //mappear con la funcion
                                Globales.buscarPro(parametros[0]).receiveI(parametros[1]);
                                exito = true;
                            }
                        }
                        else{
                            if ((ValidarNumeroParametros(parametros,1)) && (!(parametros[0].equals(""))) && (IsProceso(parametros[0]))){
                                //mappear con la funcion
                                Globales.buscarPro(parametros[0]).receiveI();
                                exito = true;
                            }
                        }
                    }
                    break;
                case "connect_mailbox":
                    if ((ValidarNumeroParametros(parametros,2)) && (!(parametros[0].equals(""))) && (!(parametros[1].equals(""))) && (IsMailbox(parametros[1])) && (IsProceso(parametros[0]))){
                        //mappear con la funcion
                        Globales.buscarPro(parametros[0]).conectar(parametros[1]);
                        exito = true;
                    }
                    break;
                case "disconnect_mailbox":
                    if ((ValidarNumeroParametros(parametros,2)) && (!(parametros[0].equals(""))) && (!(parametros[1].equals(""))) && (IsMailbox(parametros[1])) && (IsProceso(parametros[0]))){
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
                        if ((ValidarNumeroParametros(parametros,1)) && (!(parametros[0].equals(""))) && (!(IsMailbox(parametros[0])))){
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
    public static boolean ValidarNumeroParametros(String[] parametros,int numeroDeseado){
        int numeroActual = 0;
        for (String parametro : parametros) {
            System.out.print("\nParametro: "+parametro);
            if (!(parametro.isEmpty()) || (!(parametro.equals("")))) {
                System.out.print("  <-- no es vacío.");
                numeroActual++;
            }
        }
        System.out.println("\nNumero Actual = "+numeroActual);
        System.out.println("Numero Deseado = "+numeroDeseado);
        if (numeroActual == numeroDeseado){
            return true;
        }
        else{
            return false;
        }
    }
}
