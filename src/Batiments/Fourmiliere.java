package Batiments;
import java.awt.Point;
import java.util.ArrayList;

import Unites.Ouvrier;
import Unites.Unite;

public class Fourmiliere extends Batiment {
	private Point position;

	public Fourmiliere(Point pos) {
		position = pos;
	}
	
	public void addOuvrier(ArrayList<Unite> l) { // J'utilise pas vraiment en faite
		Ouvrier o = new Ouvrier(new Point(14, 2));
		l.add(o);
	}
	
	public Point getPosition() {
		return position;
	}
	
}
