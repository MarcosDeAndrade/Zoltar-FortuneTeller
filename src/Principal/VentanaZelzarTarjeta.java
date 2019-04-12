package Principal;

import java.awt.HeadlessException;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Samuel Boada
 * @author Marcos De Andrade
 * @author Alberto Pereira
 */

public class VentanaZelzarTarjeta extends javax.swing.JFrame implements Runnable {

    private Principal hola;
    private Nodo aux, padre, Nuevo;
    private int cont = 0;
    private boolean AttribAgregado = false, fin = false, PreguntaFinal = false;
    private String nuevo, viejo, atributo;
    private static Thread thread;
    private Throwable numInSet, espChar;

    /*------------------------------------Audio------------------------------------*/
    public Clip clip;
    public String ruta = "/Audio/";

    /*------------------------------------Mensajes------------------------------------*/
    private VentanaAdvertenciaSalir mensajeAdvertencia;
    private VentanaAyuda mensajeAyuda;

    /*------------------------------------Imagenes------------------------------------*/
    //Imagen Opening
    private ImageIcon Opening1, Opening2, fin1, molesto;
    //Imagen boton Cerrar Blanco
    private ImageIcon CerrarBlanco_0, CerrarBlanco_1;
    //Imagen boton Ayuda
    private ImageIcon Ayuda_0, Ayuda_1;
    //ImagenBotones "No"
    private ImageIcon No_0, No_1;
    //ImagenBotones "Si"
    private ImageIcon Si_0, Si_1;

    /*------------------------------------Metodos------------------------------------*/
    public VentanaZelzarTarjeta() throws IOException {
        initComponents();
        mensajeAdvertencia = new VentanaAdvertenciaSalir();
        mensajeAyuda = new VentanaAyuda();

        thread = new Thread(this, "Preguntas");

        hola = new Principal();
        aux = hola.getArbolito().getRaiz();

        Pregunta.setText("¿Estás Pensando en un Animal?");
        Pregunta2.setText(" ");

        escribir.setEnabled(false);
        Atributos.setEnabled(false);
        Atributos.setVisible(false);

        numInSet = new Throwable("Numero Insertado");
        espChar = new Throwable("Caracter Especial Insertado");

        this.setLocationRelativeTo(null);

        //Escalar y Establecer la Imagen de Fondo Principal
        fin1 = new ImageIcon("src/Imagenes_Wallpapers/ZelzarFinal.png");
        molesto = new ImageIcon("src/Imagenes_Wallpapers/ZelzarMolesto.png");
        Opening1 = new ImageIcon("src/Imagenes_Wallpapers/ZelzarPregunta-0.png");
        this.fondo.setIcon(new ImageIcon(Opening1.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH)));

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

        //Escalar y escoger la Imagen de Fondo del Boton Cerrar No
        No_0 = new ImageIcon("src/Imagenes_Botones/No-0.png");
        No_1 = new ImageIcon("src/Imagenes_Botones/No-1.png");
        this.No.setIcon(new ImageIcon(No_0.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
        this.No.setRolloverIcon(new ImageIcon(No_1.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH)));

        //Escalar y escoger la Imagen de Fondo del Boton Cerrar Si
        Si_0 = new ImageIcon("src/Imagenes_Botones/Si-0.png");
        Si_1 = new ImageIcon("src/Imagenes_Botones/Si-1.png");
        this.Si.setIcon(new ImageIcon(Si_0.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
        this.Si.setRolloverIcon(new ImageIcon(Si_1.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH)));

        //Escalar y Establecer la Imagen de Fondo Con tarjeta
        Opening2 = new ImageIcon("src/Imagenes_Wallpapers/ZelzarPregunta-1.png");

        this.repaint();
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
        ayuda = new javax.swing.JButton();
        cerrar = new javax.swing.JButton();
        Si = new javax.swing.JButton();
        No = new javax.swing.JButton();
        escribir = new javax.swing.JTextField();
        Panel = new javax.swing.JPanel();
        Pregunta = new javax.swing.JLabel();
        Pregunta2 = new javax.swing.JLabel();
        Atributos = new javax.swing.JTextField();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        lean.setPreferredSize(new java.awt.Dimension(580, 700));
        lean.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ayuda.setBorder(null);
        ayuda.setBorderPainted(false);
        ayuda.setContentAreaFilled(false);
        ayuda.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ayuda.setFocusPainted(false);
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
        lean.add(ayuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 620, 60, 80));

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
        lean.add(cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 60, 80));

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
        lean.add(Si, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 490, 100, 100));

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
        lean.add(No, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 490, 100, 100));

        escribir.setBackground(new java.awt.Color(237, 237, 237));
        escribir.setFont(new java.awt.Font("NSimSun", 0, 18)); // NOI18N
        escribir.setForeground(new java.awt.Color(45, 45, 45));
        escribir.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        escribir.setText("Ingrese Animal");
        escribir.setBorder(null);
        escribir.setCaretColor(new java.awt.Color(110, 110, 110));
        escribir.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                escribirFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                escribirFocusLost(evt);
            }
        });
        escribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escribirActionPerformed(evt);
            }
        });
        lean.add(escribir, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 630, 330, 30));

        Pregunta.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        Pregunta.setForeground(new java.awt.Color(45, 45, 45));
        Pregunta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Pregunta.setAutoscrolls(true);

        Pregunta2.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        Pregunta2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pregunta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Pregunta2, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addComponent(Pregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pregunta2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lean.add(Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 450, 320, 80));

        Atributos.setBackground(new java.awt.Color(237, 237, 237));
        Atributos.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        Atributos.setForeground(new java.awt.Color(45, 45, 45));
        Atributos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Atributos.setText("Ingrese Atributo");
        Atributos.setBorder(null);
        Atributos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtributosActionPerformed(evt);
            }
        });
        lean.add(Atributos, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 630, 350, 30));
        lean.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 700));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lean, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lean, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
        setVisible(false);
        VentanaPrincipal.iniciarZelzar.setVisible(false);
    }//GEN-LAST:event_cerrarActionPerformed

    private void ayudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ayudaActionPerformed
        this.mensajeAyuda.setVisible(true);
    }//GEN-LAST:event_ayudaActionPerformed

    private void SiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiActionPerformed
        this.fondo.setIcon(new ImageIcon(Opening2.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH)));

        if (PreguntaFinal == true) {
            this.fondo.setIcon(new ImageIcon(fin1.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH)));
            this.Si.setEnabled(false);
            this.Si.setVisible(false);
            this.No.setEnabled(false);
            this.No.setVisible(false);
            this.escribir.setEnabled(false);
            this.escribir.setVisible(false);
            this.Atributos.setEnabled(false);
            this.Atributos.setVisible(false);
            this.Pregunta.setVisible(false);
            this.Pregunta2.setVisible(false);
            this.Panel.setVisible(false);
            Audio("Gong");
        }
        if (AttribAgregado) {
            Pregunta2.setText(" ");

            /*  
                para 1 se inserta en el hijo derecho 
                para 0 se inserta en el hijo izquierdo
             */
            hola.getArbolito().Insertar_N(viejo, 1, padre); //  1 = SI
            hola.getArbolito().Insertar_N(nuevo, 0, padre); //  0 = NO

            AttribAgregado = false;
            fin = true;
            hola.Imprimir(hola.getArbolito().getRaiz(), 0);
            hola.getPw().close();
            try {
                hola.getBw().close();
            } catch (IOException ex) {
                Logger.getLogger(VentanaZelzarTarjeta.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                thread.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(VentanaZelzarTarjeta.class.getName()).log(Level.SEVERE, null, ex);
            }
            setVisible(false);
            VentanaPrincipal.iniciarZelzar.setVisible(false);
        } else if (fin == false) {
            if (cont == 0) {
                Pregunta.setText(aux.getInfo() + "?");
            } else {
                if (aux.getHijoDer() != null) {
                    padre = aux;
                    aux = aux.getHijoDer();

                    System.out.println("aux: " + aux.getInfo() + " || padre: " + padre.getInfo());
                    Pregunta.setText(aux.getInfo() + "?");
                } else {
                    Pregunta.setText("Es " + aux.getInfo() + "?");
                    PreguntaFinal = true;
                }

            }
        }

        cont++;

//this.fondo.setIcon(new ImageIcon(Opening1.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH)) );
    }//GEN-LAST:event_SiActionPerformed

    private void NoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoActionPerformed
        this.fondo.setIcon(new ImageIcon(Opening2.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH)));

        if (AttribAgregado) {
            Pregunta2.setText(" ");

            /*
                Para 1 se inserta en la Derecha
                Para 0 se inserta en la Izquierda
             */
            hola.getArbolito().Insertar_N(viejo, 0, padre);
            hola.getArbolito().Insertar_N(nuevo, 1, padre);
            /*
            hola.getArbolito().Insertar_N(viejo, padre.getIndice() * 2, padre);
            hola.getArbolito().Insertar_N(nuevo,
                    (padre.getIndice() * 2) + 1, padre);*/
            AttribAgregado = false;
            fin = true;
            hola.Imprimir(hola.getArbolito().getRaiz(), 0);
            hola.getPw().close();
            try {
                hola.getBw().close();
            } catch (IOException ex) {
                Logger.getLogger(VentanaZelzarTarjeta.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                thread.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(VentanaZelzarTarjeta.class.getName()).log(Level.SEVERE, null, ex);
            }
            setVisible(false);
            VentanaPrincipal.iniciarZelzar.setVisible(false);
        } else if (fin == false) {
            if (cont == 0) {
                this.fondo.setIcon(new ImageIcon(molesto.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH)));
                this.Si.setEnabled(false);
                this.Si.setVisible(false);
                this.No.setEnabled(false);
                this.No.setVisible(false);
                this.escribir.setEnabled(false);
                this.escribir.setVisible(false);
                this.Atributos.setEnabled(false);
                this.Atributos.setVisible(false);
                this.Pregunta.setVisible(false);
                this.Pregunta2.setVisible(false);
                this.Panel.setVisible(false);
                Audio("Gong");
            } else {
                if (aux.getHijoIzq() != null) {
                    padre = aux;
                    aux = aux.getHijoIzq();

                    System.out.println("aux: " + aux.getInfo() + " || padre: " + padre.getInfo());
                    Pregunta.setText(aux.getInfo() + "?");
                } else {
                    Pregunta.setText("¿Qué era?");
                    escribir.setEnabled(true);
                    padre = aux;
                    this.No.setEnabled(false);
                    this.No.setVisible(false);
                    this.Si.setEnabled(false);
                    this.Si.setVisible(false);
                }
            }
        }

        cont++;

//this.fondo.setIcon(new ImageIcon(Opening1.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH)) );
    }//GEN-LAST:event_NoActionPerformed

    private void cerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseEntered
        Audio("SonidoBoton1");
    }//GEN-LAST:event_cerrarMouseEntered

    private void ayudaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ayudaMouseEntered
        Audio("SonidoBoton1");
    }//GEN-LAST:event_ayudaMouseEntered

    private void SiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SiMouseEntered
        Audio("SonidoBoton1");
    }//GEN-LAST:event_SiMouseEntered

    private void NoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NoMouseEntered
        Audio("SonidoBoton1");
    }//GEN-LAST:event_NoMouseEntered

    private void escribirFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_escribirFocusGained
        if (escribir.getText().equals("Escribir aca si es necesario...") == true) {
            escribir.setText("");
        }
    }//GEN-LAST:event_escribirFocusGained

    private void escribirFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_escribirFocusLost
        if (escribir.getText().equals("") == true) {
            escribir.setText("Escribir aca si es necesario...");
        }
    }//GEN-LAST:event_escribirFocusLost

    private void escribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escribirActionPerformed

        viejo = padre.getInfo();
        nuevo = escribir.getText();
        System.out.println("Ingresado: " + nuevo);
        char letra;
        for (int i = 0; i < nuevo.length(); i++) {
            letra = nuevo.charAt(i);
            if (!Character.isLetter(letra) && letra != ' ' && letra != ',') {
                JOptionPane.showMessageDialog(this, numInSet + ": " + letra,
                        "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (letra == ',') {
                JOptionPane.showMessageDialog(this, espChar + ": " + letra,
                        "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        Pregunta.setText("Qué diferencia a " + viejo + " de " + nuevo + "?");

        escribir.setEnabled(false);
        escribir.setVisible(false);
        escribir.setText("Ingrese Animal");

        Atributos.setVisible(true);
        Atributos.setEnabled(true);

    }//GEN-LAST:event_escribirActionPerformed

    private void AtributosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtributosActionPerformed

        atributo = Atributos.getText();
        System.out.println("Ingreso Atributo: " + atributo);
        char letra;
        for (int i = 0; i < atributo.length(); i++) {
            letra = atributo.charAt(i);
            if (!Character.isLetter(letra) && letra != ' ') {
                JOptionPane.showMessageDialog(this, numInSet + ": " + letra,
                        "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        padre.setInfo(atributo);
        AttribAgregado = true;

        Atributos.setEnabled(false);
        Atributos.setVisible(false);
        Atributos.setText("Ingrese Atributo");

        escribir.setVisible(true);

        this.No.setEnabled(true);
        this.No.setVisible(true);
        this.Si.setEnabled(true);
        this.Si.setVisible(true);

        Pregunta.setText("Si la Respuesta para -" + atributo + "- fuera \n"
                + viejo + ",");
        Pregunta2.setText("¿Cuál sería la Respuesta?");
    }//GEN-LAST:event_AtributosActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaZelzarTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaZelzarTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaZelzarTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaZelzarTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        thread.start();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Atributos;
    private javax.swing.JButton No;
    private javax.swing.JPanel Panel;
    private javax.swing.JLabel Pregunta;
    private javax.swing.JLabel Pregunta2;
    private javax.swing.JButton Si;
    private javax.swing.JButton ayuda;
    private javax.swing.JButton cerrar;
    private javax.swing.JTextField escribir;
    private javax.swing.JLabel fondo;
    private javax.swing.JPanel lean;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        try {
            new VentanaZelzarTarjeta().setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(VentanaZelzarTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
