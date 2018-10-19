package PaqueteDrops;

import PaqueteJuego.GUI;
import PaquetePersonajes.Personaje;

public class MejoraDisparoDoble extends Drop {

	protected MejoraDisparoDoble(int x, int y, GUI gui) {
		super(x, y, gui);
		// TODO Auto-generated constructor stub
	}

	public void mejorar(Personaje personaje) {
		// TODO Auto-generated method stub
		
	}
	
	
	public Drop clone() {
		return new MejoraDisparoDoble(pos.x, pos.y, gui);
	}
	
}
