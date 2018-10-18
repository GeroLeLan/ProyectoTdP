package PaqueteDrops;

import PaquetePersonajes.Personaje;

public class MejoraDisparoDoble extends Drop {

	protected MejoraDisparoDoble(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public void mejorar(Personaje personaje) {
		// TODO Auto-generated method stub
		
	}
	
	
	public Drop clone() {
		return new MejoraDisparoDoble(pos.x, pos.y);
	}
	
}
