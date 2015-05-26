/** 
 * Nombre del Archivo: Item.java
 * Autores: JULIAN GARCIA RICO (1225435) 
 *          DIEGO FERNANDO BEDOYA (1327749) 
 *          CRISTIAN ALEXANDER VALENCIA TORRES (1329454) 
 *          OSCAR STEVEN ROMERO BERON (1326750) :D
 */
package Vista;

import Controlador.ControladorAdministrador;
import Controlador.ControladorAspirante;
import Logica.Curso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class PanelAspirante extends javax.swing.JPanel {

    /**
     * Creates new form PanelLogin
     */
    public PanelAspirante() {
        initComponents();
        initInformation();
               
        // Eventos 
        EventosPanelAspirante events = new EventosPanelAspirante();
        asignarEventos(events);
        inicializarCombobox ();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupArea = new javax.swing.ButtonGroup();
        buttonGroupPTA = new javax.swing.ButtonGroup();
        buttonGroupColombiaAprende = new javax.swing.ButtonGroup();
        scrollPanelPanelPrincipal = new javax.swing.JScrollPane();
        panelPrincipal = new javax.swing.JPanel();
        labelCedula = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        labelApellido = new javax.swing.JLabel();
        labelCorreo = new javax.swing.JLabel();
        labelDireccion = new javax.swing.JLabel();
        labelCelular = new javax.swing.JLabel();
        labelInfoPersonal = new javax.swing.JLabel();
        labelInfoProfesional = new javax.swing.JLabel();
        labelSede = new javax.swing.JLabel();
        labelInstitucion = new javax.swing.JLabel();
        labelDane = new javax.swing.JLabel();
        labelGrado = new javax.swing.JLabel();
        labelSecEducacion = new javax.swing.JLabel();
        labelMunicipio = new javax.swing.JLabel();
        labelArea = new javax.swing.JLabel();
        labelPta = new javax.swing.JLabel();
        labelColombiaAprende = new javax.swing.JLabel();
        inputNombre = new javax.swing.JTextField();
        inputApellido = new javax.swing.JTextField();
        inputCedula = new javax.swing.JTextField();
        inputCorreo = new javax.swing.JTextField();
        inputCelular = new javax.swing.JTextField();
        inputDireccion = new javax.swing.JTextField();
        inputSede = new javax.swing.JTextField();
        inputInstitucion = new javax.swing.JTextField();
        inputDane = new javax.swing.JTextField();
        inputGrado = new javax.swing.JTextField();
        inputSecEducacion = new javax.swing.JComboBox();
        inputMunicipio = new javax.swing.JTextField();
        radioButtonArea1 = new javax.swing.JRadioButton();
        radioButtonArea2 = new javax.swing.JRadioButton();
        radioButtonArea3 = new javax.swing.JRadioButton();
        inputAreaOtro = new javax.swing.JTextField();
        radioButtonArea4 = new javax.swing.JRadioButton();
        radioButtonPTANo = new javax.swing.JRadioButton();
        radioButtonPTASi = new javax.swing.JRadioButton();
        radioButtonCAprendeNo = new javax.swing.JRadioButton();
        radioButtonCAprendeSi = new javax.swing.JRadioButton();
        botonRegistrarse = new javax.swing.JButton();
        labelDepartamento = new javax.swing.JLabel();
        inputDepartamento = new javax.swing.JTextField();
        labelCursoDeseaIncribir = new javax.swing.JLabel();
        jComboBoxCursos = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(245, 245, 245));
        setPreferredSize(new java.awt.Dimension(750, 505));

        scrollPanelPanelPrincipal.setBackground(new java.awt.Color(245, 245, 245));
        scrollPanelPanelPrincipal.setBorder(null);

        panelPrincipal.setBackground(new java.awt.Color(245, 245, 245));

        labelCedula.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        labelCedula.setText("Cedula:");

        labelNombre.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        labelNombre.setText("Nombre: ");

        labelApellido.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        labelApellido.setText("Apellido: ");

        labelCorreo.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        labelCorreo.setText("Correo Electronico: ");

        labelDireccion.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        labelDireccion.setText("Direccion: ");

        labelCelular.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        labelCelular.setText("Celular: ");

        labelInfoPersonal.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        labelInfoPersonal.setForeground(new java.awt.Color(15, 15, 111));
        labelInfoPersonal.setText("INFORMACIÓN PERSONAL");

        labelInfoProfesional.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        labelInfoProfesional.setForeground(new java.awt.Color(15, 15, 111));
        labelInfoProfesional.setText("INFORMACION PROFESIONAL");

        labelSede.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        labelSede.setText("Sede a la que pertenece");

        labelInstitucion.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        labelInstitucion.setText("Intitución a la que pertenece");

        labelDane.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        labelDane.setText("Código Dane de la intitución a la que pertenece");

        labelGrado.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        labelGrado.setText("Grado");

        labelSecEducacion.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        labelSecEducacion.setText("Secretaría de Educación");

        labelMunicipio.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        labelMunicipio.setText("Municipio");

        labelArea.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        labelArea.setText("Área a la cual se va a inscribir(matemáticas, ciencias naturales, lengueaje u otras)");

        labelPta.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        labelPta.setText("Actualmente es TUTOR(A) del Programa Todos Aprender - PTA ?");

        labelColombiaAprende.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        labelColombiaAprende.setText("Tiene usuario Colombia Aprende ?");

        inputNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNombreActionPerformed(evt);
            }
        });

        buttonGroupArea.add(radioButtonArea1);
        radioButtonArea1.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        radioButtonArea1.setText("Matemáticas");
        radioButtonArea1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonArea1ActionPerformed(evt);
            }
        });

        buttonGroupArea.add(radioButtonArea2);
        radioButtonArea2.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        radioButtonArea2.setText("Ciencias Naturales y Eduación Ambiental (incluye Física, Biología y Química)");
        radioButtonArea2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonArea2ActionPerformed(evt);
            }
        });

        buttonGroupArea.add(radioButtonArea3);
        radioButtonArea3.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        radioButtonArea3.setText("Lenguaje (Lenguaje Castellana, Idiomas Extranjeros, Humaniades)");
        radioButtonArea3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonArea3ActionPerformed(evt);
            }
        });

        inputAreaOtro.setEnabled(false);

        buttonGroupArea.add(radioButtonArea4);
        radioButtonArea4.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        radioButtonArea4.setText("Otro: ");
        radioButtonArea4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonArea4ActionPerformed(evt);
            }
        });

        buttonGroupPTA.add(radioButtonPTANo);
        radioButtonPTANo.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        radioButtonPTANo.setText("No");

        buttonGroupPTA.add(radioButtonPTASi);
        radioButtonPTASi.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        radioButtonPTASi.setText("Si");

        buttonGroupColombiaAprende.add(radioButtonCAprendeNo);
        radioButtonCAprendeNo.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        radioButtonCAprendeNo.setText("No");

        buttonGroupColombiaAprende.add(radioButtonCAprendeSi);
        radioButtonCAprendeSi.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        radioButtonCAprendeSi.setText("Si");

        botonRegistrarse.setText("Registrarse");

        labelDepartamento.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        labelDepartamento.setText("Departamento");

        labelCursoDeseaIncribir.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        labelCursoDeseaIncribir.setText("Curso al que se desea inscribir");

        jComboBoxCursos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelArea, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radioButtonCAprendeSi)
                                    .addComponent(radioButtonCAprendeNo)
                                    .addComponent(radioButtonPTASi)
                                    .addComponent(radioButtonPTANo)
                                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                                        .addComponent(radioButtonArea4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(inputAreaOtro, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(radioButtonArea3)
                                    .addComponent(radioButtonArea1)
                                    .addComponent(radioButtonArea2)
                                    .addComponent(labelColombiaAprende)
                                    .addComponent(labelPta))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(botonRegistrarse)
                                .addGap(288, 288, 288)))
                        .addGap(21, 21, 21))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDepartamento)
                            .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPrincipalLayout.createSequentialGroup()
                                    .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(labelCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labelCelular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labelDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(27, 27, 27)
                                    .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(inputCelular)
                                        .addComponent(inputDireccion)
                                        .addComponent(inputCorreo)))
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelMunicipio, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelGrado, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelInstitucion, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelSede, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelInfoPersonal, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelInfoProfesional, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPrincipalLayout.createSequentialGroup()
                                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelCedula, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(labelApellido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(27, 27, 27)
                                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(inputApellido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                                            .addComponent(inputNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(inputCedula)))
                                    .addComponent(inputDane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(labelDane)
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(inputInstitucion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                                    .addComponent(inputSede, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(inputSecEducacion, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelSecEducacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(inputMunicipio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                                .addComponent(inputGrado, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(inputDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(83, Short.MAX_VALUE))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelCursoDeseaIncribir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxCursos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(labelInfoPersonal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre)
                    .addComponent(inputNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelApellido)
                    .addComponent(inputApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCedula)
                    .addComponent(inputCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCorreo)
                    .addComponent(inputCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCelular)
                    .addComponent(inputCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelDireccion)
                    .addComponent(inputDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(labelInfoProfesional)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelSede)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputSede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelInstitucion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelDane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputDane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelGrado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelSecEducacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputSecEducacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelMunicipio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelDepartamento)
                .addGap(8, 8, 8)
                .addComponent(inputDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelArea)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioButtonArea1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioButtonArea2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioButtonArea3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputAreaOtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioButtonArea4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelPta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioButtonPTANo)
                .addGap(7, 7, 7)
                .addComponent(radioButtonPTASi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelColombiaAprende)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioButtonCAprendeNo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioButtonCAprendeSi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelCursoDeseaIncribir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(botonRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        scrollPanelPanelPrincipal.setViewportView(panelPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPanelPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPanelPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void inputNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNombreActionPerformed

    private void radioButtonArea1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonArea1ActionPerformed
        // TODO add your handling code here:
        inputAreaOtro.setEnabled(false);
    }//GEN-LAST:event_radioButtonArea1ActionPerformed

    private void radioButtonArea2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonArea2ActionPerformed
        // TODO add your handling code here:
        inputAreaOtro.setEnabled(false);
    }//GEN-LAST:event_radioButtonArea2ActionPerformed

    private void radioButtonArea4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonArea4ActionPerformed
        // TODO add your handling code here:
        inputAreaOtro.setEnabled(true);
    }//GEN-LAST:event_radioButtonArea4ActionPerformed

    private void radioButtonArea3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonArea3ActionPerformed
        // TODO add your handling code here:
        inputAreaOtro.setEnabled(false);
    }//GEN-LAST:event_radioButtonArea3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonRegistrarse;
    private javax.swing.ButtonGroup buttonGroupArea;
    private javax.swing.ButtonGroup buttonGroupColombiaAprende;
    private javax.swing.ButtonGroup buttonGroupPTA;
    private javax.swing.JTextField inputApellido;
    private javax.swing.JTextField inputAreaOtro;
    private javax.swing.JTextField inputCedula;
    private javax.swing.JTextField inputCelular;
    private javax.swing.JTextField inputCorreo;
    private javax.swing.JTextField inputDane;
    private javax.swing.JTextField inputDepartamento;
    private javax.swing.JTextField inputDireccion;
    private javax.swing.JTextField inputGrado;
    private javax.swing.JTextField inputInstitucion;
    private javax.swing.JTextField inputMunicipio;
    private javax.swing.JTextField inputNombre;
    private javax.swing.JComboBox inputSecEducacion;
    private javax.swing.JTextField inputSede;
    private javax.swing.JComboBox jComboBoxCursos;
    private javax.swing.JLabel labelApellido;
    private javax.swing.JLabel labelArea;
    private javax.swing.JLabel labelCedula;
    private javax.swing.JLabel labelCelular;
    private javax.swing.JLabel labelColombiaAprende;
    private javax.swing.JLabel labelCorreo;
    private javax.swing.JLabel labelCursoDeseaIncribir;
    private javax.swing.JLabel labelDane;
    private javax.swing.JLabel labelDepartamento;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelGrado;
    private javax.swing.JLabel labelInfoPersonal;
    private javax.swing.JLabel labelInfoProfesional;
    private javax.swing.JLabel labelInstitucion;
    private javax.swing.JLabel labelMunicipio;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPta;
    private javax.swing.JLabel labelSecEducacion;
    private javax.swing.JLabel labelSede;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JRadioButton radioButtonArea1;
    private javax.swing.JRadioButton radioButtonArea2;
    private javax.swing.JRadioButton radioButtonArea3;
    private javax.swing.JRadioButton radioButtonArea4;
    private javax.swing.JRadioButton radioButtonCAprendeNo;
    private javax.swing.JRadioButton radioButtonCAprendeSi;
    private javax.swing.JRadioButton radioButtonPTANo;
    private javax.swing.JRadioButton radioButtonPTASi;
    private javax.swing.JScrollPane scrollPanelPanelPrincipal;
    // End of variables declaration//GEN-END:variables

    // Controlador
    private ControladorAdministrador contAdministrador;
    private ControladorAspirante contladorAspirante;
    
    public void limpiarPanelDatos () { 
        buttonGroupArea.clearSelection();
        buttonGroupColombiaAprende.clearSelection();
        buttonGroupPTA.clearSelection();
  
        inputNombre.setText("");
        inputApellido.setText("");
        inputCedula.setText("");
        inputCorreo.setText("" );     
        inputCelular.setText("");
        inputDireccion.setText("");
        inputSede.setText("" );     
        inputInstitucion.setText("");
        inputDane.setText("");
        inputGrado.setText("" );     
        inputMunicipio.setText("");
        inputDepartamento.setText("");
        inputAreaOtro.setText("" );     
        
        inputSecEducacion.setSelectedItem("");
        jComboBoxCursos.setSelectedItem("");
    }
    
    private void asignarEventos(EventosPanelAspirante events){
        botonRegistrarse.addActionListener(events);
    } // Fin del metodo asignarEventos
    
    public void inicializarCombobox () {  
        contAdministrador = ControladorAdministrador.getInstance();
        ArrayList <String> idNombreCursos = new ArrayList<>();
        idNombreCursos = contAdministrador.listaCursosIds();
        jComboBoxCursos.setModel(new javax.swing.DefaultComboBoxModel(new String[] {""}));
        for (int i = 0; i < idNombreCursos.size(); i++){ 
            jComboBoxCursos.addItem(idNombreCursos.get(i));
        }
        
    }
    
    private String codigoCurso(){
        String codigoNombre = " ";
        codigoNombre = (String) jComboBoxCursos.getSelectedItem();
        String codigoCurso = " ";    
        int posiSeparador = 0;
        for(int i =0; i < codigoNombre.length();i++){
            if(codigoNombre.charAt(i)==' '){
                posiSeparador = i;
                i = codigoNombre.length();
            }
        }
        codigoCurso = codigoNombre.substring(0, posiSeparador);
        return codigoCurso;
    }
        
    public void guardarAspirante(){   
        contAdministrador = ControladorAdministrador.getInstance();
        contladorAspirante= ControladorAspirante.getInstance();
        
        String cedula = inputCedula.getText();
        String nombres = inputNombre.getText();
        String apellidos = inputApellido.getText();
        String correo = inputCorreo.getText();
        String celular = inputCelular.getText();
        String direccion = inputDireccion.getText();
        String sedePertenece = inputSede.getText();
        String intitucion = inputInstitucion.getText();
        String codigoDaneIntitucion = inputDane.getText();
        String grado = inputGrado.getText();
        String secretariaEducacion = inputSecEducacion.getSelectedItem().toString();
        String municipio = inputMunicipio.getText();
        String departamento = inputDepartamento.getText();
        String areaInscripcion = obtenerArea();
        boolean tutorPta = obtenerPTA();
        boolean usuarioColombiaAprende = obtenerColombiaAprende();
        boolean estado = true; // REVISAR OJO
        String result = contladorAspirante.crearAspirante(cedula, nombres, apellidos, correo, celular, 
                direccion, sedePertenece, intitucion, codigoDaneIntitucion, grado, 
                secretariaEducacion, municipio, departamento, areaInscripcion, 
                tutorPta, usuarioColombiaAprende, estado);
        JOptionPane.showMessageDialog(null, result);
        
        if  (result.equals("Se creo el aspirante con exito")) {
            limpiarPanelDatos ();
            java.util.Date fecha = new Date();
            String result2 = contladorAspirante.crearHistorialAspirante (cedula, codigoCurso(),fecha, estado);
            JOptionPane.showMessageDialog(null, result2);
        }
        
        
    } // Fin de la clase guardarAspirante    
        
    /**
     * Nombre: intiInformation
     * Proposito: Metodo que iniciliza la informacion de los comboBox
     */
    private void initInformation(){
        inputSecEducacion.addItem("");
        inputSecEducacion.addItem("Amazonas"); //------
        inputSecEducacion.addItem("Huila"); //------
        inputSecEducacion.addItem("Nariño");//------
        inputSecEducacion.addItem("Tolima"); //------
        inputSecEducacion.addItem("Valle del Cauca");//------
        inputSecEducacion.addItem("");//------
        inputSecEducacion.addItem("Buenaventura");
        inputSecEducacion.addItem("Buga");
        inputSecEducacion.addItem("Cali");
        inputSecEducacion.addItem("Caquetá");
        inputSecEducacion.addItem("Cartago");
        inputSecEducacion.addItem("Florencia");
        inputSecEducacion.addItem("Ibagué");
        inputSecEducacion.addItem("Ipiales");
        inputSecEducacion.addItem("Jamundí");
        inputSecEducacion.addItem("Neiva");
        inputSecEducacion.addItem("Palmira");
        inputSecEducacion.addItem("Pasto");
        inputSecEducacion.addItem("Popayán");
        inputSecEducacion.addItem("Putumayo");
        inputSecEducacion.addItem("Tumaco");
        
    } // Fin del metodo intiInformation  
        
    private void mostarMensaje(int tipo, String titulo, String mensaje) {
        JOptionPane.showMessageDialog(null, titulo, mensaje, tipo);   
    } // Fin del metodo 
        
    private String obtenerArea(){
        String area = "";
        if (radioButtonArea1.isSelected()) {
            area = radioButtonArea1.getText();
        } else if (radioButtonArea2.isSelected()) {
            area = "Ciencias Naturales y Eduación Ambiental";
        } else if (radioButtonArea3.isSelected()) {
            area = "Lenguaje";
        } else if (radioButtonArea4.isSelected()) {
            area = inputAreaOtro.getText();
        } 
        return area;
    } // Fin del metodo obtenerArea
    
    private boolean obtenerColombiaAprende(){
        boolean result = false;
        if (radioButtonCAprendeSi.isSelected()) {
            result = true;
        }
        return result;    
    } // Fin del metodo obtenerColombiaAprende
    
    private boolean obtenerPTA(){
        boolean result = false;
        if (radioButtonPTASi.isSelected()) {
            result = true;
        }
        return result;
    } // Fin del metodo obtenerPTA
    
    private class EventosPanelAspirante implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == botonRegistrarse) {    
                guardarAspirante();   
                
            }
        }
    } // Fin de la clase EventosPanelAspirante
    
} // Fin de la clase PanelLogin
