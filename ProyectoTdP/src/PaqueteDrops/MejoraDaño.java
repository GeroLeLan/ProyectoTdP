package PaqueteDrops;

import javax.swing.ImageIcon;

import PaqueteArmas.ArmaMejorada;
import PaquetePersonajes.Personaje;

public class MejoraDa�o extends Drop {
	
	public MejoraDa�o(int x, int y) {
		super(x, y);
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/turtleMejoraDa�o.gif"));
		setGrafico();
	}
	
	public void mejorar(Personaje personaje) {
		System.out.println("hola mejora da�o");
		personaje.setArma(new ArmaMejorada());
	}
	
	
	public Drop clone() {
		return new MejoraDa�o(pos.x, pos.y);
	}
	
}
