package PaqueteDrops;

import javax.swing.ImageIcon;

import PaquetePersonajes.Personaje;

public class Escudo extends Drop{
	
	public Escudo(int x, int y) {
		super(x, y);
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/turtleEscudo.gif"));
	}
	
	public void mejorar(Personaje personaje) {
		personaje.setEscudo(true);
	}
	
	
	public Drop clone() {
		return new Escudo(pos.x, pos.y);
	}

}
