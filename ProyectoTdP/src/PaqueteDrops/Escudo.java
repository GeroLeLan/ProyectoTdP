package PaqueteDrops;

import javax.swing.ImageIcon;
import PaqueteJuego.GUI;
import PaquetePersonajes.Personaje;

public class Escudo extends Drop {
	
	public Escudo(int x, int y, GUI gui) {
		super(x, y, gui);
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/turtleEscudo.gif"));
	}
	
	public void mejorar(Personaje personaje) {
		personaje.setEscudo(true);
		gui.mostrarIconoDrop(0, new ImageIcon("./bin/ImageIcons/iconoDropEscudo_Habilitado.png"));
	}
	
	
	public Drop clone() {
		return new Escudo(pos.x, pos.y, gui);
	}

}