package Principal;

import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Samuel Boada
 * @author Marcos De Andrade
 * @author Alberto Pereira
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /*------------------------------------Audio---------------------------------------*/
    public Clip clip;
    public String ruta = "/Audio/";
    private final AudioClip sonido;

    /*------------------------------------Mensajes------------------------------------*/
    private VentanaAdvertenciaSalir mensajeAdvertencia;
    private VentanaAyuda mensajeAyuda;
    public static VentanaZelzar iniciarZelzar;

    /*------------------------------------Imagenes------------------------------------*/
    //Imagen Opening
    private ImageIcon Opening;
    //Imagen boton Cerrar Blanco
    private ImageIcon CerrarBlanco_0, CerrarBlanco_1;
    //Imagen boton Iniciar
    private ImageIcon Menu1_0, Menu1_1;
    //Imagen boton Visualizar
    private ImageIcon Menu2_0, Menu2_1;
    //Imagen boton Borrar
    private ImageIcon Menu3_0, Menu3_1;
    //Imagen boton IniciarMoneda
    private ImageIcon Moneda_0, Moneda_1;
    //Imagen boton Ayuda
    private ImageIcon Ayuda_0, Ayuda_1;

    /*------------------------------------Metodos------------------------------------*/
    public VentanaPrincipal() throws IOException {
        initComponents();

        mensajeAdvertencia = new VentanaAdvertenciaSalir();
        mensajeAyuda = new VentanaAyuda();

        this.setLocationRelativeTo(null);
        this.setVisible(true);

        //Escalar y Establecer la Imagen de Fondo Principal
        Opening = new ImageIcon("src/Imagenes_Wallpapers/Opening.png");
        this.fondo.setIcon(new ImageIcon(Opening.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH)));
        //Escalar y escoger Boton Cerrar
        CerrarBlanco_0 = new ImageIcon("src/Imagenes_Botones/CerrarBlanco-0.png");
        CerrarBlanco_1 = new ImageIcon("src/Imagenes_Botones/CerrarBlanco-1.png");
        this.cerrar.setIcon(new ImageIcon(CerrarBlanco_0.getImage().getScaledInstance(45, 65, Image.SCALE_SMOOTH)));
        this.cerrar.setRolloverIcon(new ImageIcon(CerrarBlanco_1.getImage().getScaledInstance(50, 70, Image.SCALE_SMOOTH)));

        //Escalar y escoger Boton Ayuda
        Ayuda_0 = new ImageIcon("src/Imagenes_Botones/Ayuda-0.png");
        Ayuda_1 = new ImageIcon("src/Imagenes_Botones/Ayuda-1.png");
        this.ayuda.setIcon(new ImageIcon(Ayuda_0.getImage().getScaledInstance(45, 65, Image.SCALE_SMOOTH)));
        this.ayuda.setRolloverIcon(new ImageIcon(Ayuda_1.getImage().getScaledInstance(50, 70, Image.SCALE_SMOOTH)));

        //Escalar y escoger Boton Iniciar
        Menu1_0 = new ImageIcon("src/Imagenes_Botones/Boton-1-sin-mano.png");
        Menu1_1 = new ImageIcon("src/Imagenes_Botones/Boton-1.png");
        this.iniciar.setIcon(new ImageIcon(Menu1_0.getImage().getScaledInstance(480, 40, Image.SCALE_SMOOTH)));
        this.iniciar.setRolloverIcon(new ImageIcon(Menu1_1.getImage().getScaledInstance(480, 40, Image.SCALE_SMOOTH)));

        //Escalar y escoger Boton IniciarMoneda
        Moneda_0 = new ImageIcon("src/Imagenes_Botones/Moneda-0.png");
        Moneda_1 = new ImageIcon("src/Imagenes_Botones/Moneda-1.png");
        this.moneda.setIcon(new ImageIcon(Moneda_0.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        this.moneda.setRolloverIcon(new ImageIcon(Moneda_1.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH)));

        //Escalar y escoger Boton Visualizar
        Menu2_0 = new ImageIcon("src/Imagenes_Botones/Boton-2-sin-manos.png");
        Menu2_1 = new ImageIcon("src/Imagenes_Botones/Boton-2.png");
        this.visualizar.setIcon(new ImageIcon(Menu2_0.getImage().getScaledInstance(480, 40, Image.SCALE_SMOOTH)));
        this.visualizar.setRolloverIcon(new ImageIcon(Menu2_1.getImage().getScaledInstance(480, 40, Image.SCALE_SMOOTH)));

        //Escalar y escoger Boton Borrar
        Menu3_0 = new ImageIcon("src/Imagenes_Botones/Boton-3-sin-mano.png");
        Menu3_1 = new ImageIcon("src/Imagenes_Botones/Boton-3.png");
        this.borrar.setIcon(new ImageIcon(Menu3_0.getImage().getScaledInstance(480, 40, Image.SCALE_SMOOTH)));
        this.borrar.setRolloverIcon(new ImageIcon(Menu3_1.getImage().getScaledInstance(480, 40, Image.SCALE_SMOOTH)));

        this.repaint();

        // Sonido de Fondo
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Audio/MusicaFondo1.wav"));
        sonido.loop();
    }

    public void Audio(String archivo) {
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(ruta + archivo + ".wav")));
            clip.start();
        } catch (IOException e) {
        } catch (LineUnavailableException e) {
        } catch (UnsupportedAudioFileException e) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lean = new javax.swing.JPanel();
        iniciar = new javax.swing.JButton();
        moneda = new javax.swing.JButton();
        visualizar = new javax.swing.JButton();
        borrar = new javax.swing.JButton();
        ayuda = new javax.swing.JButton();
        cerrar = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        lean.setPreferredSize(new java.awt.Dimension(580, 700));
        lean.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iniciar.setBorder(null);
        iniciar.setBorderPainted(false);
        iniciar.setContentAreaFilled(false);
        iniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        iniciar.setFocusPainted(false);
        iniciar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        iniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                iniciarMouseEntered(evt);
            }
        });
        iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarActionPerformed(evt);
            }
        });
        lean.add(iniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 480, 50));

        moneda.setBorder(null);
        moneda.setBorderPainted(false);
        moneda.setContentAreaFilled(false);
        moneda.setFocusPainted(false);
        moneda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        moneda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                monedaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                monedaMouseEntered(evt);
            }
        });
        moneda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monedaActionPerformed(evt);
            }
        });
        lean.add(moneda, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 460, 130, 130));

        visualizar.setBorder(null);
        visualizar.setBorderPainted(false);
        visualizar.setContentAreaFilled(false);
        visualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        visualizar.setFocusPainted(false);
        visualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        visualizar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                visualizarMouseMoved(evt);
            }
        });
        visualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                visualizarMouseEntered(evt);
            }
        });
        visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizarActionPerformed(evt);
            }
        });
        lean.add(visualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 480, 50));

        borrar.setBorder(null);
        borrar.setBorderPainted(false);
        borrar.setContentAreaFilled(false);
        borrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        borrar.setFocusPainted(false);
        borrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        borrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                borrarMouseEntered(evt);
            }
        });
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });
        lean.add(borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 480, 50));

        ayuda.setBorder(null);
        ayuda.setBorderPainted(false);
        ayuda.setContentAreaFilled(false);
        ayuda.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ayuda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ayuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ayudaMouseEntered(evt);
            }
        });
        ayuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ayudaActionPerformed(evt);
            }
        });
        lean.add(ayuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 610, 60, 80));

        cerrar.setBorder(null);
        cerrar.setBorderPainted(false);
        cerrar.setContentAreaFilled(false);
        cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cerrar.setFocusPainted(false);
        cerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cerrarMouseEntered(evt);
            }
        });
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarActionPerformed(evt);
            }
        });
        lean.add(cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 60, 80));

        fondo.setPreferredSize(new java.awt.Dimension(580, 700));
        lean.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 700));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lean, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lean, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
        this.mensajeAdvertencia.setVisible(true);
        Audio("SonidoBoton1");
    }//GEN-LAST:event_cerrarActionPerformed

    private void iniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarActionPerformed
        try {
            iniciarZelzar = new VentanaZelzar();
        } catch (IOException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.iniciarZelzar.setVisible(true);
    }//GEN-LAST:event_iniciarActionPerformed

    private void visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_visualizarActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        try {
            new VentanaAdvertenciaBaseDatos().setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_borrarActionPerformed

    private void ayudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ayudaActionPerformed
        this.mensajeAyuda.setVisible(true);
        Audio("SonidoBoton1");
    }//GEN-LAST:event_ayudaActionPerformed

    private void monedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monedaActionPerformed
        try {
            iniciarZelzar = new VentanaZelzar();
        } catch (IOException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.iniciarZelzar.setVisible(true);
    }//GEN-LAST:event_monedaActionPerformed

    private void monedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_monedaMouseClicked
        Audio("SonidoMoneda1");
    }//GEN-LAST:event_monedaMouseClicked

    private void visualizarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_visualizarMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_visualizarMouseMoved

    private void visualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_visualizarMouseEntered
        Audio("SonidoBoton1");
    }//GEN-LAST:event_visualizarMouseEntered

    private void iniciarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iniciarMouseEntered
        Audio("SonidoBoton1");
    }//GEN-LAST:event_iniciarMouseEntered

    private void borrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrarMouseEntered
        Audio("SonidoBoton1");
    }//GEN-LAST:event_borrarMouseEntered

    private void monedaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_monedaMouseEntered
        Audio("SonidoBoton1");
    }//GEN-LAST:event_monedaMouseEntered

    private void ayudaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ayudaMouseEntered
        Audio("SonidoBoton1");
    }//GEN-LAST:event_ayudaMouseEntered

    private void cerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseEntered
        Audio("SonidoBoton1");
    }//GEN-LAST:event_cerrarMouseEntered

    public VentanaZelzar getIniciarZelzar() {
        return iniciarZelzar;
    }

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VentanaPrincipal().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ayuda;
    private javax.swing.JButton borrar;
    private javax.swing.JButton cerrar;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton iniciar;
    private javax.swing.JPanel lean;
    private javax.swing.JButton moneda;
    private javax.swing.JButton visualizar;
    // End of variables declaration//GEN-END:variables
}
