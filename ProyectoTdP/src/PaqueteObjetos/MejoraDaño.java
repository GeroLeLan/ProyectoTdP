package PaqueteObjetos;

import javax.swing.ImageIcon;

import PaqueteArmas.ArmaMejorada;
import PaqueteJuego.GUI;
import PaqueteObjetosImplementados.Personaje;

public class MejoraDa�o extends Drop {
	
	
	public MejoraDa�o(int x, int y,GUI gui) {
		super(x, y,gui);
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/turtleMejoraDa�o.gif"));
		setGrafico();
		
	}

	public int morir() {
		grafico.setVisible(false);
		borrable = true;
		return 0;
	}
	
	@Override
	public void mejorar(Personaje personaje) {
		personaje.setArma(new ArmaMejorada());
		gui.mostrarIconoDrop(1,  new ImageIcon("./bin/ImageIcons/iconoDropDa�o_Habilitado.png"));
	}
	
}
