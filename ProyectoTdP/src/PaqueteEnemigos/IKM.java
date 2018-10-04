package PaqueteEnemigos;

import java.awt.Point;
import javax.swing.ImageIcon;

public class IKM extends Inteligencia {
	public IKM() {
		super();
		icono = new ImageIcon("./bin/ImageIcons/IKM.png");
		puntosKill = 25;
		velocidad = 3;
	}
	
	public void mover(int dir, Point pos) {
		
	}

	@Override
	public boolean debeMoverse() {
		return false;
	}
}
