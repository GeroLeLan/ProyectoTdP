package PaqueteObjetos;

import PaqueteColisionadores.Colisionador;
import PaqueteColisionadores.ColisionadorDisparo;
import PaqueteObjetosImplementados.Objeto;
import PaqueteObjetosImplementados.Obstaculo;


public abstract class Disparo extends Intangible {
	protected boolean borrable;
	protected int da�o;
	protected int velocidad;
	
	public Disparo(int x, int y) {
		super(x, y);

		borrable=false;

		da�o = 200;

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

	
	public int colisionar(Objeto o) {
		return o.serChocado(new ColisionadorDisparo(this));
	}
	
	protected void setGrafico() {}
	
	protected int morir() {
		return 0;
	}
	
	//DEBE REDEFINIR A mover().

}
