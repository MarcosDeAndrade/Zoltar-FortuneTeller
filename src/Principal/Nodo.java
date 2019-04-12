/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

/**
 *
 * @author JOSE LARREA
 */
public class Nodo {

    private String Info;
    private Nodo HijoIzq;
    private Nodo HijoDer;
    private int Indice;

    public Nodo(String Info) {
        this.Info = Info;
        this.HijoIzq = null;
        this.HijoDer = null;
        Indice = 0;
    }

    public String getInfo() {
        return Info;
    }

    public Nodo getHijoIzq() {
        return HijoIzq;
    }

    public Nodo getHijoDer() {
        return HijoDer;
    }

    public void setInfo(String Info) {
        this.Info = Info;
    }

    public void setHijoIzq(Nodo HijoIzq) {
        this.HijoIzq = HijoIzq;
    }

    public void setHijoDer(Nodo HijoDer) {
        this.HijoDer = HijoDer;
    }

    public int getIndice() {
        return Indice;
    }

    public void setIndice(int Indice) {
        this.Indice = Indice;
    }

    public boolean tieneHijos() {
        if (HijoIzq != null || HijoDer != null) {
            return true;
        }
        return false;
    }

}
