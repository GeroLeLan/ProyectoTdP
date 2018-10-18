package PaqueteObjetos;

import javax.swing.ImageIcon;

import PaqueteArmas.ArmaSupermisil;
import PaqueteObjetosImplementados.Personaje;

public class SuperMisil extends Temporales{

	public SuperMisil(int x, int y) {
		super(x, y);
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
