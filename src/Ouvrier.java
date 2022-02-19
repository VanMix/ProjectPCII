import java.awt.Point;

public class Ouvrier extends Unite{
	private Point position;
    
	public Ouvrier() {
	}
	
	public Ouvrier(Point pos) {
		position = pos;
	}
	
	@Override
	void seDeplacer(Point d) {
		position = d;
	}

	@Override
	Point getPos() {
		return position;
	}
	

}
