package PaqueteDrops;

import javax.swing.ImageIcon;

import PaqueteArmas.ArmaMejorada;
import PaquetePersonajes.Personaje;

public class MejoraDaño extends Drop {
	
	public MejoraDaño(int x, int y) {
		super(x, y);
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/turtleMejoraDaño.gif"));
		setGrafico();
	}
	
	public void mejorar(Personaje personaje) {
		System.out.println("hola mejora daño");
		personaje.setArma(new ArmaMejorada());
	}
	
	
	public Drop clone() {
		return new MejoraDaño(pos.x, pos.y);
	}
	
}
