package MVC;

import Environnement.Ressource;
import Environnement.typeRessource;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
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
    // Permet de tester si une case est occupée.
    public boolean estOccupee() { return this.occupeeRessource; }

    /**
     * Methode pour effectuer l'affichage graphique des ressources.
     */
    public void drawRessource(Graphics g)
    {
        //this.repaint();
        //this.setBackground(Color.lightGray);
        JLabel labelM = null;
        try {
            Image imageMiel = ImageIO.read(new File("Ressources/miel.jpg"));
            Image imageBois = ImageIO.read(new File("Ressources/Ressource.png"));

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
}
