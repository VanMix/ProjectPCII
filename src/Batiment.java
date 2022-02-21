import java.awt.Point;

public abstract class Batiment {
	private Point position;
	private final double TIMER = 0.5; // ms


	public Batiment(Point pos){
		position = pos;
	}


}
