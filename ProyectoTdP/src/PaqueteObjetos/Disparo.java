package PaqueteObjetos;

import PaqueteColisionadores.Colisionador;
import PaqueteObjetosImplementados.Obstaculo;

public abstract class Disparo extends Intangible {
	protected int da�o;
	protected int velocidad;
	
	protected Disparo(int x, int y) {
		super(x, y);
	}
	
	public int getDa�o() {
		return da�o;
	}
	
	public int da�arObstaculo(Obstaculo obstaculo) {
		return obstaculo.recibirDisparo(this);
	}
	
	public int serChocado(Colisionador c) {
		return 0;
	}
}
