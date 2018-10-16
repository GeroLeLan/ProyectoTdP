package PaqueteObjetos;

import javax.swing.ImageIcon;

import PaqueteObjetosImplementados.Personaje;

public class SuperMisil extends Temporales{

	public SuperMisil(int x, int y) {
		super(x, y);
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/200w.gif"));
		setGrafico();
	}



	@Override
	public void mejorar(Personaje personaje) {
		// TODO Auto-generated method stub
		
	}
	
}
