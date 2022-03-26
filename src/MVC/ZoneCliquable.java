package MVC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

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
    public void mouseClicked(MouseEvent e) {
        return;
    }
    // Action à effectuer lors d'un clic droit.
    public void clicDroit() { }

}