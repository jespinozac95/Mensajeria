/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensajeria;

import java.awt.Font;
import javax.swing.JDialog;
import javax.swing.JTextArea;


/**
 *
 * @author Andres
 */
public class PantallaError {
    public PantallaError(String texto){
    JDialog Error = new JDialog(); 
    JTextArea ErrorText = new JTextArea(); 
    ErrorText.setText(texto);
    ErrorText.setLineWrap(true);
    Error.setSize(100, 100);
    Error.add(ErrorText);
    Error.setTitle("Error");
    Error.setVisible(true);
    ErrorText.setEditable(false);
    }    
}
