package PaqueteDrops;

import javax.swing.ImageIcon;

import PaquetePersonajes.Personaje;
import PaqueteJuego.GUI;

public class SuperMisil extends Temporales {

	public SuperMisil(int x, int y, GUI gui) {
		super(x, y,gui);
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/turtleSupermisil.gif"));
		setGrafico();
	}
	
	public void mejorar(Personaje personaje) {
		
	}
	
	
	public Drop clone() {
		return new SuperMisil(pos.x, pos.y, gui);
	}
	
}
