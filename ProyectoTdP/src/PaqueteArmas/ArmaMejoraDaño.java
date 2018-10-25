package PaqueteArmas;

import javax.swing.ImageIcon;

import PaqueteArmas.Arma;
import PaqueteDisparos.Disparo;
import PaqueteJuego.GUI;

public class ArmaMejoraDaño extends Arma {
	protected GUI gui;
	
	public ArmaMejoraDaño(GUI g) {
		super();
		gui = g;
		daño = 100;
		cambiarImagenGUI();
	}
	
	public Disparo disparar(int x,int y) {
		return new Disparo(x,y, daño);
	}

	public void cambiarImagenGUI() {
		gui.mostrarIconoDrop(1,  new ImageIcon("./bin/ImageIcons/iconoDropDaño_Habilitado.png"));
		gui.mostrarIconoDrop(2,  new ImageIcon("./bin/ImageIcons/iconoDropSupermisil_Deshabilitado.png"));
		gui.mostrarIconoDrop(4,  new ImageIcon("./bin/ImageIcons/iconoDropPerforador_Deshabilitado.png"));
	}
}
