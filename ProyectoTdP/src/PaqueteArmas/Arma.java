package PaqueteArmas;

import PaqueteDisparos.Disparo;

abstract public class Arma {
	protected int daño; 
	
	public Arma () {}
	abstract public Disparo disparar(int x,int y);

}