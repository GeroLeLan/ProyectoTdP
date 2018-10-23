package PaqueteArmas;

import PaqueteDisparos.Disparo;


abstract public class Arma {
	protected int daño; 
	
	public Arma () {
		daño = 10; 
	}
	
	public int getDaño() {
		return daño;
	}
	
	abstract public Disparo disparar(int x, int y);

	public MementoArma crearMemento() {
		return new MementoArma(this);
	}
}