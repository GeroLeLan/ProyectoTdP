package PaqueteEnemigos;

import java.util.Random;

import javax.swing.ImageIcon;

import PaqueteColisionadores.Colisionador;
import PaqueteObjetos.Disparo;

import PaqueteColisionadores.ColisionadorEnemigo;

import PaqueteObjetosImplementados.Animado;
import PaqueteObjetosImplementados.Objeto;
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
		moviendo = intel.iniciaConMovimiento();
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
	
	public void mover() {
		if (moviendo)
			intel.mover(pos);
		else {
			Random r = new Random();
			int chance = r.nextInt(550);
			if (chance <= 6)
				moviendo = true;
		}
		grafico.setLocation(pos);
	}
	
	public int recibirDaño(int d) {
		vida -= d;
		intel.cambiarInteligencia(vida, this);
		if(vida <= 0)
			return morir();
		return 0;
	}
	
	public int serChocado(Colisionador c) {
		return c.chocarEnemigo(this);
	}


	public Disparo disparar() {
		return intel.disparar(pos);
	}

	public int colisionar(Objeto o) {
		return o.serChocado(new ColisionadorEnemigo(this));

	}
}
