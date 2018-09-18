package PaqueteObjetosImplementados;

import javax.swing.ImageIcon;


public class Jugador extends Objeto {
	protected int velocidad;

	
	public Jugador(int vel, int x, int y) {
		super(x, y);
		velocidad = vel;
		setGrafico();
	}
	
	protected void setGrafico() {
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/Jugador - Estándar.png"));
		grafico.setSize(75, 90);
		grafico.setLocation(pos);
	}
	
	public int getVel() {
		return velocidad;
	}
	
}
