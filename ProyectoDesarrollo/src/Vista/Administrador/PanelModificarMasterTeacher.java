/** 
 * Nombre del Archivo: Item.java
 * Autores: JULIAN GARCIA RICO (1225435) 
 *          DIEGO FERNANDO BEDOYA (1327749) 
 *          CRISTIAN ALEXANDER VALENCIA TORRES (1329454) 
 *          OSCAR STEVEN ROMERO BERON (1326750) 
 */
package Vista.Administrador;

import Controlador.ControladorAdministrador;
import Logica.MasterTeacher;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author oscar
 */
public class PanelModificarMasterTeacher extends javax.swing.JPanel {

    /**
     * Creates new form PanelLogin
     */
    public PanelModificarMasterTeacher() {
        initComponents();

        // Eventos 
        EventosPanelLogin events = new EventosPanelLogin();
        asignarEventos(events);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBuscar2 = new javax.swing.JPanel();
        labelBuscarMaster = new javax.swing.JLabel();
        labelBuscarPor = new javax.swing.JLabel();
        labelDatoBusqueda = new javax.swing.JLabel();
        botonBuscar = new javax.swing.JButton();
        inputBuscarPor = new javax.swing.JComboBox();
        inputDatoBusqueda = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabelCedula = new javax.swing.JLabel();
        jLabelNombres = new javax.swing.JLabel();
        jLabelApellidos = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelCiudad = new javax.swing.JLabel();
        jLabelIdCurso = new javax.swing.JLabel();
        jLabelPais = new javax.swing.JLabel();
        jTextFieldCedula = new javax.swing.JTextField();
        jTextFieldApellidos = new javax.swing.JTextField();
        jTextFieldNombres = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldCiudad = new javax.swing.JTextField();
        jTextFieldPais = new javax.swing.JTextField();
        jButtonModificar = new javax.swing.JButton();
        jComboBoxIdCurso = new javax.swing.JComboBox();
        jButtonCancelar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setPreferredSize(new java.awt.Dimension(750, 505));

        panelBuscar2.setBackground(new java.awt.Color(245, 245, 245));

        labelBuscarMaster.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        labelBuscarMaster.setForeground(new java.awt.Color(15, 15, 111));
        labelBuscarMaster.setText("MODIFICAR MASTER TEACHER");

        labelBuscarPor.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        labelBuscarPor.setText("Buscar por:");

        labelDatoBusqueda.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        labelDatoBusqueda.setText("Dato busqueda:");

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        inputBuscarPor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cedula", "Correo" }));
        inputBuscarPor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        inputDatoBusqueda.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        javax.swing.GroupLayout panelBuscar2Layout = new javax.swing.GroupLayout(panelBuscar2);
        panelBuscar2.setLayout(panelBuscar2Layout);
        panelBuscar2Layout.setHorizontalGroup(
            panelBuscar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBuscar2Layout.createSequentialGroup()
                .addGroup(panelBuscar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBuscar2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(labelBuscarMaster))
                    .addGroup(panelBuscar2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelBuscar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBuscar2Layout.createSequentialGroup()
                                .addComponent(labelBuscarPor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputBuscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(labelDatoBusqueda))
                            .addComponent(botonBuscar))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(inputDatoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        panelBuscar2Layout.setVerticalGroup(
            panelBuscar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBuscar2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelBuscarMaster)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBuscar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelBuscarPor)
                    .addComponent(labelDatoBusqueda)
                    .addComponent(inputBuscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputDatoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(245, 245, 245));

        jLabelCedula.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabelCedula.setText("Cedula: ");

        jLabelNombres.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabelNombres.setText("Nombres: ");

        jLabelApellidos.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabelApellidos.setText("Apellidos: ");

        jLabelEmail.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabelEmail.setText("Email: ");

        jLabelCiudad.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabelCiudad.setText("Ciudad:");

        jLabelIdCurso.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabelIdCurso.setText("Id_Curso:");

        jLabelPais.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabelPais.setText("Pais:");

        jTextFieldCedula.setEditable(false);
        jTextFieldCedula.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        jTextFieldApellidos.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        jTextFieldNombres.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        jTextFieldEmail.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        jTextFieldCiudad.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        jTextFieldPais.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N

        jButtonModificar.setText("Modificar");
        jButtonModificar.setEnabled(false);
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jComboBoxIdCurso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonModificar))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCedula)
                            .addComponent(jLabelApellidos)
                            .addComponent(jLabelNombres)
                            .addComponent(jLabelEmail)
                            .addComponent(jLabelCiudad)
                            .addComponent(jLabelPais)
                            .addComponent(jLabelIdCurso))
                        .addGap(80, 80, 80)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                            .addComponent(jTextFieldNombres, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                            .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                            .addComponent(jTextFieldCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                            .addComponent(jTextFieldCiudad, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                            .addComponent(jTextFieldPais, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                            .addComponent(jComboBoxIdCurso, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 222, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelCedula)
                                    .addComponent(jTextFieldCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelApellidos)
                                    .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelNombres)
                                    .addComponent(jTextFieldNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addComponent(jLabelEmail))
                            .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCiudad)
                            .addComponent(jTextFieldCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPais))
                        .addGap(18, 18, 18)
                        .addComponent(jLabelIdCurso))
                    .addComponent(jComboBoxIdCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonModificar)
                    .addComponent(jButtonCancelar)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, 730, Short.MAX_VALUE)
                        .addGap(8, 8, 8))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        // TODO add your handling code here:
        buscarMasterTeacher () ;
        jButtonModificar.setEnabled(true);
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        // TODO add your handling code here:
       modificarMasterTeacher () ;
       //limpiarPanelDatos ();
       jButtonModificar.setEnabled(false);
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        limpiarPanelDatos ();
        limpiarPanelBuscar ();
        jButtonModificar.setEnabled(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JComboBox inputBuscarPor;
    private javax.swing.JTextField inputDatoBusqueda;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JComboBox jComboBoxIdCurso;
    private javax.swing.JLabel jLabelApellidos;
    private javax.swing.JLabel jLabelCedula;
    private javax.swing.JLabel jLabelCiudad;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelIdCurso;
    private javax.swing.JLabel jLabelNombres;
    private javax.swing.JLabel jLabelPais;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextFieldApellidos;
    private javax.swing.JTextField jTextFieldCedula;
    private javax.swing.JTextField jTextFieldCiudad;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNombres;
    private javax.swing.JTextField jTextFieldPais;
    private javax.swing.JLabel labelBuscarMaster;
    private javax.swing.JLabel labelBuscarPor;
    private javax.swing.JLabel labelDatoBusqueda;
    private javax.swing.JPanel panelBuscar2;
    // End of variables declaration//GEN-END:variables

    // Controlador
    ControladorAdministrador contAdministrador;
    
    
     public void buscarMasterTeacher () { 
        contAdministrador = ControladorAdministrador.getInstance();
        String ItemSeleccionado = inputBuscarPor.getSelectedItem().toString();
        if (ItemSeleccionado.equals("Cedula")) { 
            MasterTeacher master = contAdministrador.buscarMasterTeacherPorCedula(inputDatoBusqueda.getText());
            if (master == null) {
            mostarMensaje(JOptionPane.INFORMATION_MESSAGE, 
                         "Error: consulta arroja null", "La consulta no arrojo ningun resultado");
            limpiarPanelBuscar ();
            limpiarPanel ();
            } else {
                if (master.getEstado()) {
                            mostrarInfoMasterTeacher (master);
                            limpiarPanelBuscar ();} 
                   else { 
                       JOptionPane.showMessageDialog(null, "El master teacher ya ha sido eliminado");
                       limpiarPanel ();
                   }
            }
        } 

        if (ItemSeleccionado.equals("Correo")) { 
            ArrayList <MasterTeacher> mt = contAdministrador.listaMasterTeacher ();
            boolean bandera = false ;
            for (int i=0; i< mt.size(); i++) { 
                
                if (mt.get(i).getCorreo() .equals(inputDatoBusqueda.getText())) { 
                    MasterTeacher master = contAdministrador.buscarMasterTeacherPorCedula(mt.get(i).getCedula());
                    if (master == null) {
                       mostarMensaje(JOptionPane.INFORMATION_MESSAGE, 
                       "Error: consulta arroja null", "La consulta no arrojo ningun resultado");
                       limpiarPanelBuscar ();
                       limpiarPanel ();
                       } else {
                        if (master.getEstado()) {
                            mostrarInfoMasterTeacher (master);
                            limpiarPanelBuscar ();
                            bandera = true;
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "El master teacher ya ha sido eliminado");
                            limpiarPanel ();
                            limpiarPanelBuscar ();
                        }
                    
                    }
                }
            }
            
            if (!bandera) { JOptionPane.showMessageDialog(null, "Error: la consulta para el campo correo no arrojo niungun resultado");
                            limpiarPanel ();}
       }
        
        
    }
     
      public void limpiarPanel() { 
        jTextFieldApellidos.setText("");
        jTextFieldCedula.setText("");
        jTextFieldCiudad.setText("");
        jTextFieldEmail.setText("");
        jComboBoxIdCurso.setSelectedItem("");
        jTextFieldNombres.setText("");
        jTextFieldPais.setText("");
     }
     
     public void limpiarPanelBuscar () { 
        inputDatoBusqueda.setText("");
    }
    
     public void mostrarInfoMasterTeacher (MasterTeacher master) {
        if (master.getCedula() != null) {
            jTextFieldCedula.setText("" + master.getCedula());
        }
        if (master.getApellido() != null) {
            jTextFieldApellidos.setText("" + master.getApellido());
        }
        if (master.getNombre()
                != null) {
            jTextFieldNombres.setText("" + master.getNombre());
        }
        if (master.getCorreo() != null) {
            jTextFieldEmail.setText("" + master.getCorreo());
        }
        if (master.getCiudad() != null) {
            jTextFieldCiudad.setText("" + master.getCiudad());
        }
        if (master.getPais() != null) {
            jTextFieldPais.setText("" + master.getPais());
        }
        if (master.getIdCurso() != null) {
            
            jComboBoxIdCurso.setSelectedItem("" + master.getIdCurso().getIdCurso() + " " +  master.getIdCurso().getNombre());
            //jComboBoxIdCurso.setSelectedItem("IC9 5");
        }
        
    }
     
     public void inicializarCombobox () {  
        contAdministrador = ControladorAdministrador.getInstance();
        ArrayList <String> idNombreCursos = new ArrayList<>();
        idNombreCursos = contAdministrador.listaCursosIds();
        jComboBoxIdCurso.setModel(new javax.swing.DefaultComboBoxModel(new String[] {""}));
        for (int i = 0; i < idNombreCursos.size(); i++){ 
            jComboBoxIdCurso.addItem(idNombreCursos.get(i));
        }
        
    }
     
     private String codigoCurso(){
        String codigoNombre = " ";
        codigoNombre = (String) jComboBoxIdCurso.getSelectedItem();
        String codigoCurso = " ";    
        int posiSeparador = 0;
        for(int i =0; i < codigoNombre.length();i++){
            if(codigoNombre.charAt(i)==' '){
                posiSeparador = i;
            }
        }
        codigoCurso = codigoNombre.substring(0, posiSeparador);
        return codigoCurso;
    }
     
     public void modificarMasterTeacher () { 
        
       contAdministrador = ControladorAdministrador.getInstance();
       String cedula= jTextFieldCedula.getText();
       String nombre= jTextFieldNombres.getText(); 
       String apellido= jTextFieldApellidos.getText(); 
       String email= jTextFieldEmail.getText(); 
       String ciudad= jTextFieldCiudad.getText(); 
       String pais = jTextFieldPais.getText(); 
       boolean estado = true;
       String result="";
       
       result = contAdministrador.modificarMasterTeacher(cedula, nombre, apellido, email, ciudad, pais, estado, 
                                                             contAdministrador.getDaoCurso().findCurso(codigoCurso()));
       JOptionPane.showMessageDialog(null, result);
       if (result.equals("Se creo el master teacher con exito")) { 
           limpiarPanelDatos ();
       }
                }
     
     public void limpiarPanelDatos () { 
        jTextFieldCedula.setText("");
        jTextFieldApellidos.setText("");
        jTextFieldNombres.setText("");
        jTextFieldEmail.setText("");
        jTextFieldCiudad.setText("" );     
        jTextFieldPais.setText("");
        jComboBoxIdCurso.setSelectedItem("");
    }
     private void mostarMensaje(int tipo, String titulo, String mensaje) {
        JOptionPane.showMessageDialog(null, titulo, mensaje, tipo);   
    } // Fin del metodo 
            

    private void asignarEventos(EventosPanelLogin events){
        
    } // Fin del metodo asignarEventos
    
    private class EventosPanelLogin implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        }
    
    } // Fin de la clase EventosPanelLogin

} // Fin de la clase PanelLogin
