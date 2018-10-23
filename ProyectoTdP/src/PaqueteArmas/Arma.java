package PaqueteArmas;

import PaqueteDisparos.Disparo;


abstract public class Arma {
	protected int da�o; 
	
	public Arma () {
		da�o = 10; 
	}
	
	public int getDa�o() {
		return da�o;
	}
	
	abstract public Disparo disparar(int x, int y);

	public MementoArma crearMemento() {
		return new MementoArma(this);
	}
}