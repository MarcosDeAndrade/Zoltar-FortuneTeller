/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

/**
 *
 * @author Samuel Boada
 * @author Marcos De Andrade
 * @author Alberto Pereira
 */
public class Arbol {

    private Nodo Raiz;
    //Variable global
    private Nodo Busqueda;

    public Arbol() {
        Raiz = null;
    }

    public Nodo getRaiz() {
        System.out.println("Arbol.getRaiz");
        return Raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.Raiz = raiz;
        this.Raiz.setIndice(1);
        System.out.println("Arbol.setRaiz");
    }

    public void Insertar_N(String Dato, int indicador, Nodo padre) {
        Nodo nuevo = new Nodo(Dato);

        if (padre == Raiz) {
            switch (indicador) {
                case 0:
                    nuevo.setIndice(padre.getIndice() * 2);
                    Raiz.setHijoIzq(nuevo);
                    return;
                case 1:
                    nuevo.setIndice(padre.getIndice() * 3);
                    Raiz.setHijoDer(nuevo);
                    return;
            }
        } else {
            if (padre.getIndice() % 2 == 0) {
                switch (indicador) {
                    case 0:
                        nuevo.setIndice(padre.getIndice() * 2);
                        break;
                    case 1:
                        nuevo.setIndice((padre.getIndice() * 2) + 2);
                        break;
                }
            } else {
                switch (indicador) {
                    case 0:
                        nuevo.setIndice((padre.getIndice() * 2) + 1);
                        break;
                    case 1:
                        nuevo.setIndice((padre.getIndice() * 2) + 3);
                }
            }
        }

        Nodo pa;

        if (isVacio()) {
            Raiz = nuevo;
            Raiz.setIndice(1);
            System.out.println("Insertado.Raiz");
        } else {
            pa = recorrer(padre, Raiz);
            if (pa != null) {
                if (indicador == 0) {
                    pa.setHijoIzq(nuevo);

                    System.out.println("Insertado.Hijo_Izquierda: " + Dato
                            + " || Padre: " + pa.getInfo());
                } else {
                    pa.setHijoDer(nuevo);
                    System.out.println("Insertado.Hijo_Derecha: " + Dato
                            + " || Padre: " + pa.getInfo());
                }
            }
        }

    }

    public boolean isVacio() {
        return (Raiz == null);
    }

    public Nodo recorrer(Nodo x, Nodo root) {
        Nodo aux = x;
        if (root != null && x != null) {
            if (isVacio()) {
                return null;
            } else {
                if (root.getInfo().equals(aux.getInfo())) {
                    return root;
                } else {
                    if (aux.getIndice() % 2 == 0) {
                        if (aux.getIndice() % root.getIndice() == 0) {
                            root = root.getHijoIzq();
                            aux = recorrer(x, root);
                        }
                        if (aux == null) {
                            root = root.getHijoDer();
                            aux = recorrer(x, root);
                        }
                    } else {
                        if (aux.getIndice() % 3 == 0) {
                            root = root.getHijoDer();
                            aux = recorrer(x, root);
                        }
                        if (aux == null) {
                            root = root.getHijoDer();
                            aux = recorrer(x, root);
                        }
                    }
                }
            }
        } else {
            aux = Raiz;
        }
        return aux;
    }

}
