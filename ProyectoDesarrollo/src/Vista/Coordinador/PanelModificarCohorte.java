/** 
 * Nombre del Archivo: Item.java
 * Autores: JULIAN GARCIA RICO (1225435) 
 *          DIEGO FERNANDO BEDOYA (1327749) 
 *          CRISTIAN ALEXANDER VALENCIA TORRES (1329454) 
 *          OSCAR STEVEN ROMERO BERON (1326750) 
 */
package Vista.Coordinador;

import Controlador.ControladorCohorte;
import Controlador.ControladorTablas;
import Logica.Aspirante;
import Logica.Cohorte;
import Logica.Curso;
import Logica.CursoCohorte;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Clock;
import java.util.List;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
        jButtonFinalizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLTyAsp = new javax.swing.JTable();
        jButtonListarLTs = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDateChooserFechaInicio = new com.toedter.calendar.JDateChooser();
        jDateChooserFechaFin = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabelIdCohorte = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButtonBuscarAspirantes = new javax.swing.JButton();
        jComboBoxPCMZona = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxCurso = new javax.swing.JComboBox();
        jDialogAspirantes = new javax.swing.JDialog();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableAspiratesBD = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabelNombreArea = new javax.swing.JLabel();
        jButtonSeleccionarAspirante = new javax.swing.JButton();
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

        jButtonFinalizar.setText("FINALIZAR");

        jScrollPane1.setBackground(new java.awt.Color(245, 243, 241));

        jTableLTyAsp.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        jTableLTyAsp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CEDULA", "NOMBRES", "APELLIDOS", "TIPO", "CODIGO", "CURSO", "¿INCLUIR?"
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
        jScrollPane1.setViewportView(jTableLTyAsp);
        if (jTableLTyAsp.getColumnModel().getColumnCount() > 0) {
            jTableLTyAsp.getColumnModel().getColumn(0).setResizable(false);
            jTableLTyAsp.getColumnModel().getColumn(0).setPreferredWidth(75);
            jTableLTyAsp.getColumnModel().getColumn(1).setResizable(false);
            jTableLTyAsp.getColumnModel().getColumn(2).setResizable(false);
            jTableLTyAsp.getColumnModel().getColumn(3).setResizable(false);
            jTableLTyAsp.getColumnModel().getColumn(4).setResizable(false);
            jTableLTyAsp.getColumnModel().getColumn(5).setResizable(false);
            jTableLTyAsp.getColumnModel().getColumn(6).setResizable(false);
            jTableLTyAsp.getColumnModel().getColumn(6).setPreferredWidth(43);
        }

        jButtonListarLTs.setText("Listar LT's");

        jLabel12.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(15, 15, 111));
        jLabel12.setText("MODIFICAR COHORTE");

        jLabel2.setText("Fecha inicio:");

        jLabel3.setText("Fecha finalizacion:");

        jLabel4.setText("Cohorte:");

        jLabelIdCohorte.setText("codigo de la cohorte");

        jLabel1.setText("Cursos:");

        jButtonBuscarAspirantes.setText("BUSCAR");

        jLabel5.setText("Zona:");

        javax.swing.GroupLayout jPanelModificarCohorteLayout = new javax.swing.GroupLayout(jPanelModificarCohorte);
        jPanelModificarCohorte.setLayout(jPanelModificarCohorteLayout);
        jPanelModificarCohorteLayout.setHorizontalGroup(
            jPanelModificarCohorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelModificarCohorteLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonListarLTs)
                .addGap(18, 18, 18)
                .addComponent(jButtonGuardarCursoSeleccionado)
                .addGap(24, 24, 24)
                .addComponent(jButtonFinalizar)
                .addGap(43, 43, 43))
            .addGroup(jPanelModificarCohorteLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanelModificarCohorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelModificarCohorteLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooserFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonBuscarAspirantes))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelModificarCohorteLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanelModificarCohorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelModificarCohorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelModificarCohorteLayout.createSequentialGroup()
                                .addComponent(jDateChooserFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1))
                            .addGroup(jPanelModificarCohorteLayout.createSequentialGroup()
                                .addComponent(jLabelIdCohorte)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelModificarCohorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxPCMZona, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxCurso, 0, 187, Short.MAX_VALUE))))
                .addGap(0, 18, Short.MAX_VALUE))
        );
        jPanelModificarCohorteLayout.setVerticalGroup(
            jPanelModificarCohorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelModificarCohorteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelModificarCohorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelModificarCohorteLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanelModificarCohorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelIdCohorte, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelModificarCohorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooserFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelModificarCohorteLayout.createSequentialGroup()
                        .addGroup(jPanelModificarCohorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxPCMZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelModificarCohorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jComboBoxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanelModificarCohorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooserFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscarAspirantes)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelModificarCohorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFinalizar)
                    .addComponent(jButtonGuardarCursoSeleccionado)
                    .addComponent(jButtonListarLTs))
                .addGap(17, 17, 17))
        );

        jDialogAspirantes.setTitle("LISTado");

        jTableAspiratesBD.setBackground(new java.awt.Color(245, 245, 245));
        jTableAspiratesBD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(jTableAspiratesBD);

        jLabel10.setText("Listado de estudiante del area");

        jLabelNombreArea.setText("nombre del area");

        jButtonSeleccionarAspirante.setText("SELECCIONAR");

        javax.swing.GroupLayout jDialogAspirantesLayout = new javax.swing.GroupLayout(jDialogAspirantes.getContentPane());
        jDialogAspirantes.getContentPane().setLayout(jDialogAspirantesLayout);
        jDialogAspirantesLayout.setHorizontalGroup(
            jDialogAspirantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogAspirantesLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelNombreArea)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jDialogAspirantesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogAspirantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogAspirantesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonSeleccionarAspirante)))
                .addContainerGap())
        );
        jDialogAspirantesLayout.setVerticalGroup(
            jDialogAspirantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogAspirantesLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jDialogAspirantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabelNombreArea))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSeleccionarAspirante)
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
    private javax.swing.JButton jButtonBuscarAspirantes;
    private javax.swing.JButton jButtonBuscarCohorte;
    private javax.swing.JButton jButtonFinalizar;
    private javax.swing.JButton jButtonGuardarCursoSeleccionado;
    private javax.swing.JButton jButtonListarLTs;
    private javax.swing.JButton jButtonSeleccionarAspirante;
    private javax.swing.JButton jButtonSiguienteCohorte;
    private javax.swing.JComboBox jComboBoxCurso;
    private javax.swing.JComboBox jComboBoxPCMZona;
    private com.toedter.calendar.JDateChooser jDateChooserFechaFin;
    private com.toedter.calendar.JDateChooser jDateChooserFechaInicio;
    private javax.swing.JDialog jDialogAspirantes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelIdCohorte;
    private javax.swing.JLabel jLabelNombreArea;
    private javax.swing.JPanel jPanelBuscarCohortes;
    private javax.swing.JPanel jPanelModificarCohorte;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableAspiratesBD;
    private javax.swing.JTable jTableLTyAsp;
    private javax.swing.JTable jTableListaCohorte;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
    private Controlador.ControladorCohorte controlCohorte;
    private Vector <Cohorte> listadoCohorte;
    private Vector <Curso> listadoCursos;
    private Vector <Logica.Curso> cursosSelect;
    private Vector <CursoCohorte> listadoCursoCohorte;
    private Vector <Aspirante> listaAspirantes;
    private Vector<Aspirante> listadoLT;
    private ControladorTablas contoltablas;
    private int poslistaLT;
    private int curso; 
    
    private void misComponentes()
    {
        actualizarPanelPrincipal(jPanelBuscarCohortes);
        
        controlCohorte = new ControladorCohorte();
        
        // seteo de combobox
        jComboBoxPCMZona.addItem("");
        jComboBoxPCMZona.addItem("Amazonas");
        jComboBoxPCMZona.addItem("Antioquia");
        jComboBoxPCMZona.addItem("Arauca");
        jComboBoxPCMZona.addItem("Atlantico");
        jComboBoxPCMZona.addItem("Bolivar");
        jComboBoxPCMZona.addItem("Boyacá");
        jComboBoxPCMZona.addItem("Caldas");
        jComboBoxPCMZona.addItem("Caquetá");
        jComboBoxPCMZona.addItem("Casanare");
        jComboBoxPCMZona.addItem("Cauca");
        jComboBoxPCMZona.addItem("Cesar");
        jComboBoxPCMZona.addItem("Chocó");
        jComboBoxPCMZona.addItem("Córdoba");
        jComboBoxPCMZona.addItem("Cundinamarca");
        jComboBoxPCMZona.addItem("Guainía");
        jComboBoxPCMZona.addItem("Guaviare");
        jComboBoxPCMZona.addItem("Huila");
        jComboBoxPCMZona.addItem("La Guajira");
        jComboBoxPCMZona.addItem("Magdalena");
        jComboBoxPCMZona.addItem("Meta");
        jComboBoxPCMZona.addItem("Nariño");
        jComboBoxPCMZona.addItem("Norte de Santander");
        jComboBoxPCMZona.addItem("Putumayo");
        jComboBoxPCMZona.addItem("Quindio");
        jComboBoxPCMZona.addItem("Risaralda");
        jComboBoxPCMZona.addItem("San Andres y Providencia");
        jComboBoxPCMZona.addItem("Santander");
        jComboBoxPCMZona.addItem("Sucre");
        jComboBoxPCMZona.addItem("Tolima");
        jComboBoxPCMZona.addItem("Valle del Cauca");
        jComboBoxPCMZona.addItem("Vaupés");
        jComboBoxPCMZona.addItem("Vichada");
        
        listadoLT = new Vector();
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
        jButtonFinalizar.addActionListener(events);
        jButtonListarLTs.addActionListener(events);
        jButtonSeleccionarAspirante.addActionListener(events);
        jButtonBuscarAspirantes.addActionListener(events);
    } // Fin del metodo asignarEventos
    
    
    public void mostrarCohortes(){
        listadoCohorte = new Vector<>();
        
        listadoCohorte = controlCohorte.buscarCohorte();
        System.out.println("tam listadoCohorte " + listadoCohorte.size());
        
        contoltablas = new ControladorTablas(listadoCohorte);
        
        DefaultTableModel modelo = new DefaultTableModel(contoltablas.contruirCuerpo(4), contoltablas.titulos(4)){
            public boolean isCellEditable(int row, int column) { 
                if (column == 3) return true; 
                else return false; 
            }
        };
        jTableListaCohorte.setModel(modelo);
//        
        jTableListaCohorte.getColumnModel().getColumn(3).setCellEditor(jTableListaCohorte.getDefaultEditor(Boolean.class));
        jTableListaCohorte.getColumnModel().getColumn(3).setCellRenderer(jTableListaCohorte.getDefaultRenderer(Boolean.class));
        jTableListaCohorte.getTableHeader().setReorderingAllowed(false);
        
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
    
    private void crearJDialog(JDialog dialog){
        listarAspirantes();
        dialog.setVisible(true);
        dialog.pack();
    } // fin del metodo crearJDialogs
    
    private void listarCursos()
    {
        String idcurso = new String();
        String idcursoCohorte = new String();
        listadoCursos = new Vector<>();
        cursosSelect = new Vector<>();
        listadoCursoCohorte = new Vector<CursoCohorte>();
        
        listadoCursos = (Vector<Curso>) controlCohorte.buscarCursos();
        listadoCursoCohorte = controlCohorte.buscarCursoCohorte(jLabelIdCohorte. getText());
        
        jComboBoxCurso.removeAllItems();
        jComboBoxCurso.addItem("");
        for (int i = 0; i < listadoCursos.size(); i++)
        {
            
            idcurso = listadoCursos.get(i).getIdCurso();
            for(int j = 0; j < listadoCursoCohorte.size(); j++){
                
                idcursoCohorte = listadoCursoCohorte.get(j).getCurso().getIdCurso();
                
                if(idcurso.equals(idcursoCohorte)){
                    jComboBoxCurso.addItem(listadoCursos.get(i).getIdCurso() + " " + listadoCursos.get(i).getNombre());
                    cursosSelect.add(listadoCursos.get(i));
                }
            }
        }
    }
    
    private void limpiarTablas(JTable tabla, int tam){
        DefaultTableModel borrar = (DefaultTableModel) tabla.getModel();
        System.out.println("llego ");
        for (int i = tam; i < borrar.getRowCount(); i--){
            borrar.removeRow(i);
            System.out.println("lo hizo");
        }
    }
       
    private void listarAspirantes(){
        String area = listadoCursoCohorte.get(jComboBoxCurso.getSelectedIndex() - 1).getCursoCohortePK().getIdCurso();
        String dep = jComboBoxPCMZona.getSelectedItem().toString();
        curso = jComboBoxCurso.getSelectedIndex();
        jLabelNombreArea.setText(jComboBoxCurso.getSelectedItem().toString());
        listaAspirantes = new Vector<>();
        listaAspirantes = controlCohorte.listarAspirantes(area, dep);
        System.out.println("listaAspirantes " + listaAspirantes.size() + ", " + area);
        contoltablas = new ControladorTablas(listaAspirantes);
        
        DefaultTableModel modelo = new DefaultTableModel(contoltablas.contruirCuerpo(2), contoltablas.titulos(2))
        { 
            public boolean isCellEditable(int row, int column) { 
                if (column == 4) return true; 
                else return false; 
            }
        };
        
        jTableAspiratesBD.setModel(modelo);
        
        jTableAspiratesBD.getColumnModel().getColumn(4).setCellEditor(jTableAspiratesBD.getDefaultEditor(new Boolean(false).getClass()));
        jTableAspiratesBD.getColumnModel().getColumn(4).setCellRenderer(jTableAspiratesBD.getDefaultRenderer(Boolean.class));
        jTableAspiratesBD.getTableHeader().setReorderingAllowed(false);
        
    }// fin del metodo listarAspirantes
    
    /**
     * trae los campos que hay en la bd y los muestra en la tabla que apaerece 
     * en el dialog y lo incluye en la tabla del panelMatricula
     */
    private void aspirantesSeleccionados()
    {
        TableModel TMAspirante = jTableAspiratesBD.getModel();
        poslistaLT = listadoLT.size();
        DefaultTableModel TMSelecionados = (DefaultTableModel) jTableLTyAsp.getModel();
        int fila = TMAspirante.getRowCount();
       // curso = jComboBoxCurso.getSelectedIndex() - 1;
        
        if(0 == JOptionPane.showConfirmDialog(null, "¿Esta seguro que estos son los aspirantes que va a seleccionar?")){
            for(int i=0; i< fila; i++) { 
                if(TMAspirante.getValueAt(i, 4).equals(true)){
                    listadoLT.addElement(listaAspirantes.get(i));
                }
            }
            
            for (int i = poslistaLT; i < listadoLT.size(); i++){
                //System.out.println(cursosSelect.get(i).getNombre());
                TMSelecionados.addRow(new Object[] {listadoLT.get(i).getCedula(),
                                                    listadoLT.get(i).getNombres(),
                                                    listadoLT.get(i).getApellidos(),
                                                    "Aspirante",
                                                    
                                                    cursosSelect.get(curso - 1).getIdCurso(),
                                                    cursosSelect.get(curso - 1).getNombre(),
                                                    false}
                );
            }
            
            jDialogAspirantes.setVisible(false);
        }
    } // fin del metodo AspirantesSeleccionados
    
    private void  guardarCursoCohorte()
    {
        DefaultTableModel dtm = (DefaultTableModel) jTableLTyAsp.getModel();
        int valor = JOptionPane.showConfirmDialog(null, "¿Desea guardar todos los cambios?");
        String mensaje = new String();
        
        if(valor == 0){
            mensaje = "Guardando los cambios:\n- fechas de la cohorte\n- nuevos aspirantes matriculados\n- desmatriculado de los LT's";
            JOptionPane.showMessageDialog(null, mensaje);
            controlCohorte.modificarCohorte(jLabelIdCohorte.getText(), jDateChooserFechaInicio.getDate(), jDateChooserFechaFin.getDate());
            for (int i = 0; i < dtm.getRowCount(); i++){
                
                
                if("Aspirante".equals(jTableLTyAsp.getValueAt(i, 3).toString()) && jTableLTyAsp.getValueAt(i, 6).equals(true)){
                    
                    controlCohorte.modificarAspirante(jTableLTyAsp.getValueAt(i, 4).toString(), jLabelIdCohorte.getText(), false);
                    controlCohorte.ingresarLT(listadoLT.get(i));
                    controlCohorte.ingresarMatricula(jLabelIdCohorte.getText(), jTableLTyAsp.getValueAt(i, 4).toString(),jTableLTyAsp.getValueAt(i, 0).toString());
                    controlCohorte.crearTarea(jTableLTyAsp.getValueAt(i, 0).toString(), jTableLTyAsp.getValueAt(i, 4).toString());
                    controlCohorte.enviarCorreos(listadoLT.get(i).getCorreo(),
                                                 listadoLT.get(i).getNombres() + " " + listadoLT.get(i).getApellidos(),
                                                 listadoLT.get(i).getCedula());
                }
                if ("Leader teacher".equals(jTableLTyAsp.getValueAt(i, 3).toString()) && jTableLTyAsp.getValueAt(i, 6).equals(false)){
                    controlCohorte.eliminarTarea(jTableLTyAsp.getValueAt(i, 0).toString(), jTableLTyAsp.getValueAt(i, 4).toString());
                    controlCohorte.modificarAspirante(jTableLTyAsp.getValueAt(i, 4).toString(), jLabelIdCohorte.getText(), true);
                    controlCohorte.eliminarMatricula(jTableLTyAsp.getValueAt(i, 0).toString(), jLabelIdCohorte.getText(), jTableLTyAsp.getValueAt(i, 4).toString());
                }
                System.out.println("guardarCursoCohorte = " + dtm.getValueAt(i, 6));
            }
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
                listarCursos();
                actualizarPanelPrincipal(jPanelModificarCohorte);
            }
            else if(e.getSource() == jButtonBuscarAspirantes){
                crearJDialog(jDialogAspirantes);
            }
            else if(e.getSource() == jButtonListarLTs){
                listarAspirantes();
            }
            else if(e.getSource() == jButtonGuardarCursoSeleccionado){
                guardarCursoCohorte();
            }
            else if(e.getSource() == jButtonFinalizar){
                actualizarPanelPrincipal(jPanelBuscarCohortes);
            }
            else if(e.getSource() == jButtonSeleccionarAspirante){
                aspirantesSeleccionados();
            }
        }
        
    
    } // Fin de la clase EventosPanelLogin

} // Fin de la clase PanelLogin
