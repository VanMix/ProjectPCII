package MVC;

import Environnement.Ressource;
import Environnement.typeRessource;
import Unites.Unite;

import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Affichage extends Grille{
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

		for(int x = 0; x < plateau.length; x++){
			for(int y = 0; y < plateau[x].length; y++){
				this.plateau[x][y] = new Case(this, etat);
				ajouteElement(this.plateau[x][y]);
			}
		}
	}

/*
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		//Utilisation de la classe Graphics2D afin d'effectuer une rotation de la map lors de l'affichage
		Graphics2D graphs = (Graphics2D) g;
		graphs.rotate(-Math.PI / 4);
		graphs.translate(-175, 150);


		//MVC.Affichage des ressources
		dessineRessource(g);

		/*for(int i = 1; i <= (l.size())/10; i++) {
			Point rot1 = l.get(0);
			Point rot2 = l.get(l.size()-1);
			int [] p1 = rotation(rot1);
			int [] p2 = rotation(rot2);
			g.drawLine(i*decalage, p1[1] * decalage, i*decalage, p2[1] * decalage);
			g.drawLine(p1[0]*decalage, i*decalage, p2[0]*decalage,  i * decalage);
		}*/
	/*
		this.setBackground(new Color(235, 178, 102));
		for (ArrayList<Point> ligne : etat.getCarte().getGrille()) {
			for (int i = 1; i <= ligne.size(); i++) {
				Point rot1 = ligne.get(0);
				Point rot2 = ligne.get(ligne.size() - 1);

				g.drawLine(rot1.x * decalage, i * decalage, rot2.x, i * decalage);
				g.drawLine(i * decalage, rot1.y * decalage, i * decalage, rot2.y * decalage);
			}

			//	ArrayList<Unites.Unite> aiList = etat.getAI().getUnit();
			g.setColor(Color.RED);

			for (Unite u : aiList) {
				Point p = u.getPos();
				g.drawOval(p.x * decalage + 7, p.y * decalage + 7, 20, 20);
			}

		}
	}
		public void dessineRessource (Graphics g)
		{
			System.out.print(this.etat.getRessource().size());
			for (Ressource r : this.etat.getRessource()) {
				//System.out.println(r.getPosition().x +" "+ r.getPosition().y);
				if (r.gettR() == typeRessource.bois) {
					g.setColor(Color.BLUE);
				} else {
					g.setColor(Color.CYAN);
				}
				g.drawOval(r.getPosition().x * this.decalage + 15, r.getPosition().y * this.decalage + 15, 5, 5);
				g.fillOval(r.getPosition().x * this.decalage + 15, r.getPosition().y * this.decalage + 15, 5, 5);
			}
		}

	public int getDecal() {
		return decalage;
	}
	
	public void setAIList(ArrayList<Unite> l) {
		aiList = l;
	}*/
/*
	public void drawCaserne(Graphics g) throws IOException {
		JFrame f = new JFrame("");
		this.setBounds(50, 50, 50, 50);
		BufferedImage img = ImageIO.read(new File("Caserne.jpg"));
		JLabel pic = new JLabel(new ImageIcon(img));
		this.add(pic);
		f.setSize(50, 50);
		f.setLayout(null);
		f.setVisible(true);
	}*/
}
