package Unites;

import java.awt.Point;

public class Ouvrier extends Unite {
	private Point position;
	private Point posFinal = null;
	
	private int vie = 100;
    
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
	
	
	@Override
	public void run() {
		while(/*posFinal != null */ true) {
	//		if(posFinal != null) {
				if(posFinal.x > position.x && posFinal.y > position.y) {
					position = new Point(position.x + 1, position.y +1);
				}
				else if(posFinal.x > position.x && posFinal.y < position.y) {
					position =  new Point(position.x + 1, position.y - 1);
				}
				else if(posFinal.x < position.x && posFinal.y > position.y) {
					position =  new Point(position.x - 1, position.y  + 1);
				}
				else if(posFinal.x < position.x && posFinal.y < position.y) {
					position =  new Point(position.x - 1, position.y - 1);
				}
				else if(posFinal.x < position.x && posFinal.y == position.y) {
					position =  new Point(position.x - 1, position.y);
				}
				else if(posFinal.x > position.x && posFinal.y == position.y) {
					position =  new Point(position.x + 1, position.y);
				}
				else if(posFinal.x == position.x && posFinal.y > position.y) {
					position =  new Point(position.x, position.y + 1);
				}
				else if(posFinal.x == position.x && posFinal.y < position.y) {
					position =  new Point(position.x, position.y - 1);
				}
				
			/*	if(posFinal.x == position.x && posFinal.y == position.y) {
					posFinal = null;
				} */
	//		}
			try {
				Thread.sleep(2000);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void setPosFinal(Point p) {
		posFinal = p;
	}
	
/*	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.CYAN);
        g.fillOval(position.x*10, position.y*10, 15, 15);
} */

}