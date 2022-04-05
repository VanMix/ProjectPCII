package MVC;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import Batiments.Caserne;
import Batiments.Fourmiliere;
import Environnement.Ressource;
import Environnement.typeRessource;
import Unites.Combattante;
import Unites.Ouvrier;
import Unites.Unite;

public class Case extends ZoneCliquable {
	private  Point posInGrid;
    private Ressource ressource = null;
    private boolean occupeeRessource = false;
    
    private Unite u = null;
    public boolean occupeUnite = false;
    
    private Combattante c = null;
    private boolean occupeCombattante = false;
    
    private Fourmiliere f = null;
    private boolean occupeFourmiliere = false;
    
    private Caserne caserne = null;
    private boolean occupeCaserne = false;

    // Constructeur
    public Case(Etat e, Point p) {
        // Initialisation d'une case cliquable, de dimensions 40*40 pixels.
        super(e,40, 40);
        posInGrid = p;
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        Border blackline = BorderFactory.createLineBorder(Color.gray);
        this.setBorder(blackline);

        //affichage graphique des ressources
        if(this.occupeeRessource) {
        	drawRessource(g);
        }
      //affichage graphique des combattantes
        if(this.occupeCombattante) {
            drawCombattante(g);
        }
        if(this.occupeUnite) {
        	drawUnit(g);
        }
        if(this.estOccupeFourmiliere()) {
        	drawFourmiliere(g);
        }
        if(this.estOccupeCaserne()) {
        	drawCaserne(g);
        }
    }
    
    
    public boolean estOccupeeCombattante() { return this.occupeCombattante; }
    
    
    // Permet de tester si une case est occupée.
    public boolean estOccupeeRessource() { return this.occupeeRessource; }

    /**
     * Methode pour effectuer l'affichage graphique des ressources.
     */
    public void drawRessource(Graphics g) {
        try {
            Image imageMiel = ImageIO.read(new File("C:\\Users\\Thomas\\Desktop\\pcii\\ProjectPCII\\src\\Ressources\\miel.png"));
            Image imageBois = ImageIO.read(new File("C:\\Users\\Thomas\\Desktop\\pcii\\ProjectPCII\\src\\Ressources\\Ressource.png"));

            if (this.ressource.gettR() == typeRessource.bois)
                g.drawImage(imageBois, 0 , 0, 474/11, 288/8, this);
            else
                g.drawImage(imageMiel, 0 , 0, 839/22, 847/22, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void drawCombattante(Graphics g){
        try {
            Image imageCombattante = ImageIO.read(new File("C:\\Users\\Thomas\\Desktop\\pcii\\ProjectPCII\\src\\Ressources\\combattante.jpg"));
            g.drawImage(imageCombattante, 0, 0, 1353/35, 1076/20, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void setCombattante(Combattante c){
        this.c = c;
        this.occupeCombattante = true;
    }

    public void removeCombattante(){
        this.c = null;
        this.occupeCombattante = false;
    }
    
    public Combattante getCombattante(){
        return this.c;
    }

    public void setRessource(Ressource r)
    {
        this.ressource = r;
        this.occupeeRessource = true;
    }
    
    public Ressource removeRessource() {
    	Ressource r = this.ressource;
    	this.ressource = null;
    	this.occupeeRessource = false;
    	
    	return r;
    }
    
    
    public boolean estOccupeUnit() {
    	return this.occupeUnite;
    }
    
    public void setUnit(Unite unit) {
    	u = unit;
    	this.occupeUnite = true;
    }
    
    public void removeUnit() {
    	u = null;
    	this.occupeUnite = false;
    }
    
    public Unite getUnit() {
    	return u;
    }
    
    public Point getPosInGrid() {
    	return posInGrid;
    }
    
    /**
     *
     * @param g
     * 
     * J'affiche l'image de la fourmiliere qui genere les ouvieres
     */
    
    public void drawFourmiliere(Graphics g){
        try {
            Image image = ImageIO.read(new File("C:\\Users\\Thomas\\Desktop\\pcii\\ProjectPCII\\src\\Ressources\\fourmiliere.jpg"));
            g.drawImage(image, 0, 0, 612/10, 467/10, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public boolean estOccupeFourmiliere() {
    	return this.occupeFourmiliere;
    }
    
    public void setFourmiliere(Fourmiliere fo) {
    	this.f = fo;
    	this.occupeFourmiliere = true;
    }
    
    
    /**
    *
    * @param g
    * 
    * J'affiche l'image de la caserne qui genere les combattantes
    */
   
   public void drawCaserne(Graphics g){
       try {
           Image image = ImageIO.read(new File("C:\\Users\\Thomas\\Desktop\\pcii\\ProjectPCII\\src\\Ressources\\caserne.jpg"));
           g.drawImage(image, 0, 0, 800/15, 601/15, this);
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
   
   
   public boolean estOccupeCaserne() {
   	return this.occupeCaserne;
   }
   
   public void setCaserne(Caserne c) {
   	this.caserne = c;
   	this.occupeCaserne = true;
   }
    
    
    
    public void drawUnit(Graphics g) {
    	try {
            Image imageUnit = ImageIO.read(new File("C:\\Users\\Thomas\\Desktop\\pcii\\ProjectPCII\\src\\Ressources\\ouvrier.jpeg"));
            if(u instanceof Ouvrier) {
            	g.drawImage(imageUnit, 0 , 0, 192/5, 165/4, this);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    } 
    

    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) {
        	clicDroit(e);
        }
        else {
        	if(estOccupeFourmiliere()) {
        		super.getEtat().getJoueurs().get(0).addUnite(new Ouvrier(new Point(14, 2)));
        		super.getEtat().getJoueurs().get(0).setNbNourritures(-10);
        	    System.out.println("Vous generez une ouvriere : - 10 de nourriture ! Votre nombre de nourriture : " + super.getEtat().getJoueurs().get(0).getNbNourritures());
        		
        	}
        	else if(estOccupeCaserne()) {
        		super.getEtat().getJoueurs().get(0).addUnite(new Combattante(new Point(0, 12)));
        		super.getEtat().getJoueurs().get(0).setNbBois(-20);
        	    System.out.println("Vous generez une ouvriere : - 20 de bois ! Votre nombre de bois : " + super.getEtat().getJoueurs().get(0).getNbBois());
        	}
        	else {
        		clicGauche(e);
        	}
        }
    }
    
    public void clicDroit(MouseEvent e) {
    	super.getEtat().posInitial = posInGrid;
    	
    }
    
    public void clicGauche(MouseEvent e) {
    	super.getEtat().posfinal = posInGrid;
    	super.getEtat().unitADeplacer();
    }

}