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

	@Override
	public void mover(Point pos) {
		CantTurnos--;
		if(CantTurnos==0) {
			
			enemigo.recuperarIntel();
		}
	}

	@Override
	public boolean iniciaConMovimiento() {
		return false;
	}

	@Override
	public Disparo disparar(Point pos) {
		return null;
	}
}
