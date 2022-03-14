import Joueurs.AIPlayer;
import Joueurs.Joueur;
import MVC.*;

import javax.swing.JFrame;

public class Main {
	private static int temps = 0;

	public static void main(String[] args) {
       Fenetre fenetre = new Fenetre("Main");

		Affichage affichage = new Affichage(10);
		Etat etat = new Etat(affichage);
		fenetre.ajouteElement(affichage);
		fenetre.dessineFenetre();
        
	   //ai.start();
	}
}