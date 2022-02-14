import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class AIPlayer extends Thread{
	ArrayList<Unite> list = new ArrayList<Unite>();
	ArrayList<Batiment> listBat = new ArrayList<Batiment>();
	
 //   private Etat etat;
    private Controle control;
	
	public AIPlayer(Controle c/*Etat e*/) {
	//	etat = e;
		control = c;
		
		Unite unit1 = new Ouvrier(new Point(1,1));
		list.add(unit1);
		
	//	this.start();
	}
	
	@Override
	public void  run() {
		while(true) {
			for(Unite fourmi : list) {
				int random;
				
				Point p = new Point(0,0);
				
				while(!control.getEtat().verifBorne(p)) { // depasse d'une case par rapport à a borne 10, à faire
                    random = (new Random()).nextInt(100);
					if(random < 50) {
						if(random < 25) p = new Point(fourmi.getPos().x - 1, fourmi.getPos().y - 1);
						else  p = new Point(fourmi.getPos().x - 1, fourmi.getPos().y + 1);
					}
					else {
						if(random < 75)  p = new Point(fourmi.getPos().x + 1, fourmi.getPos().y - 1);
						else p = new Point(fourmi.getPos().x + 1, fourmi.getPos().y + 1);
					}
				}
				fourmi.seDeplacer(p); 
				System.out.println(p.x + " " + p.y);
			}
            control.getAff().setAIList(list);
			control.getEtat().move();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public  ArrayList<Unite>getUnit() {
		return list;
	}

}
