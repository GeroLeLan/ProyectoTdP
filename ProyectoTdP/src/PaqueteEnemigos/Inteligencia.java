package PaqueteEnemigos;

import javax.swing.ImageIcon;

public abstract class Inteligencia {
	protected final int Xmax =java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	protected final int Ymax =java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	protected ImageIcon icono;
	protected int puntosKill;
	
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
}
