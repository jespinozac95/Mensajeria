/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensajeria;

import java.util.Arrays;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Andres
 */
public class VentanaInicio extends javax.swing.JFrame {

    /**
     * Creates new form VentanaInicio
     */
    public VentanaInicio() {
        initComponents();       
        CIndirecto.setVisible(false);
        CDirecReceive.setEditable(false);        
        TCantFijo.setEditable(false);
        //LFijo.setVisible(false);
        if (Globales.reset){
            //LSeleccionCantProcesos.setVisible(false);
            TCantProcesos.setEditable(false);
        }
        this.getRootPane().setDefaultButton(BContinuar);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LBienvenido = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        LSeleccionCantProcesos = new javax.swing.JLabel();
        LSeleccionFormato1 = new javax.swing.JLabel();
        BContinuar = new javax.swing.JButton();
        CLargo = new javax.swing.JComboBox();
        LSeleccionDirecc = new javax.swing.JLabel();
        TCola = new javax.swing.JTextField();
        LSeleccionFormato = new javax.swing.JLabel();
        TCantProcesos = new javax.swing.JTextField();
        LCola = new javax.swing.JLabel();
        CSend = new javax.swing.JComboBox();
        LFijo = new javax.swing.JLabel();
        TCantFijo = new javax.swing.JTextField();
        CDirecReceive = new javax.swing.JComboBox();
        CReceive = new javax.swing.JComboBox();
        CIndirecto = new javax.swing.JComboBox();
        CDireccionamiento = new javax.swing.JComboBox();
        CDisciplina = new javax.swing.JComboBox();
        LSeleccionSinc = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(72, 91, 231));
        setLocationByPlatform(true);
        setPreferredSize(new java.awt.Dimension(700, 580));
        setResizable(false);

        LBienvenido.setFont(new java.awt.Font("Calibri Light", 0, 24)); // NOI18N
        LBienvenido.setText("¡Bienvenido a OSchat!");
        LBienvenido.setName(""); // NOI18N

        jLabel2.setText("A continuación, se le solicita la configuración del sistema de mensajería.");

        jLabel3.setText("Recuerde que si no selecciona algún campo para cambiarse, las opciones por defecto serán cargadas.");

        LSeleccionCantProcesos.setText("Seleccione la cantidad de procesos por utilizar:");

        LSeleccionFormato1.setText("Seleccione la disciplina de manejo de datos deseada:");

        BContinuar.setText("Continuar");
        BContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BContinuarActionPerformed(evt);
            }
        });

        CLargo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Variable", "Fijo" }));
        CLargo.setToolTipText("Formato de colas que se desee.");
        CLargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CLargoActionPerformed(evt);
            }
        });

        LSeleccionDirecc.setText("Seleccione el tipo de direccionamiento deseado:");

        TCola.setToolTipText("Cantidad de elementos en la cola de mensajes.");
        TCola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TColaActionPerformed(evt);
            }
        });

        LSeleccionFormato.setText("Seleccione el tipo de formato deseado:");

        TCantProcesos.setToolTipText("Debe ingresar el númerro (2 a 6) de procesos que desea utillizar en la ejecución.");
        TCantProcesos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TCantProcesosActionPerformed(evt);
            }
        });

        LCola.setText("Tamaño de la cola:");

        CSend.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Blocking", "Non-Blocking" }));
        CSend.setToolTipText("Debe seleccionar la modalidad de envío que se desee");
        CSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CSendActionPerformed(evt);
            }
        });

        LFijo.setText("Tamaño fijo de mensaje:");

        TCantFijo.setToolTipText("Cantidad de caracteres del largo de cada mensaje.");

        CDirecReceive.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Receive Explícito", "Receive Implícito" }));
        CDirecReceive.setToolTipText("Tipo de emisor deseado.");
        CDirecReceive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CDirecReceiveActionPerformed(evt);
            }
        });

        CReceive.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Blocking", "Non-Blocking", "Prueba de llegada" }));
        CReceive.setToolTipText("Debe seleccionar la modalidad de de recibo de mensajes deseada.");

        CIndirecto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Estático", "Dinámico" }));
        CIndirecto.setToolTipText("Modalidad de direccionamieno indrecto deseada.");
        CIndirecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CIndirectoActionPerformed(evt);
            }
        });

        CDireccionamiento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Directo", "Indirecto" }));
        CDireccionamiento.setToolTipText("Selección de direccionamiento requerido.");
        CDireccionamiento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CDireccionamiento.setName(""); // NOI18N
        CDireccionamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CDireccionamientoActionPerformed(evt);
            }
        });

        CDisciplina.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "FIFO (First In - First Out)", "Prioridad" }));
        CDisciplina.setToolTipText("Modalidad de manejo de datos seleccionada.");
        CDisciplina.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CDisciplina.setName(""); // NOI18N
        CDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CDisciplinaActionPerformed(evt);
            }
        });

        LSeleccionSinc.setText("Seleccione el tipo de sincronización Send deseado:");

        jLabel1.setText("Seleccione el tipo de sincronización Receive deseado:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(TCantProcesos, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TCantFijo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LFijo)
                    .addComponent(LCola)
                    .addComponent(TCola, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CReceive, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(CDirecReceive, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CIndirecto, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BContinuar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(250, 250, 250))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(56, 56, 56)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(CDireccionamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addComponent(CLargo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(LSeleccionFormato, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(56, 56, 56)
                            .addComponent(CSend, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(55, 55, 55)
                            .addComponent(CDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(LSeleccionDirecc)
                        .addComponent(LSeleccionSinc)
                        .addComponent(LSeleccionCantProcesos)
                        .addComponent(LSeleccionFormato1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(571, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LCola)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TCola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TCantProcesos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CReceive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CDirecReceive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CIndirecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(LFijo)
                .addGap(18, 18, 18)
                .addComponent(TCantFijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(BContinuar, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(LSeleccionCantProcesos)
                    .addGap(47, 47, 47)
                    .addComponent(LSeleccionSinc)
                    .addGap(18, 18, 18)
                    .addComponent(CSend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(LSeleccionDirecc, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(CDireccionamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(LSeleccionFormato)
                    .addGap(18, 18, 18)
                    .addComponent(CLargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(45, 45, 45)
                    .addComponent(LSeleccionFormato1)
                    .addGap(18, 18, 18)
                    .addComponent(CDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(LBienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(LBienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CDirectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CDirectoActionPerformed
       
    }//GEN-LAST:event_CDirectoActionPerformed

    private void CDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CDisciplinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CDisciplinaActionPerformed

    private void CDireccionamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CDireccionamientoActionPerformed
        // TODO add your handling code here:
        String valor=CDireccionamiento.getSelectedItem().toString();
        switch (valor) {
            case "Directo":
            CDirecReceive.setVisible(true);
            CIndirecto.setVisible(false);
            break;
            case "Indirecto":
            CIndirecto.setVisible(true);
            CDirecReceive.setVisible(false);
            break;
        }
    }//GEN-LAST:event_CDireccionamientoActionPerformed

    private void CIndirectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CIndirectoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CIndirectoActionPerformed

    private void CDirecReceiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CDirecReceiveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CDirecReceiveActionPerformed

    private void CSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CSendActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CSendActionPerformed

    private void TCantProcesosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TCantProcesosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TCantProcesosActionPerformed

    private void TColaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TColaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TColaActionPerformed

    private void CLargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLargoActionPerformed
        // TODO add your handling code here:
        String valorCLargo=CLargo.getSelectedItem().toString();
        switch (valorCLargo) {
            case "Fijo":
            TCantFijo.setEditable(true);
            TCantFijo.setVisible(true);
            LFijo.setVisible(true);
            break;
            case "Variable":
            TCantFijo.setVisible(false);
            LFijo.setVisible(false);
            break;
        }
    }//GEN-LAST:event_CLargoActionPerformed

    private void BContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BContinuarActionPerformed
        boolean PuedeContinuar = true;
        //GET CANT PROCESOS
        if (!(Globales.reset)){
            try{
                int numProcesos = Integer.parseInt(TCantProcesos.getText());
                if ((1 < numProcesos)&& (numProcesos < 7)){
                    Globales.Procesos = numProcesos;
                }
                else{
                    PantallaError Error = new PantallaError("Debe ingresar un número entre 2 y 6 en el campo del número de procesos.");
                    PuedeContinuar = false;
                }
            }
            catch(Exception e){
                PantallaError Error = new PantallaError("Debe ingresar un número entre 2 y 6 en el campo del número de procesos  para continuar.");
                PuedeContinuar = false;
            }
        }
        //GET RECEIVE
        try{
            Globales.Receive = CReceive.getSelectedItem().toString();
        }
        catch(Exception e){
            PantallaError Error = new PantallaError("Debe configurar la sincronización Receive para continuar.");
            PuedeContinuar = false;
        }
        //GET SEND
        try{
            switch (CSend.getSelectedItem().toString()){
                case "Blocking":
                Globales.SendBlocking = true;
                break;
                case "Non-Blocking":
                Globales.SendBlocking = false;
                break;
            }
        }
        catch(Exception e){
            PantallaError Error = new PantallaError("Debe configurar la sincronización Send para continuar.");
            PuedeContinuar = false;
        }
        //GET DIRECCIONAMIENTO
        try{
            if (CDireccionamiento.getSelectedItem().toString().equals("Directo")){
                Globales.DireccionamientoDirecto = true;
                if (CDirecReceive.getSelectedItem().toString().equals("Receive Explícito")){
                    Globales.ReceiveExplicito = true;
                }
                else{
                    Globales.ReceiveExplicito = false;
                }
            }
            else{
                Globales.DireccionamientoDirecto = false;
                if (CIndirecto.getSelectedItem().toString().equals("Estático")){
                    Globales.IndirectoEstatico = true;
                }
                else{
                    Globales.IndirectoEstatico = false;
                }
            }
        }
        catch(Exception e){
            PantallaError Error = new PantallaError("Debe configurar la sincronización de Direccionamiento completamente para continuar.");
            PuedeContinuar = false;
        }
        //GET FORMATO VALIDAR LARGO 10-140 num entero
        try{
            if (CLargo.getSelectedItem().toString().equals("Fijo")){
                Globales.LargoMsjFijo = true;
                if ((Integer.parseInt(TCantFijo.getText()) < 10) || (Integer.parseInt(TCantFijo.getText()) > 140)){
                    PantallaError Error = new PantallaError("El largo del formato de los mensajes debe ser entre 10 y 140 caracteres.");
                    PuedeContinuar = false;
                }
                else{
                    Globales.LargoMsj = Integer.parseInt(TCantFijo.getText());
                }
            }
            else{
                Globales.LargoMsjFijo = false;
            }
        }
        catch (Exception e){
            PantallaError Error = new PantallaError("Debe configurar el Formato (largo) de los mensajes completamente para continuar.");
            PuedeContinuar = false;
        }
        //GET DISCIPLINA
        try{
            if (CDisciplina.getSelectedItem().toString().equals("Prioridad")){
                Globales.FIFO = false;
            }
            else{
                Globales.FIFO = true;
            }
        }
        catch (Exception e){
            PantallaError Error = new PantallaError("Debe especificar la disciplina (FIFO o Prioridad) de la cola para continuar.");
            PuedeContinuar = false;
        }
        //GET TAMANO COLA 1-20 num entero
        try{
            if ((Integer.parseInt(TCola.getText()) < 1) || (Integer.parseInt(TCola.getText().toString()) > 20)){
                PantallaError Error = new PantallaError("El largo de la cola debe ser de 1-20.");
                PuedeContinuar = false;
            }
            else{
                Globales.TamanoCola = Integer.parseInt(TCola.getText());
            }
        }
        catch (Exception e){
            PantallaError Error = new PantallaError("Debe especificar el largo de la cola para continuar, y esta debe ser de largo 1-20.");
            PuedeContinuar = false;
        }
        if (PuedeContinuar == true){
            //Set texto de ayuda dinámico
            SetTextoAyuda();
            //Pida los nombres de los procesos
            if (!(Globales.reset)){
                SetNombresDeProcesos();
                //Tire pantalla de exito con: create() fue realizado
                PantallaExito exitoCreate = new PantallaExito("Create() realizado con éxito.\nLos procesos y elementos que especificó fueron creados con sus configuraciones.\n\nPresione F1 para observar cuáles funciones puede realizar.\nPresione F2 para observar los elementos del sistema.");
            }
            else{
                PantallaExito exitoCreate = new PantallaExito("Las configuraciones fueron cambiadas exitosamente y los logs reiniciado.\n\nPresione F1 para observar cuáles funciones puede realizar.\nPresione F2 para observar los elementos del sistema.");
            }
            this.setVisible(false);
            //Cerrar esta ventana y tirar ventana de consola
            if ((Globales.reset) && (!(Globales.DireccionamientoDirecto)) && (Globales.IndirectoEstatico)){
                //System.out.println("Reset con Indirecto Estatico");
                for (int i = 0;i<Globales.Procesos;i++){
                    Mailbox mb = new Mailbox("MB"+Globales.procs[i].nombre);
                    Globales.mails[Globales.UltimoIndiceMailbox]=mb;
                    Globales.UltimoIndiceMailbox++;
                    Globales.procs[i].conectar(mb.nombre);
                }
            }
            Pantalla_principal Pantalla_Principal = new Pantalla_principal();
            Pantalla_Principal.setVisible(true);
            Globales.PantPrincipal = Pantalla_Principal;
            this.setEnabled(false);
        }
    }//GEN-LAST:event_BContinuarActionPerformed

    public void SetTextoAyuda(){
        //Adaptar el texto de ayuda de acuerdo con las variables de configuración al momento
        String Texto = "Bienvenido a la Sección de Ayuda \nRecuerde escribir sin espacios.\nNota: Por regla de negocio, habrán máximo 6 mailboxes creados en el sistema.\nLista de comandos que puede ejecutar:\n - view(): Permite observar todo lo que está ocurriendo en el sistema mediante la sección de Visualización de Estados y Logs.\n - reset(): Reinicia el sistema y permite reconfigurarlo.";
        if (Globales.DireccionamientoDirecto){
            if (Globales.FIFO){
                Texto += "\n - send(NombreDelProcesoEmisor,NombreDelProcesoReceptor,Mensaje)";
                Texto += ": Envía un mensaje a un proceso.";
                if (Globales.LargoMsjFijo){
                    Texto += "El mensaje no debe sobrepasar los "+Globales.LargoMsj+" caracteres.";
                }
            }
            else{
                Texto += "\n - send(NombreDelProcesoEmisor,NombreDelProceso,Mensaje,NúmeroDePrioridad)";
                Texto += ": Envía un mensaje a un proceso con cierta prioridad (1,2 o 3, con 1 la más alta).";
                if (Globales.LargoMsjFijo){
                    Texto += "El mensaje no debe sobrepasar los "+Globales.LargoMsj+" caracteres.";
                }
            }
            if (Globales.ReceiveExplicito){
                Texto += "\n - receive(NombreDelProcesoReceptor,NombreDelProcesoEmisor)";
                Texto += ": Recibir un mensaje de un proceso.";
            }
            else{
                Texto += "\n - receive(NombreDelProcesoReceptor)";
                Texto += ": Recibir un mensaje del proceso que le envió previamente.";
            }
        }
        else{
            if (Globales.FIFO){
                Texto += "\n - send(NombreDelProcesoEmisor,NombreDelBuzón,Mensaje)";
                Texto += ": Envía un mensaje a un buzón.";
                if (Globales.LargoMsjFijo){
                    Texto += "El mensaje no debe sobrepasar los "+Globales.LargoMsj+" caracteres.";
                }
            }
            else{
                Texto += "\n - send(NombreDelProcesoEmisor,NombreDelBuzón,Mensaje,NúmeroDePrioridad)";
                Texto += ": Envía un mensaje a un buzón con cierta prioridad (1,2 o 3, con 1 la más alta).";
                if (Globales.LargoMsjFijo){
                    Texto += "El mensaje no debe sobrepasar los "+Globales.LargoMsj+" caracteres.";
                }
            }
            if (Globales.ReceiveExplicito){
                Texto += "\n - receive(NombreDelProcesoReceptor,NombreDelProcesoDeOrigen)";
                Texto += ": Recibe un mensaje del buzón suscrito del proceso de origen especificado.";
            }
            else{
                Texto += "\n - receive(NombreDelProcesoReceptor)";
                Texto += ": Recibe un mensaje del buzón suscrito.";
            }
            if (!(Globales.IndirectoEstatico)){
                Texto += "\n - create_mailbox(NombreDelBuzón)";
                Texto += ": Crea un buzón.";
            }
            Texto += "\n - connect_mailbox(NombreDelBuzón,NombreDelProcesoAConectar)";
            Texto += ": Conectar el proceso en referencia a cierto buzón.";
            Texto += "\n - disconnect_mailbox(NombreDelBuzón,NombreDelProcesoADesconectar)";
            Texto += ": Desonectar el proceso en referencia de cierto buzón.";
        }
        Globales.TextoAyuda = Texto;
    }
    
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
            java.util.logging.Logger.getLogger(VentanaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaInicio().setVisible(true);         
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BContinuar;
    private javax.swing.JComboBox CDirecReceive;
    private javax.swing.JComboBox CDireccionamiento;
    private javax.swing.JComboBox CDisciplina;
    private javax.swing.JComboBox CIndirecto;
    private javax.swing.JComboBox CLargo;
    private javax.swing.JComboBox CReceive;
    private javax.swing.JComboBox CSend;
    private javax.swing.JLabel LBienvenido;
    private javax.swing.JLabel LCola;
    private javax.swing.JLabel LFijo;
    private javax.swing.JLabel LSeleccionCantProcesos;
    private javax.swing.JLabel LSeleccionDirecc;
    private javax.swing.JLabel LSeleccionFormato;
    private javax.swing.JLabel LSeleccionFormato1;
    private javax.swing.JLabel LSeleccionSinc;
    private javax.swing.JTextField TCantFijo;
    private javax.swing.JTextField TCantProcesos;
    private javax.swing.JTextField TCola;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    public void SetNombresDeProcesos() {
        for (int i=0;i<Globales.Procesos;i++){
            int numeroDeProcesoEnCuestion = i+1;
            String nombre = (String)JOptionPane.showInputDialog(new JFrame(),"Escriba el nombre del proceso #"+numeroDeProcesoEnCuestion,"Nombrar Procesos",JOptionPane.PLAIN_MESSAGE);
            while ((nombre==null) || (nombre.equals("")) || (MapeadorFunciones.IsProceso(nombre))){
                nombre = (String)JOptionPane.showInputDialog(new JFrame(),"El nombre que escribió ya está asignado a un proceso o no tenía caracteres.\nEscriba otro nombre para el proceso #"+numeroDeProcesoEnCuestion,"Nombrar Procesos",JOptionPane.PLAIN_MESSAGE);    
            }
            //System.out.println("Proceso #"+numeroDeProcesoEnCuestion+" = "+nombre);
            Proceso p = new Proceso(nombre);
            Globales.procs[i]=p;
        }
    }
}
