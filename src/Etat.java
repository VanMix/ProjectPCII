import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Etat {
	private Carte carte = new Carte();
	private ArrayList<Joueur> joueurs;
	private int nbJoueurs = 2;
	private Affichage aff;
	private AIPlayer ordi /*= new AIPlayer(this) */;
	private ArrayList<Ressource> listRessource = new ArrayList<Ressource>();

	public Etat(Affichage affichage) {
		aff = affichage;
		
		joueurs = new ArrayList<Joueur>();
		initCarte();
		initRessources();
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
	   return p.x <= carte.getLongueur()-1 && p.x > 0 &&
			   p.y <= carte.getLargeur()-1 && p.y > 0;

	}

	public void initRessources()
	{
		Random rand = new Random();
		int nbRessources = rand.nextInt(10) + 1;
		while(nbRessources != 0)
		{
			Ressource temp = new Ressource();
			this.listRessource.add(temp);
			nbRessources--;
		}
	}
	public ArrayList<Ressource> getRessource()
	{
		return this.listRessource;
	}
	public AIPlayer getAI() {
		return ordi;
	}
	
	public void move() {
		aff.repaint();
	}

}
