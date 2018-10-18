package PaqueteObjetos;

import PaqueteJuego.GUI;

public abstract class Temporales extends Drop {
	protected Temporales(int x, int y,GUI gui) {
		super(x, y,gui);
		// TODO Auto-generated constructor stub
	}
	protected int tiempo;
	abstract public int morir();
		
		
	
}
