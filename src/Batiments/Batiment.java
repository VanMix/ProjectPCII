package Batiments;

import Unites.Unite;

import java.awt.Point;
import java.util.ArrayList;

public abstract class Batiment {
	private final Point position;
	private final double TIMER = 0.5; // ms
	private ArrayList<Unite> troupes = new ArrayList<>();

	public Batiment(Point pos){
		position = pos;
	}

	public void addUnite(Unite unit){
		troupes.add(unit);
	}

	public void remUnite(Unite unit){
		troupes.remove(unit);
	}

	public ArrayList<Unite> getTroupes() {
		return troupes;
	}
}
