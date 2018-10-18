package PaqueteObjetos;

import javax.swing.ImageIcon;


import PaqueteJuego.GUI;
import PaqueteObjetosImplementados.Personaje;

public class Congelar extends Temporales{

	public Congelar(int x, int y,GUI gui) {
		super(x, y,gui);
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/turtleCongelar.gif"));
		setGrafico();
		
	}

	public int morir() {
		grafico.setVisible(false);
		borrable = true;
		return 0;
	}
	
	@Override
	public void mejorar(Personaje personaje) {
	
			gui.getTiempo().wait(3000);
		
	}
	
}