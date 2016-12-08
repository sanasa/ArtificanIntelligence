package business;
import Entite.Fait;
import Entite.Regle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sana on 17/10/2016.
 */
public class Chainage {

    private List<Fait> BF;
    private List<Regle> BR;

    public Chainage() {
        this.BF= Moteur_inference.getBF();
        this.BR= Moteur_inference.getBR();
    }

    public boolean chainageAvantAvecConflits(Fait but)
    { List<Regle> BRD=new ArrayList<Regle>();

       while(!BR.isEmpty()) {
           if(INBaseFaits(but,BF)){
               return true;
           }
           BRD.clear();
           for (Regle regle : BR) {
               filtrage(regle, BF, BR,BRD);
           }
           if(BRD.isEmpty()) return false;
           Regle regleAdeclencher = choix1erRegle(BRD);
           // Entite.Regle regleAdeclencher = choixPlusDePremisses(BRD);
           BF.addAll(regleAdeclencher.getConclusion());
           BR.remove(regleAdeclencher);
       }
        return false ;
    }

    private Regle choix1erRegle(List<Regle> brd)
    {

        return brd.get(0);


    }

    private void filtrage(Regle regle, List<Fait> bf, List<Regle> br, List<Regle> brd)
    {
        boolean premisseIn=false;

        int i=0;
        while(!premisseIn && i< regle.getPremisse().size())
        {
            if(INBaseFaits(regle.getPremisse().get(i),BF))
            {
                i++;
            }else
            premisseIn=true;


        }
        if(!premisseIn)
            brd.add(regle);

    }

    public boolean INBaseFaits(Fait a,List<Fait> faits)
    {
        for (Fait i:faits) {

            if(a.getNomFait().equals(i.getNomFait()))
                return true;

        }
        return false;
    }

    public boolean chainageArriere(Fait but)
    {
      List<Regle> butRegle=new ArrayList<Regle>();

      if(INBaseFaits(but,BF)){
          return true;
      }

      for (Regle r: BR) {

          if(INBaseFaits(but,r.getConclusion()))
          {
              butRegle.add(r);
          }

      }
      if(butRegle.isEmpty()) return false;

      for (Regle r: butRegle) {
          for (Fait fait:r.getPremisse()) {

              if(!chainageArriere(fait)) { break;  }
              if(INBaseFaits(fait,BF)) {}
              else BF.add(fait);


          }
          return  true;

      }


            return false;


  }
}
