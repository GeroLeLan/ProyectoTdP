package PaqueteDrops;

import PaqueteArmas.ArmaMejoraDaņo;
import PaquetePersonajes.Personaje;
import PaqueteJuego.GUI;

public class MejoraDaņo extends Drop {
	public MejoraDaņo(int x, int y, GUI gui) {
		super(x, y, gui);
		grafico.setIcon(this.gui.getBuscadorDeImagenes().buscarImagen("/ImageIcons/turtleMejoraDaņo.gif"));
		setGrafico();
	}
	
	public void mejorar(Personaje personaje) {
		personaje.setArma(new ArmaMejoraDaņo(gui));
	}
	
	public Drop clone() {
		return new MejoraDaņo(pos.x, pos.y, gui);
	}
	
}
