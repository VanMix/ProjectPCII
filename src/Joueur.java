import java.util.ArrayList;
import java.util.Random;


public class Joueur extends Thread {
	private ArrayList<Unite> list = new ArrayList<Unite>();
	private ArrayList<Batiment> listBat = new ArrayList<Batiment>();
	private int nbBois = 0;
	private int nbNourritures = 0;

	public Joueur() {
		setListUnite();
	}
	
	public ArrayList<Unite> getListe() {
		return list;
	}
	
	public void setListUnite() {
		Random rand = new Random();
		int r = rand.nextInt(10)+1;
		for(int i = 0; i < r; i++) {
		//	list.add(new Unite());
		}
	}

}
