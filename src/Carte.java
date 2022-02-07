import java.awt.Point;
import java.util.ArrayList;

public class Carte {
	private ArrayList<Point> grille;
	private ArrayList<ArrayList<Unite>> unites = new ArrayList<ArrayList<Unite>>();
	private Etat etat;
	
	public Carte() {
		grille = new ArrayList<Point>();
		
		for(int i = 1; i <= 10; i++) {
			for(int j = 1; j <= 10; j++) {
				grille.add(new Point(i,j));
			}
		}
	}
	
	public ArrayList<ArrayList<Unite>> getListeUnite()  {
		return unites;
	}
	
	public ArrayList<Point> getGrille() {
		return grille;
	}
    
}