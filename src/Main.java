import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
       JFrame fenetre = new JFrame("Main");
		
		Affichage affichage = new Affichage();
		Etat etat = new Etat(affichage);
		
		fenetre.add(affichage);
		
		fenetre.pack();
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // TEST 
	}

}
