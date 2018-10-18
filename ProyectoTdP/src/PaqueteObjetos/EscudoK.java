package PaqueteObjetos;

import javax.swing.ImageIcon;

import PaqueteObjetosImplementados.Personaje;

public class EscudoK extends Drop{
	
	public EscudoK(int x, int y) {
		super(x, y);
		
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/turtleEscudo.gif"));
	}

	
	public void mejorar(Personaje personaje) {
		personaje.setEscudo(true);
		
	}


	
	public int morir() {
		grafico.setVisible(false);
		borrable = true;
		return 0;
	}

}
