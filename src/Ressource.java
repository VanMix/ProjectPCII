import javax.swing.text.Position;
import java.awt.*;
import java.util.Random;

enum typeRessource
{
    bois, nourriture
}

public class Ressource
{
    protected typeRessource tR;
    private Point position = new Point();

    public Ressource()
    {
        initialiseRessources();
    }

    public void initialiseRessources()
    {
        Random rand = new Random();
        int xtmp = rand.nextInt(9) + 1;
        int ytmp = rand.nextInt(9) + 1;
        while ((xtmp == 1 && ytmp == 9) || (xtmp == 9 && ytmp == 1))
        {
            xtmp = rand.nextInt(9) + 1;
            ytmp = rand.nextInt(9) + 1;
        }
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
};



