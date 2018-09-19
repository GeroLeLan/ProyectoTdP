package PaqueteEnemigos;

import javax.swing.ImageIcon;

public class ITieneArma extends Inteligencia {
	public ITieneArma() {
		super();
		icono.setIcon(new ImageIcon("./bin/ImageIcons/ITieneArma.png"));
		puntosKill = 15;
	}
}
