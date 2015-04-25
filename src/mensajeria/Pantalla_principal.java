/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensajeria;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Jespi_000
 */
public class Pantalla_principal extends javax.swing.JFrame {

    /**
     * Creates new form Pantalla_principal
     */
    public Pantalla_principal() {
        initComponents();
        Globales.PantPrincipal = this;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelViewDinamico = new javax.swing.JPanel();
        visualizacionLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TLogs = new javax.swing.JTable();
        consolaLabel = new java.awt.Label();
        consolaText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        consolaOldText = new javax.swing.JTextArea();
        outputLabel = new java.awt.Label();
        jScrollPane2 = new javax.swing.JScrollPane();
        outputText = new javax.swing.JTextArea();
        menu = new javax.swing.JMenuBar();
        Ayuda = new javax.swing.JMenu();
        General = new javax.swing.JMenuItem();
        ElementosSistema = new javax.swing.JMenuItem();
        Creditos = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Mensajería");
        setName("VentanaPrincipal"); // NOI18N
        setResizable(false);

        PanelViewDinamico.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PanelViewDinamico.setToolTipText("Aquí podrá visualizar el estado de cada elemento del sistema al ejecutar la función view().");

        visualizacionLabel.setText("Visualización de Estados y Logs");

        TLogs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(TLogs);

        javax.swing.GroupLayout PanelViewDinamicoLayout = new javax.swing.GroupLayout(PanelViewDinamico);
        PanelViewDinamico.setLayout(PanelViewDinamicoLayout);
        PanelViewDinamicoLayout.setHorizontalGroup(
            PanelViewDinamicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelViewDinamicoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelViewDinamicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelViewDinamicoLayout.createSequentialGroup()
                        .addComponent(visualizacionLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelViewDinamicoLayout.setVerticalGroup(
            PanelViewDinamicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelViewDinamicoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(visualizacionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        consolaLabel.setText("Consola");

        consolaText.setBackground(new java.awt.Color(0, 0, 0));
        consolaText.setForeground(new java.awt.Color(0, 255, 51));
        consolaText.setText(">>> ");
        consolaText.setToolTipText("Aquí puede escribir las funciones permitidas por el sistema.");
        consolaText.setAlignmentX(0.0F);
        consolaText.setCaretColor(new java.awt.Color(0, 255, 0));
        consolaText.setName(""); // NOI18N
        consolaText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consolaTextActionPerformed(evt);
            }
        });
        consolaText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                consolaTextKeyTyped(evt);
            }
        });

        consolaOldText.setEditable(false);
        consolaOldText.setBackground(new java.awt.Color(0, 0, 0));
        consolaOldText.setColumns(20);
        consolaOldText.setForeground(new java.awt.Color(0, 153, 255));
        consolaOldText.setLineWrap(true);
        consolaOldText.setRows(5);
        consolaOldText.setText("¡Bienvenido al sistema!");
        consolaOldText.setToolTipText("Aquí se muestran sus entradas anteriores en la consola.");
        consolaOldText.setWrapStyleWord(true);
        consolaOldText.setCaretColor(new java.awt.Color(51, 153, 255));
        consolaOldText.setDisabledTextColor(new java.awt.Color(51, 153, 255));
        jScrollPane1.setViewportView(consolaOldText);

        outputLabel.setText("Evaluación de la información ");

        outputText.setEditable(false);
        outputText.setColumns(20);
        outputText.setLineWrap(true);
        outputText.setRows(5);
        outputText.setText(Globales.TextoAyuda);
        outputText.setToolTipText("Aquí se muestran los mensajes de error, advertencia, ayuda o éxito de sus acciones.");
        outputText.setWrapStyleWord(true);
        jScrollPane2.setViewportView(outputText);

        Ayuda.setText("Ayuda");
        Ayuda.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                AyudaMenuSelected(evt);
            }
        });
        Ayuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AyudaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AyudaMousePressed(evt);
            }
        });
        Ayuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AyudaActionPerformed(evt);
            }
        });

        General.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        General.setText("Ayuda General");
        General.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GeneralActionPerformed(evt);
            }
        });
        Ayuda.add(General);

        ElementosSistema.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        ElementosSistema.setText("Elementos del Sistema");
        ElementosSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ElementosSistemaActionPerformed(evt);
            }
        });
        Ayuda.add(ElementosSistema);

        menu.add(Ayuda);

        Creditos.setText("Créditos");
        Creditos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CreditosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CreditosMousePressed(evt);
            }
        });
        Creditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreditosActionPerformed(evt);
            }
        });
        menu.add(Creditos);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelViewDinamico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(consolaText)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(consolaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(outputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelViewDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(consolaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(consolaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
        );

        consolaLabel.getAccessibleContext().setAccessibleName("ConsolaLabel");
        outputLabel.getAccessibleContext().setAccessibleName("Output");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void CreaTabla (){ 
    int lenProcs = Globales.procs.length;    
    int lenMails = Globales.mails.length;    
    Object[][] datos = new Object[12][2];    
    String[] columnas = new String[]{            
            "Nombre",
            "Bitacora"};
    final Class[] tiposColumnas = new Class[]{
         //Variable que especifica el tipo de dato de cada columna
            java.lang.String.class,            
            JButton.class 
        };
     int numerofilas = 0;
     for (numerofilas=0;numerofilas<lenProcs;numerofilas++){
        if (Globales.procs[numerofilas]==null){
            break;}
        else{
            datos[numerofilas][0]= Globales.procs[numerofilas].nombre;
            datos[numerofilas][1]= new JButton("Ver Proceso");}
        }
     for (int i=0;i<lenMails;i++){
        if (Globales.mails[i]==null){
            break;}
        else{
            datos[numerofilas][0]= Globales.mails[i].nombre;
            datos[numerofilas][1]= new JButton("Ver Mailbox");}
            numerofilas++;
        }
     
     TLogs.setModel(new javax.swing.table.DefaultTableModel(datos,columnas) {
            // Se puede saber el tipo  de dato que tiene cada columna.
            Class[] tipos = tiposColumnas;
            @Override
            public Class getColumnClass(int columnIndex) {                
                return tipos[columnIndex];
            }
            @Override
            public boolean isCellEditable(int row, int column) {               
                return !(this.getColumnClass(column)!=null);
            }
        });
   
      TLogs.setDefaultRenderer(JButton.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {                
                return (Component) objeto;
            }
        });
     /*****Click del mouse*****/
      
       TLogs.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                View view = new View();
                view.viewPorProceso();
                view.setVisible(true);
                int fila = TLogs.rowAtPoint(e.getPoint());
                int columna = TLogs.columnAtPoint(e.getPoint());
               //Esto es un comentario 
                

                if (TLogs.getModel().getColumnClass(columna).equals(JButton.class)) {                                                            
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < TLogs.getModel().getColumnCount(); i++) {
                        if (!TLogs.getModel().getColumnClass(i).equals(JButton.class)) {
                            sb.append("\n").append(TLogs.getModel().getColumnName(i)).append(": ").append(TLogs.getModel().getValueAt(fila, i));
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Seleccionado el proceso" + sb.toString());
                    
                    
                    
                }
            }
        });
      
     /************************/ 
     
    }
   
   
   
   /************************/
    
    private void consolaTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consolaTextActionPerformed
        //Escuchar la entrada del usuario
        String entrada = new String();
        try {
            //Obtener la entrada del usuario quitandole los >>> 
            entrada = consolaText.getText();
            entrada = entrada.replace(">", "");
            entrada = entrada.replace(" ", "");
            //System.out.println("Entrada del usuario: " + entrada);
            
            //Limpiar el texto en consolaText
            consolaText.setText(">>> ");
            //Mover el texto a consolaOldText y scrollear hasta abajo
            consolaOldText.append("\n>>> " + entrada);
            consolaOldText.setCaretPosition(consolaOldText.getDocument().getLength());
            
            String[] lineaEntrada = entrada.split("\\(");
            String nombreFuncion = lineaEntrada[0];
            
            //Si la función entrada del usuario no está dentro de los comandos permitidos entonces:
            if ((!(Arrays.asList(Globales.FuncionesPermitidas).contains(nombreFuncion))) || (!(entrada.endsWith(")")))){
                //Mostrar el mensaje de error en outputText
                outputText.setText("Error: La acción digitada no es válida para el sistema.");
            }
            else {
                //Obtener el nombre de la función y sus parámetros, validarlos y llamar a la función respectiva directamente.
                String [] parametros = new String[4];
                String p = lineaEntrada[1].substring(0, lineaEntrada[1].length()-1);
                parametros = p.split(",", 4);
                if (MapeadorFunciones.ValidarFuncion(nombreFuncion)){
                    boolean exito = MapeadorFunciones.Mapear(nombreFuncion, parametros);
                    if (exito){
                        if (nombreFuncion.equals("reset")){
                            this.setVisible(false);
                        }
                        outputText.setText("Realizado con éxito.");
                    }
                    else{
                        outputText.setText("Los parámetros ingresados no pudieron ser enlazados para la ejecución de la función.");
                    }
                }
                else{
                    outputText.setText("La función ingresada no puede ser ejecutada con las configuraciones especificadas.");
                }
            }
        }
        catch(Exception e){
            System.out.println("Excepción.");
        }
    }//GEN-LAST:event_consolaTextActionPerformed

    private void consolaTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_consolaTextKeyTyped
        //Función para mostrar ayuda sensitiva cuando el usuario ingrese una función.
        char tecla = evt.getKeyChar();
        if (tecla == '('){
            String entradaPorLinea = consolaText.getText();
            entradaPorLinea = entradaPorLinea.replace(">", "");
            entradaPorLinea = entradaPorLinea.replace(" ", "");
            String[] entradaPorLineaSeccionada = entradaPorLinea.split("\\(");
            String nombreFuncion = entradaPorLineaSeccionada[0];
            if(Arrays.asList(Globales.FuncionesPermitidas).contains(nombreFuncion)){
                String Texto = "";
                switch(nombreFuncion){
                    case "view":
                        outputText.setText("view(). Sin parámetros. Permite observar todo lo que está pasando en el sistema.");
                        break;
                    case "reset":
                        outputText.setText("reset(). Sin parámetros. Permite reconfigurar el sistema, borrando los estados al momento pero manteniendo los procesos.");
                        break;
                    case "send":
                        if (Globales.DireccionamientoDirecto){
                            if (Globales.FIFO){
                                Texto += "- send(NombreDelProcesoEmisor,NombreDelProcesoReceptor,Mensaje)";
                                Texto += ": Envía un mensaje a un proceso.";
                            }
                            else{
                                Texto += "- send(NombreDelProcesoEmisor,NombreDelProceso,Mensaje,NúmeroDePrioridad)";
                                Texto += ": Envía un mensaje a un proceso con cierta prioridad (1,2 o 3, con 1 la más alta).";
                            }
                        }
                        else{
                            if (Globales.FIFO){
                                Texto += "- send(NombreDelProcesoEmisor,NombreDelBuzón,Mensaje)";
                                Texto += ": Envía un mensaje a un buzón.";}
                            else{
                                Texto += "- send(NombreDelProcesoEmisor,NombreDelBuzón,Mensaje,NúmeroDePrioridad)";
                                Texto += ": Envía un mensaje a un buzón con cierta prioridad (1,2 o 3, con 1 la más alta).";
                            }
                        }
                        if (Globales.LargoMsjFijo){
                            Texto += "El mensaje no debe sobrepasar los "+Globales.LargoMsj+" caracteres.";
                        }
                        outputText.setText(Texto);
                        break;
                    case "receive":
                        if (Globales.DireccionamientoDirecto){
                            if (Globales.ReceiveExplicito){
                                Texto += "- receive(NombreDelProcesoReceptor,NombreDelProcesoEmisor)";
                                Texto += ": Recibir un mensaje de un proceso.";
                            }
                            else{
                                Texto += "- receive(NombreDelProcesoReceptor)";
                                Texto += ": Recibir un mensaje del proceso que le envió previamente.";
                            }
                        }
                        else{
                            if (Globales.ReceiveExplicito){
                                Texto += "\n - receive(NombreDelProcesoReceptor,NombreDelProcesoDeOrigen)";
                                Texto += ": Recibe un mensaje del buzón suscrito del proceso de origen especificado.";
                            }
                            else{
                                Texto += "- receive(NombreDelProcesoReceptor)";
                                Texto += ": Recibe un mensaje del buzón suscrito.";
                            }
                        }
                        outputText.setText(Texto);
                        break;
                    case "create_mailbox":
                        if (!(Globales.DireccionamientoDirecto)){
                            /*if (Globales.IndirectoEstatico){
                                outputText.setText("create_mailbox(NombreDelProcesoCreador,NombreDelBuzón). Crea un buzón.");
                            }
                            else{*/
                                outputText.setText("create_mailbox(NombreDelBuzón). Crea un buzón.");
                            //}
                        }
                        else{
                            outputText.setText("Advertencia: No se puede ejecutar este comando en el direccionamiento directo.");
                        }
                        break;
                    case "connect_mailbox":
                        if (!(Globales.DireccionamientoDirecto)){
                            if (!(Globales.IndirectoEstatico)){
                                outputText.setText("connect_mailbox(NombreDelProcesoAConectar,NombreDelBuzón). Conectar el proceso en referencia a cierto buzón.");
                            }
                            else{
                                outputText.setText("Advertencia: No se puede ejecutar este comando en el direccionamiento indirecto estático.");
                            }
                        }
                        else{
                            outputText.setText("Advertencia: No se puede ejecutar este comando en el direccionamiento directo.");
                        }
                        break;
                    case "disconnect_mailbox":
                        if (!(Globales.DireccionamientoDirecto)){
                            if (!(Globales.IndirectoEstatico)){
                                outputText.setText("disconnect_mailbox(NombreDelBuzón,NombreDelProcesoADesconectar). Desconectar el proceso en referencia de cierto buzón.");
                            }
                            else{
                                outputText.setText("Advertencia: No se puede ejecutar este comando en el direccionamiento indirecto estático.");
                            }
                        }
                        else{
                            outputText.setText("Advertencia: No se puede ejecutar este comando en el direccionamiento directo.");
                        }
                        break;
                }
            }
            else{
                outputText.setText("Advertencia: El nombre de la función que acaba de ingresar no es válido, dirígase al menú de ayuda para observar las funciones permitidas.");
            }
        }
    }//GEN-LAST:event_consolaTextKeyTyped

    private void AyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AyudaActionPerformed

    }//GEN-LAST:event_AyudaActionPerformed

    private void AyudaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AyudaMousePressed
        
    }//GEN-LAST:event_AyudaMousePressed

    private void AyudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AyudaMouseClicked

    }//GEN-LAST:event_AyudaMouseClicked

    private void AyudaMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_AyudaMenuSelected

    }//GEN-LAST:event_AyudaMenuSelected

    private void GeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GeneralActionPerformed
        JOptionPane.showMessageDialog(new JFrame(),Globales.TextoAyuda,"Ayuda General",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_GeneralActionPerformed

    private void ElementosSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ElementosSistemaActionPerformed
        String elementos = "";
        elementos = elementos+"Procesos:";
        for (int i=0;i<Globales.Procesos;i++){
            elementos = elementos+"\n- "+Globales.procs[i].nombre;
        }
        if (!(Globales.DireccionamientoDirecto)){
            elementos = elementos+"\n\nBuzones (Mailbox):";
            for (int i=0;i<Globales.UltimoIndiceMailbox;i++){
                try{
                    elementos = elementos+"\n> "+Globales.mails[i].nombre;
                }
                catch(Exception exc){
                }
            }
        }
        elementos=elementos+"\n\nConfiguración";
        if (Globales.SendBlocking){
            elementos=elementos+"\nSend: Blocking";
        }
        else{
            elementos=elementos+"\nSend: Non-Blocking";
        }
        elementos=elementos+"\nReceive: "+Globales.Receive;
        if (Globales.DireccionamientoDirecto){
            elementos=elementos+"\nDireccionamiento: Directo";
            if (Globales.ReceiveExplicito){
                elementos=elementos+"\nReceiveDirecto: Explícito";
            }
            else{
                elementos=elementos+"\nReceiveDirecto: Implícito";
            }
        }
        else{
            elementos=elementos+"\nDireccionamiento: Indirecto";
            if (Globales.IndirectoEstatico){
                elementos=elementos+"\nIndirecto: Estático";
            }
            else{
                elementos=elementos+"\nIndirecto: Dinámico";
            }
        }
        elementos=elementos+"\nCantidad de procesos: "+Globales.Procesos;
        elementos=elementos+"\nCantidad de mensajes en cola: "+Globales.TamanoCola;
        if (Globales.LargoMsjFijo){
            elementos=elementos+"\nLargo Fijo: "+Globales.LargoMsj+" caracteres";
        }
        if (Globales.FIFO){
            elementos=elementos+"\nDisciplina de Cola: FIFO";
        }
        else{
            elementos=elementos+"\nDisciplina de Cola: Prioridad";
        }
        JOptionPane.showMessageDialog(new JFrame(),elementos,"Elementos del Sistema",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_ElementosSistemaActionPerformed

    private void CreditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreditosActionPerformed
        JOptionPane.showMessageDialog(new JFrame(),"El presente programa fue diseñado y desarrollado para el curso Infraestructura Tecnológica I, I semestre 2015.\n\nLos estudiantes responsables son:\n- Adrián Siles Masís\n- Mauricio Gamboa Cubero\n- Andrés Pacheco Quesada\n- Josué Espinoza Castro","Créditos",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_CreditosActionPerformed

    private void CreditosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreditosMouseClicked
        JOptionPane.showMessageDialog(new JFrame(),"El presente programa fue diseñado y desarrollado para el curso Infraestructura Tecnológica I, I semestre 2015.\n\nLos estudiantes responsables son:\n- Adrián Siles Masís\n- Mauricio Gamboa Cubero\n- Andrés Pacheco Quesada\n- Josué Espinoza Castro","Créditos",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_CreditosMouseClicked

    private void CreditosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreditosMousePressed
        JOptionPane.showMessageDialog(new JFrame(),"El presente programa fue diseñado y desarrollado para el curso Infraestructura Tecnológica I, I semestre 2015.\n\nLos estudiantes responsables son:\n- Adrián Siles Masís\n- Mauricio Gamboa Cubero\n- Andrés Pacheco Quesada\n- Josué Espinoza Castro","Créditos",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_CreditosMousePressed

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
            java.util.logging.Logger.getLogger(Pantalla_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pantalla_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pantalla_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pantalla_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pantalla_principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Ayuda;
    private javax.swing.JMenu Creditos;
    private javax.swing.JMenuItem ElementosSistema;
    private javax.swing.JMenuItem General;
    private javax.swing.JPanel PanelViewDinamico;
    private javax.swing.JTable TLogs;
    private java.awt.Label consolaLabel;
    private javax.swing.JTextArea consolaOldText;
    private javax.swing.JTextField consolaText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenuBar menu;
    private java.awt.Label outputLabel;
    private javax.swing.JTextArea outputText;
    private javax.swing.JLabel visualizacionLabel;
    // End of variables declaration//GEN-END:variables

    private void JButton(String clic_Aquí) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
