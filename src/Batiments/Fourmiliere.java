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

    /**
     * Affecte la fourmi, non seulement à la fourmilière où elle a été crée mais aussi, au joueur à qui elle appartient
     * @param fourmi
     */
    public void addFourmiAll(Ouvrier fourmi){
        super.addUnite(fourmi);
        player.addUnite(fourmi);
    }

    /**
     * Enleve une fourmi de la fourmiliere lorsqu'elle est déployé sur la carte
     * @param fourmi, la fourmi concerné (pour l'instant ne peut être qu'une ouvrière
     */
    public void remFourmiBat(Ouvrier fourmi){
        super.remUnite(fourmi);
    }
    public Joueur getPlayer() {
        return player;
    }

    /**
     * Demande à la reine de générer une nouvelle ouvrière
     */
    public void createOuvrier(){
        reine.createOuvriere();
    }

    /**
     * En fonction du nombre choisis, déploie sur la grille de jeu, les unités qui sont présentes dans la fourmilière
     * @param nbUnite, le nombre d'unités à déployer
     */
    public void deploiementUnite(int nbUnite){
        ArrayList<Unite> unitesDeployes = new ArrayList<>();

        //Condition testant si le nombre choisis par le joueur concerne toutes les unités de la fourmilière ou juste une partie
        int finParcours = (player.getOuvrieres().size() < nbUnite) ? player.getOuvrieres().size() : player.getOuvrieres().size() - nbUnite;
            for (int i = 0; i < finParcours; i++) {
                unitesDeployes.add(player.getOuvrieres().get(i)); // ajoute les fourmis dans la liste des fourmis à déployer
                remFourmiBat(player.getOuvrieres().get(i)); //ENlève les fourmis de la fourmilière pour éviter qu'elles se trouvent à 2 endroits différents
            }
            map.addUnites(unitesDeployes); //les déploient sur la grille de jeu
    }
}
