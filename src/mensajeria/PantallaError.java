/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensajeria;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author Andres
 */
public class PantallaError {
    public PantallaError(String texto){
        JOptionPane.showMessageDialog(new JFrame(),texto,"Error",JOptionPane.ERROR_MESSAGE);
    }
}
