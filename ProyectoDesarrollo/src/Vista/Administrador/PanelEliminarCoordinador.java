/** 
 * Nombre del Archivo: Item.java
 * Autores: JULIAN GARCIA RICO (1225435) 
 *          DIEGO FERNANDO BEDOYA (1327749) 
 *          CRISTIAN ALEXANDER VALENCIA TORRES (1329454) 
 *          OSCAR STEVEN ROMERO BERON (1326750) 
 */
package Vista.Administrador;

import Controlador.ControladorAdministrador;
import Logica.Empleado;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author oscar
 */
public class PanelEliminarCoordinador extends javax.swing.JPanel {

    /**
     * Creates new form PanelLogin
     */
    public PanelEliminarCoordinador() {
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
        labelEliminarCoordinador = new javax.swing.JLabel();
        labelBuscarPor = new javax.swing.JLabel();
        labelDatoBusqueda = new javax.swing.JLabel();
        inputBuscarPor = new javax.swing.JComboBox();
        inputDatoBusqueda = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabelCedula = new javax.swing.JLabel();
        jLabelNombres = new javax.swing.JLabel();
        jLabelApellidos = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelCargo = new javax.swing.JLabel();
        jLabelTelefono = new javax.swing.JLabel();
        jLabelDireccion = new javax.swing.JLabel();
        jTextFieldCedula = new javax.swing.JTextField();
        jTextFieldApellidos = new javax.swing.JTextField();
        jTextFieldNombres = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldCargo = new javax.swing.JTextField();
        jTextFieldTelefono = new javax.swing.JTextField();
        jTextFieldDireccion = new javax.swing.JTextField();
        botonEliminar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(750, 505));

        panelBuscar2.setBackground(new java.awt.Color(245, 245, 245));
        panelBuscar2.setBorder(null);

        labelEliminarCoordinador.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        labelEliminarCoordinador.setForeground(new java.awt.Color(15, 15, 111));
        labelEliminarCoordinador.setText("ELIMINAR COORDINADOR");

        labelBuscarPor.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        labelBuscarPor.setText("Buscar por:");

        labelDatoBusqueda.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        labelDatoBusqueda.setText("Dato busqueda:");

        inputBuscarPor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cedula", "Correo" }));
        inputBuscarPor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBuscar2Layout = new javax.swing.GroupLayout(panelBuscar2);
        panelBuscar2.setLayout(panelBuscar2Layout);
        panelBuscar2Layout.setHorizontalGroup(
            panelBuscar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBuscar2Layout.createSequentialGroup()
                .addGroup(panelBuscar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBuscar2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(labelEliminarCoordinador))
                    .addGroup(panelBuscar2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(labelBuscarPor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputBuscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(labelDatoBusqueda)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(inputDatoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(panelBuscar2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBuscar2Layout.setVerticalGroup(
            panelBuscar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBuscar2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelEliminarCoordinador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBuscar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelBuscarPor)
                    .addComponent(labelDatoBusqueda)
                    .addComponent(inputBuscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputDatoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonBuscar)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(245, 245, 245));

        jLabelCedula.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabelCedula.setText("Cedula: ");

        jLabelNombres.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabelNombres.setText("Nombres: ");

        jLabelApellidos.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabelApellidos.setText("Apellidos: ");

        jLabelEmail.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabelEmail.setText("Email: ");

        jLabelCargo.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabelCargo.setText("Cargo: ");

        jLabelTelefono.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabelTelefono.setText("Telefono: ");

        jLabelDireccion.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabelDireccion.setText("Direccion: ");

        jTextFieldCedula.setEditable(false);
        jTextFieldCedula.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N

        jTextFieldApellidos.setEditable(false);
        jTextFieldApellidos.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N

        jTextFieldNombres.setEditable(false);
        jTextFieldNombres.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N

        jTextFieldEmail.setEditable(false);
        jTextFieldEmail.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N

        jTextFieldCargo.setEditable(false);
        jTextFieldCargo.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N

        jTextFieldTelefono.setEditable(false);

        jTextFieldDireccion.setEditable(false);
        jTextFieldDireccion.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N

        botonEliminar.setText("Eliminar");
        botonEliminar.setEnabled(false);
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCedula)
                    .addComponent(jLabelApellidos)
                    .addComponent(jLabelNombres)
                    .addComponent(jLabelEmail)
                    .addComponent(jLabelCargo)
                    .addComponent(jLabelDireccion)
                    .addComponent(jLabelTelefono))
                .addGap(80, 80, 80)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonCancelar)
                .addGap(18, 18, 18)
                .addComponent(botonEliminar))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCedula)
                            .addComponent(jTextFieldCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelApellidos)
                            .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNombres)
                            .addComponent(jTextFieldNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addComponent(jLabelEmail))
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCargo)
                    .addComponent(jTextFieldCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTelefono, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDireccion))
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonEliminar)
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
                        .addComponent(panelBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, 728, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        // TODO add your handling code here:
        eliminarCoordinador ();
        botonEliminar.setEnabled(false);
        limpiarPanelDatos ();
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        limpiarPanelDatos ();
        botonEliminar.setEnabled(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        // TODO add your handling code here:
        buscarCoordinador ();
    }//GEN-LAST:event_botonBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JComboBox inputBuscarPor;
    private javax.swing.JTextField inputDatoBusqueda;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabelApellidos;
    private javax.swing.JLabel jLabelCargo;
    private javax.swing.JLabel jLabelCedula;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelNombres;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextFieldApellidos;
    private javax.swing.JTextField jTextFieldCargo;
    private javax.swing.JTextField jTextFieldCedula;
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNombres;
    private javax.swing.JTextField jTextFieldTelefono;
    private javax.swing.JLabel labelBuscarPor;
    private javax.swing.JLabel labelDatoBusqueda;
    private javax.swing.JLabel labelEliminarCoordinador;
    private javax.swing.JPanel panelBuscar2;
    // End of variables declaration//GEN-END:variables

    // Controlador
    ControladorAdministrador contAdministrador;
    
    public void limpiarPanelDatos () { 
        jTextFieldCedula.setText("");
        jTextFieldApellidos.setText("");
        jTextFieldNombres.setText("");
        jTextFieldEmail.setText("");
        jTextFieldCargo.setText("" );     
        jTextFieldDireccion.setText("");
        jTextFieldTelefono.setText("");
    }
    
    public void limpiarPanelBuscar () { 
        inputDatoBusqueda.setText("");
    }
    
    private void mostarMensaje(int tipo, String titulo, String mensaje) {
        JOptionPane.showMessageDialog(null, titulo, mensaje, tipo);   
    } // Fin del metodo 
    
    public Empleado buscarCoordinador () { 
        botonEliminar.setEnabled(true);
        Empleado empleado = new Empleado();
        contAdministrador = ControladorAdministrador.getInstance();
        String ItemSeleccionado = inputBuscarPor.getSelectedItem().toString();
        if (ItemSeleccionado.equals("Cedula")) { 
            empleado = contAdministrador.buscarEmpleadoPorCedula(inputDatoBusqueda.getText());
            if (empleado == null) {
            mostarMensaje(JOptionPane.INFORMATION_MESSAGE, 
            "Error: consulta arroja null", "La consulta no arrojo ningun resultado");
            limpiarPanelBuscar ();
            } else {
            mostrarInfoCoordinador (empleado);
            limpiarPanelBuscar ();} }
        if (ItemSeleccionado.equals("Correo")) { 
            ArrayList <Empleado> empleados = contAdministrador.listaEmpleados();
            for (int i=0; i<empleados.size(); i++) { 
                if (empleados.get(i).getEmail().equals(inputDatoBusqueda.getText())) { 
                    empleado = contAdministrador.buscarEmpleadoPorCedula(empleados.get(i).getCedula());
                    if (empleado == null) {
                        mostarMensaje(JOptionPane.INFORMATION_MESSAGE, 
                        "Error: consulta arroja null", "La consulta no arrojo ningun resultado");
                        limpiarPanelBuscar ();
                        } else {
                        mostrarInfoCoordinador (empleado);
                        limpiarPanelBuscar ();}
                    }
            } 
       }
        
       return empleado; 
    }
    
    public void mostrarInfoCoordinador (Empleado empleado) {
        if (empleado.getCedula() != null) {
            jTextFieldCedula.setText("" + empleado.getCedula());
        }
        if (empleado.getApellidos() != null) {
            jTextFieldApellidos.setText("" + empleado.getApellidos());
        }
        if (empleado.getNombres() != null) {
            jTextFieldNombres.setText("" + empleado.getNombres());
        }
        if (empleado.getEmail() != null) {
            jTextFieldEmail.setText("" + empleado.getEmail());
        }
        if (empleado.getCargo() != null) {
            jTextFieldCargo.setText("" + empleado.getCargo());
        }
        if (empleado.getDirecion() != null) {
            jTextFieldDireccion.setText("" + empleado.getDirecion());
        }
        if (empleado.getTelefono() != null) {
            jTextFieldTelefono.setText("" + empleado.getTelefono());
        }
        
    }
    
    public void eliminarCoordinador () { 
        contAdministrador = ControladorAdministrador.getInstance();
        Empleado emp = contAdministrador.buscarEmpleadoPorCedula(jTextFieldCedula.getText());
        String result = contAdministrador.modificarEmpleado(emp.getCedula(), emp.getNombres(),emp.getApellidos(),emp.getEmail(),
                                                            emp.getCargo(),emp.getDirecion(),emp.getTelefono(), false);
        if (result.equals("1")) {
            mostarMensaje(JOptionPane.INFORMATION_MESSAGE, 
                    "La operacion se realiza exitosamente", "Confirmacion Operacion");
        }
    }

    private void asignarEventos(EventosPanelLogin events){
        
    } // Fin del metodo asignarEventos
    
    private class EventosPanelLogin implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        }
    
    } // Fin de la clase EventosPanelLogin

} // Fin de la clase PanelLogin
