package PaqueteEnemigos;

import java.awt.Point;
import javax.swing.ImageIcon;

import PaqueteObjetos.Disparo;
//import PaqueteObjetos.DisparoEnemigo;
import PaqueteObjetosImplementados.Personaje;

public class IKM extends Inteligencia {
	private Inteligencia intelActual;
	private boolean cambio;
	
	public IKM(Personaje p) {
		super(p);
		icono = new ImageIcon("./bin/ImageIcons/IKM.png");
		puntosKill = 25;
		velocidad = 3;
		intelActual = new IKB(p);
		cambio = false;
	}
	
	public void cambiarInteligencia(int vida, Enemigo enem) {
		if (!cambio && vida <= 50) {
			intelActual = new IKA(personajeJuego);
			cambio = true;
		}
	}
	
	public void mover(Point pos) {
		intelActual.mover(pos);
	}
	
	public boolean iniciaConMovimiento() {
		return false;
	}

	public Disparo disparar(Point pos) {
		return null;
	}
}
