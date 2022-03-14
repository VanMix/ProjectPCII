package Environnement;

import Unites.Unite;

import java.awt.Point;
import java.util.ArrayList;

public class Carte {
	private final ArrayList<ArrayList<Point>> grille = new ArrayList<>();
	private ArrayList<ArrayList<Unite>> unites = new ArrayList<>();
	private final int LONGUEUR = 10;
	private final int LARGEUR = 10;
	
	public Carte() {
		for(int i = 1; i <= LONGUEUR; i++) {
			ArrayList<Point> ligne = new ArrayList<>();
			for(int j = 1; j <= LARGEUR; j++) {
				ligne.add(new Point(i,j));
			}
			grille.add(ligne);
		}
	}
	
	public ArrayList<ArrayList<Unite>> getListeUnite()  {
		return unites;
	}
	
	public ArrayList<ArrayList<Point>> getGrille() {
		return grille;
	}
	
	public int getLongueur() {
		return LONGUEUR;
	}
	
	public int getLargeur() {
		return LARGEUR;
	}

	public ArrayList<ArrayList<Unite>> getUnites() {
		return unites;
	}

	public void addUnites(ArrayList<Unite>listeTroupes){
			unites.add(listeTroupes);
	}
}
