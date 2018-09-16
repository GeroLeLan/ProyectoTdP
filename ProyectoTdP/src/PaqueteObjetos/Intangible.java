package PaqueteObjetos;

import PaqueteObjetosImplementados.Objeto;

public abstract class Intangible extends Objeto{
	protected Intangible(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public void colisionar() {
		//aca hay que hacer que los intangibles ignoresn los disparos y esas cosas
	}
}
