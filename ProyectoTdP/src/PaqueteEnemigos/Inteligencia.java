package PaqueteEnemigos;

import java.awt.Point;
import javax.swing.ImageIcon;

public abstract class Inteligencia {
	protected static final int Ymax = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	protected static final int Xmax = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	protected ImageIcon icono;
	protected int puntosKill;
	protected int velocidad;
	
	protected Inteligencia() {
		icono = new ImageIcon();
	}
	
	public ImageIcon getIcono() {
		return icono;
	}
	
	public int getPuntosKill() {
		return puntosKill;
	}
	
	public Inteligencia clone() {
		return null;
	}
	
	public abstract void mover(int dir, Point pos);
	
	public int getVelocidad() {
		return velocidad;
	}
	
	public abstract boolean debeMoverse();
}
