package MVC;

import java.awt.*;

public class Case extends ZoneCliquable {

    private boolean occupee = false;
    // Constructeur
    public Case(Affichage plateau, Etat e) {
        // Initialisation d'une case cliquable, de dimensions 40*40 pixels.
        super(e,40, 40);
    }

    // Permet de tester si une case est occupée.
    public boolean estOccupee() { return this.occupee; }

    public void poseReine(){
        this.occupee = true;
    }

    public void enleveReine(){
        this.occupee = false;
    }
}
