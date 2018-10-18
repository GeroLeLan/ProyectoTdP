package PaqueteDrops;

import javax.swing.ImageIcon;

import PaquetePersonajes.Personaje;

public class SubirVida extends Drop{

	public SubirVida(int x, int y) {
		super(x, y);
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/turtleVida.gif"));
	}

	
	public void mejorar(Personaje personaje) {
		personaje.modificarVida(20);	
	}
	
	
	public Drop clone() {
		return new SubirVida(pos.x, pos.y);
	}

}
