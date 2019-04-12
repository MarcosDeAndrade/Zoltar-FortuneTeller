/*
 ------------------------------------------------------------------------------
 |       Universidad Metropolitana, Caracas Venezuela                         |
 |       Ingenieria en Sistemas                                               |
 |       Estructura de Datos                                                  |
 |       * Profesor:    Christian Guillen                                     |
 |       * Integrantes: Samuel Boada, Marcos De Andrade, Alberto Pereira      |
 |       Proyecto N°2 - Adivinador de Animales                                |
 |       Periodo 1718-3 (junio 2018)                                          |
 ------------------------------------------------------------------------------
 */
package Principal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Principal {

    private Arbol arbolito, ArbolPrueba;
    private Nodo inicio, uno, dos;
    private final VentanaPrincipal ventana;
    private int cont = 0, i = 0;
    private File texto;
    private FileWriter w;
    private BufferedWriter bw;
    private PrintWriter pw;

    public Principal() throws IOException {

        texto = new File("Memoria.txt");

        arbolito = new Arbol();
        ArbolPrueba = new Arbol();
        inicio = new Nodo("Vuela");
        uno = new Nodo("Es Roedor");
        dos = new Nodo("Caza");

        leerTxt();
        ventana = new VentanaPrincipal();
    }

    public static void main(String[] args) throws IOException {
        Principal x = new Principal();
    }

    public Arbol getArbolito() {
        return arbolito;
    }

    public VentanaPrincipal getVentana() {
        return ventana;
    }

    public void Imprimir(Nodo root, int cont) {
        if (cont == 0) {
            try {
                w = new FileWriter(texto);
                bw = new BufferedWriter(w);
                pw = new PrintWriter(bw);
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            cont++;
        }
        pw.println(root.getIndice() + root.getInfo() + ",");
        System.out.println("Imprimir: " + root.getInfo());
        if (root.getHijoDer() != null) {
            Imprimir(root.getHijoDer(), cont);
        }
        if (root.getHijoIzq() != null) {
            Imprimir(root.getHijoIzq(), cont);
        }
    }

    public void leerTxt() {
        System.out.println("leer");
        String texto = "";

        try {
            BufferedReader bf = new BufferedReader(new FileReader(this.texto.getPath()));
            String aux = "";
            String bfRead;
            while ((bfRead = bf.readLine()) != null) {
                aux = aux + bfRead;
                texto = aux;
                System.out.println("Texto: " + texto);
            }
            descifrar(texto, 0, null, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en Archivo", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void descifrar(String texto, int from, Nodo origen, boolean Impar) {
        Nodo nuevo, padre = origen;
        String palabra = "";
        char letra;
        int indice = 0, nextInd = 0, cont = 0;
        boolean recuerdaHijo = false;
        for (i = from; i < texto.length(); i++) {
            letra = texto.charAt(i);
            if (!Character.isLetter(letra) && letra != ' ' && letra != ',') {
                indice = Integer.parseInt("" + letra);
                indice = getIndice(texto, indice, i, false);
            } else if (Character.isLetter(letra) || letra == ' ') {
                palabra = palabra + letra;
                for (int j = i + 1; j < texto.length(); j++) {
                    letra = texto.charAt(j);
                    if (Character.isLetter(letra) || letra == ' ') {
                        palabra = palabra + letra;
                        i = j;
                    } else {
                        j = texto.length();
                        if (i + 2 < texto.length()) {
                            nextInd = getIndice(texto, Integer.parseInt("" + texto.charAt(i + 2)), i + 2, true);
                        } else {
                            nextInd = texto.length() * 2;
                        }

                        System.out.println("Indice: " + indice
                                + " || Palabra: " + palabra);
                        nuevo = new Nodo(palabra);
                        nuevo.setIndice(indice);
                        if (indice == 1) {
                            arbolito.setRaiz(nuevo);
                        } else {
                            if (indice == 2) {
                                arbolito.getRaiz().setHijoIzq(nuevo);
                                cont = indice;
                                Impar = false;
                            } else if (indice == 3) {
                                arbolito.getRaiz().setHijoDer(nuevo);
                                if (nextInd != 2) {
                                    letra = texto.charAt(i + 1);
                                    if (!Character.isLetter(letra)) {
                                        i++;
                                    }
                                    Impar = true;
                                    descifrar(texto, i, nuevo, Impar);
                                }

                            } else if (indice % 2 == 0) {
                                if ((padre.getIndice() * 2) + 2 == indice) {
                                    arbolito.Insertar_N(palabra, 1, padre);
                                    System.out.println(nuevo.getInfo() + " || " + padre.getInfo());

                                    if (nextInd != indice - 2 && nextInd != texto.length() * 2) {
                                        cont++;
                                        recuerdaHijo = true;
                                        i++;
                                        descifrar(texto, i, nuevo, Impar);
                                    }
                                } else {
                                    arbolito.Insertar_N(palabra, 0, padre);
                                    System.out.println(nuevo.getInfo() + " || " + padre.getInfo());
                                    cont++;
                                    if (nextInd != texto.length() * 2) {
                                        cont++;
                                        i++;
                                        descifrar(texto, i, nuevo, Impar);
                                    }
                                }
                            } else {
                                if ((padre.getIndice() * 2) + 3 == indice) {
                                    arbolito.Insertar_N(palabra, 1, padre);
                                    System.out.println(nuevo.getInfo() + " || " + padre.getInfo());

                                    if (nextInd != indice - 2 && nextInd != 2) {
                                        cont++;
                                        recuerdaHijo = true;
                                        i++;
                                        descifrar(texto, i, nuevo, Impar);
                                    }
                                } else {
                                    arbolito.Insertar_N(palabra, 0, padre);
                                    System.out.println(nuevo.getInfo() + " || " + padre.getInfo());
                                    cont++;
                                    if (nextInd != 2 && indice < nextInd) {
                                        cont++;
                                        i++;
                                        descifrar(texto, i, nuevo, Impar);
                                    }
                                }
                            }
                        }

                        if (cont > 0 && recuerdaHijo == false) {
                            padre = nuevo;
                            cont = 0;
                        }

                        if (nextInd == 2 && Impar == true) {
                            return;
                        }
                        if (cont >= 2) {
                            if (Impar == true) {
                                if (nuevo.tieneHijos()) {
                                    if ((padre.getIndice() * 2) + 3 == nuevo.getIndice()) {
                                        padre.setHijoDer(nuevo);
                                    } else {
                                        padre.setHijoIzq(nuevo);
                                    }
                                }
                            } else {
                                if (nuevo.tieneHijos()) {
                                    if ((padre.getIndice() * 2) + 2 == nuevo.getIndice()) {
                                        padre.setHijoDer(nuevo);
                                    } else {
                                        padre.setHijoIzq(nuevo);
                                    }
                                }
                            }
                            if (recuerdaHijo == false) {
                                return;
                            }
                        }

                        palabra = "";

                        indice = 0;
                        recuerdaHijo = false;
                    }
                }
            }

        }
    }

    public int getIndice(String texto, int from, int inicio, boolean next) {
        char letra;

        int indice = from, aux = inicio;

        for (int j = inicio + 1; j < texto.length(); j++) {
            letra = texto.charAt(j);
            if (!Character.isLetter(letra) && letra != ',' && letra != ' ') {
                indice = (indice * 10) + Integer.parseInt("" + letra);
                aux = j;
            } else {
                j = texto.length();
            }

        }
        if (next == false) {
            i = aux;
        }
        return indice;

    }

    public int getNxtIndice(String texto, int from) {
        char letra;
        int indice = from;
        for (int j = i + 3; j < texto.length(); j++) {
            letra = texto.charAt(j);
            if (!Character.isLetter(letra) && letra != ',' && letra != ' ') {
                indice = (indice * 10) + Integer.parseInt("" + letra);
                i = j;
            } else {
                j = texto.length();
            }
        }
        return indice;
    }

    public PrintWriter getPw() {
        return pw;
    }

    public BufferedWriter getBw() {
        return bw;
    }

    public void EliminarBaseDeDatos() {
        try {
            w = new FileWriter(texto);
            bw = new BufferedWriter(w);
            pw = new PrintWriter(bw);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Archivo", "Error", JOptionPane.ERROR_MESSAGE);
        }
        pw.println("1Pajaro,");
        System.out.println("Eliminada con Exito");
    }

}
