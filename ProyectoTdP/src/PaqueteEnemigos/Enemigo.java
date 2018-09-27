package PaqueteEnemigos;

import javax.swing.ImageIcon;

import PaqueteObjetosImplementados.Animado;
import TDAListaDE.Position;

public class Enemigo extends Animado {
	protected Inteligencia intel;
	protected Position<Enemigo> posEnListaJuego; //Guarda su posición en la lista de enemigos del juego.
	
	public Enemigo (Inteligencia i, int velocidad, int x, int y) {
		super(velocidad, x, y);
		intel = i;
		setGrafico();
	}
	
	public void setPosEnListaJuego(Position<Enemigo> posJ) {
		posEnListaJuego = posJ;
	}
	
	protected void setGrafico() {
		grafico.setSize((int)(Xmax*0.05),(int)(Ymax*0.1));
		grafico.setIcon(new ImageIcon(escalarGrafico(intel.getIcono())));
		grafico.setLocation(pos);
	}
	
	

	protected int morir() {
		ImageIcon iconoOriginal = new ImageIcon("./bin/ImageIcons/Animación - Muerte de Enemigo.gif");
		ImageIcon iconoEscala = new ImageIcon(escalarGrafico(iconoOriginal));
		grafico.setIcon(iconoEscala);
		return intel.getPuntosKill();
	}

	@Override
	public void colisionar() {
		// TODO Auto-generated method stub
		
	}

	
		
}

	

	

	
	
	

