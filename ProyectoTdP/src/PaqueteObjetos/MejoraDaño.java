package PaqueteObjetos;

import javax.swing.ImageIcon;

import PaqueteArmas.ArmaMejorada;
import PaqueteObjetosImplementados.Personaje;

public class MejoraDa�o extends Drop {
	
	
	public MejoraDa�o(int x, int y) {
		super(x, y);
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/turtleMejoraDa�o.gif"));
		setGrafico();
		
	}

	public int morir() {
		return 0;
	}
	@Override
	public void mejorar(Personaje personaje) {
		System.out.println("hola mejora da�o");
		personaje.setArma(new ArmaMejorada());
	}
	
}
