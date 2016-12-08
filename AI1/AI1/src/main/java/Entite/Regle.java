package Entite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sana on 08/10/2016.
 */
public class Regle {

    private int numRegle;
    private List<Fait> premisse;
    private List<Fait> conclusion;

    public Regle(int numRegle, List<Fait> premisse, List<Fait> conclusion) {
        this.numRegle = numRegle;
        this.premisse = premisse;
        this.conclusion = conclusion;
    }

    public Regle() {
        premisse=new ArrayList<Fait>();
        conclusion= new ArrayList<Fait>();
    }

    public int getNumRegle() {
        return numRegle;
    }

    public void setNumRegle(int numRegle) {
        this.numRegle = numRegle;
    }

    public List<Fait> getPremisse() {
        return premisse;
    }

    public void setPremisse(Fait fait) {
        premisse.add(fait);
    }

    public List<Fait> getConclusion() {
        return conclusion;
    }

    public void setConclusion(Fait conclusion) {
       this.conclusion.add(conclusion);
    }
}
