package PaqueteEnemigos;

import PaqueteObjetos.Objeto;
import TDAListaDE.Position;

public class Enemigo extends Objeto {
	protected Inteligencia intel;
	protected Position<Enemigo> posEnJuego; //Guarda su posición en la lista de enemigos del juego.
	protected boolean movimientoActivado; //Cuando se cree el mapa, los enemigos tendrán una posición fija. Al comenzar la partida se empezarán a mover.
	
	public Enemigo (Inteligencia i, int x, int y) {
		super(x, y);
		intel = i;
		setGrafico();
		movimientoActivado = false;
	}
	
	public void setPosEnJuego(Position<Enemigo> pos) {
		posEnJuego = pos;
	}
	
	protected void setGrafico() {
		grafico = intel.getIcono();
	}
}
