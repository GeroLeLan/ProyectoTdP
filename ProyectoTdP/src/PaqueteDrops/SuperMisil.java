package PaqueteDrops;

import javax.swing.ImageIcon;


import PaqueteArmas.ArmaSupermisil;
import PaquetePersonajes.Personaje;
import PaqueteJuego.GUI;

public class SuperMisil extends Temporales {

	public SuperMisil(int x, int y, GUI gui) {
		super(x, y,gui);
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/turtleSupermisil.gif"));
		setGrafico();
	}
	
	public void mejorar(Personaje personaje) {
		personaje.setArma(new ArmaSupermisil());
		gui.mostrarIconoDrop(2,  new ImageIcon("./bin/ImageIcons/iconoDropSupermisil_Habilitado.png"));
		gui.mostrarIconoDrop(1,  new ImageIcon("./bin/ImageIcons/iconoDropDaño_Deshabilitado.png"));
		gui.mostrarIconoDrop(4,  new ImageIcon("./bin/ImageIcons/iconoDropPerforador_Deshabilitado.png"));
	}
	
	
	public Drop clone() {
		return new SuperMisil(pos.x, pos.y, gui);
	}
	
}
