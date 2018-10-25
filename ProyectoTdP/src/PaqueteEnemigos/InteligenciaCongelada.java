package PaqueteEnemigos;

import java.awt.Point;

import PaqueteDisparos.Disparo;
import PaquetePersonajes.Personaje;



public class InteligenciaCongelada extends Inteligencia {
	int CantTurnos;
	Enemigo enemigo;
	protected InteligenciaCongelada(Personaje p,Enemigo e) {
		super(p);
		enemigo=e;
		CantTurnos=30;
	}

	public void mover(Point pos) {
		CantTurnos--;
		if(CantTurnos==0) {
			enemigo.recuperarIntel();
		}
	}

	public boolean iniciaConMovimiento() {
		return false;
	}

	public Disparo disparar(Point pos) {
		return null;
	}
}
