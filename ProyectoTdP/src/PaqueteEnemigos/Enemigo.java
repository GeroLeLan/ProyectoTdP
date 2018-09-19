package PaqueteEnemigos;

import PaqueteObjetosImplementados.Objeto;
import TDAListaDE.Position;

public class Enemigo extends Objeto {
	protected Inteligencia intel;
	protected Position<Enemigo> posEnListaJuego; //Guarda su posición en la lista de enemigos del juego.
	private final int Xmax =java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	private final int Ymax =java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	
	public Enemigo (Inteligencia i, int x, int y) {
		super(x, y);
		intel = i;
		setGrafico();
	}
	
	public void setPosEnListaJuego(Position<Enemigo> posJ) {
		posEnListaJuego = posJ;
	}
	
	protected void setGrafico() {
		grafico = intel.getIcono();
<<<<<<< HEAD

		//grafico.setSize(75,90);
		
		

		grafico.setSize((int)(Xmax*0.05),(int)(Ymax*0.07));

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
