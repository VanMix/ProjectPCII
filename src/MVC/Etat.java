package MVC;

import Batiments.Caserne;
import Environnement.Carte;
import Environnement.Ressource;
import Joueurs.AIPlayer;
import Joueurs.Joueur;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Etat {
	private Carte carte = new Carte();
	private ArrayList<Joueur> joueurs;
	private Affichage aff;
	private int nbJoueurs = 2;
	private AIPlayer ordi /*= new Joueurs.AIPlayer(this) */;
	private ArrayList<Ressource> listRessource = new ArrayList<>();
	private Timer timer = new Timer();
	private int tempspassee = 0;

	public Etat(Affichage a) {
		aff = a;
		joueurs = new ArrayList<Joueur>();
		Joueur j1 = new Joueur();
		joueurs.add(j1);

		//initCarte();
		initRessources();
	}

	public ArrayList<Joueur> getJoueurs() {
		return joueurs;
	}

	public void initCarte() {
		for(Joueur j : joueurs) {
			carte.getListeUnite().add(j.getUnites());
		}
	}

	//public void initPlayer(Joueur player){
	//	joueur = player;
	//}

	public Carte getCarte() {
		return carte;
	}
	
	public boolean verifBorne(Point p) {
	   return p.x <= carte.getLongueur()-1 && p.x > 0 &&
			   p.y <= carte.getLargeur()-1 && p.y > 0;

	}

	/**
	 * Methode pour initialiser les ressources.
	 */
	public void initRessources()
	{
		Random rand = new Random();
		int nbRessources = rand.nextInt(51) + 20;
		System.out.println("Nb ressources qu'on souhaite initialiser : "+nbRessources);
		while(nbRessources != 0)
		{
			boolean tempB = true;
			Ressource temp = new Ressource();
			if(!this.listRessource.isEmpty())
			{
				for(Ressource res : this.listRessource)
				{
					//Verification si il n'y a pas de ressource deja presente dans la case où on souhaite ajouter une ressource.
					if(temp.getPosition().x == res.getPosition().x && temp.getPosition().y == res.getPosition().y)
					{
						tempB = false;
						break;
					}
				}
			}
			if(tempB)
			{
				this.listRessource.add(temp);
				nbRessources--;
			}
		}
		System.out.println("Nb ressources present dans la liste de ressources : "+this.listRessource.size());
	}

	/**
	 * Thread pour ajouter des ressources toutes les 2,5 secondes.
	 */
	public void threadRessource()
	{
		new Thread(() ->
		{
			while(true)
			{
				boolean tempB = true;
				Ressource r = new Ressource();
				if(this.listRessource.size() < 60)
				{
					for (Ressource res : this.listRessource)
					{
						if (r.getPosition().x == res.getPosition().x && r.getPosition().y == res.getPosition().y)
						{
							tempB = false;
							break;
						}
					}
					if(tempB)
					{
						this.listRessource.add(r); // ajoute de la nouvelle ressource a la liste de ressources.
						System.out.println(this.listRessource.size());
						System.out.println("Coordonnee de la ressource ajouter : "+r.getPosition());
						this.aff.getPlateau()[r.getPosition().x][r.getPosition().y].setRessource(r); // ajout de la nouvelles ressource au plateau de jeu.
						this.aff.refreshReesources(); // appel pour actualiser l'affichage graphique.
					}
				}
				try
				{
					Thread.sleep(2500);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	public ArrayList<Ressource> getListRessource()
	{
		return this.listRessource;
	}

	public AIPlayer getAI() {
		return ordi;
	}

	public void createCaserne(Joueur joueur, Point pos){
		int tempsConstruc = 10;
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				tempspassee++;
			}
		}, 1000, 1000);
		if(tempspassee == tempsConstruc)
			joueur.addBat(new Caserne(pos, joueur));
	}

}
