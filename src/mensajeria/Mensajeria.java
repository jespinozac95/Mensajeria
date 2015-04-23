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
    }

    public static void ImprimirGlobales() {
        System.out.println("SendBlocking = "+Globales.SendBlocking);
        System.out.println("Receive = "+Globales.Receive);
        System.out.println("Receive Explicito = "+Globales.ReceiveExplicito);
        System.out.println("DireccionamientoDirecto = "+Globales.DireccionamientoDirecto);
        System.out.println("IndirectoEstatico = "+Globales.IndirectoEstatico);
        System.out.println("LargoMsjFijo = "+Globales.LargoMsjFijo);
        System.out.println("LargoMsj = "+Globales.LargoMsj);
        System.out.println("FIFO = "+Globales.FIFO);
        System.out.println("TamanoCola = "+Globales.TamanoCola);
        System.out.println("Cantidad de procesos = "+Globales.Procesos);
        System.out.println(">>>>>>>>>><<<<<<<<<<");
    }
    
}
