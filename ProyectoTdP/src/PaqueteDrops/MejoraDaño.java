package PaqueteDrops;

import javax.swing.ImageIcon;

import PaqueteArmas.ArmaMejoraDaño;
import PaquetePersonajes.Personaje;
import PaqueteJuego.GUI;

public class MejoraDaño extends Drop {
	public MejoraDaño(int x, int y, GUI gui) {
		super(x, y, gui);
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/turtleMejoraDaño.gif"));
		setGrafico();
	}
	
	public void mejorar(Personaje personaje) {
		personaje.setArma(new ArmaMejoraDaño());
		gui.mostrarIconoDrop(1,  new ImageIcon("./bin/ImageIcons/iconoDropDaño_Habilitado.png"));
		gui.mostrarIconoDrop(2,  new ImageIcon("./bin/ImageIcons/iconoDropSupermisil_Deshabilitado.png"));
		gui.mostrarIconoDrop(4,  new ImageIcon("./bin/ImageIcons/iconoDropPerforador_Deshabilitado.png"));
	}
	
	
	public Drop clone() {
		return new MejoraDaño(pos.x, pos.y, gui);
	}
	
}
