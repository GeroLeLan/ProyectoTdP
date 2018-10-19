package PaqueteDrops;


import PaqueteEnemigos.Enemigo;
import PaqueteJuego.GUI;

import TDAListaDE.Position;


import PaquetePersonajes.Personaje;
import javax.swing.ImageIcon;



public class Congelar extends Temporales{
	public Congelar(int x, int y, GUI gui) {
		super(x, y, gui);
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/turtleCongelar.gif"));
	}

	public int morir() {
		grafico.setVisible(false);
		borrable = true;
		return 0;
	}
	
	public void mejorar(Personaje personaje) {

		for (Position<Enemigo> en : gui.getListaEnemigos().positions()) {
			en.element().frenar(3000);
		}
			
	}

		


	public Drop clone() {
		return new Congelar(pos.x, pos.y, gui);
	}
}
	
