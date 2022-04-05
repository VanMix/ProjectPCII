package Batiments;

import Joueurs.Joueur;
import Unites.Ouvrier;
import Unites.Unite;

import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Caserne extends Batiment{
	private Point position;

	public Caserne(Point pos) {
		position = pos;
	}
	
	public Point getPosition() {
		return position;
	}
	

}
