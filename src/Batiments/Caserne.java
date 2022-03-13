package Batiments;

import Joueurs.Joueur;
import Unites.Ouvrier;
import Unites.Unite;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Caserne extends Batiment{
    private final Joueur player;
    private static final int tempo = 1000;
    private final Timer time = new Timer();
    private int tempsEcoule = 0;
    private static final int tempsCreaOuvriere = 5;

    public Caserne(Point pos, Joueur plyr) {
        super(pos);
        player = plyr;
    }

    /**
     * Génére une unité de fourmi
     */
    public void createTroupe(){
        if(player.getNbNourritures() > 5) { //Si le joueur à suffisamment de ressources, déclenche un chrono pour créer la fourmi
            player.setNbNourritures(-5); //Enlève le nombre de ressources correspondant au prix de la fourmi
            time.schedule(new TimerTask() {
                @Override
                public void run() {
                    tempsEcoule++;

                }
            }, tempo, 1000);
        }

        if (tempsEcoule == tempsCreaOuvriere){ //une fois que le chrono atteint le temps de création d'une fourmi
            Unite nUnit = new Ouvrier(); //NOus créons l'unité et nous affectons cette même unité aux unités du joueur, ainsi qu'au bâtiment où elle a été crée
            player.addUnite(nUnit);
            super.addUnite(nUnit);
            time.cancel(); //on arrête le chrono
            tempsEcoule = 0; // on remet le compteur à 0
        }
    }
}
