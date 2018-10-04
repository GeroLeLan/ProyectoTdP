package PaqueteEnemigos;

import java.awt.Point;
import javax.swing.ImageIcon;

public class ITieneArma extends Inteligencia {
	public ITieneArma() {
		super();
		icono = new ImageIcon("./bin/ImageIcons/ITieneArma.png");
		puntosKill = 15;
		velocidad = 3;
	}
	
	public void mover(int dir, Point pos) {
		if (dir > 45) {
			pos.setLocation(pos.x - velocidad, pos.y);
			if (pos.x < 0)
				pos.x = (int) (Xmax * 0.6);
		}
		else {
			pos.setLocation(pos.x + velocidad, pos.y);
			if (pos.x > Xmax * 0.585)
				pos.x = (int) (Xmax * 0.01);
		}
	}
	
	public boolean debeMoverse() {
		return true;
	}
}
