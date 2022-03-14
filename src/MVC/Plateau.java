package MVC;

public class Plateau extends Grille{
    // Attributs : taille et tableau de cases
    private final int taille;
    private Case[][] plateau;

    // Constructeur
    public Plateau(int taille, Etat e) {
        // Initialisation de la grille graphique de dimensions taille*taille
        super(taille, taille);
        this.taille = taille;

        this.plateau = new Case[taille][taille];

        for(int x = 0; x < plateau.length; x++){
            for(int y = 0; y < plateau[x].length; y++){
                this.plateau[x][y] = new Case(this, e);
                ajouteElement(this.plateau[x][y]);
            }
        }

    }
}
