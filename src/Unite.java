import java.awt.Point;

public abstract class Unite {
	private PanneauDeControle panneau;
	
/*	public Unite() {	
	} */
	
	abstract void seDeplacer(Point d);
	
	abstract Point getPos();

}
