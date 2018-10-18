package PaqueteObjetos;

import javax.swing.ImageIcon;

import PaqueteArmas.ArmaSupermisil;
import PaqueteJuego.GUI;
import PaqueteObjetosImplementados.Personaje;

public class SuperMisil extends Temporales{

	public SuperMisil(int x, int y,GUI gui) {
		super(x, y,gui);
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/turtleSupermisil.gif"));
		setGrafico();
	}



	
	public void mejorar(Personaje personaje) {
		//personaje.setArma(new ArmaSupermisil()); 
		
	}

	@Override
	public int morir() {
		grafico.setVisible(false);
		borrable = true;
		return 0;
	}
	
}
