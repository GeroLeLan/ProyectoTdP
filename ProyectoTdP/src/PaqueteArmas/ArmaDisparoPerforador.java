package PaqueteArmas;

import javax.swing.ImageIcon;

import PaqueteDisparos.Disparo;
import PaqueteDisparos.DisparoPerforador;
import PaqueteJuego.GUI;

public class ArmaDisparoPerforador extends Arma {
	protected GUI gui;
	
	public ArmaDisparoPerforador(GUI g) {
		super();
		gui = g;
		cambiarImagenGUI();
	}
	
	public Disparo disparar(int x, int y) {
		return new DisparoPerforador(x, y, daño);
	}

	public void cambiarImagenGUI() {
		gui.mostrarIconoDrop(4,  new ImageIcon("./bin/ImageIcons/iconoDropPerforador_Habilitado.png"));
		gui.mostrarIconoDrop(1,  new ImageIcon("./bin/ImageIcons/iconoDropDaño_Deshabilitado.png"));
		gui.mostrarIconoDrop(2,  new ImageIcon("./bin/ImageIcons/iconoDropSupermisil_Deshabilitado.png"));
	}

}
