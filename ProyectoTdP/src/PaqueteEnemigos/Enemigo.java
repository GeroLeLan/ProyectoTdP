package PaqueteEnemigos;

import PaqueteObjetosNacho.Objeto;
import TDAListaDE.Position;

public class Enemigo extends Objeto {
	protected Inteligencia intel;
	protected Position<Enemigo> posEnJuego; //Guarda su posici�n en la lista de enemigos del juego.
	
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
		grafico.setSize(75, 75);
		grafico.setLocation(pos);
	}
}
