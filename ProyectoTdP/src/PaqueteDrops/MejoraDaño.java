package PaqueteDrops;

import javax.swing.ImageIcon;

import PaqueteArmas.ArmaMejorada;
import PaquetePersonajes.Personaje;

public class MejoraDaņo extends Drop {
	
	public MejoraDaņo(int x, int y) {
		super(x, y);
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/turtleMejoraDaņo.gif"));
		setGrafico();
	}
	
	public void mejorar(Personaje personaje) {
		System.out.println("hola mejora daņo");
		personaje.setArma(new ArmaMejorada());
	}
	
	
	public Drop clone() {
		return new MejoraDaņo(pos.x, pos.y);
	}
	
}
