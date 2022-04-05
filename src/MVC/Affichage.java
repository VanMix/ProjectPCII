package MVC;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import Batiments.Caserne;
import Batiments.Fourmiliere;
import Environnement.Ressource;
import Unites.Combattante;
import Unites.Unite;


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
				this.plateau[x][y] = new Case(etat, new Point(x, y));
				ajouteElement(this.plateau[x][y]);
			}
		}
		this.setAllRessources();
	    setAllUnit();
		this.setBackground(Color.orange);
		this.etat.threadUnit();
		this.etat.threadRessource();
		this.etat.setCombattantePlateau(new Combattante(new Point(13, 1)));
		this.etat.setFourmilierePlateau(new Fourmiliere(new Point(14, 1)));
		this.etat.setCasernePlateau(new Caserne(new Point(0, 13)));
	}

	/**
	 * Methode pour initialise toute les ressources dans chaque case en fonction des coordonnees de chaque ressources.
	 */
	public void setAllRessources() {
		for (Ressource r : this.etat.getListRessource()) {
			this.plateau[r.getPosition().x][r.getPosition().y].setRessource(r);
		}
	}
	
	

	/**
	 * Methode pour actualiser l'affichage graphique.
	 */
	public void refreshReesources()
	{
		for(Case[] tabCase : this.plateau)
		{
			for(Case c : tabCase)
			{
				// repaint seulement les cases ou il y'a une ressource.
				if(c.estOccupeeRessource())
					c.repaint();
			}
		}
	}
	
	public void setAllUnit() {
		for(Unite u : etat.getJoueurs().get(0).getUnites()) {
			this.plateau[u.getPos().x][u.getPos().y].setUnit(u);
			
		}
	}
	
	public void refreshUnit() {
		for(Case[] tabCase : this.plateau) {
			for(Case c : tabCase) {
				if(c.estOccupeUnit()) {
					c.repaint();
				}
			}
		}
	}

	public Case[][] getPlateau() {
		return plateau;
	}

/*	public void setCase(Point pos) {
		plateau[pos.x][pos.y] = new Case(etat);
		ajouteElement(plateau[pos.x][pos.y]);
	} */
  
 /* 	@Override
	public void paint(Graphics g) {
		for(Unite u : etat.getJoueurs().get(0).getUnites()) {
			if(u instanceof Ouvrier) {
				((Ouvrier) u).paintComponent(g);
			}
		}
	} */
}