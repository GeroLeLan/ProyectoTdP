package PaqueteObjetosImplementados;

import java.awt.Point;

import PaqueteObjetosImplementados.Objeto;

public abstract class Animado extends Objeto {
	protected int velocidad;
	protected int fuerzaK;//es el daño que produce al chocar con algo (yo propongo cambiarlo a fuerzaI o fuerza solo (gero))
	
	protected Animado(int velocidad, int x, int y) {
		super(x, y);
		this.pos = new Point(x, y);
		this.velocidad = velocidad;
	}
	public abstract int recibirDaño(int d);
	
	public abstract void mover(int dir);
	
	public int getVida() {
		return vida;
	}
}
