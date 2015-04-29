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
public class InformacionView {
    public String nombre;
    public boolean esProceso;
    public Object[][] bitacoraInfo;
    public Object[][] colaInfo;
    public boolean bitacoraVacia;
    public boolean colaVacia;
    
    public InformacionView(String nombre, boolean esProceso,Object[][] bitacora,Object[][] cola){
        this.nombre = nombre;
        this.esProceso = esProceso;
        this.bitacoraInfo = bitacora;
        this.colaInfo = cola;
    }
}
