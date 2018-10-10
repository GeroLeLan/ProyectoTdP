package PaqueteObjetos;

import PaqueteColisionadores.Colisionador;
import PaqueteObjetosImplementados.Obstaculo;

public abstract class Disparo extends Intangible {
	protected boolean borrable;
	protected int daño;
	protected int velocidad;
	
	protected Disparo(int x, int y) {
		super(x, y);
		borrable=false;
	}
	
	public int getDaño() {
		return daño;
	}
	public boolean soyBorrable() {
		return borrable;
	}
	public int dañarObstaculo(Obstaculo obstaculo) {
		return obstaculo.recibirDisparo(this);
	}
	
	public int serChocado(Colisionador c) {
		return 0;
	}

	abstract public void avanzar() ;
}
