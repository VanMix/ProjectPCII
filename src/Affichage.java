import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
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
		
		ArrayList<Point> l = etat.getCarte().getGrille();
		for(int i = 1; i <= (l.size())/10; i++) {
			Point p1 = l.get(0);
			Point p2 = l.get(l.size()-1);
			g.drawLine(i*decalage, p1.y * decalage, i*decalage, p2.y * decalage);
			g.drawLine(p1.x*decalage, i*decalage, p2.x*decalage,  i * decalage);
		}
		
	//	ArrayList<Unite> aiList = etat.getAI().getUnit();
		g.setColor(Color.RED);
		
		for(Unite u : aiList) {
			Point p = u.getPos();
			g.drawOval(p.x *decalage + 10, p.y * decalage + 10, 20, 20);
		}

	} 
	
	public int getDecal() {
		return decalage;
	}
	
	public void setAIList(ArrayList<Unite> l) {
		aiList = l;
	}

}
