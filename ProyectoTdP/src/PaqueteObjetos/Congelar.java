package PaqueteObjetos;


import javax.swing.ImageIcon;

import PaqueteDrops.Drop;
import PaqueteDrops.Temporales;
import PaqueteEnemigos.Enemigo;
import PaqueteJuego.GUI;
import PaquetePersonajes.Personaje;
import TDAListaDE.Position;


public class Congelar extends Temporales{


	public Congelar(int x, int y,GUI gui) {
		super(x, y,gui);
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/turtleCongelar.gif"));
				
	}

	public int morir() {
		grafico.setVisible(false);
		borrable = true;
		return 0;
	}
	
	
	public void mejorar(Personaje personaje) {
		for(Position<Enemigo> en:gui.getListaEnemigos().positions()) {
			en.element().frenar();
		}
		gui.mostrarIconoDrop(3, new ImageIcon("./bin/ImageIcons/iconoDropCongelar_Habilitado.png"));
		
	}

	
	public Drop clone() {
		return new Congelar(pos.x,pos.y,gui);
	}
	
}