package business;
import Entite.Fait;
import Entite.Regle;

import java.util.List;

/**
 * Created by Sana on 19/10/2016.
 */
public class Moteur_inference {

    private static List<Regle> BR;
    private  static  List<Fait> BF;

    public Moteur_inference(List<Regle> BR, List<Fait> BF) {
        this.BR = BR;
        this.BF = BF;
    }

    public static List<Regle> getBR() {
        return BR;
    }

    public static void setBR(String nameFile) {
        BR = FileManager.readRegles(nameFile);
    }

    public static List<Fait> getBF() {
        return BF;
    }

    public static void setBF(String name) {
        BF= FileManager.readFaits(name);
    }
}
