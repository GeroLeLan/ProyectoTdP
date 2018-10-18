package PaqueteDrops;

import javax.swing.ImageIcon;

import PaqueteArmas.ArmaMejorada;
import PaquetePersonajes.Personaje;
import PaqueteJuego.GUI;

public class MejoraDa�o extends Drop {
	public MejoraDa�o(int x, int y, GUI gui) {
		super(x, y, gui);
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/turtleMejoraDa�o.gif"));
		setGrafico();
	}
	
	public void mejorar(Personaje personaje) {
		personaje.setArma(new ArmaMejorada());
		gui.mostrarIconoDrop(1,  new ImageIcon("./bin/ImageIcons/iconoDropDa�o_Habilitado.png"));
	}
	
	
	public Drop clone() {
		return new MejoraDa�o(pos.x, pos.y, gui);
	}
	
}
