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
public class Mensajeria {
    public static void main(String[] args) {
        //Llamar a la ventana de configuración (VentanaInicio.java)
        
        VentanaInicio VentanaDeConfiguracion = new VentanaInicio();
        VentanaDeConfiguracion.setLocationRelativeTo(null);
        VentanaDeConfiguracion.setVisible(true);
        
        //Adaptar el texto de ayuda de acuerdo con las variables de configuración al momento
        String Texto = "Bienvenido a la Sección de Ayuda \nRecuerde escribir sin espacios.\nLista de comandos que puede ejecutar:\n- create(): Ejecuta las configuraciones especificadas. Se debe ejecutar antes de cualquiera de todas las siguientes operaciones.\n - view(): Permite observar todo lo que está ocurriendo en el sistema mediante la sección de Visualización de Estados y Logs.\n - reset(): Reinicia el sistema y permite reconfigurarlo.";
        if (Globales.DireccionamientoDirecto){
            if (Globales.FIFO){
                Texto += "\n - send(NombreDelProceso,Mensaje)";
                Texto += ": Envía un mensaje a un proceso.";
            }
            else{
                Texto += "\n - send(NombreDelProceso,Mensaje,NúmeroDePrioridad)";
                Texto += ": Envía un mensaje a un proceso con cierta prioridad (1,2 o 3, con 1 la más alta).";
            }
            if (Globales.ReceiveExplicito){
                Texto += "\n - receive(NombreDelProceso)";
                Texto += ": Recibir un mensaje de un proceso.";
            }
            else{
                Texto += "\n - receive()";
                Texto += ": Recibir un mensaje del proceso que le envió previamente.";
            }
        }
        else{
            if (Globales.FIFO){
                Texto += "\n - send(NombreDelBuzón,Mensaje)";
                Texto += ": Envía un mensaje a un buzón.";
            }
            else{
                Texto += "\n - send(NombreDelBuzón,Mensaje,NúmeroDePrioridad)";
                Texto += ": Envía un mensaje a un buzón con cierta prioridad (1,2 o 3, con 1 la más alta).";
            }
            Texto += "\n - receive()";
            Texto += ": Recibe un mensaje del buzón suscrito.";
            if (Globales.IndirectoEstatico){
                Texto += "\n - create_mailbox(NombreDelBuzón)";
                Texto += ": Crea un buzón. Una ventana emergente aparecerá para que pueda configurar el buzón (definir los procesos que serán vinculados)";
            }
            else{ //Se puede create_mailbox aquí tambien?
                Texto += "\n - connect_mailbox(NombreDelBuzón)";
                Texto += ": Conectar el proceso en referencia a cierto buzón.";
                Texto += "\n - disconnect_mailbox(NombreDelBuzón)";
                Texto += ": Desonectar el proceso en referencia de cierto buzón.";
            }
        }
        Globales.TextoAyuda = Texto;
    }
    
}
