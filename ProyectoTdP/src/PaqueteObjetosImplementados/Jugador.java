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
		grafico.setIcon(new ImageIcon(this.getClass().getResource("src/ImageIcons/JUGADOR.png")));
		System.out.print("H");
		grafico.setSize(250, 75);
		grafico.setLocation(pos);
	}
	
	public int getVel() {
		return velocidad;
	}
	
}
