package PaqueteObjetos;

import javax.swing.ImageIcon;

import PaqueteJuego.GUI;
import PaqueteObjetosImplementados.Personaje;

public class SubirVida extends Drop{

	public SubirVida(int x, int y,GUI gui) {
		super(x, y,gui);
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/turtleVida.gif"));
	}

	
	public void mejorar(Personaje personaje) {
		personaje.mejorarVida();
		
	}


	@Override
	public int morir() {
		grafico.setVisible(false);
		borrable = true;
		return 0;
	}

}
