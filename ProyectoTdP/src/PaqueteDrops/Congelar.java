package PaqueteDrops;


import PaquetePersonajes.Personaje;
import javax.swing.ImageIcon;
import PaqueteJuego.GUI;

public class Congelar extends Temporales{
	public Congelar(int x, int y, GUI gui) {
		super(x, y, gui);
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/turtleCongelar.gif"));
	}

	public int morir() {
		grafico.setVisible(false);
		borrable = true;
		return 0;
	}
	
	public void mejorar(Personaje personaje) {
			gui.getTiempo().wait(3000);
	}

	public Drop clone() {
		return new Congelar(pos.x, pos.y, gui);
	}
	
}