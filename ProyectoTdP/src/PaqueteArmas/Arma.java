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
	
	public abstract Disparo disparar(int x, int y);
	
	public abstract void cambiarImagenGUI();
}