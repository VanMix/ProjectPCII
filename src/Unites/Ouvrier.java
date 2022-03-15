package Unites;

import java.awt.Point;

public class Ouvrier extends Unite {
	private Point position;
    
	public Ouvrier() {
	}
	
	public Ouvrier(Point pos) {
		position = pos;
	}
	
	@Override
	public void seDeplacer(Point d) {
		position = d;
	}

	@Override
	public Point getPos() {
		return position;
	}
	

}
