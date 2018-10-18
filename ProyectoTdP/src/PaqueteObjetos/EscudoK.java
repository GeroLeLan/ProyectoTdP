package PaqueteObjetos;

import javax.swing.ImageIcon;

import PaqueteJuego.GUI;
import PaqueteObjetosImplementados.Personaje;

public class EscudoK extends Drop{
	
	public EscudoK(int x, int y,GUI gui) {
		super(x, y, gui);
		
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/turtleEscudo.gif"));
	}

	public void mejorar(Personaje personaje) {
		personaje.setEscudo(true);
		gui.mostrarIconoDrop(0, new ImageIcon("./bin/ImageIcons/iconoDropEscudo_Habilitado.png"));
	}

	
	public int morir() {
		grafico.setVisible(false);
		borrable = true;
		return 0;
	}

}
