package PaqueteArmas;

import PaqueteDisparos.Disparo;

public abstract class Arma {
	protected int da�o;
	
	public Arma () {
		da�o = 10;
	}
	
	public int getDa�o() {
		return da�o;
	}
	
	public abstract Disparo disparar(int x, int y);
	
	public abstract void cambiarImagenGUI();
}