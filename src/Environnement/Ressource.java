package Environnement;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Ressource {
    private typeRessource tR;
    private final Point position = new Point();

    public Ressource() {
        initialiseRessources();
    }

    public void initialiseRessources() {
        int xtmp;
        int ytmp;
        Random rand = new Random();
        do {
            xtmp = rand.nextInt(15);
            ytmp = rand.nextInt(15);
        } while ((xtmp > 11 || xtmp < 3) && (ytmp > 11 || ytmp < 3));
        this.position.setLocation(xtmp, ytmp);
        if (rand.nextInt(2) == 0)
            tR = typeRessource.bois;
        else
            tR = typeRessource.nourriture;
    }

    public Point getPosition() {
        return this.position;
    }

    public typeRessource gettR()
    {
        return tR;
    }
}



