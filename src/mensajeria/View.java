/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensajeria;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Andres
 */
public class View extends javax.swing.JFrame {

    /**
     * Creates new form View
     */
    public View() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TView = new javax.swing.JTable();
        VerCola = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Fecha", "Origen", "Estado", "Destino", "Mensaje"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TView);

        VerCola.setText("Ver Cola");
        VerCola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerColaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(VerCola)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(VerCola)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VerColaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerColaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VerColaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);
            }
        });
    }
    
    public void viewPorProceso(String proceso){ 
       
       int lenProcs = Globales.Procesos;  
       Object[][] infoProceso = new Object[10][6];
       String[] columnas = new String[]{"Fecha","Acción","Origen","Estado Blocked","Destino","Mensaje"};
    
       final Class[] tiposColumnas = new Class[]{java.lang.String.class,java.lang.String.class,java.lang.String.class,java.lang.String.class,java.lang.String.class,java.lang.String.class}; //Variable que especifica el tipo de dato de cada columna.
       
       Proceso p = Globales.buscarPro(proceso);
       
        for (int i=0;i<lenProcs;i++){           
        if ((p==null)||(p.bitacora==null) || (p.bitacora.tamano()==0)){            
            break;}
        else{
            if (p.bitacora.tamano()==i){
                break;
            }
            //System.out.println("else de view por proceso");
            infoProceso[i][0] = p.bitacora.listaR.get(i).fecha;
            infoProceso[i][1] = p.bitacora.listaR.get(i).accion;
            infoProceso[i][2] = p.bitacora.listaR.get(i).origen;
            infoProceso[i][3] = p.bitacora.listaR.get(i).estado_origen;
            infoProceso[i][4] = p.bitacora.listaR.get(i).destino;
            infoProceso[i][5] = p.bitacora.listaR.get(i).mensaje;
        }
       }
        //JOptionPane.showMessageDialog(null,new JScrollPane(TView));
        TView.setModel(new javax.swing.table.DefaultTableModel(infoProceso,columnas) {
                    // Se puede saber el tipo  de dato que tiene cada columna.
                    /*Class[] tipos = tiposColumnas;
                    @Override
                    public Class getColumnClass(int columnIndex) {                
                        return tipos[columnIndex];
                    }
                    @Override
                    public boolean isCellEditable(int row, int column) {               
                        return !(this.getColumnClass(column)!=null);
                    }*/
                });
    }
    public void viewPorMB(String nombreMB) {
       Object[][] infoMB = new Object[10][4];
       String[] columnas = new String[]{"Fecha","Acción","Origen","Mensaje"};
    
       final Class[] tiposColumnas = new Class[]{java.lang.String.class,java.lang.String.class,java.lang.String.class,java.lang.String.class,java.lang.String.class,java.lang.String.class}; //Variable que especifica el tipo de dato de cada columna.
       
       Mailbox mb = Globales.buscarMB(nombreMB);
       
        for (int i=0;i<6;i++){           
        if ((mb==null)||(mb.bitacora==null) || (mb.bitacora.tamano()==0)){            
            break;}
        else{
            if (mb.bitacora.tamano()==i){
                break;
            }
            //System.out.println("else de view por proceso");
            infoMB[i][0] = mb.bitacora.listaR.get(i).fecha;
            infoMB[i][1] = mb.bitacora.listaR.get(i).accion;
            infoMB[i][2] = mb.bitacora.listaR.get(i).origen;
            infoMB[i][3] = mb.bitacora.listaR.get(i).mensaje;
        }
       }
        TView.setModel(new javax.swing.table.DefaultTableModel(infoMB,columnas) {
                    // Se puede saber el tipo  de dato que tiene cada columna.
                    /*Class[] tipos = tiposColumnas;
                    @Override
                    public Class getColumnClass(int columnIndex) {                
                        return tipos[columnIndex];
                    }
                    @Override
                    public boolean isCellEditable(int row, int column) {               
                        return !(this.getColumnClass(column)!=null);
                    }*/
                });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TView;
    private javax.swing.JButton VerCola;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
