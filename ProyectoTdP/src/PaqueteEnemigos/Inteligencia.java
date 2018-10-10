package PaqueteEnemigos;

import java.awt.Point;
import javax.swing.ImageIcon;

import PaqueteObjetos.Disparo;
import PaqueteObjetosImplementados.Personaje;

public abstract class Inteligencia {
	protected static final int Ymax = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	protected static final int Xmax = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	protected ImageIcon icono;
	protected int puntosKill;
	protected int velocidad;
	protected Personaje personajeJuego;
	
	protected Inteligencia(Personaje p) {
		icono = new ImageIcon();
		personajeJuego = p;
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
	public abstract void mover(Point pos);
	
	public int getVelocidad() {
		return velocidad;
	}
	
	public abstract boolean iniciaConMovimiento();
	
	public void cambiarInteligencia(int vida, Enemigo enem) { } //Lo redefinirán las inteligencias que cambien.

	abstract public Disparo disparar(Point pos) ;
}
