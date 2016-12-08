package business;
import Entite.Fait;
import Entite.Regle;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * Created by Sana on 08/10/2016.
 */

public  class FileManager {
    private static Logger log = Logger.getLogger(FileManager.class.getName());
 /*
 lit un fichier texte representant la base des regles
 et les separent dans une liste d'objetcs representant
 chacun une regle.
 */
    public static List<Regle> readRegles(String nomFichier)
    {
       List<Regle> regles=new ArrayList<Regle>();

        try{
            BufferedReader in = new BufferedReader(new FileReader(nomFichier));
            String s;
            Fait fait;
            Regle regle;
            while((s = in.readLine()) != null && !(s.isEmpty())){

                String[] X = s.split(":");
                regle=new Regle();
                try {

                    regle.setNumRegle(Integer.parseInt(X[1]));
                }catch (Exception e){
                    e.printStackTrace();
                }





                String[] Y=X[2].split(" ");

                for(int i=0;i<Y.length;i++)
                {   fait=new Fait();

                    if(Y[i].equals("NON"))
                    {
                        fait.setNon(true);
                        i++;
                    }
                    else
                    {
                        fait.setNon(false);

                    }

                    fait.setNomFait(Y[i]);
                    fait.setNumRegleSource(Integer.parseInt(X[1]));
                    regle.setPremisse(fait);


                }

                String[] Z=X[3].split(" ");
                for(int i=0;i<Z.length;i++)
                {    fait=new Fait();

                    if(Z[i].equals("NON"))
                    {
                        fait.setNon(true);
                        i++;
                    }
                    else
                    {
                        fait.setNon(false);

                    }

                    fait.setNomFait(Z[i]);
                    fait.setNumRegleSource(Integer.parseInt(X[1]));
                    regle.setConclusion(fait);


                }

                regles.add(regle);

              log.info("Ajout de la régle numéro "+regle.getNumRegle()+" Premisses : ");
                for (Fait f: regle.getPremisse()                     ) {
                    log.info(f.getNomFait());
                }
                log.info("Conclusion :");
                for (Fait f:regle.getConclusion()
                     ) {
                    log.info(f.getNomFait());

                }

            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return regles;


    }

    /*
 lit un fichier texte representant la base des faits
 et les separent dans une liste d'objetcs representant
 chacun un fait.
 */
    public static List<Fait> readFaits(String nomFichier)
    {
        List<Fait> faits=new ArrayList<Fait>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(nomFichier));
            String s;
            Fait fait;

            while ((s = in.readLine()) != null) {
                fait=new Fait();
                fait.setNomFait(s);
                fait.setNumRegleSource(-1);
                fait.setNon(false);
                faits.add(fait);

                log.info("Fait ajouté a la BF , Nom : "+fait.getNomFait());
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return faits;
        }
}



