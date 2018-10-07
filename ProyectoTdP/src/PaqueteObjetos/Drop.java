package PaqueteObjetos;

import PaqueteColisionadores.Colisionador;

public abstract class Drop extends Intangible {

	protected Drop(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public int serChocado(Colisionador c) {
		return 0;
	}

}
