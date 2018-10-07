package PaqueteEnemigos;

import java.awt.Point;
import java.util.Random;

import javax.swing.ImageIcon;

import PaqueteObjetosImplementados.Personaje;

public class IKA extends Inteligencia {
	private int vecesMovido;
	
	public IKA(Personaje p) {
		super(p);
		icono = new ImageIcon("./bin/ImageIcons/IKA.png");
		puntosKill = 20;
		velocidad = 1;
		vecesMovido = 1;
	}
	
	public void mover(Point pos) {
		Random r = new Random();
		int dir = r.nextInt(90);
		
		for (int i = 0; i < vecesMovido; i++) {
			if (dir < 40) {
				pos.setLocation(pos.x, pos.y + velocidad);
				if (pos.y > Ymax * 0.9)
					pos.y = 0;
			}
			else {
				if (dir < 65) {
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
		}
		if (vecesMovido <= 15)
			vecesMovido++;
	}
	
	public boolean iniciaConMovimiento() {
		return false;
	}
}
