package PaqueteObjetos;

import PaqueteColisionadores.Colisionador;
import PaqueteObjetosImplementados.Obstaculo;

public abstract class Disparo extends Intangible {
	protected int daño;
	protected int velocidad;
	
	protected Disparo(int x, int y) {
		super(x, y);
	}
	
	public int getDaño() {
		return daño;
	}
	
	public int dañarObstaculo(Obstaculo obstaculo) {
		return obstaculo.recibirDisparo(this);
	}
	
	public int serChocado(Colisionador c) {
		return 0;
	}
}
