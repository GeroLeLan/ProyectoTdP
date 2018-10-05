package PaqueteEnemigos;

import java.awt.Point;
import javax.swing.ImageIcon;

import PaqueteObjetos.Personaje;

public class IKB extends Inteligencia {
	public IKB(Personaje p) {
		super(p);
		icono = new ImageIcon("./bin/ImageIcons/IKB.png");
		puntosKill = 30;
		velocidad = 4;
	}

	public void mover(Point pos) {
		if (personajeJuego.getPos().x > pos.x)
			pos.setLocation(pos.x + velocidad, pos.y);
		else {
			if (personajeJuego.getPos().x < pos.x)
				pos.setLocation(pos.x - velocidad, pos.y);
		}
		pos.setLocation(pos.x, pos.y + velocidad);
	}
	
	public boolean iniciaConMovimiento() {
		return false;
	}
}
