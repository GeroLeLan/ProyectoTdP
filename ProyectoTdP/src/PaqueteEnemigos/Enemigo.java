package PaqueteEnemigos;

import PaqueteObjetosImplementados.Objeto;
import TDAListaDE.Position;

public class Enemigo extends Objeto {
	protected Inteligencia intel;
	protected Position<Enemigo> posEnJuego; //Guarda su posición en la lista de enemigos del juego.
	
	public Enemigo (Inteligencia i, int x, int y) {
		super(x, y);
		intel = i;
		setGrafico();
	}
	
	public void setPosEnJuego(Position<Enemigo> posJ) {
		posEnJuego = posJ;
	}
	
	protected void setGrafico() {
		grafico = intel.getIcono();
		grafico.setSize(75,90);
		grafico.setLocation(pos);
	}
	
	
	@Override
	public void morir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void colisionar() {
		// TODO Auto-generated method stub
		
	}
}
