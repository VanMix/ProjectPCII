import Joueurs.AIPlayer;
import Joueurs.Joueur;
import Joueurs.AIPlayer;
import MVC.*;

import javax.swing.JFrame;

public class Main {
	private static int temps = 0;

	public static void main(String[] args) {
       Fenetre fenetre = new Fenetre("Main");

		Affichage affichage = new Affichage(15);
		fenetre.ajouteElement(affichage);
		fenetre.dessineFenetre();
        
	//   ai.start();
	}
}