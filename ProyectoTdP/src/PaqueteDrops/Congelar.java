package PaqueteDrops;

import PaquetePersonajes.Personaje;

public class Congelar extends Temporales{

	protected Congelar(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void setGrafico() {
		// TODO Auto-generated method stub
	}

	@Override
	public void mejorar(Personaje personaje) {
		// TODO Auto-generated method stub
		
	}
	
	
	public Drop clone() {
		return new Congelar(pos.x, pos.y);
	}
	
}
