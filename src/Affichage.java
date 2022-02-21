import java.awt.*;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Affichage extends JPanel{
	private final int hauteur = 500;
	private final int largeur = 800;
	private Etat etat = new Etat(this);
	private final int decalage = 35;
	
	private ArrayList<Unite> aiList = new ArrayList<Unite>();

	public Affichage() {
		this.setPreferredSize(new Dimension(largeur, hauteur));
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		//Utilisation de la classe Graphics2D afin d'effectuer une rotation de la map lors de l'affichage
		Graphics2D graphs = (Graphics2D) g;
		graphs.rotate(-Math.PI/4);
		graphs.translate(-175,150);

		/*for(int i = 1; i <= (l.size())/10; i++) {
			Point rot1 = l.get(0);
			Point rot2 = l.get(l.size()-1);
			int [] p1 = rotation(rot1);
			int [] p2 = rotation(rot2);
			g.drawLine(i*decalage, p1[1] * decalage, i*decalage, p2[1] * decalage);
			g.drawLine(p1[0]*decalage, i*decalage, p2[0]*decalage,  i * decalage);
		}*/
		this.setBackground(new Color(235, 178, 102));
		for(ArrayList<Point>ligne : etat.getCarte().getGrille()){
			for(int i = 1; i <= ligne.size(); i++) {
				Point rot1 = ligne.get(0);
				Point rot2 = ligne.get(ligne.size() - 1);

				g.drawLine(rot1.x * decalage, i * decalage, rot2.x , i * decalage);
				g.drawLine(i * decalage, rot1.y * decalage, i * decalage, rot2.y * decalage);
			}

	//	ArrayList<Unite> aiList = etat.getAI().getUnit();
		g.setColor(Color.RED);
		
		for(Unite u : aiList) {
			Point p = u.getPos();
			g.drawOval(p.x *decalage + 7, p.y * decalage + 7, 20, 20);
		}

		//Affichage des ressources
		dessineRessource(g);
	}

	public void dessineRessource(Graphics g)
	{
			for(Ressource r : this.etat.getRessource())
			{
				if(r.tR == typeRessource.bois)
				{
					g.setColor(Color.BLUE);
					g.drawOval(r.getPosition().x*this.decalage + 15, r.getPosition().y*this.decalage + 15, 5, 5);
					g.fillOval(r.getPosition().x*this.decalage + 15, r.getPosition().y*this.decalage + 15, 5, 5);
				}
				else
				{
					g.setColor(Color.CYAN);
					g.drawOval(r.getPosition().x*this.decalage + 15, r.getPosition().y*this.decalage + 15, 5, 5);
					g.fillOval(r.getPosition().x*this.decalage + 15, r.getPosition().y*this.decalage + 15, 5, 5);
				}
			}
	}
	
	public int getDecal() {
		return decalage;
	}
	
	public void setAIList(ArrayList<Unite> l) {
		aiList = l;
	}

}
