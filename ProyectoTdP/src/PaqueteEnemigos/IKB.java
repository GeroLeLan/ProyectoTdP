package PaqueteEnemigos;

import java.awt.Point;
import javax.swing.ImageIcon;

public class IKB extends Inteligencia {
	public IKB() {
		super();
		icono = new ImageIcon("./bin/ImageIcons/IKB.png");
		puntosKill = 30;
		velocidad = 5;
	}

	public void mover(int dir, Point pos) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean debeMoverse() {
		return false;
	}
}
