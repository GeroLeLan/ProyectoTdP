package PaquetePersonajes;

import javax.swing.ImageIcon;

public class Jugador extends Personaje {
	
	public Jugador(int vel, int x, int y) {
		super(vel, x, y);
		velocidad = vel;
		vida = 100;
		setGrafico();
	}
	
	protected void setGrafico() {
		grafico.setSize((int)(Xmax*0.05),(int)(Ymax*0.1));
		ImageIcon iconoOriginal = new ImageIcon("./bin/ImageIcons/Jugador - Estándar.png");
		ImageIcon iconoEscala = new ImageIcon(escalarGrafico(iconoOriginal));
		grafico.setIcon(iconoEscala);
		grafico.setLocation(pos);
	}
	
	public int morir() {
		ImageIcon iconoOriginal = new ImageIcon("./bin/ImageIcons/Jugador - Muerto.png");
		ImageIcon iconoEscala = new ImageIcon(escalarGrafico(iconoOriginal));
		grafico.setIcon(iconoEscala);
		vida = 0;
		return -30;
	}
}
