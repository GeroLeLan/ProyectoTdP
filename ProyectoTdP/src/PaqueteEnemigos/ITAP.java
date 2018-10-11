package PaqueteEnemigos;

import java.awt.Point;
import javax.swing.ImageIcon;

import PaqueteObjetos.Disparo;
import PaqueteObjetosImplementados.Personaje;

public class ITAP extends Inteligencia {
	private Inteligencia intelActual;
	
	public ITAP(Personaje p) {
		super(p);
		icono = new ImageIcon("./bin/ImageIcons/ITAP - Armado.png");
		puntosKill = 20;
		velocidad = 1;
		intelActual = new ITieneArma(p);
	}
	
	public void mover(Point pos) {
		intelActual.mover(pos);
	}
	
	public void cambiarInteligencia(int vida, Enemigo enem) {
		if (vida <= 20) {
			intelActual = new IKB(personajeJuego);
			icono = new ImageIcon("./bin/ImageIcons/ITAP - Desarmado.png");
			enem.setGrafico();
		}
	}
	
	public boolean iniciaConMovimiento() {
		return true;
	}
	
	public Disparo disparar(Point pos) {
		return intelActual.disparar(pos);
	}
}
