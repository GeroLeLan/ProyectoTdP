package PaqueteArmas;

import PaqueteObjetos.Disparo;

abstract public class Arma {
	protected int da�o; 
	public Arma () {
	}
	abstract public Disparo disparar(int x,int y);

}