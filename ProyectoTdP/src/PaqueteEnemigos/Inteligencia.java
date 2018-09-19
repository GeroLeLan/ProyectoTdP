package PaqueteEnemigos;

import javax.swing.JLabel;

public abstract class Inteligencia {
	protected JLabel icono;
	protected int puntosKill;
	
	protected Inteligencia() {
		icono = new JLabel();
	}
	
	public JLabel getIcono() {
		return icono;
	}
	
	public int getPuntosKill() {
		return puntosKill;
	}
}
