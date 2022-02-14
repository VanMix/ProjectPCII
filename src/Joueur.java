import java.util.ArrayList;
import java.util.Random;


public class Joueur {
	ArrayList<Unite> list = new ArrayList<Unite>();
	ArrayList<Batiment> listBat = new ArrayList<Batiment>();
	
	public Joueur() {
		
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
