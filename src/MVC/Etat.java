package MVC;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import Batiments.Caserne;
import Batiments.Fourmiliere;
import Environnement.Carte;
import Environnement.Ressource;
import Environnement.typeRessource;
import Joueurs.AIPlayer;
import Joueurs.Joueur;
import Unites.Combattante;
import Unites.Unite;

public class Etat {
	private Carte carte = new Carte();
	private ArrayList<Joueur> joueurs;
	private Affichage aff;
	private int nbJoueurs = 2;
	private AIPlayer ordi /*= new Joueurs.AIPlayer(this) */;
	private ArrayList<Ressource> listRessource = new ArrayList<>();
	private Timer timer = new Timer();
	private int tempspassee = 0;
	
	public Point posInitial = null;
	public Point posfinal = null;
	
	public Etat(Affichage a) {
		aff = a;
		joueurs = new ArrayList<Joueur>();
		Joueur j1 = new Joueur();
		joueurs.add(j1);
		initCarte();
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

	public void initRessources() {
		Random rand = new Random();
		int nbRessources = rand.nextInt(40) + 20;
		while(nbRessources != 0) {
			boolean tempB = true;
			Ressource temp = new Ressource();
			if(!this.listRessource.isEmpty()) {
				for(Ressource res : this.listRessource)
				{
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
	}
	
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
	
	public void threadUnit() {
		new Thread(() -> {
			while(true) {
				for(Case[] tabCase : this.aff.getPlateau()) {
					for(Case c : tabCase) {
						if (c.estOccupeUnit()) {
							c.removeUnit();
						}
						if (c.estOccupeeCombattante()) {
							c.removeCombattante();
						}
					}
				}
				for(Joueur j : joueurs) {
					for(Unite u : j.getUnites()) {
						Case c = this.aff.getPlateau()[u.getPos().x][u.getPos().y];
						if (u instanceof Combattante) {
							c.setCombattante((Combattante) u);
						}
						else {
							c.setUnit(u);
						
						    if(c.estOccupeeRessource()) { // Je regarde si la case contient une ressource si c'est le cas alors je l'enleve et augmente le score du joueur
						    	Ressource r = c.removeRessource();
						    	if (r.gettR() == typeRessource.bois) {
						    		System.out.println("nombre de bois : " + j.getNbBois());
						    		}
						    	else {
						    		j.setNbNourritures(1);
						    		System.out.println("nombre de nourriture : " + j.getNbNourritures());
						    		}
						    	} 
					//	this.aff.refreshUnit();
						    }
						}
				}

				try {
					Thread.sleep(1000);
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
	
	public Affichage getAff() {
		return aff;
	}

	/* public void createCaserne(Joueur joueur, Point pos) {
		int tempsConstruc = 10;
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				tempspassee++;

			}
		}, 1000, 1000);
		if (tempspassee == tempsConstruc) {
			joueur.addBat(new Caserne(pos, joueur));
			timer.cancel();
			tempspassee = 0;
		}
	} */
	
	public void unitADeplacer() {
		Case c = this.getAff().getPlateau()[posInitial.x][posInitial.y];
		Unite u = null;
		if(c.estOccupeUnit()) {
			u = c.getUnit();
		}
		else if(c.estOccupeeCombattante())
			u = c.getCombattante();
		System.out.println("pos :"+u.getPos());
		u.setPosFinal(posfinal);
		if(!u.isAlive()) {
			u.start();
		}
		posInitial = posfinal;
	}
	
	
	public void setCombattantePlateau(Combattante c){
		this.joueurs.get(0).addUnite(c);
		this.aff.getPlateau()[c.getPos().x][c.getPos().y].setCombattante(c);
	}
	
	public void setFourmilierePlateau(Fourmiliere f){
		this.joueurs.get(0).addBat(f);
		this.aff.getPlateau()[f.getPosition().x][f.getPosition().y].setFourmiliere(f);
	}
	
	public void setCasernePlateau(Caserne c){
		this.joueurs.get(0).addBat(c);
		this.aff.getPlateau()[c.getPosition().x][c.getPosition().y].setCaserne(c);
	}
	
	

}