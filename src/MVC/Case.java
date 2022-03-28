package MVC;

import javax.swing.*;
import Environnement.Ressource;
import Environnement.typeRessource;

import javax.imageio.ImageIO;
import javax.swing.border.Border;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Case extends ZoneCliquable {
    private Ressource ressource = null;
    private boolean occupeeRessource = false;

    // Constructeur
    public Case(Etat e) {
        // Initialisation d'une case cliquable, de dimensions 40*40 pixels.
        super(e,40, 40);
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        Border blackline = BorderFactory.createLineBorder(Color.gray);
        this.setBorder(blackline);

        //affichage graphique des ressources
        if(this.occupeeRessource)
            drawRessource(g);
    }

    // Permet de tester si une case est occupée par une ressource.
    public boolean estOccupeeRessource() { return this.occupeeRessource; }

    /**
     * Methode pour effectuer l'affichage graphique des ressources.
     */

    public void drawRessource(Graphics g) {
        try {
            Image imageMiel = ImageIO.read(new File("src/Ressources/miel.jpg"));
            Image imageBois = ImageIO.read(new File("src/Ressources/Ressource.png"));

            if (this.ressource.gettR() == typeRessource.bois)
                g.drawImage(imageBois, 0 , 0, 474/11, 288/8, this);
            else
                g.drawImage(imageMiel, 0 , 0, 839/22, 847/22, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setRessource(Ressource r)
    {
        this.ressource = r;
        this.occupeeRessource = true;
    }

    public void removeRessource()
    {
        this.ressource = null;
        this.occupeeRessource = false;
    }
}
