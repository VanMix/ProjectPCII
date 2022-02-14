import java.awt.Point;
import java.util.ArrayList;

public class Etat {
	private Carte carte = new Carte();
	private ArrayList<Joueur> joueurs;
	private int nbJoueurs = 2;
	private Affichage aff;
	private AIPlayer ordi /*= new AIPlayer(this) */;
	
	public Etat(Affichage affichage) {
		aff = affichage;
		
		joueurs = new ArrayList<Joueur>();
		initCarte();
	}
	
	public void initCarte() {
		for(Joueur j : joueurs) {
			carte.getListeUnite().add(j.getListe());
		}
	}
	
	public Carte getCarte() {
		return carte;
	}
	
	public boolean verifBorne(Point p) {
	   return p.x <= carte.getLongueur() && p.x > 0 &&
			   p.y <= carte.getLargeur() && p.y > 0;

	}
	
	public AIPlayer getAI() {
		return ordi;
	}
	
	public void move() {
		aff.repaint();
	}

}
