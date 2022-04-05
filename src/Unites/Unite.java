
package Unites;

import java.awt.Point;

import MVC.PanneauDeControle;

public abstract class Unite extends Thread{
	private PanneauDeControle panneau;
	public abstract void seDeplacer(Point d);
	
	public abstract Point getPos();
	
	public abstract void setPosFinal(Point p);
	
//	public abstract void moveUnit();

}