package PaqueteArmas;

import PaqueteDisparos.Disparo;

abstract public class Arma {
	protected int da�o; 
	
	public Arma () {
		da�o = 10; 
	}
	
	abstract public Disparo disparar(int x, int y);
}