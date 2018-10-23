package PaqueteDrops;

import javax.swing.ImageIcon;

import PaqueteArmas.ArmaDisparoPerforador;
import PaqueteJuego.GUI;
import PaquetePersonajes.Personaje;

public class MejoraDisparoPerforador extends Drop {

	protected MejoraDisparoPerforador(int x, int y, GUI gui) {
		super(x, y, gui);
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/turtlePerforador.gif"));
		setGrafico();
	}

	public void mejorar(Personaje personaje) {
		personaje.setArma(new ArmaDisparoPerforador());
		gui.mostrarIconoDrop(4,  new ImageIcon("./bin/ImageIcons/iconoDropPerforador_Habilitado.png"));
		gui.mostrarIconoDrop(1,  new ImageIcon("./bin/ImageIcons/iconoDropDa�o_Deshabilitado.png"));
		gui.mostrarIconoDrop(2,  new ImageIcon("./bin/ImageIcons/iconoDropSupermisil_Deshabilitado.png"));

	}
	
	
	public Drop clone() {
		return new MejoraDisparoPerforador(pos.x, pos.y, gui);
	}
	
}
