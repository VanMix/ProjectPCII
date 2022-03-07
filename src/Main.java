import Joueurs.AIPlayer;
import MVC.Affichage;
import MVC.Controle;
import MVC.Etat;

import javax.swing.JFrame;
import java.sql.Array;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
       JFrame fenetre = new JFrame("Main");
       
		Affichage affichage = new Affichage();
		Etat etat = new Etat(affichage);
		Controle control = new Controle(etat, affichage);
		AIPlayer ai = new AIPlayer(control);
		
		fenetre.add(affichage);
		
		fenetre.pack();
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ai.start();
	}
}