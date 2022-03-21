package MVC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controle extends JPanel implements MouseListener {
	private Etat etat;

	public Controle(Etat e, int x, int y) {
		etat = e;
		setPreferredSize(new Dimension(x, y));
		addMouseListener(this);
		//setBackground(Color.WHITE);
	}
	
	
	public Etat getEtat() {
		return etat;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//etat.createCaserne(etat.getJoueurs(), new Point(e.getX(), e.getY()));
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
}
