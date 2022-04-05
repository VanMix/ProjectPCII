package MVC;

import java.awt.Dimension;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import Unites.Ouvrier;
import Unites.Unite;

public class ZoneCliquable extends Controle {

    private boolean occupee = false;

    public ZoneCliquable(Etat e, int x, int y) {
        super(e, x, y);
    }

    // Permet de tester si une case est occupée.
    public boolean estOccupee() { return this.occupee; }

    public void poseElement(){
        this.occupee = true;
    }

    public void enleveElement(){
        this.occupee = false;
    } 

   
    /**
     * Interfaçage entre la bibliothèque standard et les méthodes [clicGauche]
     * et [clicDroit].
     */
 /*   public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) {
            this.clicDroit(e);
        }  else { 
            this.clicGauche(e);
        } 
    }

    
    public Point clicDroit(MouseEvent e) {
   
 /*   	Dimension dim = super.getEtat().getAff().getPlateau()[0][0].getSize();
    	
    	int x = e.getX()/dim.width;
    	int y = e.getY()/dim.height;
    	
    	System.out.println(e.getX() + " " + e.getY());
    	
    	Case c = super.getEtat().getAff().getPlateau()[x][y];
    	if(c.occupeUnite) {
    		Unite u = c.getUnit();
    	    
    		if(u instanceof Ouvrier) {
    			u.setClick();
    		}
    	} */
    	
 //   }
    
  //  public void clicGauche(MouseEvent e) {
    	
  //  } 
}
