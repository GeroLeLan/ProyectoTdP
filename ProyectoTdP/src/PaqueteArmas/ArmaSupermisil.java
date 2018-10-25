package PaqueteArmas;


import javax.swing.ImageIcon;

import PaqueteDisparos.Disparo;
import PaqueteDisparos.MegaDisparo;
import PaqueteJuego.GUI;

public class ArmaSupermisil extends Arma {
	protected GUI gui;
	
	public ArmaSupermisil(GUI g) {
		super();
		gui = g;
		daño=20;
		cambiarImagenGUI();
	}
	public Disparo disparar(int x, int y) {
		return new MegaDisparo(x,y,daño);
	}
	
	public void cambiarImagenGUI() {
		gui.mostrarIconoDrop(2,  new ImageIcon("./bin/ImageIcons/iconoDropSupermisil_Habilitado.png"));
		gui.mostrarIconoDrop(1,  new ImageIcon("./bin/ImageIcons/iconoDropDaño_Deshabilitado.png"));
		gui.mostrarIconoDrop(4,  new ImageIcon("./bin/ImageIcons/iconoDropPerforador_Deshabilitado.png"));
	}
	
	

}
