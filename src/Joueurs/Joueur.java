package Joueurs;

import Batiments.Batiment;
import Unites.Ouvrier;
import Unites.Unite;

import java.awt.*;
import java.util.ArrayList;


public class Joueur {
	private ArrayList<Unite> listUnit = new ArrayList<>();
	private ArrayList<Batiment> listBat = new ArrayList<>();
	private int nbBois;
	private int nbNourritures;

	public Joueur() {
		nbBois = 100;
		nbNourritures = 100;
		listUnit.add(new Ouvrier(new Point(14, 0)));
		listUnit.add(new Ouvrier(new Point(0, 14)));
	}
	
	public ArrayList<Unite> getUnites() {
		return listUnit;
	}

	public ArrayList<Batiment> getListBat() {
		return listBat;
	}

	public void addBat(Batiment bat) {
		listBat.add(bat);
	}

	public void addUnite(Unite unit) {
		listUnit.add(unit);
	}

	public int getNbBois() {
		return nbBois;
	}

	public int getNbNourritures() {
		return nbNourritures;
	}

	public void setNbBois(int bois) {
		nbBois += bois;
	}

	public void setNbNourritures(int nourriture) {
		nbNourritures += nourriture;
	}

	public ArrayList<Ouvrier> getOuvrieres(){
		ArrayList<Ouvrier> res = new ArrayList<>();
		for(Unite unit : listUnit)
			if(unit instanceof Ouvrier)
				res.add((Ouvrier) unit);
		return res;
	}
	
}