package MVC;

import Environnement.Ressource;
import Unites.Unite;

import java.awt.*;
import java.util.ArrayList;


public class Affichage extends Grille {
	private final int hauteur = 500;
	private final int largeur = 800;
	private Etat etat = new Etat(this);
	private final int decalage = 35;

	// Attributs : taille et tableau de cases
	private Case[][] plateau;

	private ArrayList<Unite> aiList = new ArrayList<>();

	public Affichage(int taille) {
		super(taille, taille);
		this.plateau = new Case[taille][taille];

		for (int x = 0; x < plateau.length; x++) {
			for (int y = 0; y < plateau[x].length; y++) {
				this.plateau[x][y] = new Case(etat);
				ajouteElement(this.plateau[x][y]);
			}
		}
		setAllRessources();
		this.setBackground(Color.orange);
	}

	/**
	 * Methode pour initialise toute les ressources dans chaque case en fonction des coordonnees de chaque ressources.
	 */
	public void setAllRessources() {
		for (Ressource r : this.etat.getListRessource()) {
			System.out.println("x = " + r.getPosition().x + " " + "y = " + r.getPosition().y);
			this.plateau[r.getPosition().x][r.getPosition().y].setRessource(r);
		}
	}

	public Case[][] getPlateau() {
		return plateau;
	}

	public void setCase(Point pos) {
		plateau[pos.x][pos.y] = new Case(etat);
		ajouteElement(plateau[pos.x][pos.y]);
	}
  
  	@Override
	public void paint(Graphics g) {
		for(Unite u : etat.getJoueurs().get(0).getUnites()) {
			if(u instanceof Ouvrier) {
				((Ouvrier) u).paintComponent(g);
			}
		}
	}
}
