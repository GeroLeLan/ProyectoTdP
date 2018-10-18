package PaqueteDrops;

import javax.swing.ImageIcon;

import PaquetePersonajes.Personaje;

public class SuperMisil extends Temporales{

	public SuperMisil(int x, int y) {
		super(x, y);
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/turtleSupermisil.gif"));
		setGrafico();
	}
	
	public void mejorar(Personaje personaje) {
		//personaje.setArma(new ArmaSupermisil()); 
	}
	
	
	public Drop clone() {
		return new SuperMisil(pos.x, pos.y);
	}
	
}
