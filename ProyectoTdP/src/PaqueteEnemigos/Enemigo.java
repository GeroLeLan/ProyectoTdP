package PaqueteEnemigos;

import javax.swing.ImageIcon;

import PaqueteObjetosImplementados.Animado;
import TDAListaDE.Position;

public class Enemigo extends Animado {
	protected Inteligencia intel;
	protected Position<Enemigo> posEnListaJuego; //Guarda su posición en la lista de enemigos del juego.
	protected final int vidaInicial = 100;
	protected boolean moviendo;
	
	public Enemigo (Inteligencia i, int x, int y) {
		super(i.getVelocidad(), x, y);
		vida = vidaInicial;
		intel = i;
		setGrafico();
		moviendo = intel.debeMoverse();
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
	
	public void mover(int dir) {
		intel.mover(dir, pos);
		grafico.setLocation(pos);
	}
	
	public boolean getMoviendo() {
		return moviendo;
	}
	public void setMoviendo(boolean m) {
		moviendo = m;
	}
	
		
}
