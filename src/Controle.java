import java.awt.Point;

public class Controle {
	private Etat etat;
	private Affichage aff;
	
	public Controle(Etat e, Affichage a) {
		etat = e;
		aff = a;
	}
	
	public void repaint() {
		etat.move();
	}
	
	
	public Etat getEtat() {
		return etat;
	}
	
	public Affichage getAff() {
		return aff;
	}

}
