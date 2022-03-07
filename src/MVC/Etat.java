package MVC;

import Environnement.Carte;
import Environnement.Ressource;
import Joueurs.AIPlayer;
import Joueurs.Joueur;
import MVC.Affichage;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Etat {
	private Carte carte = new Carte();
	private ArrayList<Joueur> joueurs;
	private int nbJoueurs = 2;
	private Affichage aff;
	private AIPlayer ordi /*= new Joueurs.AIPlayer(this) */;
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
		int nbRessources = rand.nextInt(20) + 10;
		System.out.println(nbRessources);
		while(nbRessources != 0)
		{
			Ressource temp = new Ressource();
			if(!this.listRessource.isEmpty())
			{
				for(Ressource res : this.listRessource)
				{
					if(temp.getPosition().x == res.getPosition().x && temp.getPosition().y == res.getPosition().y)
					{
						break;
					}
				}
				this.listRessource.add(temp);
				nbRessources--;
			}
			else
			{
				this.listRessource.add(temp);
				nbRessources--;
			}
		}
		//System.out.println(this.listRessource.size());
		// ajout de ressource tout les 2 secs
		/*new Thread(() ->
		{
			while(true)
			{
				if(this.listRessource.size() < 30)
				{
					Ressource r = new Ressource();
					this.listRessource.add(r);
				}
				try
				{
					Thread.sleep(3000);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}).start();*/
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
