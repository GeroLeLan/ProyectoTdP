package PaqueteObjetos;

import javax.swing.ImageIcon;

import PaqueteArmas.ArmaMejorada;
import PaqueteObjetosImplementados.Personaje;

public class MejoraDaņo extends Drop {
	
	
	public MejoraDaņo(int x, int y) {
		super(x, y);
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/turtleMejoraDaņo.gif"));
		setGrafico();
		
	}

	public int morir() {
		return 0;
	}
	@Override
	public void mejorar(Personaje personaje) {
		System.out.println("hola mejora daņo");
		personaje.setArma(new ArmaMejorada());
	}
	
}
