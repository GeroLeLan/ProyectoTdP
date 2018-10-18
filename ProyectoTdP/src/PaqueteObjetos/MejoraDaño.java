package PaqueteObjetos;

import javax.swing.ImageIcon;

import PaqueteArmas.ArmaMejorada;
import PaqueteJuego.GUI;
import PaqueteObjetosImplementados.Personaje;

public class MejoraDaño extends Drop {
	
	
	public MejoraDaño(int x, int y,GUI gui) {
		super(x, y,gui);
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/turtleMejoraDaño.gif"));
		setGrafico();
		
	}

	public int morir() {
		grafico.setVisible(false);
		borrable = true;
		return 0;
	}
	
	@Override
	public void mejorar(Personaje personaje) {
		System.out.println("hola mejora daño");
		personaje.setArma(new ArmaMejorada());
	}
	
}
