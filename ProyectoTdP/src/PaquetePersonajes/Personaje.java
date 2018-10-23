package PaquetePersonajes;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import PaqueteArmas.Arma;
import PaqueteArmas.ArmaEstandar;
import PaqueteColisionadores.Colisionador;
import PaqueteDisparos.Disparo;
import PaqueteDrops.Drop;
import PaqueteGenericos.Animado;
import PaqueteGenericos.Objeto;

public abstract class Personaje extends Animado {
	protected Arma arma;
	protected boolean escudo;
	protected int cantEsc;
	protected Personaje(int v, int x, int y) {
		super(v, x, y);
		arma=new ArmaEstandar();
		escudo=false;
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
	public void modificarVida(int v) {
		vida += v;
	}
	
	public void mejorar(Drop drop) {
		drop.mejorar(this);
	}
	
	public int colisionar(Objeto o) {
		return 0;
	}
	
	public int serChocado(Colisionador c) {
		return c.chocarPersonaje(this);
	}
	
	public Disparo disparar() {
		return arma.disparar((int) (pos.x + grafico.getWidth() * 0.6), pos.y);
	}

	public void setArma(Arma ar) {
		arma = ar;
	}
	
	public void setEscudo(boolean esc) {
		escudo = esc;
		cantEsc = 3;
	}
	public boolean getEscudo() {
		return escudo;
	}
	public void chocoEscudo() {
		cantEsc--;
		if(cantEsc == 0)	
			escudo = false;
	}
	

}

