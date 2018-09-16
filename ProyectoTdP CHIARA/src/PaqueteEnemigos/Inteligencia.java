package PaqueteEnemigos;

import javax.swing.JLabel;

public abstract class Inteligencia {
	protected JLabel icono;
	
	protected Inteligencia() {
		icono = new JLabel();
	}
	
	public JLabel getIcono() {
		return icono;
	}
}
