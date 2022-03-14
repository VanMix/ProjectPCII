package Unites;

import MVC.PanneauDeControle;

import java.awt.Point;

public abstract class Unite {
	private PanneauDeControle panneau;
	public abstract void seDeplacer(Point d);
	
	public abstract Point getPos();

}
