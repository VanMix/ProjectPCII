import java.util.ArrayList;

public class Etat {
	private Carte carte = new Carte();
	private ArrayList<Joueur> joueurs;
	private int nbJoueurs = 2;
	private Affichage aff;
	
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

}
