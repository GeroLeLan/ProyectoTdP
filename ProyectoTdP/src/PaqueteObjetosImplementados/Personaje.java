package PaqueteObjetosImplementados;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import PaqueteColisionadores.Colisionador;
import PaqueteObjetos.Arma;
<<<<<<< HEAD
=======
import PaqueteObjetos.Disparo;
>>>>>>> dd3bba543e7ea215949fc855fc96016e284f2929
import PaqueteObjetos.Drop;

public abstract class Personaje extends Animado {
	protected Arma arma;
	
	protected Personaje(int v, int x, int y) {
		super(v, x, y);
	}

	public int getVel() {
		return velocidad;
	}
	
	public void mover(int dir) {
		if (dir == KeyEvent.VK_LEFT || dir == KeyEvent.VK_A) {
			ImageIcon iconoOriginal = new ImageIcon("./bin/ImageIcons/Jugador - Izquierda.png");
			ImageIcon iconoEscala = new ImageIcon(escalarGrafico(iconoOriginal));
			grafico.setIcon(iconoEscala);
			if (pos.x - 5 > 0)
				pos.x -= velocidad;
		}
		if (dir == KeyEvent.VK_RIGHT || dir == KeyEvent.VK_D) {
			ImageIcon iconoOriginal = new ImageIcon("./bin/ImageIcons/Jugador - Derecha.png");
			ImageIcon iconoEscala = new ImageIcon(escalarGrafico(iconoOriginal));
			grafico.setIcon(iconoEscala);
			if (pos.x < (int) (Xmax*0.6) * 0.9)
				pos.x += velocidad;
		}
		grafico.setLocation(pos);
	}
	
	public int recibirDaño(int d) {
		vida -= d;
		if(vida <= 0)
			return morir();
		return -5;
	}
	
	public void mejorar(Drop drop) {}
	
	public int colisionar(Objeto o) {
		return 0;
	}
	
	public int serChocado(Colisionador c) {
		return c.chocarPersonaje(this);
	}
<<<<<<< HEAD
=======
	
	public Disparo disparar() {
		return new Disparo((int) (pos.x + grafico.getWidth() * 0.6), pos.y);
	}
>>>>>>> dd3bba543e7ea215949fc855fc96016e284f2929
}
