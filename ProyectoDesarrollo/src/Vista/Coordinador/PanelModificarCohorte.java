/** 
 * Nombre del Archivo: Item.java
 * Autores: JULIAN GARCIA RICO (1225435) 
 *          DIEGO FERNANDO BEDOYA (1327749) 
 *          CRISTIAN ALEXANDER VALENCIA TORRES (1329454) 
 *          OSCAR STEVEN ROMERO BERON (1326750) 
 */
package Vista.Coordinador;

import Controlador.ControladorCohorte;
import Logica.Cohorte;
import Logica.Curso;
import Logica.CursoCohorte;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author oscar
 */
public class PanelModificarCohorte extends javax.swing.JPanel {

    /**
     * Creates new form PanelLogin
     */
    public PanelModificarCohorte() {
        initComponents();
        // inicio de mis componentes
        misComponentes();  // El panel cambia es en panel de Coordinador
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

        jPanelBuscarCohortes = new javax.swing.JPanel();
        jButtonSiguienteCohorte = new javax.swing.JButton();
        jButtonBuscarCohorte = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableListaCohorte = new javax.swing.JTable();
        jPanelModificarCohorte = new javax.swing.JPanel();
        jButtonGuardarCursoSeleccionado = new javax.swing.JButton();
        jButtonSiguienteEnPCurso = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCursos = new javax.swing.JTable();
        jButtonListarCursos = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDateChooserFechaInicio = new com.toedter.calendar.JDateChooser();
        jDateChooserFechaFin = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabelIdCohorte = new javax.swing.JLabel();
        jPanelCrearMatricula = new javax.swing.JPanel();
        jButtonGuardarMatricula = new javax.swing.JButton();
        jButtonFinalizarMatricula = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableLeaderTeacher = new javax.swing.JTable();
        jButtonListarAspirantes = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        panelPrincipal = new javax.swing.JPanel();

        jPanelBuscarCohortes.setBackground(new java.awt.Color(245, 245, 245));
        jPanelBuscarCohortes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButtonSiguienteCohorte.setText("SIGUIENTE >>");

        jButtonBuscarCohorte.setText("BUSCAR");

        jLabel11.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(15, 15, 111));
        jLabel11.setText("BUSCAR COHORTE");

        jTableListaCohorte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "FECHA INICIO", "FECHA FIN", "MODIFICAR (UNO)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTableListaCohorte);
        if (jTableListaCohorte.getColumnModel().getColumnCount() > 0) {
            jTableListaCohorte.getColumnModel().getColumn(0).setResizable(false);
            jTableListaCohorte.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTableListaCohorte.getColumnModel().getColumn(1).setResizable(false);
            jTableListaCohorte.getColumnModel().getColumn(2).setResizable(false);
            jTableListaCohorte.getColumnModel().getColumn(3).setResizable(false);
            jTableListaCohorte.getColumnModel().getColumn(3).setPreferredWidth(80);
        }

        javax.swing.GroupLayout jPanelBuscarCohortesLayout = new javax.swing.GroupLayout(jPanelBuscarCohortes);
        jPanelBuscarCohortes.setLayout(jPanelBuscarCohortesLayout);
        jPanelBuscarCohortesLayout.setHorizontalGroup(
            jPanelBuscarCohortesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscarCohortesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonBuscarCohorte, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonSiguienteCohorte, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
            .addGroup(jPanelBuscarCohortesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBuscarCohortesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                    .addGroup(jPanelBuscarCohortesLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelBuscarCohortesLayout.setVerticalGroup(
            jPanelBuscarCohortesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscarCohortesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelBuscarCohortesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSiguienteCohorte)
                    .addComponent(jButtonBuscarCohorte))
                .addGap(31, 31, 31))
        );

        jPanelModificarCohorte.setBackground(new java.awt.Color(245, 245, 245));
        jPanelModificarCohorte.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButtonGuardarCursoSeleccionado.setText("GUARDAR");

        jButtonSiguienteEnPCurso.setText("SIGUIENTE >>");

        jScrollPane1.setBackground(new java.awt.Color(245, 243, 241));

        jTableCursos.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        jTableCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "NOMBRE", "¿INCLUIR?"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableCursos);

        jButtonListarCursos.setText("Listar Cursos");

        jLabel12.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(15, 15, 111));
        jLabel12.setText("MODIFICAR COHORTE");

        jLabel2.setText("Fecha inicio:");

        jLabel3.setText("Fecha finalizacion:");

        jLabel4.setText("Cohorte:");

        jLabelIdCohorte.setText("codigo de la cohorte");

        javax.swing.GroupLayout jPanelModificarCohorteLayout = new javax.swing.GroupLayout(jPanelModificarCohorte);
        jPanelModificarCohorte.setLayout(jPanelModificarCohorteLayout);
        jPanelModificarCohorteLayout.setHorizontalGroup(
            jPanelModificarCohorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelModificarCohorteLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonListarCursos)
                .addGap(18, 18, 18)
                .addComponent(jButtonGuardarCursoSeleccionado)
                .addGap(18, 18, 18)
                .addComponent(jButtonSiguienteEnPCurso)
                .addGap(43, 43, 43))
            .addGroup(jPanelModificarCohorteLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanelModificarCohorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(jPanelModificarCohorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanelModificarCohorteLayout.createSequentialGroup()
                            .addGroup(jPanelModificarCohorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addGroup(jPanelModificarCohorteLayout.createSequentialGroup()
                                    .addGap(44, 44, 44)
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelIdCohorte)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanelModificarCohorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jDateChooserFechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                .addComponent(jDateChooserFechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanelModificarCohorteLayout.setVerticalGroup(
            jPanelModificarCohorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelModificarCohorteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelModificarCohorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelModificarCohorteLayout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelModificarCohorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabelIdCohorte)))
                    .addComponent(jDateChooserFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelModificarCohorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooserFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelModificarCohorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGuardarCursoSeleccionado)
                    .addComponent(jButtonSiguienteEnPCurso)
                    .addComponent(jButtonListarCursos))
                .addGap(28, 28, 28))
        );

        jPanelCrearMatricula.setBackground(new java.awt.Color(245, 245, 245));
        jPanelCrearMatricula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButtonGuardarMatricula.setText("GUARDAR");

        jButtonFinalizarMatricula.setText("FINALIZAR");

        jScrollPane2.setBackground(new java.awt.Color(245, 245, 245));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTableLeaderTeacher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cedula", "Nombres", "Apellidos", "Email", "Codigo", "Area", "Incluir"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableLeaderTeacher);

        jButtonListarAspirantes.setText("LISTAR");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(15, 15, 111));
        jLabel8.setText("LISTAR ASPIRANTES");

        javax.swing.GroupLayout jPanelCrearMatriculaLayout = new javax.swing.GroupLayout(jPanelCrearMatricula);
        jPanelCrearMatricula.setLayout(jPanelCrearMatriculaLayout);
        jPanelCrearMatriculaLayout.setHorizontalGroup(
            jPanelCrearMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCrearMatriculaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCrearMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCrearMatriculaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonListarAspirantes, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonGuardarMatricula)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonFinalizarMatricula))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
                    .addGroup(jPanelCrearMatriculaLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelCrearMatriculaLayout.setVerticalGroup(
            jPanelCrearMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCrearMatriculaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCrearMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFinalizarMatricula)
                    .addComponent(jButtonGuardarMatricula)
                    .addComponent(jButtonListarAspirantes))
                .addContainerGap())
        );

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setPreferredSize(new java.awt.Dimension(750, 505));

        panelPrincipal.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscarCohorte;
    private javax.swing.JButton jButtonFinalizarMatricula;
    private javax.swing.JButton jButtonGuardarCursoSeleccionado;
    private javax.swing.JButton jButtonGuardarMatricula;
    private javax.swing.JButton jButtonListarAspirantes;
    private javax.swing.JButton jButtonListarCursos;
    private javax.swing.JButton jButtonSiguienteCohorte;
    private javax.swing.JButton jButtonSiguienteEnPCurso;
    private com.toedter.calendar.JDateChooser jDateChooserFechaFin;
    private com.toedter.calendar.JDateChooser jDateChooserFechaInicio;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelIdCohorte;
    private javax.swing.JPanel jPanelBuscarCohortes;
    private javax.swing.JPanel jPanelCrearMatricula;
    private javax.swing.JPanel jPanelModificarCohorte;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableCursos;
    private javax.swing.JTable jTableLeaderTeacher;
    private javax.swing.JTable jTableListaCohorte;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
    private Controlador.ControladorCohorte controlCohorte;
    private Vector <Cohorte> listadoCohorte;
    private Vector <Curso> listadoCursos;
    private Vector <CursoCohorte> listadoCursoCohorte;
    
    private void misComponentes()
    {
        actualizarPanelPrincipal(jPanelBuscarCohortes);
        
        controlCohorte = new ControladorCohorte();
    }
         
    private void actualizarPanelPrincipal(JPanel panelNuevo) {
        panelPrincipal.removeAll();
        panelPrincipal.add(panelNuevo);
        panelPrincipal.repaint();
        panelPrincipal.updateUI();  
//        limpiarTablas(jTableAspiratesBD); 
//        limpiarTablas(jTableCursos);
//        limpiarTablas(jTableLeaderTeacher);
    } // Fin del metodo actualizarPanelPrincipal

    private void asignarEventos(EventosPanelLogin events){
        jButtonBuscarCohorte.addActionListener(events);
        jButtonSiguienteCohorte.addActionListener(events);
        jButtonGuardarCursoSeleccionado.addActionListener(events);
        jButtonSiguienteEnPCurso.addActionListener(events);
        jButtonListarCursos.addActionListener(events);
        jButtonGuardarMatricula.addActionListener(events);
        jButtonFinalizarMatricula.addActionListener(events);
        jButtonListarAspirantes.addActionListener(events);
    } // Fin del metodo asignarEventos
    
    
    public void mostrarCohortes(){
        listadoCohorte = new Vector<>();
        
        listadoCohorte = controlCohorte.buscarCohorte();
        DefaultTableModel tabla = (DefaultTableModel) jTableListaCohorte.getModel();
        for (int i = 0; i < listadoCohorte.size(); i++)
        {
            System.out.println("tamalista = " + listadoCohorte.size());
            tabla.addRow(new Object[]{listadoCohorte.get(i).getIdCohorte(),
                                      listadoCohorte.get(i).getFechaInicio(),
                                      listadoCohorte.get(i).getFechaFin(),
            
                                      false});
        }
    }
    
    private void mostrarInfoCohorte()
    {
        boolean cuantos = true;
        DefaultTableModel tabla = (DefaultTableModel) jTableListaCohorte.getModel();
        for (int i = 0; i < tabla.getRowCount(); i++)
        {
            if (cuantos && tabla.getValueAt(i, 3).equals(true))
            {
                JOptionPane.showMessageDialog(null, "Se mostrara la informacion de la cohorte " + tabla.getValueAt(i, 0));
                cuantos = false;
                
                jLabelIdCohorte.setText(listadoCohorte.get(i).getIdCohorte());
                jDateChooserFechaInicio.setDate(listadoCohorte.get(i).getFechaInicio());
                jDateChooserFechaFin.setDate(listadoCohorte.get(i).getFechaFin());
            }
            else if (!cuantos && tabla.getValueAt(i, 3).equals(true)){
                JOptionPane.showMessageDialog(null, "No se mostrara la informacion de la cohorte " + tabla.getValueAt(i, 0));
            }
        }
    }
    
    private void listarCursos()
    {
        String idcurso = new String();
        String idcursoCohorte = new String();
        listadoCursos = new Vector<>();
        listadoCursoCohorte = new Vector<CursoCohorte>();
        
        listadoCursos = (Vector<Curso>) controlCohorte.buscarCursos();
        listadoCursoCohorte = controlCohorte.buscarCursoCohorte(jLabelIdCohorte. getText());
        
        DefaultTableModel dtm = (DefaultTableModel) jTableCursos.getModel();
        
        for (int i = 0; i < listadoCursos.size(); i++)
        {
            dtm.addRow(new Object[] {listadoCursos.get(i).getIdCurso(), listadoCursos.get(i).getNombre() , false});
            idcurso = listadoCursos.get(i).getIdCurso();
            for(int j = 0; j < listadoCursoCohorte.size(); j++){
                
                idcursoCohorte = listadoCursoCohorte.get(j).getCurso().getIdCurso();
                
                if(idcurso.equals(idcursoCohorte)){
                    dtm.setValueAt(true, i, 2);
                   // dtm.se
                }
            }
        }
    }
    
    private void  guardarCursoCohorte()
    {
        DefaultTableModel dtm = (DefaultTableModel) jTableCursos.getModel();
        for (int i = 0; i < dtm.getRowCount(); i++){
            
        }
        
    }
    
    private class EventosPanelLogin implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == jButtonBuscarCohorte){
                mostrarCohortes();
            }
            else if(e.getSource() == jButtonSiguienteCohorte){
                mostrarInfoCohorte();
                actualizarPanelPrincipal(jPanelModificarCohorte);
            }
            else if(e.getSource() == jButtonListarCursos){
                listarCursos();
            }
            else if(e.getSource() == jButtonGuardarCursoSeleccionado){
                
            }
            else if(e.getSource() == jButtonSiguienteEnPCurso){
                
            }
            else if(e.getSource() == jButtonGuardarMatricula){
                
            }
            else if(e.getSource() == jButtonFinalizarMatricula){
                
            }
            else if(e.getSource() == jButtonListarAspirantes){
                
            }
        }
        
    
    } // Fin de la clase EventosPanelLogin

} // Fin de la clase PanelLogin
