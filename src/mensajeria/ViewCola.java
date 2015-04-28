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
public class ViewCola extends javax.swing.JFrame {

    /**
     * Creates new form ViewCola
     */
    public ViewCola() {
        initComponents();
    }
    
    public void viewColaProceso(String proceso){
        Object[][] infoProceso = new Object[Globales.TamanoCola][2];
        String[] columnas = new String[]{"Mensaje","Emisor"};
        Proceso p = Globales.buscarPro(proceso);
       
        for (int i=0;i<p.cola.lista.size();i++){           
        if ((p==null)||(p.cola==null) || (p.cola.lista.isEmpty())){            
            break;}
        else{
            //System.out.println("else de view por proceso");
            infoProceso[i][0] = p.cola.lista.get(i).contenido;
            infoProceso[i][1] = p.cola.lista.get(i).origen.nombre;
        }
        Globales.viewcola.TViewCola.setModel(new javax.swing.table.DefaultTableModel(infoProceso,columnas) {
                });
    }
    }
    public void viewColaMB(String mailbox){
        Object[][] infoProceso = new Object[Globales.TamanoCola][2];
        String[] columnas = new String[]{"Mensaje","Emisor"};
        Mailbox mb = Globales.buscarMB(mailbox);
       
        for (int i=0;i<mb.contenido.lista.size();i++){           
        if ((mb==null)||(mb.contenido==null) || (mb.contenido.lista.isEmpty())){            
            break;}
        else{
            //System.out.println("else de view por proceso");
            infoProceso[i][0] = mb.contenido.lista.get(i).contenido;
            infoProceso[i][1] = mb.contenido.lista.get(i).origen.nombre;
        }
        Globales.viewcola.TViewCola.setModel(new javax.swing.table.DefaultTableModel(infoProceso,columnas) {
                });
    }
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
        TViewCola = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TViewCola.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tiempo", "Mensaje", "Emisor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TViewCola);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ViewCola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewCola().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TViewCola;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
