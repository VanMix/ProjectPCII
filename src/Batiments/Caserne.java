package Batiments;

import Environnement.Carte;
import Joueurs.Joueur;
import Unites.Ouvrier;
import Unites.Unite;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Caserne extends Batiment{
    private final Carte map;
    private final Joueur player;
    private static final int tempo = 1000;
    private Timer time = new Timer();
    private int tempsEcoule = 0;
    private static final int tempsCreaOuvriere = 5;

    public Caserne(Point pos, Carte carte, Joueur plyr) {
        super(pos);
        map = carte;
        player = plyr;
    }

    public void createTroupe(){
        if(player.getNbNourritures() > 5) {
            time.schedule(new TimerTask() {
                @Override
                public void run() {
                    tempsEcoule++;

                }
            }, tempo, 1000);
        }

        if (tempsEcoule == tempsCreaOuvriere){
            player.setNbNourritures(-5);
            Unite nUnit = new Ouvrier();
            player.addUnite(nUnit);
            super.addUnite(nUnit);
            time.cancel();
            tempsEcoule = 0;
        }
    }
}
