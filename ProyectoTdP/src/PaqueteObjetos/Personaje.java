package PaqueteObjetos;

import PaqueteObjetosImplementados.Animado;

public abstract class Personaje extends Animado {
	protected Personaje(int v, int x, int y) {
		super(v, x, y);
		// TODO Auto-generated constructor stub
	}

	protected Arma arma;
}
