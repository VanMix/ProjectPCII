import java.awt.Point;

public abstract class Unite {
	private PanneauDeControle panneau;
	Point position;
	
	public Unite() {	
	}
	
	public void seDeplacer(Point d) {
		position = d;
	}

}
