package PaqueteDrops;

import javax.swing.ImageIcon;

import PaquetePersonajes.Personaje;
import PaqueteJuego.GUI;

public class SubirVida extends Drop{

	public SubirVida(int x, int y, GUI gui) {
		super(x, y, gui);
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/turtleVida.gif"));
	}

	
	public void mejorar(Personaje personaje) {
		personaje.modificarVida(20);	
	}
	
	public Drop clone() {
		return new SubirVida(pos.x, pos.y, gui);
	}

}
