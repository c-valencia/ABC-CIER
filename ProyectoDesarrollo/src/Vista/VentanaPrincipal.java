/** 
 * Nombre del Archivo: Item.java
 * Autores: JULIAN GARCIA RICO (1225435) 
 *          DIEGO FERNANDO BEDOYA (1327749) 
 *          CRISTIAN ALEXANDER VALENCIA TORRES (1329454) 
 *          OSCAR STEVEN ROMERO BERON (1326750) 
 */
package Vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;
import java.awt.Color;
/**
 * Nombre Clase:
 * Funcion: 
 */

public class VentanaPrincipal extends JFrame {
    
    private JPanel panelBase;
    private JPanel panelSuperior;
    private JPanel panelInferior;
    private PanelPrincipal panelPrincipal;
    private JButton botonCerrar;
    /*
      Nombre: Ventana
      Proposito: Constructor de la clase, en el se asignan las caracteristicas
      del JFrame
    */
    public VentanaPrincipal() {
        // Carga el LookAndFeel    
        cargarLookAndFeel(); 
        
        // Iniciar componentes panelBase
        panelBase();
                
        // Caracteristicas Frame
        this.setMinimumSize(new Dimension(1000, 650));
        this.setTitle ("ABC-CIER");
        this.getContentPane().add(panelBase);
        this.pack();
        this.setLocationRelativeTo(null);         
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Eventos 
        EventosVentanaPrincipal event = new EventosVentanaPrincipal();
        asignarEvenros(event);
    } // Fin del Constructor

    private void panelBase(){
        panelBase = new JPanel(new BorderLayout());        
        // Components
        panelSuperior();               
        panelInferior();
        // Add Components
        panelBase.add(panelSuperior, BorderLayout.NORTH);
        panelBase.add(panelInferior, BorderLayout.SOUTH);
    } // Fin del metodo panelPrincipal
    
    
    private void panelSuperior(){
        panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBackground(Color.WHITE);
        // Components 
        JLabel labelImagne = new JLabel();
        ImageIcon img = new ImageIcon(getClass().getResource("/Vista/Image/Logo_cier-sur.jpg"));
        labelImagne.setIcon(img);
        JPanel panelTemporal = new JPanel();
        panelTemporal.setBackground(Color.WHITE);
        panelTemporal.setBorder(BorderFactory.createEmptyBorder(90, 0, 0,0));
        botonCerrar = new JButton("Cerrar Sesión");
        botonCerrar.setEnabled(false);
        botonCerrar.setBackground(Color.WHITE);
        panelTemporal.add(botonCerrar);
        // Add Components 
        panelSuperior.add(labelImagne, BorderLayout.WEST);
        panelSuperior.add(panelTemporal, BorderLayout.EAST);
    } // Fin del metodo panelSuperior
    
    
    private void panelInferior(){
        panelInferior = new JPanel(new FlowLayout());
        // Components
        panelPrincipal = new PanelPrincipal(this); 

        // Add Components
        panelInferior.add(panelPrincipal);        
    }// Fin del metodo panelInferior
    
    /**
     * Nombre: actualizarPanelInferior
     * Proposito: Metodo que cambiar el contenido del panelInferior
     * @param panelNuevo 
     */
    public void actualizarPanelInferior(JPanel panelNuevo){
        botonCerrar.setEnabled(true);
        panelInferior.removeAll();
        panelInferior.add(panelNuevo);
        panelInferior.repaint();
        panelInferior.updateUI();
    } // Fin del metodo acutlizar panel Inferior
    
    /*
     Nombre: cargarLookAndFeel
     Proposito: Metodo que carga LookAndFeel de la interfaz
     */
    private void cargarLookAndFeel() {
        try {
            // Se cargar el look And Feel por defecto en java en caso de que ocurra una excepcion
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            /*
             Luego cargamos el nuevo lookAndFeel para la aplicacion, si ocurre una excepcion
             se mostrará el look And Feel por defecto en java
             */
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            //Actualizamos el componente
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception exception) {
            System.out.println("No se pudo cargar el lookAndFeel");
        }
    } // Fin del metodo cargarLookAndFeel

    private void asignarEvenros (EventosVentanaPrincipal events) {
        this.addWindowListener(events);
        botonCerrar.addActionListener(events);
    }
    
    private class EventosVentanaPrincipal implements ActionListener, WindowListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == botonCerrar){
            // EN ESTE SE DEBE ACTULIZAR EL VALOR DE LA SESION EN LA BASE DE DATOS                   
                panelPrincipal = new PanelPrincipal(VentanaPrincipal.this);
                actualizarPanelInferior(panelPrincipal);
                botonCerrar.setEnabled(false);
            }
        }

        @Override
        public void windowOpened(WindowEvent e) {
        }

        @Override
        public void windowClosing(WindowEvent e) {
            // EN ESTE SE DEBE ACTULIZAR EL VALOR DE LA SESION EN LA BASE DE DATOS
        }        
        @Override
        public void windowClosed(WindowEvent e) {
        }

        @Override
        public void windowIconified(WindowEvent e) {
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
        }

        @Override
        public void windowActivated(WindowEvent e) {
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
        }
    
    } // Fin de la clase EventosVentanaPrincipa
        
} // Fin de la clase VentanaPrincipal
