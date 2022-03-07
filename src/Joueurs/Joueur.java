package Joueurs;

import Batiments.Batiment;
import Unites.Ouvrier;
import Unites.Unite;

import java.util.ArrayList;


public class Joueur extends Thread {
	private ArrayList<Unite> list = new ArrayList<Unite>();
	private ArrayList<Batiment> listBat = new ArrayList<Batiment>();
	private int nbBois;
	private int nbNourritures;

	public Joueur() {
		nbBois = 100;
		nbNourritures = 100;
	}
	
	public ArrayList<Unite> getListe() {
		return list;
	}
	
	public void addUnite(Unite unit) {
		list.add(unit);
	}

	public int getNbBois() {
		return nbBois;
	}

	public int getNbNourritures() {
		return nbNourritures;
	}

	public void setNbBois(int bois) {
		nbBois = bois;
	}

	public void setNbNourritures(int nourriture) {
		nbNourritures = nourriture;
	}

	public ArrayList<Ouvrier> getOuvrieres(){
		ArrayList<Ouvrier> res = new ArrayList<>();
		for(Unite unit : list)
			if(unit instanceof Ouvrier)
				res.add((Ouvrier) unit);
		return res;
	}
}
