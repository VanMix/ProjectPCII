package Unites;

import java.awt.Point;

import javax.swing.JComponent;

import MVC.PanneauDeControle;

public abstract class Unite extends JComponent{
	private PanneauDeControle panneau;
	public abstract void seDeplacer(Point d);
	
	public abstract Point getPos();

}