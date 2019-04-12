package Principal;

import java.awt.Image;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

/**
 *
 * @author Samuel Boada
 * @author Marcos De Andrade
 * @author Alberto Pereira
 */
public class VentanaAyuda extends javax.swing.JFrame {

    /*------------------------------------Audio------------------------------------*/
    public Clip clip;
    public String ruta = "/Audio/";
    /*------------------------------------Imagenes------------------------------------*/
    //Imagen Opening
    private ImageIcon Ayuda;
    //Imagen boton Cerrar Blanco
    private ImageIcon CerrarNegro_0, CerrarNegro_1;

    /*------------------------------------Metodos------------------------------------*/
    public VentanaAyuda() {
        initComponents();

        setLocationRelativeTo(null);

        //Escalar y Establecer la Imagen de Fondo Principal
        Ayuda = new ImageIcon("src/Imagenes_Wallpapers/Instrucciones.png");
        this.fondo.setIcon(new ImageIcon(Ayuda.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH)));

        //Escalar y escoger Boton Ayuda
        CerrarNegro_0 = new ImageIcon("src/Imagenes_Botones/CerrarNegro-0.png");
        CerrarNegro_1 = new ImageIcon("src/Imagenes_Botones/CerrarNegro-1.png");
        this.cerrar.setIcon(new ImageIcon(CerrarNegro_0.getImage().getScaledInstance(55, 75, Image.SCALE_SMOOTH)));
        this.cerrar.setRolloverIcon(new ImageIcon(CerrarNegro_1.getImage().getScaledInstance(60, 80, Image.SCALE_SMOOTH)));
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lean = new javax.swing.JPanel();
        cerrar = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        lean.setPreferredSize(new java.awt.Dimension(580, 700));
        lean.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        fondo.setPreferredSize(new java.awt.Dimension(5800, 700));
        lean.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lean, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lean, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_cerrarActionPerformed

    private void cerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseEntered
        Audio("SonidoBoton1");
    }//GEN-LAST:event_cerrarMouseEntered

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
            java.util.logging.Logger.getLogger(VentanaAyuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAyuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAyuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAyuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAyuda().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cerrar;
    private javax.swing.JLabel fondo;
    private javax.swing.JPanel lean;
    // End of variables declaration//GEN-END:variables
}
