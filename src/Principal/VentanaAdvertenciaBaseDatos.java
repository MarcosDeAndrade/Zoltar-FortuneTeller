package Principal;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class VentanaAdvertenciaBaseDatos extends javax.swing.JFrame {

    private Principal hola;

    /*------------------------------------Audio------------------------------------*/
    public Clip clip;
    public String ruta = "/Audio/";
    /*------------------------------------Imagenes------------------------------------*/
    //Imagen VentanaAdvertenciaSalir
    private ImageIcon AdvertenciaBorrar;
    //Imagen Botones "No"
    private ImageIcon No_0, No_1;
    //ImagenBotones "Si"
    private ImageIcon Si_0, Si_1;

    /*-------------------------------------Metodos-------------------------------------*/
    public VentanaAdvertenciaBaseDatos() throws IOException {
        initComponents();

        hola = new Principal();

        setLocationRelativeTo(null);
        //Metodo para poner Trasparente el jFrame y el jLabel(lean)
        setBackground(new Color(0, 0, 0, 0));
        lean.setBackground(new Color(0, 0, 0, 0));

        //Escalar y Establecer la Imagen de Fondo Principal
        AdvertenciaBorrar = new ImageIcon("src/Imagenes_Wallpapers/AdvertenciaBaseDatos.png");
        this.fondo.setIcon(new ImageIcon(AdvertenciaBorrar.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH)));

        //Escalar y escoger la Imagen de Fondo del Boton Cerrar No
        No_0 = new ImageIcon("src/Imagenes_Botones/No-0.png");
        No_1 = new ImageIcon("src/Imagenes_Botones/No-1.png");
        this.No.setIcon(new ImageIcon(No_0.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        this.No.setRolloverIcon(new ImageIcon(No_1.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH)));

        //Escalar y escoger la Imagen de Fondo del Boton Cerrar Si
        Si_0 = new ImageIcon("src/Imagenes_Botones/Si-0.png");
        Si_1 = new ImageIcon("src/Imagenes_Botones/Si-1.png");
        this.Si.setIcon(new ImageIcon(Si_0.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
        this.Si.setRolloverIcon(new ImageIcon(Si_1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

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
        Si = new javax.swing.JButton();
        No = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        lean.setToolTipText("");
        lean.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Si.setBorder(null);
        Si.setBorderPainted(false);
        Si.setContentAreaFilled(false);
        Si.setFocusPainted(false);
        Si.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Si.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SiMouseEntered(evt);
            }
        });
        Si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiActionPerformed(evt);
            }
        });
        lean.add(Si, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 100, 100));

        No.setBorder(null);
        No.setBorderPainted(false);
        No.setContentAreaFilled(false);
        No.setFocusPainted(false);
        No.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        No.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                NoMouseEntered(evt);
            }
        });
        No.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoActionPerformed(evt);
            }
        });
        lean.add(No, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, 110, 110));
        lean.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 395));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lean, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lean, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiActionPerformed
        try {
            hola.EliminarBaseDeDatos();
            hola.getPw().close();
            hola.getBw().close();
        } catch (IOException ex) {
            Logger.getLogger(VentanaAdvertenciaBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        setVisible(false);
    }//GEN-LAST:event_SiActionPerformed

    private void NoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoActionPerformed
        setVisible(false);
    }//GEN-LAST:event_NoActionPerformed

    private void NoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NoMouseEntered
        Audio("SonidoBoton1");
    }//GEN-LAST:event_NoMouseEntered

    private void SiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SiMouseEntered
        Audio("SonidoBoton1");
    }//GEN-LAST:event_SiMouseEntered

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
            java.util.logging.Logger.getLogger(VentanaAdvertenciaBaseDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAdvertenciaBaseDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAdvertenciaBaseDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAdvertenciaBaseDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VentanaAdvertenciaBaseDatos().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaAdvertenciaBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton No;
    private javax.swing.JButton Si;
    private javax.swing.JLabel fondo;
    private javax.swing.JPanel lean;
    // End of variables declaration//GEN-END:variables
}
