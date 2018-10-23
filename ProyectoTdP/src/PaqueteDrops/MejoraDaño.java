package PaqueteDrops;

import javax.swing.ImageIcon;

import PaqueteArmas.ArmaMejoraDaņo;
import PaquetePersonajes.Personaje;
import PaqueteJuego.GUI;

public class MejoraDaņo extends Drop {
	public MejoraDaņo(int x, int y, GUI gui) {
		super(x, y, gui);
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/turtleMejoraDaņo.gif"));
		setGrafico();
	}
	
	public void mejorar(Personaje personaje) {
		personaje.setArma(new ArmaMejoraDaņo());
		gui.mostrarIconoDrop(1,  new ImageIcon("./bin/ImageIcons/iconoDropDaņo_Habilitado.png"));
	}
	
	
	public Drop clone() {
		return new MejoraDaņo(pos.x, pos.y, gui);
	}
	
}
