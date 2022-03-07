package Unites;

import Batiments.Fourmiliere;
import java.util.Timer;
import java.util.TimerTask;

public class Reine{
    private final Fourmiliere camp;
    private static final int tempo = 1;
    private Timer time = new Timer();
    private int tempsEcoule = 0;
    private static final int tempsCreaOuvriere = 5;

    public Reine(Fourmiliere maison){
        camp = maison;
    }

    public void createOuvriere(){
        if(camp.getPlayer().getNbNourritures() > 5) {
            time.schedule(new TimerTask() {
                @Override
                public void run() {
                    tempsEcoule++;

                }
            }, tempo, 1000);
        }

        if (tempsEcoule == tempsCreaOuvriere){
            camp.getPlayer().setNbNourritures(-5);
            camp.addFourmiAll(new Ouvrier());
            time.cancel();
            tempsEcoule = 0;
        }
    }


}
