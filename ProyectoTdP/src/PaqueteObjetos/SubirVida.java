package PaqueteObjetos;

import javax.swing.ImageIcon;

import PaqueteObjetosImplementados.Personaje;

public class SubirVida extends Drop{

	public SubirVida(int x, int y) {
		super(x, y);
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/turtleVida.gif"));
	}

	
	public void mejorar(Personaje personaje) {
		personaje.mejorarVida();
		
	}

}
