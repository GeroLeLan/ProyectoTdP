package PaqueteObjetos;

import PaqueteObjetosImplementados.Animado;

public abstract class Personaje extends Animado {
	protected Arma arma;
	
	protected Personaje(int v, int x, int y) {
		super(v, x, y);
		// TODO Auto-generated constructor stub
	}

	public int getVel() {
		return velocidad;
	}
}
