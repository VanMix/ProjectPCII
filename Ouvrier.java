package Unites;

import java.awt.Color;
import java.awt.Graphics;
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
	
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.CYAN);
        g.fillOval(position.x*10, position.y*10, 15, 15);
}

}