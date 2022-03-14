package Unites;

import Batiments.Fourmiliere;
import java.util.Timer;
import java.util.TimerTask;

public class Reine{
    //Une Reine doit être lié à une fourmilière (qui elle même sera relié à un joueur)
    private final Fourmiliere camp;

    //Les attributs suivants seront utilisés afin de pouvoir utiliser un timer de génération pour notre unité
    private static final int tempo = 1000; //en ms
    private final Timer time = new Timer();
    private int tempsEcoule = 0;

    public Reine(Fourmiliere maison){
        camp = maison;
    }

    public void createOuvriere(){
        if(camp.getPlayer().getNbNourritures() > 5) {
            time.schedule(new TimerTask() {
                @Override
                public void run() {
                    tempsEcoule++; //en fonction du tempo, le compteur du chrono augmentera

                }
            }, tempo, 1000); //Lorsque cette ligne est éxécuté, le chrono se lancera automatiquement
        }

        //temps nécessaire pour créer une ouvrière
        int tempsCreaOuvriere = 5;
        if (tempsEcoule == tempsCreaOuvriere){
            camp.getPlayer().setNbNourritures(-5); //enlève le nombre de ressources pour créer notre ouvrière
            camp.addFourmiAll(new Ouvrier()); //crée l'ouvrière et l'affecte à la forumilière du joueur
            time.cancel(); //stop le timer
            tempsEcoule = 0; // remet le compteur à 0
        }
    }
}
