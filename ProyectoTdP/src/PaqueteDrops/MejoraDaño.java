package PaqueteDrops;

import javax.swing.ImageIcon;

import PaqueteArmas.ArmaMejoraDa�o;
import PaquetePersonajes.Personaje;
import PaqueteJuego.GUI;

public class MejoraDa�o extends Drop {
	public MejoraDa�o(int x, int y, GUI gui) {
		super(x, y, gui);
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/turtleMejoraDa�o.gif"));
		setGrafico();
	}
	
	public void mejorar(Personaje personaje) {
		personaje.setArma(new ArmaMejoraDa�o());
		gui.mostrarIconoDrop(1,  new ImageIcon("./bin/ImageIcons/iconoDropDa�o_Habilitado.png"));
		gui.mostrarIconoDrop(2,  new ImageIcon("./bin/ImageIcons/iconoDropSupermisil_Deshabilitado.png"));
		gui.mostrarIconoDrop(4,  new ImageIcon("./bin/ImageIcons/iconoDropPerforador_Deshabilitado.png"));
	}
	
	
	public Drop clone() {
		return new MejoraDa�o(pos.x, pos.y, gui);
	}
	
}
