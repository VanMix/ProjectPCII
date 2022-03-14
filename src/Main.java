import Joueurs.AIPlayer;
import Joueurs.Joueur;
import MVC.*;

import javax.swing.JFrame;

public class Main {
	private static int temps = 0;

	public static void main(String[] args) {
       Fenetre fenetre = new Fenetre("Main");

		//Affichage affichage = new Affichage();
		Etat etat = new Etat();
		Plateau map = new Plateau(10, etat);
		etat.addPlateau(map);
		fenetre.ajouteElement(map);
		fenetre.dessineFenetre();
        
	   //ai.start();
	}
}