package Batiments;
import Environnement.Carte;
import Joueurs.Joueur;
import Unites.Ouvrier;
import Unites.Reine;
import Unites.Unite;

import java.awt.*;
import java.util.ArrayList;

public class Fourmiliere extends Batiment {
    private final Carte map;
    private final Joueur player;

    private final Reine reine;
    public Fourmiliere(Point pos, Carte nMap, Joueur plyr) {
        super(pos);
        map = nMap;
        player = plyr;
        reine = new Reine(this);
    }

    public void addFourmiAll(Ouvrier fourmi){
        super.addUnite(fourmi);
        player.addUnite(fourmi);
    }

    public void remFourmiBat(Ouvrier fourmi){
        super.remUnite(fourmi);
    }
    public Joueur getPlayer() {
        return player;
    }

    public void createOuvrier(){
        reine.createOuvriere();
    }

    public void deploiementUnite(int nbUnite){
        ArrayList<Unite> unitesDeployes = new ArrayList<>();
        int finParcours = (player.getOuvrieres().size() < nbUnite) ? player.getOuvrieres().size() : player.getOuvrieres().size() - nbUnite;
            for (int i = 0; i < finParcours; i++) {
                unitesDeployes.add(player.getOuvrieres().get(i));
                remFourmiBat(player.getOuvrieres().get(i));
            }
            map.addUnites(unitesDeployes);
    }
}
