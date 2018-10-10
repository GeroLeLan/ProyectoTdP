package PaqueteObjetos;

import PaqueteColisionadores.Colisionador;
import PaqueteObjetosImplementados.Obstaculo;

public abstract class Disparo extends Intangible {
	protected boolean borrable;
	protected int da�o;
	protected int velocidad;
	
	protected Disparo(int x, int y) {
		super(x, y);
		borrable=false;
	}
	
	public int getDa�o() {
		return da�o;
	}
	public boolean soyBorrable() {
		return borrable;
	}
	public int da�arObstaculo(Obstaculo obstaculo) {
		return obstaculo.recibirDisparo(this);
	}
	
	public int serChocado(Colisionador c) {
		return 0;
	}

	abstract public void avanzar() ;
}
