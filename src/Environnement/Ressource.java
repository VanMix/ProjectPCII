package Environnement;

import java.awt.*;
import java.util.Random;

public class Ressource
{
    private typeRessource tR;
    private final Point position = new Point();

    public Ressource()
    {
        initialiseRessources();
    }

    public void initialiseRessources()
    {
        int xtmp;
        int ytmp;
        Random rand = new Random();
        do
        {
            xtmp = rand.nextInt(9) + 1;
            ytmp = rand.nextInt(9) + 1;
        } while ((xtmp == 1 && ytmp == 9) || (xtmp == 9 && ytmp == 1));
        this.position.setLocation(xtmp, ytmp);
        if (rand.nextInt(2) == 0)
            tR = typeRessource.bois;
        else
            tR = typeRessource.nourriture;
    }

    public Point getPosition()
    {
        return this.position;
    }

    public typeRessource gettR() {
        return tR;
    }
}



