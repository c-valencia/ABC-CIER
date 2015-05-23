/** 
 * Nombre del Archivo: Item.java
 * Autores: JULIAN GARCIA RICO (1225435) 
 *          DIEGO FERNANDO BEDOYA (1327749) 
 *          CRISTIAN ALEXANDER VALENCIA TORRES (1329454) 
 *          OSCAR STEVEN ROMERO BERON (1326750) 
 */
package Vista.Coordinador;

import Controlador.ControladorReportes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author oscar
 */
public class PanelReporte extends javax.swing.JPanel {

    /**
     * Creates new form PanelLogin
     */
    public PanelReporte() {
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

        panelBuscarMesAno = new javax.swing.JPanel();
        labelReportEspecifico = new javax.swing.JLabel();
        labelAno = new javax.swing.JLabel();
        inputAno = new com.toedter.calendar.JYearChooser();
        labelMes = new javax.swing.JLabel();
        inputMes = new com.toedter.calendar.JMonthChooser();
        botonBuscarMesAno = new javax.swing.JButton();
        panelCursoEstDepart = new javax.swing.JPanel();
        labelCodCursoCED = new javax.swing.JLabel();
        labelReporteEspecifico2 = new javax.swing.JLabel();
        labelDepartementoCDE = new javax.swing.JLabel();
        scrollPanelListDepar = new javax.swing.JScrollPane();
        listDepart = new javax.swing.JList();
        inputCodCursoCDE = new javax.swing.JTextField();
        botonReporteCDE = new javax.swing.JButton();
        panelSuperior = new javax.swing.JPanel();
        labelReporte = new javax.swing.JLabel();
        labelListaReportes = new javax.swing.JLabel();
        comboReportes = new javax.swing.JComboBox();
        panelInferior = new javax.swing.JPanel();

        panelBuscarMesAno.setBackground(new java.awt.Color(245, 245, 245));
        panelBuscarMesAno.setBorder(null);

        labelReportEspecifico.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        labelReportEspecifico.setForeground(new java.awt.Color(15, 15, 111));
        labelReportEspecifico.setText("CURSOS CON MAYOR  NÚMERO DE ASISTENTES EN EL MES");

        labelAno.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        labelAno.setText("Año:");

        labelMes.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        labelMes.setText("Mes:");

        botonBuscarMesAno.setText("Generar Reporte");

        javax.swing.GroupLayout panelBuscarMesAnoLayout = new javax.swing.GroupLayout(panelBuscarMesAno);
        panelBuscarMesAno.setLayout(panelBuscarMesAnoLayout);
        panelBuscarMesAnoLayout.setHorizontalGroup(
            panelBuscarMesAnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBuscarMesAnoLayout.createSequentialGroup()
                .addGroup(panelBuscarMesAnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBuscarMesAnoLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(panelBuscarMesAnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonBuscarMesAno)
                            .addGroup(panelBuscarMesAnoLayout.createSequentialGroup()
                                .addComponent(labelAno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputAno, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelMes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelBuscarMesAnoLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(labelReportEspecifico)))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        panelBuscarMesAnoLayout.setVerticalGroup(
            panelBuscarMesAnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBuscarMesAnoLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(labelReportEspecifico)
                .addGap(40, 40, 40)
                .addGroup(panelBuscarMesAnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelAno)
                    .addComponent(inputAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMes)
                    .addComponent(inputMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(botonBuscarMesAno)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        panelCursoEstDepart.setBackground(new java.awt.Color(245, 245, 245));

        labelCodCursoCED.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        labelCodCursoCED.setText("Codigo del Curso:");

        labelReporteEspecifico2.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        labelReporteEspecifico2.setForeground(new java.awt.Color(15, 15, 111));
        labelReporteEspecifico2.setText("Estudiantes por curso por Departamento");

        labelDepartementoCDE.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        labelDepartementoCDE.setText("Departamento: ");

        listDepart.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Amazonas", "Antioquia", "Arauca", "Atlantico", "Bolivar", "Boyacá ", "Caldas ", "Caquetá ", "Casanare", "Cauca ", "Cesar", "Chocó", "Córdoba", "Cundinamarca", "Guainía", "Guaviare", "Huila", "La Guajira", "Magdalena", "Meta", "Nariño", "Norte de Santander", "Putumayo", "Quindio", "Risaralda", "San Andres y Providencia", "Santander", "Sucre ", "Tolima", "Valle del Cauca", "Vaupés ", "Vichada" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        scrollPanelListDepar.setViewportView(listDepart);

        botonReporteCDE.setText("Generar Reporte");

        javax.swing.GroupLayout panelCursoEstDepartLayout = new javax.swing.GroupLayout(panelCursoEstDepart);
        panelCursoEstDepart.setLayout(panelCursoEstDepartLayout);
        panelCursoEstDepartLayout.setHorizontalGroup(
            panelCursoEstDepartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCursoEstDepartLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(panelCursoEstDepartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCursoEstDepartLayout.createSequentialGroup()
                        .addComponent(labelReporteEspecifico2)
                        .addContainerGap(279, Short.MAX_VALUE))
                    .addGroup(panelCursoEstDepartLayout.createSequentialGroup()
                        .addGroup(panelCursoEstDepartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCursoEstDepartLayout.createSequentialGroup()
                                .addComponent(labelCodCursoCED)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputCodCursoCDE)
                                .addGap(35, 35, 35)
                                .addComponent(labelDepartementoCDE))
                            .addGroup(panelCursoEstDepartLayout.createSequentialGroup()
                                .addComponent(botonReporteCDE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPanelListDepar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75))))
        );
        panelCursoEstDepartLayout.setVerticalGroup(
            panelCursoEstDepartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCursoEstDepartLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(labelReporteEspecifico2)
                .addGap(26, 26, 26)
                .addGroup(panelCursoEstDepartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPanelListDepar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDepartementoCDE)
                    .addGroup(panelCursoEstDepartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelCodCursoCED)
                        .addComponent(inputCodCursoCDE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonReporteCDE)
                .addGap(34, 34, 34))
        );

        setBackground(new java.awt.Color(245, 245, 245));
        setBorder(null);
        setPreferredSize(new java.awt.Dimension(750, 505));

        panelSuperior.setBackground(new java.awt.Color(245, 245, 245));
        panelSuperior.setBorder(null);
        panelSuperior.setPreferredSize(new java.awt.Dimension(759, 146));

        labelReporte.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        labelReporte.setForeground(new java.awt.Color(15, 15, 111));
        labelReporte.setText("REPORTES");

        labelListaReportes.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        labelListaReportes.setText("Lista de Reportes: ");

        comboReportes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Cursos con mayor número de asistentes en el mes", "item1", "item2", "item3", "item4", "item5", "item6" }));
        comboReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboReportesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSuperiorLayout = new javax.swing.GroupLayout(panelSuperior);
        panelSuperior.setLayout(panelSuperiorLayout);
        panelSuperiorLayout.setHorizontalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSuperiorLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelListaReportes)
                            .addComponent(comboReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelSuperiorLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(labelReporte)))
                .addContainerGap(265, Short.MAX_VALUE))
        );
        panelSuperiorLayout.setVerticalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(labelReporte)
                .addGap(18, 18, 18)
                .addComponent(labelListaReportes)
                .addGap(18, 18, 18)
                .addComponent(comboReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        panelInferior.setBackground(new java.awt.Color(245, 245, 245));
        panelInferior.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        panelInferior.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
            .addComponent(panelInferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelInferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboReportesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboReportesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscarMesAno;
    private javax.swing.JButton botonReporteCDE;
    private javax.swing.JComboBox comboReportes;
    private com.toedter.calendar.JYearChooser inputAno;
    private javax.swing.JTextField inputCodCursoCDE;
    private com.toedter.calendar.JMonthChooser inputMes;
    private javax.swing.JLabel labelAno;
    private javax.swing.JLabel labelCodCursoCED;
    private javax.swing.JLabel labelDepartementoCDE;
    private javax.swing.JLabel labelListaReportes;
    private javax.swing.JLabel labelMes;
    private javax.swing.JLabel labelReportEspecifico;
    private javax.swing.JLabel labelReporte;
    private javax.swing.JLabel labelReporteEspecifico2;
    private javax.swing.JList listDepart;
    private javax.swing.JPanel panelBuscarMesAno;
    private javax.swing.JPanel panelCursoEstDepart;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JScrollPane scrollPanelListDepar;
    // End of variables declaration//GEN-END:variables
        
    // Controlador
    private ControladorReportes contReportes;
    
    
    private void actualizarPanelInferior(JPanel panelNuevo) {    
        panelInferior.removeAll();
        panelInferior.add(panelNuevo);
        panelInferior.repaint();
        panelInferior.updateUI();        
    } // Fin del metodo actualizarPanelInferior
    
    
    private void actualizarPanelBuscar(int index){
        switch (index) {
            case 0: {
                JPanel panelVacio = new JPanel();
                panelVacio.setBackground(new java.awt.Color(245, 245, 245));
                actualizarPanelInferior(panelVacio);
            };break;
            case 1: {
                actualizarPanelInferior(panelBuscarMesAno);
            };break;
            
            case 2: {
                actualizarPanelInferior(panelCursoEstDepart);
            };break;
            
            case 3: {
            };break;
                
            case 4: {
            };break;     
                
            case 5: {
            };break;
                
            case 6: {
            };break;                
        };        
    } // Fin del metodo actualizarPanelBus    
    
    private void mostrarReporte(JasperPrint informe, String titulo) {
        if (informe != null) {
            JasperViewer ventanaVisor = new JasperViewer(informe, false);
            ventanaVisor.setTitle(titulo);
            ventanaVisor.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo realizar el informe");
        }

    } // Fin del metodo  mostrarReporte   
        
    private void reporteEstCursoDepar(){
        contReportes = ControladorReportes.getInstance();
        String idCurso = inputCodCursoCDE.getText();
        String departamento = ""+ listDepart.getSelectedValue();
        JasperPrint informe = contReportes.reporteEstCurDepart(idCurso, departamento);
        mostrarReporte(informe, "Reporte");
    } // Fin del metodo reporteEstCursoDepar
    
    
    private  void reportePrueba(){
        contReportes = ControladorReportes.getInstance();
        String ano = "" + inputAno.getYear();
        String mes = "" + (inputMes.getMonth() + 1);         
        JasperPrint informe = contReportes.pruebaReporte(ano, mes);
        mostrarReporte(informe, "Informe Prueba");
    } // Fin del metodo reportePrueba
    

    
    private void asignarEventos(EventosPanelLogin events){
        comboReportes.addActionListener(events);
        botonBuscarMesAno.addActionListener(events);
        botonReporteCDE.addActionListener(events);
    } // Fin del metodo asignarEventos
       
    private class EventosPanelLogin implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == comboReportes) {
                int index = comboReportes.getSelectedIndex();
                actualizarPanelBuscar(index);
            }
            if (e.getSource() == botonBuscarMesAno) {
                reportePrueba();
            }
            
            if (e.getSource() == botonReporteCDE) {
                reporteEstCursoDepar();
            }
        }
    
    } // Fin de la clase EventosPanelLogin

} // Fin de la clase PanelLogin
