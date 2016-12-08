package Entite;

/**
 * Created by Sana on 08/10/2016.
 */
public class Fait {

    private String nomFait;
    private int numRegleSource;
    private boolean non;

    public Fait(String nomFait, int numRegleSource) {
        this.nomFait = nomFait;
        this.numRegleSource = numRegleSource;
    }

    public Fait() {
    }

    public boolean isNon() {
        return non;
    }

    public void setNon(boolean non) {
        this.non = non;
    }

    public String getNomFait() {
        return nomFait;
    }

    public void setNomFait(String nomFait) {
        this.nomFait = nomFait;
    }

    public int getNumRegleSource() {
        return numRegleSource;
    }

    public void setNumRegleSource(int numRegleSource) {
        this.numRegleSource = numRegleSource;
    }
}
