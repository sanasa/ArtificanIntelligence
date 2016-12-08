package client;

import Entite.Fait;
import business.Chainage;
import business.Moteur_inference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Sana on 08/10/2016.
 */
public class App {

    public static void main(String[] m)
    {
        Moteur_inference.setBR("D:\\Etudes GL4\\IA\\TP1\\REGLES.txt");
        Moteur_inference.setBF("D:\\Etudes GL4\\IA\\TP1\\FAITS.txt");

        String butname = readButDuClient();

        Chainage chainage =new Chainage();
       // resultatChainageArriere(butname,chainage);
        resultatChainageAvant(butname,chainage);

}

    private static String readButDuClient() {
        System.out.print("Entrez le but a chercher :");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String butname = null;
        try {
            butname=br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } // le client entre le but a chercher
        return butname;
    }

    private static void resultatChainageAvant(String butname,Chainage chainage)
    {
        Fait but=new Fait(butname,-1);
        if(chainage.chainageAvantAvecConflits(but))
        {
            System.out.print("Le but est atteint par chainage avant.");
        }else System.out.print("Le but n'est pas atteint");
    }

    private static void resultatChainageArriere(String butname,Chainage chainage)
    {
        Fait but=new Fait(butname,-1);
        if(chainage.chainageArriere(but))
        {
            System.out.print("Le but est atteint par chainage arrière.");
        }else System.out.print("Le but n'est pas atteint");
    }
}
