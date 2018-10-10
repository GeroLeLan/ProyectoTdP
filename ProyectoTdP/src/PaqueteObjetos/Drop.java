package PaqueteObjetos;

import PaqueteColisionadores.Colisionador;
import PaqueteColisionadores.ColisionadorDrop;
import PaqueteObjetosImplementados.Objeto;

public abstract class Drop extends Intangible {

	protected Drop(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public int serChocado(Colisionador c) {
		return 0;
	}
	
	public int colisionar(Objeto o) {
		return o.serChocado(new ColisionadorDrop(this));
	}

}
