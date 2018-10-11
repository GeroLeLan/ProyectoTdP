package PaqueteEnemigos;

import java.awt.Point;
import javax.swing.ImageIcon;

import PaqueteObjetos.Disparo;
import PaqueteObjetosImplementados.Personaje;

public class IKB extends Inteligencia {
	public IKB(Personaje p) {
		super(p);
		icono = new ImageIcon("./bin/ImageIcons/IKB.png");
		puntosKill = 30;
		velocidad = 5;
	}

	public void mover(Point pos) {
		if (personajeJuego.getPos().x > pos.x)
			pos.setLocation(pos.x + velocidad, pos.y);
		else {
			if (personajeJuego.getPos().x < pos.x)
				pos.setLocation(pos.x - velocidad, pos.y);
		}
		pos.setLocation(pos.x, pos.y + velocidad);
		if (pos.y > Ymax * 0.9)
			pos.y = 0;
	}
	
	public boolean iniciaConMovimiento() {
		return false;
	}
<<<<<<< HEAD

	@Override
=======
	
>>>>>>> dd3bba543e7ea215949fc855fc96016e284f2929
	public Disparo disparar(Point pos) {
		return null;
	}
}
